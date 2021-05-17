package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.AdresseHist;

@Repository
public interface AdresseHistRepository extends JpaRepository<AdresseHist, Integer >{

}
