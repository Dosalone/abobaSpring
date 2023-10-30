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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers(){
        List<UserEntity> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return UserJpaMapper.toDomain(result);
    }

    public UserModel getUserById(long id){
        return UserJpaMapper.toDomain(userRepository.findById(id).get());
    }

    public String deleteUserById(long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Удаление успешно завершено";
        } else return "Удаление не удалось";
    }

    public String deleteUsersByListId(List<Long> listId) {
        List<String> result = new ArrayList<>();
        if(listId == null){
            return "Списка нет";
        }
        if(listId.isEmpty()){
            return "Список пуст";
        }
        for (Long id : listId) {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                result.add(String.format("Удаление %d успешно завершено", id));
            } else result.add(String.format("Удаление %d не удалось", id));
        }
        return result.toString();
    }

    public Long addUser(UserModel userModel){
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