package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.AdresseHist;
import com.salemdoux.ecole.repositories.AdresseHistRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AdresseHistService {

	@Autowired
	private AdresseHistRepository repo;

	public AdresseHist buscar(Integer id) throws ObjectNotFoundException {
		Optional<AdresseHist> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + AdresseHist.class.getName()));

	}

}
