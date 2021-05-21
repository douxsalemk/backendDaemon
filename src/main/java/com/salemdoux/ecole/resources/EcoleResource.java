package com.salemdoux.ecole.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salemdoux.ecole.domain.Ecole;
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
  
}
