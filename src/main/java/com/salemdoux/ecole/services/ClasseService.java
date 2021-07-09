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
import com.salemdoux.ecole.domain.Classe;
import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.dto.ClasseDTO;
import com.salemdoux.ecole.repositories.ClasseRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;
import com.salemdoux.ecole.services.exceptions.ObjectNotFoundException;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository repo;


	@Autowired
	private AnneScolaireService serv;
	
	@Autowired
	private EcoleService servE;
	
	
	public Classe find(Integer id) {
		Optional<Classe> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Classe.class.getName()));

	}
		
	@Transactional
	public Classe insert(ClasseDTO objDto) throws javassist.tools.rmi.ObjectNotFoundException {
		
		AnneScolaire a =  serv.find(objDto.getAnneScolaire());

		Ecole e = servE.find(objDto.getEcole());
		
		Classe c = new Classe(null, objDto.getDescricao(), a, e);

		repo.save(c);
		return c;
	}


	public Classe update(Classe obj) {
		Classe newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Classe newObj, Classe obj) {
		newObj.setDescricao(obj.getDescricao());
	}
	

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um Objeto relationado a um outro");

		}
	}

	public List<Classe> findAll() {
		return repo.findAll();
	}

	public Page<Classe> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
