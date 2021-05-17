package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.Admistration;

@Repository
public interface AdmistrationRepository extends JpaRepository<Admistration, Integer >{

}
