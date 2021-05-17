package com.salemdoux.ecole.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Admistration implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa identidade;

	
	@ManyToOne
	@JoinColumn(name="matricule_id")
	private Matricule matricule;

	@OneToOne
	@MapsId
	private Actif actif;
	
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	@ManyToOne
	@JoinColumn(name="ecole_id")
	private Ecole ecole;
	
	public Pessoa getIdentite() {
		return identidade;
	}

	public void setIdentite(Pessoa identidade) {
		this.identidade = identidade;
	}

	public Matricule getMatricule() {
		return matricule;
	}

	public void setMatricule(Matricule matricule) {
		this.matricule = matricule;
	}

	public Actif getActif() {
		return actif;
	}

	public void setActif(Actif actif) {
		this.actif = actif;
	}

	public Admistration() {
		
	}
	
	public Admistration(Integer id) {
		super();
		this.id = id;
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
		Admistration other = (Admistration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
