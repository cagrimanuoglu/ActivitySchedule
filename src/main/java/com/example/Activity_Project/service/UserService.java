package com.example.Activity_Project.service;

import com.example.Activity_Project.dto.UserDto;
import com.example.Activity_Project.entity.User;
import com.example.Activity_Project.mapper.UserMapper;
import com.example.Activity_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<UserDto> addUser(UserDto userDto) {

        User user = userMapper.fromDto(userDto);
        user.setRole("ROLE_USER");
        user=userRepository.save(user);
        UserDto userDto1 = userMapper.toDto(user);
        return ResponseEntity.ok(userDto1);
    }

    @Override
    //@Cacheable(cacheNames = "allUser")
    public ResponseEntity<List<UserDto>> getAllUser() {

        List<User> users;
        List<UserDto> userDtos = new ArrayList<UserDto>();
       users = userRepository.findAll();

       for (int i=0;i<users.size();i++)
       {
            userDtos.add(userMapper.toDto(users.get(i)));
       }

        return ResponseEntity.ok(userDtos);
    }

    @Override
    public Optional<User> getByid(Long id) {
        return userRepository.findById(id);
    }

}
