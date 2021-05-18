package com.salemdoux.ecole.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactHist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*
	 * @OneToOne(cascade = CascadeType.ALL, mappedBy = "contactHistoric") private
	 * Pessoa pessoa;
	 * 
	 * 
	 * @OneToMany private List<Contact> contactHistoric;
	 */
	public ContactHist() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * public Pessoa getPessoa() { return pessoa; }
	 * 
	 * public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
	 * 
	 * public List<Contact> getContactHist() { return contactHistoric; }
	 * 
	 * public void setContactHist(List<Contact> contactHistoric) {
	 * this.contactHistoric = contactHistoric; }
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
		ContactHist other = (ContactHist) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
