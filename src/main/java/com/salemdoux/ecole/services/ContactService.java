package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Contact;
import com.salemdoux.ecole.dto.ContactDTO;
import com.salemdoux.ecole.repositories.ContactRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;
import com.salemdoux.ecole.services.exceptions.ObjectNotFoundException;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repo;

	public Contact find(Integer id) throws ObjectNotFoundException {
		Optional<Contact> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Contact.class.getName()));

	}
	
	public Contact insert(Contact obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Contact update(Contact obj){
		Contact newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}

	private void updateData(Contact newObj, Contact obj) {
		newObj.setEmail(obj.getEmail());;
		newObj.setTelefone(obj.getTelefone());;
	}

	public void delete(Integer id){
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um endereço relationado a uma pessoa");

		}
	}
	
	public List<Contact> findAll(){
		return repo.findAll();
	}
	
	public Page<Contact> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Contact fromDTO(ContactDTO objDto) {
		return new Contact(objDto.getId(), objDto.getEmail(), objDto.getTelefone());
	}
		
	
}
