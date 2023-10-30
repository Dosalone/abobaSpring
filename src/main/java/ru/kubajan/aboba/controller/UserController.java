package ru.kubajan.aboba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kubajan.aboba.model.UserModel;
import ru.kubajan.aboba.service.UserService;

import java.util.ArrayList;
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

    @GetMapping(value = "/delete/{id}")
    public String deleteUserById(@PathVariable long id){
        return userService.deleteUserById(id);
    }

    @PostMapping(path = "/delete/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUsersByListId(@RequestBody List<Long> listId){
        return userService.deleteUsersByListId(listId);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Long addUser(@RequestBody UserModel userModel){
        return userService.addUser(userModel);
    }

}
