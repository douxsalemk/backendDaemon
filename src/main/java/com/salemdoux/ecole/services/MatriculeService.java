package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Matricule;
import com.salemdoux.ecole.domain.Matricule;
import com.salemdoux.ecole.repositories.MatriculeRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MatriculeService {

	@Autowired
	private MatriculeRepository repo;

	public Matricule find(Integer id) throws ObjectNotFoundException {
		Optional<Matricule> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Matricule.class.getName()));

	}
	
	public Matricule insert(Matricule obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Matricule update(Matricule obj) throws ObjectNotFoundException {
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
	
	public List<Matricule> findAll(){
		return repo.findAll();
	}
	
	public Page<Matricule> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	

}
