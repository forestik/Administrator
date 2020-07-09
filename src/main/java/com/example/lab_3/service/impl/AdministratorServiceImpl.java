package com.example.lab_3.service.impl;

import com.example.lab_3.entity.Abiturient;
import com.example.lab_3.entity.Administrator;
import com.example.lab_3.entity.Faculty;
import com.example.lab_3.entity.Statement;
import com.example.lab_3.repository.AdministratorRepo;
import com.example.lab_3.resource.AbiturientResource;
import com.example.lab_3.resource.FacutlyResource;
import com.example.lab_3.service.intefaces.AdministratorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorRepo administratorRepo;
    private FacutlyResource facutlyResource;
    private AbiturientResource abiturientResource;

    public AdministratorServiceImpl(AdministratorRepo administratorRepo, FacutlyResource facutlyResource, AbiturientResource abiturientResource) {
        this.administratorRepo = administratorRepo;
        this.facutlyResource = facutlyResource;
        this.abiturientResource = abiturientResource;

    }

    /**
     * method is used to save the entity to the database.
     *
     * @param administrator entity must not be {@literal null}.
     * @return the saved entity.
     */
    @Override
    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepo.save(administrator);
    }

    /**
     * method is used to search for all entities.
     *
     * @return all entities.
     */
    @Override
    public List<Administrator> findAllAdministrators() {
        return administratorRepo.findAll();
    }

    /**
     * method is used to search for the entity.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     */
    @Override
    public Administrator findAdministratorById(Long id) {
        return administratorRepo.findById(id).orElse(null);
    }

    /**
     * method is used to update the entity.
     *
     * @param administrator entity must not be {@literal null}.
     * @return the updated entity.
     */
    @Override
    public Administrator updateAdministrator(Administrator administrator) {
        Administrator toUpdate = administratorRepo.findById(administrator.getId()).orElse(null);
        if (toUpdate != null) {
            toUpdate.setFirstName(administrator.getFirstName());
            toUpdate.setLastName(administrator.getLastName());
            toUpdate.setFaculty(administrator.getFaculty());
        }
        return administratorRepo.save(toUpdate);
    }

    /**
     * method is used to remove the entity.
     *
     * @param id must not be {@literal null}.
     */
    @Override
    public void deleteAdministrator(Long id) {
        Administrator administrator = administratorRepo.findById(id).orElse(null);
        if (administrator.getFaculty() != null) {
            Faculty faculty = facutlyResource.findFacultyById(administrator.getFaculty().getId());
            faculty.setAdministrator(null);
            facutlyResource.saveFaculty(faculty);
        }
        administratorRepo.deleteById(id);
    }


}

