package com.example.Activity_Project.service;

import com.example.Activity_Project.dto.UserDto;
import com.example.Activity_Project.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    ResponseEntity<UserDto> addUser(UserDto userDto);
    ResponseEntity<List<UserDto>> getAllUser();
    Optional<User> getByid(Long id);


}
