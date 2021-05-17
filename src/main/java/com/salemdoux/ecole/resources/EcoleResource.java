package com.salemdoux.ecole.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salemdoux.ecole.domain.Pessoa;
import com.salemdoux.ecole.services.PessoaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/ecole")
public class EcoleResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws ObjectNotFoundException {
		Pessoa obj = service.buscar(id);		
		return ResponseEntity.ok().body(obj);
	}
  
}
