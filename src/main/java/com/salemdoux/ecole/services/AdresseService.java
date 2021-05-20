package com.salemdoux.ecole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Adresse;
import com.salemdoux.ecole.repositories.AdresseRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository repo;

	public Adresse find(Integer id) throws ObjectNotFoundException {
		Optional<Adresse> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Adresse.class.getName()));

	}

	public Adresse insert(Adresse obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Adresse update(Adresse obj) throws ObjectNotFoundException {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) throws ObjectNotFoundException{
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um endereço relationado a uma pessoa");

		}
	}

}
