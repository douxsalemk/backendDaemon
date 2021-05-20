package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Matricule;
import com.salemdoux.ecole.repositories.MatriculeRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MatriculeService {

	@Autowired
	private MatriculeRepository repo;

	public Matricule find(Integer id) throws ObjectNotFoundException {
		Optional<Matricule> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Matricule.class.getName()));

	}

}
