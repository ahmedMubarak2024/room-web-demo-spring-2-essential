package com.mub.roomwebdemospring2essential.repositories;

import com.mub.roomwebdemospring2essential.models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();
}
