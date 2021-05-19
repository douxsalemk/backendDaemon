package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Actif;

@Repository
public interface ActifRepository extends JpaRepository<Actif, Integer >{

}
