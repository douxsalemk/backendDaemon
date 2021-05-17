package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Ecole;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer >{

}
