package ru.kubajan.aboba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organisation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationEntity {
    @Column(name = "id")
    @Id
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inn")
    private int inn;

    @Column(name = "kpp")
    private int kpp;
}
