package com.mub.roomwebdemospring2essential.services;

import com.mub.roomwebdemospring2essential.models.Room;
import com.mub.roomwebdemospring2essential.models.Room_;
import com.mub.roomwebdemospring2essential.repositories.RoomRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private static Specification<Room> getRoomSpecification(String name, String bedType) {
        return ((Specification<Room>) (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.<String>get(Room_.NAME), "%" + name + "%");
        }).or(((root, query, criteriaBuilder) -> criteriaBuilder.like(root.<String>get(Room_.BED_INFO), "%" + bedType + "%")));

    }

    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    public List<Room> getAllRoom(String name, String bedType) {
        if (name != null || bedType != null)
            return roomRepository.findAll(getRoomSpecification(name, bedType));
        else return roomRepository.findAll();

//               return roomRepository.findAll();

    }

}
