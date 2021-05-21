package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Employe;
import com.salemdoux.ecole.domain.Employe;
import com.salemdoux.ecole.repositories.EmployeRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;

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

	public Employe insert(Employe obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Employe update(Employe obj) throws ObjectNotFoundException {
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
	
	public List<Employe> findAll(){
		return repo.findAll();
	}
	
	public Page<Employe> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	
}
