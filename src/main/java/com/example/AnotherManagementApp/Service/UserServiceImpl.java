package com.example.AnotherManagementApp.Service;

import com.example.AnotherManagementApp.Entity.User;
import com.example.AnotherManagementApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements ServiceMethods{

    @Autowired(required = false)
    private UserRepository userRepository;


    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
