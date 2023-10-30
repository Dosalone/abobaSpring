package ru.kubajan.aboba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//доменная модель классов
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;

    private String name;

    private Integer age;

    private String comment;

    private OrganisationModel organisationModel;

    public UserModel(Long id, String name, Integer age, String comment){
        this.id = id;
        this.name = name;
        this.age = age;
        this.comment = comment;
    }

}
