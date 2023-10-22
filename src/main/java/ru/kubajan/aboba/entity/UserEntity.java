package ru.kubajan.aboba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kubajan.aboba.model.OrganisationModel;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private OrganisationEntity organisationEntity;

    public UserEntity(Long id, String name, Integer age, String comment){
        this.id = id;
        this.name = name;
        this.age = age;
        this.comment = comment;
    }

}
