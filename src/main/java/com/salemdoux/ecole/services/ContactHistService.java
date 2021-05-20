package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.ContactHist;
import com.salemdoux.ecole.repositories.ContactHistRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ContactHistService {

	@Autowired
	private ContactHistRepository repo;

	public ContactHist find(Integer id) throws ObjectNotFoundException {
		Optional<ContactHist> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ContactHistService.class.getName()));

	}

}
