package com.salemdoux.ecole.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.salemdoux.ecole.domain.enums.Sexe;

public class ObjectNewDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
		
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=120, message= "O tamanho deve ser entre 3 e 120 caracteres")
	private String nom;
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=120, message= "O tamanho deve ser entre 3 e 120 caracteres")
	private String postNom;

	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=120, message= "O tamanho deve ser entre 3 e 120 caracteres")
	private String preNom;
	
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=80, message= "O tamanho deve ser entre 3 e 80 caracteres")
	private String province;

	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=80, message= "O tamanho deve ser entre 3 e 80 caracteres")
	private String comune;
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=80, message= "O tamanho deve ser entre 3 e 80 caracteres")
	private String ville;
	
	@NotEmpty(message = "prenchimento obrigatório")
	private String quartier;
	
	@NotEmpty(message = "prenchimento obrigatório")
	private String avenue;
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(max=80, message= "O tamanho deve ser menor que 80 caracteres")
	private String reference;
	
	@Email
	private String email;
	
	private String telefone;
	
	@NotNull
	private Boolean actif;
	
	private Number numero;
	
	private String fonction;
	
	

	private Integer sexe;
	

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	private String ecole;
	
	

	public ObjectNewDTO() {
		
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

	public Sexe getSexe() {
		return Sexe.toEnum(sexe);
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe.getCod();
	}
	

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getAvenue() {
		return avenue;
	}

	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}
	
		
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getComune() {
		return comune;
	}
	
	public void setComune(String comune) {
		this.comune = comune;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public Boolean getActif() {
		return actif;
	}
	
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	public Number getNumero() {
		return numero;
	}
	
	public void setNumero(Number numero) {
		this.numero = numero;
	}

	public String getEcole() {
		return ecole;
	}
	
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	
	
}
