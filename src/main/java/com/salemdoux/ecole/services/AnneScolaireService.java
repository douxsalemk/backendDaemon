package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salemdoux.ecole.domain.AnneScolaire;
import com.salemdoux.ecole.dto.AnneScolaireDTO;
import com.salemdoux.ecole.repositories.AnneScolaireRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;
import com.salemdoux.ecole.services.exceptions.ObjectNotFoundException;

@Service
public class AnneScolaireService {

	@Autowired
	private AnneScolaireRepository repo;
	
	
	public AnneScolaire find(Integer id) {
		Optional<AnneScolaire> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + AnneScolaire.class.getName()));

	}


	@Transactional
	public AnneScolaire insert(AnneScolaireDTO objDto) {

		AnneScolaire a = new AnneScolaire(null, objDto.getDescricao(), objDto.getDateInicial(), objDto.getDateFinal());

		repo.save(a);
		return a;
	}


	public AnneScolaire update(AnneScolaire obj) {
		AnneScolaire newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(AnneScolaire newObj, AnneScolaire obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setDateFinal(obj.getDateFinal());
		newObj.setDateInicial(obj.getDateInicial());
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um Objeto relationado a um outro");

		}
	}

	public List<AnneScolaire> findAll() {
		return repo.findAll();
	}

	public Page<AnneScolaire> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
