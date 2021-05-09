package com.salemdoux.ecole;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.salemdoux.ecole.domain.Fonction;
import com.salemdoux.ecole.repositories.FonctionRepository;

@SpringBootApplication
public class EcoleApplication implements CommandLineRunner{

	@Autowired
	private FonctionRepository fonctionRepository;
	public static void main(String[] args) {
		SpringApplication.run(EcoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Fonction fonc1 = new Fonction(null, "Professeur");
		Fonction fonc2 = new Fonction(null, "Surveillant");
		
		fonctionRepository.saveAll(Arrays.asList(fonc1, fonc2));
	}

}
