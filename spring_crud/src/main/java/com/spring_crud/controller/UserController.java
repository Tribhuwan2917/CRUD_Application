package com.spring_crud.controller;

import com.spring_crud.service.UserResponse;
import com.spring_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/getUsers/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<UserResponse>(userService.getUser(userId),HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserResponse userResponse)
    {
        return new  ResponseEntity<String>("user with user Id "+userService.addUser(userResponse)+" added successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<>("user with user Id: "+userService.deleteUser(userId)+"deleted successfully",HttpStatus.OK);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(UserResponse userResponse)
    {
        return new ResponseEntity<>("user with user Id :"+userService.updateUser(userResponse)+"updated successfully",HttpStatus.CREATED);
    }
}
