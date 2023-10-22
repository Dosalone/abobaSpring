package ru.kubajan.aboba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "organisationEntity")
    private List<UserEntity> userEntityList;

    public OrganisationEntity(Long id, String name, int inn, int kpp) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.kpp = kpp;
    }
}
