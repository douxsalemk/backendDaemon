package com.salemdoux.ecole;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.salemdoux.ecole.domain.Adresse;
import com.salemdoux.ecole.domain.Contact;
import com.salemdoux.ecole.domain.Fonction;
import com.salemdoux.ecole.domain.Pessoa;
import com.salemdoux.ecole.repositories.AdmistrationRepository;
import com.salemdoux.ecole.repositories.AdresseHistRepository;
import com.salemdoux.ecole.repositories.AdresseRepository;
import com.salemdoux.ecole.repositories.ContactHistRepository;
import com.salemdoux.ecole.repositories.ContactRepository;
import com.salemdoux.ecole.repositories.EcoleRepository;
import com.salemdoux.ecole.repositories.EleveRepository;
import com.salemdoux.ecole.repositories.EmployeRepository;
import com.salemdoux.ecole.repositories.FonctionRepository;
import com.salemdoux.ecole.repositories.PessoaRepository;

@SpringBootApplication
public class EcoleApplication implements CommandLineRunner {

	@Autowired
	private FonctionRepository fonctionRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private AdmistrationRepository admistrationRepository;

	@Autowired
	private AdresseRepository adresseRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactHistRepository conHistRepository;

	@Autowired
	private AdresseHistRepository adresseHistRepository;

	@Autowired
	private EcoleRepository ecoleRepository;

	@Autowired
	private EleveRepository eleveRepository;

	@Autowired
	private EmployeRepository employeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Fonction fonc1 = new Fonction(null, "Professeur");
		Fonction fonc2 = new Fonction(null, "Surveillant");

		fonctionRepository.saveAll(Arrays.asList(fonc1, fonc2));

		Adresse a1 = new Adresse(null, "kinshasa", "Kinshasa", "Gombe", "Pont", "De la science", "n8");
		Adresse a2 = new Adresse(null, "Matadi", "Kinbangu", "gege", "pepe", "De la science", "n9");
		Adresse a3 = new Adresse(null, "kinshasa", "Kinshasa", "Mont-ngafula", "Belaire", "mbenseke", "n0");
		Adresse a4 = new Adresse(null, "kinshasa", "Kinshasa", "Selembao", "2pn", "Masasi", "n247 bis");
		Adresse a5 = new Adresse(null, "Lubumbashi", "Golf", "Golf", "PN", "De la patrie", "n8");

		Contact c1 = new Contact(null, "doux@gmail.com", "219913295");
		Contact c2 = new Contact(null, "detty@gmail.com", "219913265");
		Contact c3 = new Contact(null, "olivier@gmail.com", "219413295");
		Contact c4 = new Contact(null, "alex@gmail.com", "219913235");
		Contact c5 = new Contact(null, "jean@gmail.com", "219913295");
		Contact c6 = new Contact(null, "matheus@gmail.com", "219113295");
		Contact c7 = new Contact(null, "jovial@gmail.com", "219993295");
		Contact c8 = new Contact(null, "eraste@gmail.com", "219983295");
		Contact c9 = new Contact(null, "eben@gmail.com", "219913695");
		Contact c10 = new Contact(null, "moise@gmail.com", "219953295");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Pessoa p1 = new Pessoa(null, "Doux", "Salem", "Kayembe", sdf.parse("10/03/1900"), a1, c1);
		a1.getPessoas().addAll(Arrays.asList(p1));
		c1.getPessoas().addAll(Arrays.asList(p1));
		Pessoa p2 = new Pessoa(null, "Detty", "Kayaya", "Mukeba", sdf.parse("11/03/1991"), a2, c2);
		a2.getPessoas().addAll(Arrays.asList(p2));
		c2.getPessoas().addAll(Arrays.asList(p2));
		Pessoa p3 = new Pessoa(null, "Olivier", "Mukoko", "Makia", sdf.parse("12/03/1992"), a3, c3);
		a3.getPessoas().addAll(Arrays.asList(p3));
		c3.getPessoas().addAll(Arrays.asList(p3));
		Pessoa p4 = new Pessoa(null, "Alex", "Singa", "dont", sdf.parse("13/03/1993"), a4, c4);
		a4.getPessoas().addAll(Arrays.asList(p4));
		c4.getPessoas().addAll(Arrays.asList(p4));
		Pessoa p5 = new Pessoa(null, "Jean", "Makanga", "Mayombo", sdf.parse("14/03/1994"), a5, c5);
		a5.getPessoas().addAll(Arrays.asList(p5));
		c5.getPessoas().addAll(Arrays.asList(p5));
		Pessoa p6 = new Pessoa(null, "Matheus", "Oliveira", "Santos", sdf.parse("15/03/1995"), a1, c6);
		a1.getPessoas().addAll(Arrays.asList(p6));
		c6.getPessoas().addAll(Arrays.asList(p6));
		Pessoa p7 = new Pessoa(null, "Sarah", "Mbuyi", "Kayembe", sdf.parse("16/03/1990"), a2, c7);
		a2.getPessoas().addAll(Arrays.asList(p7));
		c7.getPessoas().addAll(Arrays.asList(p7));
		Pessoa p8 = new Pessoa(null, "Jovial", "Ngalula", "Kanaga", sdf.parse("17/03/1990"), a2, c8);
		a2.getPessoas().addAll(Arrays.asList(p8));
		c8.getPessoas().addAll(Arrays.asList(p8));
		Pessoa p9 = new Pessoa(null, "Eraste", "Kadiayi", "Mukeba", sdf.parse("18/03/1990"), a4, c9);
		a4.getPessoas().addAll(Arrays.asList(p9));
		c9.getPessoas().addAll(Arrays.asList(p9));
		Pessoa p10 = new Pessoa(null, "Eben", "Ezer", "Mukeba", sdf.parse("19/03/1990"), a1, c10);
		a1.getPessoas().addAll(Arrays.asList(p10));
		c10.getPessoas().addAll(Arrays.asList(p10));
		Pessoa p11 = new Pessoa(null, "Grace", "Ngandu", "Jaqueline", sdf.parse("20/03/1990"), a4, c1);
		a4.getPessoas().addAll(Arrays.asList(p11));
		c1.getPessoas().addAll(Arrays.asList(p11));
		Pessoa p12 = new Pessoa(null, "Moise", "Boele", "Boya", sdf.parse("30/03/1990"), a1, c2);
		a1.getPessoas().addAll(Arrays.asList(p12));
		c2.getPessoas().addAll(Arrays.asList(p12));

		adresseRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
		contactRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));

	}

}
