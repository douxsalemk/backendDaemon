package com.salemdoux.ecole.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salemdoux.ecole.domain.Fonction;
import com.salemdoux.ecole.services.FonctionService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/fonction")
public class FonctionResource {
	
	@Autowired
	private FonctionService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws ObjectNotFoundException {
		Fonction obj = service.buscar(id);		
		return ResponseEntity.ok().body(obj);
	}
  
}
