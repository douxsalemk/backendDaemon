package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.repositories.EcoleRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;

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
	
	public Ecole insert(Ecole obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Ecole update(Ecole obj) throws ObjectNotFoundException {
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
	
	public List<Ecole> findAll(){
		return repo.findAll();
	}
	
	public Page<Ecole> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	

}
