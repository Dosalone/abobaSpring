package ru.kubajan.aboba.mapper;

import ru.kubajan.aboba.entity.OrganisationEntity;
import ru.kubajan.aboba.model.OrganisationModel;

import java.util.ArrayList;
import java.util.List;

public class OrganisationJpaMapper {

    public static OrganisationEntity toJpa(OrganisationModel organisationModel){
        return new OrganisationEntity(
                organisationModel.getId(),
                organisationModel.getName(),
                organisationModel.getInn(),
                organisationModel.getKpp());
    }

    public static OrganisationModel toDomain(OrganisationEntity organisationEntity){
        return new OrganisationModel(
                organisationEntity.getId(),
                organisationEntity.getName(),
                organisationEntity.getInn(),
                organisationEntity.getKpp());
    }

    public static List<OrganisationModel> toDomain(List<OrganisationEntity> organisationEntityList){
        List<OrganisationModel> result = new ArrayList<>();
        for(OrganisationEntity e : organisationEntityList) {
            result.add(toDomain(e));
        }
        return result;
    }
}
