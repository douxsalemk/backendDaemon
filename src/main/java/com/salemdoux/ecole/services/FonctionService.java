package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Fonction;
import com.salemdoux.ecole.repositories.FonctionRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FonctionService {

	@Autowired
	private FonctionRepository repo;

	public Fonction buscar(Integer id) throws ObjectNotFoundException {
		Optional<Fonction> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fonction.class.getName()));

	}

}
