package com.salemdoux.ecole.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salemdoux.ecole.domain.Fonction;

@RestController
@RequestMapping(value="/fonctions")
public class FonctionResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Fonction> lister() {
		
		Fonction fonc1 = new Fonction(1, "Professeur");
		Fonction fonc2 = new Fonction(2, "Directeur");
		
		List<Fonction> liste = new ArrayList<>();
		liste.add(fonc1);
		liste.add(fonc2);
		
		return liste;
	}

}
