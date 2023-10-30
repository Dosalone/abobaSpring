package ru.kubajan.aboba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.kubajan.aboba.entity.OrganisationEntity;
import ru.kubajan.aboba.mapper.OrganisationJpaMapper;
import ru.kubajan.aboba.model.OrganisationModel;
import ru.kubajan.aboba.repository.OrganisationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    public List<OrganisationModel> getAllOrganisations(){
        List<OrganisationEntity> result = new ArrayList<>();
        organisationRepository.findAll().forEach(result::add);
        return OrganisationJpaMapper.toDomain(result);
    }

    public OrganisationModel getOrganisationById(long id){
        return OrganisationJpaMapper.toDomain(organisationRepository.findById(id).get());
    }

    public Long addOrganisation(@RequestBody OrganisationModel organisationModel){
        OrganisationEntity newOrganisation = new OrganisationEntity(null,
                organisationModel.getName(),
                organisationModel.getInn(),
                organisationModel.getKpp(), null);
        return organisationRepository.save(newOrganisation).getId();
    }
}
