package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Fonction;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Integer >{

}
