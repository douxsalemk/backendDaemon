package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Adresse;
import com.salemdoux.ecole.repositories.AdresseRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository repo;

	public Adresse buscar(Integer id) throws ObjectNotFoundException {
		Optional<Adresse> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Adresse.class.getName()));

	}

}
