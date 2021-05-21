package com.salemdoux.ecole.dto;

import java.io.Serializable;

import com.salemdoux.ecole.domain.Adresse;

public class AdresseDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String ville;
	private String quartier;
	private String avenue;
	
	public AdresseDTO() {
		
	}

	public AdresseDTO(Adresse obj) {
		id = obj.getId();
		ville = obj.getVille();
		quartier = obj.getQuartier();
		avenue = obj.getAvenue();
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
	
}
