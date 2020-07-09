package com.example.lab_3.repository;

import com.example.lab_3.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepo extends JpaRepository<Administrator,Long> {
}
