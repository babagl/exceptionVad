package com.monapp.exceptionvad.controller;

import com.monapp.exceptionvad.Entity.User;
import com.monapp.exceptionvad.dto.UserRequest;
import com.monapp.exceptionvad.exception.UserException;
import com.monapp.exceptionvad.service.UserServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserServices services;

    public UserController(UserServices services) {
        this.services = services;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(services.saveUser(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok(services.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserException {
        return ResponseEntity.ok(services.getUser(id));
    }
}
