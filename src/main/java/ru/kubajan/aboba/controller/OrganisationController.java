package ru.kubajan.aboba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kubajan.aboba.model.OrganisationModel;
import ru.kubajan.aboba.service.OrganisationService;
import java.util.List;

//слой контроллера
@RestController
@RequestMapping("organisation")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @GetMapping("/all")
    public List<OrganisationModel> getAllOrganisations(){
        return organisationService.getAllOrganisations();
    }

    @GetMapping(value = "/{id}")
    public OrganisationModel getOrganisationById(@PathVariable long id){
        return organisationService.getOrganisationById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Long addOrganisation(@RequestBody OrganisationModel organisationModel){
        return organisationService.addOrganisation(organisationModel);
    }
}
