package com.example.AnotherManagementApp.Controller;

import com.example.AnotherManagementApp.Entity.User;
import com.example.AnotherManagementApp.Service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {

    @Autowired
    private UserServiceImpl service;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, HttpSession session) {

        boolean f = service.checkEmail(user.getEmail());
        if(f){
            session.setAttribute("msg", "email already exists");
        }
        else {
            User user1 = this.service.createUser(user);
            if(user1 != null) {
                session.setAttribute("msg", "Register Successfully");
            }
            else {
                session.setAttribute("msg", "Something went wrong on server!");
            }
        }

        return "redirect:/register";
    }
}
