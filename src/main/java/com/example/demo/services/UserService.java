package com.example.demo.services;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService() {
    }

//    public Collection<User> getAll() {
//        return userRepository.getAllUsers();
//    }

    public void importData() {
        userRepository.importData();
    }

    public void clearData() {
        userRepository.clearData();
    }

}
