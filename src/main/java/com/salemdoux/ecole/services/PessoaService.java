package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Pessoa;
import com.salemdoux.ecole.repositories.PessoaRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Integer id) throws ObjectNotFoundException {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));

	}
	/*
	 * public Pessoa insert(Pessoa obj) { obj.setId(null); return repo.save(obj); }
	 */

	public Pessoa update(Pessoa obj) throws ObjectNotFoundException {
		Pessoa newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNom(obj.getNom());
		newObj.setPostNom(obj.getPostNom());
		newObj.setPreNom(obj.getPreNom());
		newObj.setSexe(obj.getSexe());
		newObj.setDateDeNaissance(obj.getDateDeNaissance());
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um endereço relationado a uma pessoa");

		}
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

	public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	/* NÂO SE PODE INICIALIZAR UMA PESSOA
	 * 
	 * public Pessoa fromDTO(PessoaDTO objDto) { return new Pessoa(objDto.getId(),
	 * objDto.getNom(), objDto.getPostNom(), objDto.getPreNom(), null, null, null);
	 * }
	 */
}
