package com.mub.roomwebdemospring2essential.util;


import com.mub.roomwebdemospring2essential.models.Room;
import com.mub.roomwebdemospring2essential.repositories.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartEvent implements ApplicationListener<ApplicationReadyEvent> {
    private RoomRepository roomRepository;

    public AppStartEvent(RoomRepository reservationService) {
        this.roomRepository = reservationService;

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<Room> room = this.roomRepository.findAll();
        //room.forEach(System.out::println);
    }
}