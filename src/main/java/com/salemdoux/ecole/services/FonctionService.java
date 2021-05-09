package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Fonction;
import com.salemdoux.ecole.repositories.FonctionRepository;

@Service
public class FonctionService {
	
	@Autowired
	private FonctionRepository repo;
	
	public Fonction trouver(Integer id){
		Optional<Fonction> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
