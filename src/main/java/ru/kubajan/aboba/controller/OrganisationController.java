package ru.kubajan.aboba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kubajan.aboba.entity.OrganisationEntity;
import ru.kubajan.aboba.repository.OrganisationRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("organisation")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @GetMapping("/all")
    public List<OrganisationEntity> getAllOrganisations(){
        List<OrganisationEntity> result = new ArrayList<>();
        organisationRepository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping("/{id}")
    public OrganisationEntity getUserById(@PathVariable long id){
        return organisationRepository.findById(id).get();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Long addOrganisation(@RequestBody OrganisationEntity organisationEntity){
        OrganisationEntity newOrganisation = new OrganisationEntity(null,
                organisationEntity.getName(),
                organisationEntity.getInn(),
                organisationEntity.getKpp());
        return organisationRepository.save(newOrganisation).getId();
    }
}
