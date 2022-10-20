package com.mub.roomwebdemospring2essential.controllers;

import com.mub.roomwebdemospring2essential.models.Room;
import com.mub.roomwebdemospring2essential.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("room")
public class RoomController {
    private final RoomService roomService;


    public RoomController(RoomService employeeService) {
        this.roomService = employeeService;


    }

    @RequestMapping(method = RequestMethod.GET)
    public String showRooms(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "bed", required = false) String bedType, Model model) {
        List<Room> allRoom = roomService.getAllRoom(name, bedType);
        model.addAttribute("rooms", allRoom);
        return "roomListing";
    }

}
