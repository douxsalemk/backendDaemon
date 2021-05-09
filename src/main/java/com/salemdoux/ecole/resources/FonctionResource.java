package com.salemdoux.ecole.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/fonctions")
public class FonctionResource {
	@RequestMapping(method=RequestMethod.GET)
	public String lister() {
		return "Rest está funcionando!";
	}

}
