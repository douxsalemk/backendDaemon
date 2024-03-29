package com.salemdoux.ecole.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salemdoux.ecole.domain.enums.Sexe;

@Entity
public class Employe extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ecole_id")
	private Ecole ecole;
	
	
	@OneToOne
	private Matricule matricule;
		
	@JoinColumn(name="fonction_id")
	
	@OneToOne
	private Fonction fonction;


	public Employe() {
		
	}
	
	
	public Employe(Integer id, String nom, String postNom, String preNom, Date dateDeNaissance, Adresse adresse,
			Contact contact, Sexe sexe,  Ecole ecole, Matricule matricule, Fonction fonction) {
		super(id, nom, postNom, preNom, dateDeNaissance, adresse, contact, sexe);
		this.id = id;
		this.ecole = ecole;
		this.matricule = matricule;
		this.fonction = fonction;
	}

	
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}


	public Matricule getMatricule() {
		return matricule;
	}

	public void setMatricule(Matricule matricule) {
		this.matricule = matricule;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
