package com.newtestdemo.demo.controllers;

import com.newtestdemo.demo.entity.User;
import com.newtestdemo.demo.repository.LogRepository;
import com.newtestdemo.demo.repository.UserRepository;
import com.newtestdemo.demo.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LogRepository logRepo;

//    public AppController(UserRepository userRepo, LogRepository logRepo) {
//        this.userRepo = userRepo;
//        this.logRepo = logRepo;
//    }

    // MySQL
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    // MongoDB
    @PostMapping("/logs")
    public Log createLog(@RequestBody Log log) {
        return logRepo.save(log);
    }

    @GetMapping("/logs")
    public List<Log> getLogs() {
        return logRepo.findAll();
    }
}
