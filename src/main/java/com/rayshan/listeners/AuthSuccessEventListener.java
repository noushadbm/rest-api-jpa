package com.rayshan.listeners;

import com.rayshan.common.entities.LoginActivity;
import com.rayshan.repository.LoginActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {
    Logger logger = LoggerFactory.getLogger(AuthSuccessEventListener.class);
    private LoginActivityRepository activityRepo;

    @Autowired
    public AuthSuccessEventListener(LoginActivityRepository repo) {
        this.activityRepo = repo;
    }
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        //System.out.println("Yes it is a success..." + event.getAuthentication().getPrincipal());
        LoginActivity activity = new LoginActivity();
        User user = (User)event.getAuthentication().getPrincipal();
        activity.setUserName(user.getUsername());
        activity.setDate(new Date());
        activity.setStatus("SUCCESS");
        logger.info("User logged in successfully. User: {}", user.getUsername());
        activityRepo.save(activity);
    }
}
