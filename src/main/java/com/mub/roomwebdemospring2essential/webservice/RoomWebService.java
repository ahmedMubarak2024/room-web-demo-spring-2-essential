package com.mub.roomwebdemospring2essential.webservice;

import com.mub.roomwebdemospring2essential.models.Room;
import com.mub.roomwebdemospring2essential.services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomWebService {
    private final RoomService roomService;

    public RoomWebService(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    public List<Room> getAll(@RequestParam(name = "name", required = false) String name, @RequestParam(value = "bed", required = false) String bedType) {
        return roomService.getAllRoom(name, bedType);
    }
}
