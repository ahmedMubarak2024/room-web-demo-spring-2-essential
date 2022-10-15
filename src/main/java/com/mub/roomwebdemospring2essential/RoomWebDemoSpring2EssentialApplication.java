package com.mub.roomwebdemospring2essential;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoomWebDemoSpring2EssentialApplication {

    private static Logger log = LoggerFactory.getLogger(RoomWebDemoSpring2EssentialApplication.class);

//

    public static void main(String[] args) {
        SpringApplication.run(RoomWebDemoSpring2EssentialApplication.class, args);

    }

}
