package br.com.hrmoraes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Suspeito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8956731809429787927L;

	@SequenceGenerator(name="Suspeito_SEQ",sequenceName="Suspeito_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Suspeito_SEQ")	
	@Id
	private int id;
	
	@Column(length=100,nullable=false)
	private String nome;

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
	
}
