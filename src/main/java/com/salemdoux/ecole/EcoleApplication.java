package com.salemdoux.ecole;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.salemdoux.ecole.domain.Actif;
import com.salemdoux.ecole.domain.Admistration;
import com.salemdoux.ecole.domain.Adresse;
import com.salemdoux.ecole.domain.Contact;
import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.domain.Eleve;
import com.salemdoux.ecole.domain.Employe;
import com.salemdoux.ecole.domain.Fonction;
import com.salemdoux.ecole.domain.Matricule;
import com.salemdoux.ecole.domain.Pessoa;
import com.salemdoux.ecole.domain.enums.Sexe;
import com.salemdoux.ecole.repositories.ActifRepository;
import com.salemdoux.ecole.repositories.AdmistrationRepository;
import com.salemdoux.ecole.repositories.AdresseRepository;
import com.salemdoux.ecole.repositories.ContactRepository;
import com.salemdoux.ecole.repositories.EcoleRepository;
import com.salemdoux.ecole.repositories.EleveRepository;
import com.salemdoux.ecole.repositories.EmployeRepository;
import com.salemdoux.ecole.repositories.FonctionRepository;
import com.salemdoux.ecole.repositories.MatriculeRepository;
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

	/*
	 * @Autowired private ContactHistRepository conHistRepository;
	 * 
	 * @Autowired private AdresseHistRepository adresseHistRepository;
	 */
	@Autowired
	private EcoleRepository ecoleRepository;

	@Autowired
	private EleveRepository eleveRepository;

	@Autowired
	private EmployeRepository employeRepository;

	@Autowired
	private ActifRepository actifRepository;

	@Autowired
	private MatriculeRepository matriculeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Fonction fonc1 = new Fonction(null, "Professeur");
		// Fonction fonc2 = new Fonction(null, "Surveillant");

		// fonctionRepository.saveAll(Arrays.asList(fonc1, fonc2));

		Adresse a1 = new Adresse(null, "kinshasa", "Kinshasa", "Gombe", "Pont", "De la science", "n8");
		Adresse a2 = new Adresse(null, "Matadi", "Kinbangu", "gege", "pepe", "De la science", "n9");
		Adresse a3 = new Adresse(null, "kinshasa", "Kinshasa", "Mont-ngafula", "Belaire", "mbenseke", "n0");
		Adresse a4 = new Adresse(null, "kinshasa", "Kinshasa", "Selembao", "2pn", "Masasi", "n247 bis");
		Adresse a5 = new Adresse(null, "Lubumbashi", "Golf", "Golf", "PN", "De la patrie", "n8");

		adresseRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));

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

		contactRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Pessoa p1 = new Pessoa(null, "Doux", "Salem", "Kayembe", sdf.parse("10/03/1900"), a1, c1, Sexe.H);
		a1.setPessoas(Arrays.asList(p1));
		c1.setPessoas(Arrays.asList(p1));

		Pessoa p2 = new Pessoa(null, "Detty", "Kayaya", "Mukeba", sdf.parse("11/03/1991"), a2, c2, Sexe.F);
		a2.setPessoas(Arrays.asList(p2));
		c2.setPessoas(Arrays.asList(p2));
		Pessoa p3 = new Pessoa(null, "Olivier", "Mukoko", "Makia", sdf.parse("12/03/1992"), a3, c3, Sexe.H);
		a3.setPessoas(Arrays.asList(p3));
		c3.setPessoas(Arrays.asList(p3));
		Pessoa p4 = new Pessoa(null, "Alex", "Singa", "dont", sdf.parse("13/03/1993"), a4, c4, Sexe.H);
		a4.setPessoas(Arrays.asList(p4));
		c4.setPessoas(Arrays.asList(p4));
		Pessoa p5 = new Pessoa(null, "Jean", "Makanga", "Mayombo", sdf.parse("14/03/1994"), a5, c5, Sexe.H);
		a5.setPessoas(Arrays.asList(p5));
		c5.setPessoas(Arrays.asList(p5));
		Pessoa p6 = new Pessoa(null, "Matheus", "Oliveira", "Santos", sdf.parse("15/03/1995"), a1, c6, Sexe.H);
		a1.setPessoas(Arrays.asList(p6));
		c6.setPessoas(Arrays.asList(p6));
		Pessoa p7 = new Pessoa(null, "Sarah", "Mbuyi", "Kayembe", sdf.parse("16/03/1990"), a2, c7, Sexe.F);
		a2.setPessoas(Arrays.asList(p7));
		c7.setPessoas(Arrays.asList(p7));
		Pessoa p8 = new Pessoa(null, "Jovial", "Ngalula", "Kanaga", sdf.parse("17/03/1990"), a2, c8, Sexe.F);
		a2.setPessoas(Arrays.asList(p8));
		c8.setPessoas(Arrays.asList(p8));
		Pessoa p9 = new Pessoa(null, "Eraste", "Kadiayi", "Mukeba", sdf.parse("18/03/1990"), a4, c9, Sexe.H);
		a4.setPessoas(Arrays.asList(p9));
		c9.setPessoas(Arrays.asList(p9));
		Pessoa p10 = new Pessoa(null, "Eben", "Ezer", "Mukeba", sdf.parse("19/03/1990"), a1, c10, Sexe.H);
		a1.setPessoas(Arrays.asList(p10));
		c10.setPessoas(Arrays.asList(p10));
		Pessoa p11 = new Pessoa(null, "Grace", "Ngandu", "Jaqueline", sdf.parse("20/03/1990"), a4, c1, Sexe.F);
		a4.setPessoas(Arrays.asList(p11));
		c1.setPessoas(Arrays.asList(p11));
		Pessoa p12 = new Pessoa(null, "Moise", "Boele", "Boya", sdf.parse("30/03/1990"), a1, c2, Sexe.H);
		a1.setPessoas(Arrays.asList(p12));
		c2.setPessoas(Arrays.asList(p12));

		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

		Actif ac1 = new Actif(null, true);
		Matricule m1 = new Matricule(null, 1, ac1);

		Actif ac2 = new Actif(null, true);
		Matricule m2 = new Matricule(null, 2, ac2);

		Actif ac3 = new Actif(null, true);
		Matricule m3 = new Matricule(null, 3, ac3);

		Actif ac4 = new Actif(null, true);
		Matricule m4 = new Matricule(null, 4, ac4);

		Actif ac5 = new Actif(null, true);
		Matricule m5 = new Matricule(null, 5, ac5);

		Actif ac6 = new Actif(null, true);
		Matricule m6 = new Matricule(null, 6, ac6);

		Actif ac7 = new Actif(null, true);
		Matricule m7 = new Matricule(null, 7, ac7);

		Actif ac8 = new Actif(null, true);
		Matricule m8 = new Matricule(null, 8, ac8);

		Actif ac9 = new Actif(null, true);
		Matricule m9 = new Matricule(null, 9, ac9);

		Actif ac10 = new Actif(null, true);
		Matricule m10 = new Matricule(null, 10, ac10);

		Actif ac11 = new Actif(null, true);
		Matricule m11 = new Matricule(null, 11, ac11);

		Actif ac12 = new Actif(null, true);
		Matricule m12 = new Matricule(null, 12, ac12);

		Actif ac13 = new Actif(null, true);
		Matricule m13 = new Matricule(null, 13, ac13);

		actifRepository.saveAll(Arrays.asList(ac1, ac2, ac3, ac4, ac5, ac6, ac7, ac8, ac9, ac10, ac11, ac12, ac13));
		matriculeRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13));

		Ecole e1 = new Ecole(null, "G.S CORBANS", m1);


		Admistration adm1 = new Admistration(null, e1, m2);
		Admistration adm2 = new Admistration(null, e1, m3);


		Eleve el1 = new Eleve(null, e1, m4);
		Eleve el2 = new Eleve(null, e1, m5);
		Eleve el3 = new Eleve(null, e1, m6);
		Eleve el4 = new Eleve(null, e1, m7);
		Eleve el5 = new Eleve(null, e1, m8);
		Eleve el6 = new Eleve(null, e1, m9);
		Eleve el7 = new Eleve(null, e1, m10);
		Eleve el8 = new Eleve(null, e1, m11);

		
		Fonction f1 = new Fonction(null, "PROFESEUR");
		Fonction f2 = new Fonction(null, "EDUCATRICE");


		Employe em1 = new Employe(null, e1, m12, f1);
		Employe em2 = new Employe(null, e1, m13, f2);

		
		e1.setAdmistrateurs(Arrays.asList(adm1, adm2));
		e1.setEleves(Arrays.asList(el1, el2, el3, el4, el5, el6, el7, el8));
		e1.setEmployers(Arrays.asList(em1, em2));
		e1.setContacts(Arrays.asList(c1, c2));
		
		ecoleRepository.saveAll(Arrays.asList(e1));
		admistrationRepository.saveAll(Arrays.asList(adm1, adm2));
		eleveRepository.saveAll(Arrays.asList(el1, el2, el3, el4, el5, el6, el7, el8));
		fonctionRepository.saveAll(Arrays.asList(f1, f2));
		employeRepository.saveAll(Arrays.asList(em1, em2));
	}
}
