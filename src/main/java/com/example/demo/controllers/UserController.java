package com.example.demo.controllers;

import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
//@RequestMapping("/userdata")
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
     //  return (List<User>) userRepository.findAll();
       return "import data ";
    }

    @GetMapping("/clear")
    public String clearData(){
        userService.clearData();
        return "clear data ";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
       // return  "Hello";
        return (List<User>) userRepository.findAll();
    }
    @GetMapping("/users/temperatures/{userid}")
    public Result getUserTemperatures(@PathVariable int userid){
        return userService.getUserTemperature(userid);
    }

    @GetMapping("/users/temperatures/hourly/{userid}")
    public Result getUserHourlyData(@PathVariable int userId){
         return userService.getUserHourlyData(userId);
    }
    @GetMapping("/users/temperatures/daily/{userid}")
    public Result getUserDailyData(@PathVariable int userId){
        return userService.getUserHourlyData(userId);
    }

}
