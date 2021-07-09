package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer >{

}
