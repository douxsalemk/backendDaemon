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

import com.salemdoux.ecole.domain.Adresse;
import com.salemdoux.ecole.dto.AdresseDTO;
import com.salemdoux.ecole.services.AdresseService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/adresses")
public class AdresseResource {
	
	@Autowired
	private AdresseService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Adresse> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Adresse obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
  
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AdresseDTO objDto){
		Adresse obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id").buildAndExpand(obj.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AdresseDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Adresse obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<AdresseDTO>> findAll() {
		List<Adresse> list = service.findAll();
		List<AdresseDTO> listDto = list.stream().map(obj -> new AdresseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AdresseDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="province") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Adresse> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AdresseDTO> listDto = list.map(obj -> new AdresseDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
		
}
