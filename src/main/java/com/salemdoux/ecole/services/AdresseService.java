package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Adresse;
import com.salemdoux.ecole.dto.AdresseDTO;
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
		Adresse newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}

	private void updateData(Adresse newObj, Adresse obj) {
		newObj.setProvince(obj.getProvince());;
		newObj.setVille(obj.getVille());;
		newObj.setComune(obj.getComune());
		newObj.setQuartier(obj.getQuartier());
		newObj.setAvenue(obj.getAvenue());
		newObj.setReference(obj.getReference());
	}
	
	public void delete(Integer id) throws ObjectNotFoundException{
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um dado que possui relationamento com outros dados");

		}
	}
	
	public List<Adresse> findAll(){
		return repo.findAll();
	}
	
	public Page<Adresse> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Adresse fromDTO(AdresseDTO objDto) {
		return new Adresse(objDto.getId(), objDto.getProvince(), objDto.getVille(), objDto.getComune(), objDto.getQuartier(), objDto.getAvenue(), objDto.getReference());
	}
			

	
}
