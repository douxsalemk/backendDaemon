package com.salemdoux.ecole.domain.enums;

public enum Sexe {
	
	H(1, "HOMME"), 
	F(2, "FEMME");

	private int cod;
	private String descricao;

	private Sexe(int cod, String descricao) {
	this.cod = cod;
	this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Sexe toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (Sexe x : Sexe.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}
