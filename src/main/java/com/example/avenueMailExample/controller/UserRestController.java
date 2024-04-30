package com.example.avenueMailExample.controller;

import com.example.avenueMailExample.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private List<User> users = Stream.of(
            new User(1L,"qwe","qwe","qwe@mail.ru","qwe"),
            new User(3L,"asd","asd","asd@mail.ru","asd"),
            new User(4L,"zxc","zxc","zxc@mail.ru","zxc")

    ).collect(Collectors.toList());

    @GetMapping
    public List<User> getAll(){
        return users;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return  users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}
