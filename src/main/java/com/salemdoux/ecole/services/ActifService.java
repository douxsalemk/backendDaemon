package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Actif;
import com.salemdoux.ecole.repositories.ActifRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ActifService {

	@Autowired
	private ActifRepository repo;

	public Actif find(Integer id) throws ObjectNotFoundException {
		Optional<Actif> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Actif.class.getName()));

	}

}
