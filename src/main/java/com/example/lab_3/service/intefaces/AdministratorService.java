package com.example.lab_3.service.intefaces;

import com.example.lab_3.entity.Abiturient;
import com.example.lab_3.entity.Administrator;
import com.example.lab_3.entity.Statement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdministratorService {

    Administrator createAdministrator(final Administrator administrator);

    List<Administrator> findAllAdministrators();

    Administrator  findAdministratorById(final Long id);

    Administrator updateAdministrator(final Administrator administrator);

    void deleteAdministrator(final Long id);

}
