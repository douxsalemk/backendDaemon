package com.salemdoux.ecole.dto;

import java.io.Serializable;

import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.domain.Employe;
import com.salemdoux.ecole.domain.Fonction;
import com.salemdoux.ecole.domain.Matricule;

public class EmployeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nom;
	private String postNom;
	private String preNom;
	
	private Ecole ecole;

	private Matricule matricule;

	private Fonction fonction;

	public EmployeDTO() {

	}

	public EmployeDTO(Employe obj) {
		id = obj.getId();
		nom = obj.getNom();
		postNom = obj.getPostNom();
		preNom = obj.getPreNom();
		ecole = obj.getEcole();
		matricule = obj.getMatricule();
		fonction = obj.getFonction();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	public Matricule getMatricule() {
		return matricule;
	}

	public void setMatricule(Matricule matricule) {
		this.matricule = matricule;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPostNom() {
		return postNom;
	}
	
	public void setPostNom(String postNom) {
		this.postNom = postNom;
	}
	
	public String getPreNom() {
		return preNom;
	}
	
	public void setPreNom(String preNom) {
		this.preNom = preNom;
	}

}
