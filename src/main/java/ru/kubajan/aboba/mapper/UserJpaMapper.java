package ru.kubajan.aboba.mapper;

import ru.kubajan.aboba.entity.OrganisationEntity;
import ru.kubajan.aboba.entity.UserEntity;
import ru.kubajan.aboba.model.OrganisationModel;
import ru.kubajan.aboba.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserJpaMapper {

    public static UserEntity toJpa(UserModel userModel){
        return new UserEntity(
                userModel.getId(),
                userModel.getName(),
                userModel.getAge(),
                userModel.getComment(),
                OrganisationJpaMapper.toJpa(userModel.getOrganisationModel()));
    }

    public static UserModel toDomain(UserEntity userEntity){
         UserModel userModel = new UserModel(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getAge(),
                userEntity.getComment());
        if(userEntity.getOrganisationEntity() != null){
            userModel.setOrganisationModel(OrganisationJpaMapper.toDomain(userEntity.getOrganisationEntity()));
        }
        return userModel;

    }

    public static List<UserModel> toDomain(List<UserEntity> userEntityList){
        List<UserModel> result = new ArrayList<>();
        for(UserEntity e : userEntityList) {
            result.add(toDomain(e));
        }
        return result;
    }
}
