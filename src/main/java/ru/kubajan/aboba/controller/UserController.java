package ru.kubajan.aboba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kubajan.aboba.model.UserModel;
import ru.kubajan.aboba.service.UserService;

import java.util.List;

//слой контроллера
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserModel getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Long addUser(@RequestBody UserModel userModel){
        return userService.addUser(userModel);
    }

}
