package com.sabtok.plm.controller;

import com.sabtok.plm.remote.UserStoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class RemoteCallController {

    @Autowired
    private UserStoryClient userStoryClient;

    @Autowired
    private RemoteService remoteService;

    @GetMapping("/story/{id}")
    public Object test(@PathVariable("id") String id){
        return remoteService.getStoryDetails(id);
    }
}
