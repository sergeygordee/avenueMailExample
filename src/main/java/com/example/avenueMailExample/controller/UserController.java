package com.example.avenueMailExample.controller;

import com.example.avenueMailExample.entity.User;
import com.example.avenueMailExample.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/userCreate")
    public String createUserForm(User user) {
        return "userCreate";
    }


    @PostMapping("/userCreate")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";

    }

    @GetMapping("/userDelete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/userUpdate/{id}")
    public String userUpdate(@PathVariable("id")Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "userUpdate";

    }

    @PostMapping("/userUpdate")
    public String userUpdate(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }




}
