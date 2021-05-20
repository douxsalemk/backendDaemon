package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Employe;
import com.salemdoux.ecole.repositories.EmployeRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EmployeService {

	@Autowired
	private EmployeRepository repo;

	public Employe find(Integer id) throws ObjectNotFoundException {
		Optional<Employe> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Employe.class.getName()));

	}

}
