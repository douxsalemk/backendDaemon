package com.salemdoux.ecole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salemdoux.ecole.domain.Actif;
import com.salemdoux.ecole.domain.Admistration;
import com.salemdoux.ecole.domain.Adresse;
import com.salemdoux.ecole.domain.Contact;
import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.domain.Matricule;
import com.salemdoux.ecole.dto.ObjectNewDTO;
import com.salemdoux.ecole.repositories.ActifRepository;
import com.salemdoux.ecole.repositories.AdmistrationRepository;
import com.salemdoux.ecole.repositories.AdresseRepository;
import com.salemdoux.ecole.repositories.ContactRepository;
import com.salemdoux.ecole.repositories.EcoleRepository;
import com.salemdoux.ecole.repositories.MatriculeRepository;
import com.salemdoux.ecole.services.exceptions.DataIntegrityException;
import com.salemdoux.ecole.services.exceptions.ObjectNotFoundException;

@Service
public class AdmistrationService {

	@Autowired
	private AdmistrationRepository repo;

	@Autowired
	private EcoleRepository ecoleRepository;

	@Autowired
	private MatriculeRepository matriculeRepository;

	@Autowired
	private AdresseRepository adresseRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ActifRepository actifRepository;

	public Admistration find(Integer id) {
		Optional<Admistration> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Admistration.class.getName()));

	}

	public Admistration insert(ObjectNewDTO objDto) {

		Adresse a = new Adresse(null, objDto.getProvince(), objDto.getVille(), objDto.getComune(), objDto.getQuartier(),
				objDto.getAvenue(), objDto.getReference());
		Contact c = new Contact(null, objDto.getEmail(), objDto.getTelefone());
		Actif ac = new Actif(null, objDto.getActif());
		Ecole ec = new Ecole(null, objDto.getEcole());
		Matricule m = new Matricule(null, objDto.getNumero(), ac);

		Admistration e = new Admistration(null, objDto.getNom(), objDto.getPostNom(), objDto.getPreNom(), objDto.getDateDeNaissance(),
				a, c, objDto.getSexe(), ec, m);

		actifRepository.save(ac);
		matriculeRepository.save(m);
		adresseRepository.save(a);
		contactRepository.save(c);
		ecoleRepository.save(ec);
		repo.save(e);
		return e;
	}

	/*
	 * public Admistration update(Admistration obj) { Admistration newObj = find(obj.getId());
	 * updateData(newObj, obj); return repo.save(newObj); }
	 * 
	 * private void updateData(Admistration newObj, Admistration obj) {
	 * newObj.setNom(obj.getNom()); newObj.setPostNom(obj.getPostNom());
	 * newObj.setPreNom(obj.getPreNom()); newObj.setSexe(obj.getSexe());
	 * newObj.setDateDeNaissance(obj.getDateDeNaissance());
	 * newObj.setAdresse(obj.getAdresse()); newObj.setContact(obj.getContact());
	 * newObj.setEcole(obj.getEcole()); newObj.setMatricule(obj.getMatricule()); }
	 * 
	 */
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um Objeto relationado a um outro");

		}
	}

	public List<Admistration> findAll() {
		return repo.findAll();
	}

	public Page<Admistration> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
