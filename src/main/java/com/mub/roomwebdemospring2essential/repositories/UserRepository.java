package com.mub.roomwebdemospring2essential.repositories;

import com.mub.roomwebdemospring2essential.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();
}