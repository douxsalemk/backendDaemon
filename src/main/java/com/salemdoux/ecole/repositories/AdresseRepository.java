package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer >{

}
