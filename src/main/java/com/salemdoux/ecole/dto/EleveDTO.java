package com.salemdoux.ecole.dto;

import java.io.Serializable;

import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.domain.Eleve;
import com.salemdoux.ecole.domain.Matricule;

public class EleveDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private Ecole ecole;

	private Matricule matricule;
	
	public EleveDTO() {
		
	}

	public EleveDTO(Eleve obj) {
		id = obj.getId();
		ecole = obj.getEcole();
		matricule = obj.getMatricule();
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
	
}
