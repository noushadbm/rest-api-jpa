package com.rayshan.listeners;

import com.rayshan.common.entities.LoginActivity;
import com.rayshan.repository.LoginActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    private LoginActivityRepository activityRepo;

    @Autowired
    public AuthFailureEventListener(LoginActivityRepository repo) {
        this.activityRepo = repo;
    }
    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        //ApplicationListener<AuthenticationSuccessEvent>
        System.out.println("Yes it is a failure..." + event.getAuthentication().getPrincipal());
        LoginActivity activity = new LoginActivity();
        activity.setUserName(event.getAuthentication().getPrincipal().toString());
        activity.setDate(new Date());
        activity.setStatus("FAILURE");
        activityRepo.save(activity);

    }
}
