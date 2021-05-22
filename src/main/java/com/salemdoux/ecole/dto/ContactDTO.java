package com.salemdoux.ecole.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import com.salemdoux.ecole.domain.Contact;

public class ContactDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@Email
	private String email;
	
	private String telefone;


	public ContactDTO(Contact obj) {
		id = obj.getId();
		email = obj.getEmail();
		telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
}
