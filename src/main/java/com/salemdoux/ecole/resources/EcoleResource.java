package com.salemdoux.ecole.resources;

import java.net.URI;

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

import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.dto.EcoleDTO;
import com.salemdoux.ecole.services.EcoleService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/ecoles")
public class EcoleResource {
	
	@Autowired
	private EcoleService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Ecole obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
  
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Ecole obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id").buildAndExpand(obj.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Ecole obj, @PathVariable Integer id) throws ObjectNotFoundException{
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
  
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EcoleDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="ecole") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Ecole> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EcoleDTO> listDto = list.map(obj -> new EcoleDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
