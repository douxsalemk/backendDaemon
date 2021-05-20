package com.salemdoux.ecole.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salemdoux.ecole.domain.Eleve;
import com.salemdoux.ecole.services.EleveService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/eleve")
public class EleveResource {
	
	@Autowired
	private EleveService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Eleve obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
  
}
