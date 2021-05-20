package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.repositories.EcoleRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EcoleService {

	@Autowired
	private EcoleRepository repo;

	public Ecole find(Integer id) throws ObjectNotFoundException {
		Optional<Ecole> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + EcoleService.class.getName()));

	}

}
