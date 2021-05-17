package com.salemdoux.ecole.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Matricule implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Number matricule;

	@OneToMany(mappedBy="matricule")
	private List<Admistration> admistrations;
	
	@OneToMany(mappedBy="matricule")
	private List<Employe> employes;
	
	@OneToMany(mappedBy="matricule")
	private List<Eleve> eleves;

	
	public List<Admistration> getAdmistrations() {
		return admistrations;
	}


	public void setAdmistrations(List<Admistration> admistrations) {
		this.admistrations = admistrations;
	}


	public List<Employe> getEmployers() {
		return employes;
	}


	public void setEmployers(List<Employe> employes) {
		this.employes = employes;
	}


	public List<Eleve> getEleves() {
		return eleves;
	}


	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}


	public Matricule() {
		
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Number getMatricule() {
		return matricule;
	}

	public void setMatricule(Number matricule) {
		this.matricule = matricule;
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
