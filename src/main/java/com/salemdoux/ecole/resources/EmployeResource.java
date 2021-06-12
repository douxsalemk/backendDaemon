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

import com.salemdoux.ecole.domain.Employe;
import com.salemdoux.ecole.dto.EmployeDTO;
import com.salemdoux.ecole.dto.ObjectNewDTO;
import com.salemdoux.ecole.services.EmployeService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/employes")
public class EmployeResource {

	@Autowired
	private EmployeService service;

	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employe> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Employe obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ObjectNewDTO objDto) {
		Employe obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Employe obj, @PathVariable Integer id) {
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
	public ResponseEntity<List<EmployeDTO>> findAll() {
		List<Employe> list = service.findAll();
		List<EmployeDTO> listDto = list.stream().map(obj -> new EmployeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@CrossOrigin 
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EmployeDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nom") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Employe> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EmployeDTO> listDto = list.map(obj -> new EmployeDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
