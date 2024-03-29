package com.salemdoux.ecole.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salemdoux.ecole.domain.Classe;
import com.salemdoux.ecole.dto.ClasseDTO;
import com.salemdoux.ecole.services.ClasseService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/classes")
public class classeRessource {

	@Autowired
	private ClasseService service;

	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Classe> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Classe obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClasseDTO objDto) throws ObjectNotFoundException {
		Classe obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Classe obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClasseDTO>> findAll() {
		List<Classe> list = service.findAll();
		List<ClasseDTO> listDto = list.stream().map(obj -> new ClasseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@CrossOrigin 
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClasseDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nom") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Classe> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClasseDTO> listDto = list.map(obj -> new ClasseDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
