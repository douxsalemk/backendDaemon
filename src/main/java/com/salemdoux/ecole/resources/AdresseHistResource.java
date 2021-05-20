package com.salemdoux.ecole.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salemdoux.ecole.domain.AdresseHist;
import com.salemdoux.ecole.services.AdresseHistService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/adresseHists")
public class AdresseHistResource {
	
	@Autowired
	private AdresseHistService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		AdresseHist obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
  
}
