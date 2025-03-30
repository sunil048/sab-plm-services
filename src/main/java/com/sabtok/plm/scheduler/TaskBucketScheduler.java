package com.sabtok.plm.scheduler;

import com.sabtok.plm.dao.BucketTaskDao;
import com.sabtok.plm.dao.TaskDao;
import com.sabtok.plm.entity.BucketTask;
import com.sabtok.plm.entity.Task;
import com.sabtok.plm.service.TaskService;
import com.sabtok.plm.util.IDGenerator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TaskBucketScheduler {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");;
    private final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy") ;


    private TaskService taskService;

    private BucketTaskDao dao;

    private TaskDao taskDao;


    @Scheduled(cron = "${task-bucket.scheduler.incident.cron}")
    public void bucketTaskRunner(){
        System.out.println("Scheduler Triggered");
        List<Task> taskList = taskService.getAllTaskExcludingClosed();
        List<String> bucketTaskList = dao.findAll().stream()
                .map(BucketTask::getTaskId).collect(Collectors.toList());
        List<Task> taskList1 = taskList.stream()
                .filter(task -> ! bucketTaskList.contains(task.getTaskid()))
                .filter(task -> task.getStatus().equalsIgnoreCase("Open"))
                .collect(Collectors.toList());

        persistTaskIntoBucket(taskList1);
    }

    @Scheduled(cron = "${task-bucket.scheduler.user.story.cron}")
    public void updateBucketTaskRunner(){
        System.out.println("Update Bucket Scheduler Triggered");
        List<Task> taskList = taskService.getAllTasks();
        Map<Boolean, List<Task>> closedTaskMap = taskList.stream()
                .collect(Collectors.partitioningBy(task -> task.getStatus().equalsIgnoreCase("Closed")));
        List<String> closedtasks = closedTaskMap.get(true)
                .stream().map(Task::getTaskid).collect(Collectors.toList());

        List<BucketTask> bucketTaskList = dao.findAll().stream()
                .filter(bt -> closedtasks.contains(bt.getTaskId()))
                .collect(Collectors.toList());
        dao.deleteAll(bucketTaskList);

    }

    public void persistTaskIntoBucket(List<Task> opentaskList) {
        List<BucketTask> bucketTask = new ArrayList<>();
        opentaskList.forEach(task -> {
            BucketTask bt = new BucketTask();
            bt.setId(IDGenerator.getUUID().toString());
            bt.setTaskId(task.getTaskid());
            bt.setTaskName(task.getName());
            bt.setDescription(task.getDescription());
            bt.setOpenDate(parseDate(task.getOpenDate()));
            bt.setQueNo(calaculateQueValue(task));
            bt.setTaskAge(getTaskAge(bt.getOpenDate()));
            bucketTask.add(bt);
        });
        dao.saveAll(bucketTask);
    }

    private LocalDate parseDate(String stringDate) {
        LocalDate parsedDate = LocalDate.now();
         try {
             parsedDate = LocalDate.parse(stringDate, formatter1);
        } catch (Exception e) {
             try {
                 parsedDate = LocalDate.parse(stringDate, formatter);
             } catch (Exception e1){
                 System.out.println("Could not able to parse "+stringDate);
             }
         }
         return parsedDate;
    }

    private Long getTaskAge(LocalDate taskOpenDate) {
        LocalDate toDay = LocalDate.now() ;
        return ChronoUnit.DAYS.between(taskOpenDate, toDay);
    }


    private int calaculateQueValue(Task task){
        if (task.getStatus().equalsIgnoreCase("Open")
                && task.getPriority().equalsIgnoreCase("High")){
            return 1;
        }
        if (task.getStatus().equalsIgnoreCase("Open")
                && task.getPriority().equalsIgnoreCase("Medium")){
            return 2;
        }
        if (task.getStatus().equalsIgnoreCase("Open")
                && task.getPriority().equalsIgnoreCase("Low")){
            return 3;
        }
        if (task.getStatus().equalsIgnoreCase("In progress")
                && task.getPriority().equalsIgnoreCase("High")){
            return 4;
        }
        return 5;
    }

}
