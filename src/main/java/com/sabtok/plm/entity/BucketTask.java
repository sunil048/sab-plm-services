package com.sabtok.plm.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="BUCKET_TASKS")
@Data
public class BucketTask  extends Traceable {
    @Id
    private String id;
    private String taskId;
    private String taskName;
    private String description;
    private Integer queNo;
    private LocalDate openDate;
    private Long taskAge;

}
