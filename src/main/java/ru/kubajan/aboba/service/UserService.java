package ru.kubajan.aboba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kubajan.aboba.entity.UserEntity;
import ru.kubajan.aboba.mapper.OrganisationJpaMapper;
import ru.kubajan.aboba.mapper.UserJpaMapper;
import ru.kubajan.aboba.model.UserModel;
import ru.kubajan.aboba.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers(){
        List<UserEntity> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return UserJpaMapper.toDomain(result);
    }

    public UserModel getUserById(@PathVariable long id){
        return UserJpaMapper.toDomain(userRepository.findById(id).get());
    }

    public Long addUser(@RequestBody UserModel userModel){
        UserEntity newUser = new UserEntity(null,
                userModel.getName(),
                userModel.getAge(),
                userModel.getComment());
        if(userModel.getOrganisationModel() != null){
            newUser.setOrganisationEntity(OrganisationJpaMapper.toJpa(userModel.getOrganisationModel()));
        }
        return userRepository.save(newUser).getId();
    }
}
