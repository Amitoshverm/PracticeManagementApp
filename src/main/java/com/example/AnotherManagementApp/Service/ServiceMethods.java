package com.example.AnotherManagementApp.Service;

import com.example.AnotherManagementApp.Entity.User;

import java.util.List;

public interface ServiceMethods {

    List<User> getUsers();
    User createUser(User user);
    public boolean checkEmail(String email);
}
