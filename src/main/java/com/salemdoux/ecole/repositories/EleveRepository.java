package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Eleve;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer >{

}
