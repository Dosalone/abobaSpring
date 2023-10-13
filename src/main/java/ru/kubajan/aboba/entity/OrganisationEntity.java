package ru.kubajan.aboba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "organisation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inn")
    private int inn;

    @Column(name = "kpp")
    private int kpp;
}
