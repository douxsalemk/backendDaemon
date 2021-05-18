package com.salemdoux.ecole.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.salemdoux.ecole.domain.enums.Sexe;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;
	private String postNom;
	private String preNom;

	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;

	private Integer sexe;

	@ManyToOne
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Contact contact;

	/*
	 * @OneToOne private Ecole ecole;
	 * 
	 * @OneToOne private Admistration admistrateur;
	 * 
	 * @OneToOne private Eleve eleve;
	 * 
	 * @OneToOne private Employe employe; */
	  
	  
	  
	 /*
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "adresseHistoric_id" ) private AdresseHist
	 * adresseHistoric;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "contactHistoric_id") private ContactHist contactHistoric;
	 */
	public Pessoa() {

	}

	public Pessoa(Integer id, String nom, String postNom, String preNom, Date dateDeNaissance, Adresse adresse,
			Contact contact, Sexe sexe) {
		super();
		this.id = id;
		this.nom = nom;
		this.postNom = postNom;
		this.preNom = preNom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.contact = contact;
		this.sexe = sexe.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/*
	 * public AdresseHist getAdresseHistoric() { return adresseHistoric; }
	 * 
	 * public void setAdressHist(AdresseHist adresseHistoric) { this.adresseHistoric
	 * = adresseHistoric; }
	 * 
	 * public ContactHist getContactHistoric() { return contactHistoric; }
	 * 
	 * public void setContactHist(ContactHist contactHistoric) {
	 * this.contactHistoric = contactHistoric; }
	 */
	public Sexe getSexe() {
		return Sexe.toEnum(sexe);
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe.getCod();
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
