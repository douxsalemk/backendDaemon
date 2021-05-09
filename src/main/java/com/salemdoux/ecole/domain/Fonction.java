package com.salemdoux.ecole.domain;

import java.io.Serializable;

public class Fonction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  fonction;
	
	public Fonction() {
	}

	public Fonction(Integer id, String fonction) {
		super();
		this.id = id;
		this.fonction = fonction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
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
		Fonction other = (Fonction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
