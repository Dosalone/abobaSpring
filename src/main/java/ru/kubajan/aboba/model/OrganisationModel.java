package ru.kubajan.aboba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//доменная модель классов
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationModel {
    private Long id;

    private String name;

    private int inn;

    private int kpp;
}
