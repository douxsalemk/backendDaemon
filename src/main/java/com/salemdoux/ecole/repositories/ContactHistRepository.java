package com.salemdoux.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salemdoux.ecole.domain.ContactHist;

@Repository
public interface ContactHistRepository extends JpaRepository<ContactHist, Integer >{

}
