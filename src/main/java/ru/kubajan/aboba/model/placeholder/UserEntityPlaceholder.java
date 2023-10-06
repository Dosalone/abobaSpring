package ru.kubajan.aboba.model.placeholder;

import ru.kubajan.aboba.entity.UserEntity;

public class UserEntityPlaceholder {
    public static UserEntity getUserPlaceholder(){
        return new UserEntity(null, "abobaw", 35, "hui3", null);
    }
}
