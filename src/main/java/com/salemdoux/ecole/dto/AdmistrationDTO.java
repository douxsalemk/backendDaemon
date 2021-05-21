package com.salemdoux.ecole.dto;

import java.io.Serializable;

import com.salemdoux.ecole.domain.Admistration;
import com.salemdoux.ecole.domain.Ecole;
import com.salemdoux.ecole.domain.Matricule;

public class AdmistrationDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
		
	private Ecole ecole;

	private Matricule matricule;
	
	public AdmistrationDTO() {
		
	}

	public AdmistrationDTO(Admistration obj) {
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
