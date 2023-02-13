package com.rayshan.listeners;

import com.rayshan.common.entities.LoginActivity;
import com.rayshan.repository.LoginActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    Logger logger = LoggerFactory.getLogger(AuthFailureEventListener.class);
    private LoginActivityRepository activityRepo;

    @Autowired
    public AuthFailureEventListener(LoginActivityRepository repo) {
        this.activityRepo = repo;
    }
    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        //System.out.println("Yes it is a failure..." + event.getAuthentication().getPrincipal());
        LoginActivity activity = new LoginActivity();
        activity.setUserName(event.getAuthentication().getPrincipal().toString());
        activity.setDate(new Date());
        activity.setStatus("FAILURE");
        logger.info("Login failed because of wrong credentials. User name: {}", activity.getUserName());
        activityRepo.save(activity);
    }
}
