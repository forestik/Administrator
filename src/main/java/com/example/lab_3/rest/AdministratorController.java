package com.example.lab_3.rest;

import com.example.lab_3.entity.Administrator;
import com.example.lab_3.service.intefaces.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/administrator")
public class AdministratorController {

    private AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping(value = "/findall")
    public List<Administrator> findAllAdministrators() {
        return administratorService.findAllAdministrators();
    }

    @GetMapping(value = "/findbyid")
    public Administrator findAdministratorById(@RequestParam(name = "id") final Long id) {
        return administratorService.findAdministratorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Administrator createAdministrator(@RequestBody final Administrator administrator) {
        return administratorService.createAdministrator(administrator);
    }


    @PutMapping(value = "/update")
    public Administrator updateAdministrator(@RequestBody final Administrator administrator) {
        return administratorService.updateAdministrator(administrator);
    }

    @DeleteMapping
    public void deleteAdministrator(@RequestParam(name = "id")final Long id){
        administratorService.deleteAdministrator(id);
    }
}
