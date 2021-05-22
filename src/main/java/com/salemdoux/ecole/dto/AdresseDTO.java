package com.salemdoux.ecole.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.salemdoux.ecole.domain.Adresse;

public class AdresseDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;

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

	public AdresseDTO() {
		
	}

	public AdresseDTO(Adresse obj) {
		id = obj.getId();
		province = obj.getProvince();
		ville = obj.getVille();
		comune = obj.getComune();
		quartier = obj.getQuartier();
		avenue = obj.getAvenue();
		reference = obj.getReference();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
