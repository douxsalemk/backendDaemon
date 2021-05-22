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

import com.salemdoux.ecole.domain.Admistration;
import com.salemdoux.ecole.dto.AdmistrationDTO;
import com.salemdoux.ecole.dto.ObjectNewDTO;
import com.salemdoux.ecole.services.AdmistrationService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/admistrations")
public class AdmistrationResource {

	@Autowired
	private AdmistrationService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Admistration> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Admistration obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ObjectNewDTO objDto) {
		Admistration obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/*
	 * @RequestMapping(value="/{id}",method=RequestMethod.PUT) public
	 * ResponseEntity<Void> update(@Valid @RequestBody Admistration obj, @PathVariable
	 * Integer id){ obj.setId(id); obj = service.update(obj); return
	 * ResponseEntity.noContent().build(); }
	 * 
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AdmistrationDTO>> findAll() {
		List<Admistration> list = service.findAll();
		List<AdmistrationDTO> listDto = list.stream().map(obj -> new AdmistrationDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AdmistrationDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nom") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Admistration> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AdmistrationDTO> listDto = list.map(obj -> new AdmistrationDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
