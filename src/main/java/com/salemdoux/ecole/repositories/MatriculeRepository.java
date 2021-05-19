package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Matricule;

@Repository
public interface MatriculeRepository extends JpaRepository<Matricule, Integer >{

}
