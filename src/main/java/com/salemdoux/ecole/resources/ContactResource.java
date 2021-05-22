package com.salemdoux.ecole.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salemdoux.ecole.domain.Contact;
import com.salemdoux.ecole.dto.ContactDTO;
import com.salemdoux.ecole.services.ContactService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/contacts")
public class ContactResource {
	
	@Autowired
	private ContactService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Contact> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Contact obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
  
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ContactDTO objDto){
		Contact obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id").buildAndExpand(obj.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ContactDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Contact obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
  
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ContactDTO>> findAll() {
		List<Contact> list = service.findAll();
		List<ContactDTO> listDto = list.stream().map(obj -> new ContactDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ContactDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="email") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Contact> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ContactDTO> listDto = list.map(obj -> new ContactDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
		
}
