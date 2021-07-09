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

import com.salemdoux.ecole.domain.AnneScolaire;
import com.salemdoux.ecole.dto.AnneScolaireDTO;
import com.salemdoux.ecole.services.AnneScolaireService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/annescolaires")
public class AnneScolaireResource {

	@Autowired
	private AnneScolaireService service;

	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AnneScolaire> find(@PathVariable Integer id) throws ObjectNotFoundException {
		AnneScolaire obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AnneScolaireDTO objDto) {
		AnneScolaire obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AnneScolaire obj, @PathVariable Integer id) {
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
	public ResponseEntity<List<AnneScolaireDTO>> findAll() {
		List<AnneScolaire> list = service.findAll();
		List<AnneScolaireDTO> listDto = list.stream().map(obj -> new AnneScolaireDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@CrossOrigin 
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AnneScolaireDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nom") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<AnneScolaire> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AnneScolaireDTO> listDto = list.map(obj -> new AnneScolaireDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
