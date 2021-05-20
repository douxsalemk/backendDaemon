package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Admistration;
import com.salemdoux.ecole.repositories.AdmistrationRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AdmistrationService {

	@Autowired
	private AdmistrationRepository repo;

	public Admistration find(Integer id) throws ObjectNotFoundException {
		Optional<Admistration> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Admistration.class.getName()));

	}

}
