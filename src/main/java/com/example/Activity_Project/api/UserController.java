package com.example.Activity_Project.api;

import com.example.Activity_Project.dto.UserDto;
import com.example.Activity_Project.entity.User;
import com.example.Activity_Project.security.model.AuthenticationRequest;
import com.example.Activity_Project.security.model.AuthenticationResponse;
import com.example.Activity_Project.service.IUserService;
import com.example.Activity_Project.service.MyUserDetailsService;
import com.example.Activity_Project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService iUserService;


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception
    {   try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getName(), authenticationRequest.getPassword())
        );
    }
    catch (BadCredentialsException e)
    {
        throw new Exception("Incorrect username or password",e);
    }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getName());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
    {
        return iUserService.addUser(userDto);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        return iUserService.getAllUser();
    }

    @PostMapping("/getUserbyid/{id}")
    public ResponseEntity<Optional<User>> getUserbyid(@PathVariable Long id)
    {
        return ResponseEntity.ok(iUserService.getByid(id));
    }



}
