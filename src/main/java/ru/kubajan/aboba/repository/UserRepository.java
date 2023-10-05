package ru.kubajan.aboba.repository;

import ru.kubajan.aboba.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
