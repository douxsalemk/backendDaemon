package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer >{

}
