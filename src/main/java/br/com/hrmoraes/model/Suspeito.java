package br.com.hrmoraes.model;

import java.io.Serializable;

public class Suspeito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4666444043009255834L;
	
	private int id;
	private String nome;
	
	public Suspeito() {
	}
	
	public Suspeito(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + id;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Suspeito)) {
			return false;
		}
		Suspeito other = (Suspeito) o;

		return id == other.getId();
	}
}
