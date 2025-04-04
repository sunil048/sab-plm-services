package com.sabtok.plm.controller;

import com.sabtok.plm.remote.UserStoryClient;
import com.sabtok.plm.service.RestCallExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteService {

    @Autowired
    private RestCallExecutor RestCallExecutor;

    @Autowired
    private UserStoryClient userStoryClient;

    public Object getStoryDetails(String storyId) {
       return  RestCallExecutor.execute(() -> userStoryClient.getUserStoryDetails(storyId));
    }
}
