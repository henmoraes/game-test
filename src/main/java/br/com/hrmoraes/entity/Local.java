package br.com.hrmoraes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Local implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4143965992707084031L;

	@SequenceGenerator(name="Local_SEQ",sequenceName="Local_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Local_SEQ")	
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
