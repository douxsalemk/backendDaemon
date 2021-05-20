package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Eleve;
import com.salemdoux.ecole.repositories.EleveRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EleveService {

	@Autowired
	private EleveRepository repo;

	public Eleve find(Integer id) throws ObjectNotFoundException {
		Optional<Eleve> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Eleve.class.getName()));

	}

}
