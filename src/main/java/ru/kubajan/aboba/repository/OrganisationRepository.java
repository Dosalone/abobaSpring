package ru.kubajan.aboba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kubajan.aboba.entity.OrganisationEntity;

@Repository
public interface OrganisationRepository extends CrudRepository<OrganisationEntity, Long> {
}
