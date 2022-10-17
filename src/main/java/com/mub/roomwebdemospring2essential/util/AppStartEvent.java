package com.mub.roomwebdemospring2essential.util;


import com.mub.roomwebdemospring2essential.models.User;
import com.mub.roomwebdemospring2essential.repositories.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartEvent implements ApplicationListener<ApplicationReadyEvent> {
    private UserRepository userRepository;

    public AppStartEvent(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<User> user = this.userRepository.findAll();
        user.forEach(System.out::println);
    }
}