package ru.kubajan.aboba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kubajan.aboba.entity.UserEntity;
import ru.kubajan.aboba.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<UserEntity> getAllUsers(){
        List<UserEntity> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable long id){
        return userRepository.findById(id).get();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Long addUser(@RequestBody UserEntity userEntity){
        UserEntity newUser = new UserEntity(null,
                                            userEntity.getName(),
                                            userEntity.getAge(),
                                            userEntity.getComment(),
                                            null);
        return userRepository.save(newUser).getId();
    }

}
