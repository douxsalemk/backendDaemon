package com.salemdoux.ecole.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ecole implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ecole;

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy="ecole") private List<Admistration> admistrateurs;
	 * 
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy="ecole") private List<Employe> employes;
	 * 
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy="ecole") private List<Eleve> eleves;
	 * 
	 * @OneToMany private List<Contact> contacts;
	 * 
	 * @OneToOne private Matricule matricule;
	 * 
	 */
	public Ecole() {

	}

	public Ecole(Integer id, String ecole) {
		super();
		this.id = id;
		this.ecole = ecole;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	/*
	 * public Matricule getMatricule() { return matricule; }
	 * 
	 * public void setMatricule(Matricule matricule) { this.matricule = matricule; }
	 * 
	 * 
	 * public List<Employe> getEmployes() { return employes; }
	 * 
	 * public void setEmployes(List<Employe> employes) { this.employes = employes; }
	 * 
	 * 
	 * public List<Admistration> getAdmistrateurs() { return admistrateurs; }
	 * 
	 * public void setAdmistrateurs(List<Admistration> admistrateurs) {
	 * this.admistrateurs = admistrateurs; }
	 * 
	 * public List<Employe> getEmployers() { return employes; }
	 * 
	 * public void setEmployers(List<Employe> employes) { this.employes = employes;
	 * }
	 * 
	 * public List<Eleve> getEleves() { return eleves; }
	 * 
	 * public void setEleves(List<Eleve> eleves) { this.eleves = eleves; }
	 * 
	 * public List<Contact> getContacts() { return contacts; }
	 * 
	 * public void setContacts(List<Contact> contacts) { this.contacts = contacts; }
	 */
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
		Ecole other = (Ecole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
