package com.example.Activity_Project.service;

import com.example.Activity_Project.entity.MyUserDetails;
import com.example.Activity_Project.entity.User;
import com.example.Activity_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> user =userRepository.findByUserName(s);

        return user.map(MyUserDetails::new).get();


    }
}
