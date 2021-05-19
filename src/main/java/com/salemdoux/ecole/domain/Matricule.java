package com.salemdoux.ecole.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matricule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Number numero;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "matricule")
	private Ecole ecole;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "matricule")
	private Admistration admistrateur;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "matricule")
	private Eleve eleve;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "matricule")
	private Employe employe;

	@OneToOne
	private Actif actif;
	
	public Matricule() {
		
	}
	
	public Matricule(Integer id, Number numero, Actif actif) {
		super();
		this.id = id;
		this.numero = numero;
		this.actif = actif;
	}
	

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	public Admistration getAdmistrateur() {
		return admistrateur;
	}

	public void setAdmistrateur(Admistration admistrateur) {
		this.admistrateur = admistrateur;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}



	public Integer getId() {
		return id;
	}

	public Actif getActif() {
		return actif;
	}

	public void setActif(Actif actif) {
		this.actif = actif;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Number getMatricule() {
		return numero;
	}

	public void setMatricule(Number numero) {
		this.numero = numero;
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
		Matricule other = (Matricule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
