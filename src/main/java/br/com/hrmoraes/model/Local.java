package br.com.hrmoraes.model;

import java.io.Serializable;

public class Local implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8989506842989608155L;
	
	private int id;
	private String nome;
	
	public Local() {
	}
	
	public Local(int id, String nome) {
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
		if (!(o instanceof Local)) {
			return false;
		}
		Local other = (Local) o;

		return id == other.getId();
	}
}
