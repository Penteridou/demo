package com.example.demo.controllers;

import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    private final UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository =  userRepository;
    }

    @GetMapping("/import")
    public String importData(){
       userService.importData();
       return "users with sensors data import ";
    }

    @GetMapping("/clear")
    public String clearData(){
        userService.clearData();
        return "clear data ";
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/temperatures/{userid}")
    public Result getUserTemperatures(@PathVariable int userid){
        return userService.getUserTemperature(userid);
    }
    @GetMapping("/temperatures/hourly/{userid}")
    public Result getUserHourlyData(@PathVariable int userid){
         return userService.getUserHourlyData(userid);
    }
    @GetMapping("/temperatures/daily/{userid}")
    public Result getUserDailyData(@PathVariable int userid){
        return userService.getUserDailyData(userid);
    }

}
