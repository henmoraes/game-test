package br.com.hrmoraes.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Crime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7569778470498393915L;
	
	private Arma arma;
	private Local local;
	private Suspeito suspeito;

	public Crime() {
	}
	
	public Crime(Arma arma, Local local, Suspeito suspeito) {
		super();
		this.arma = arma;
		this.local = local;
		this.suspeito = suspeito;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Suspeito getSuspeito() {
		return suspeito;
	}

	public void setSuspeito(Suspeito suspeito) {
		this.suspeito = suspeito;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		if(arma != null) {
			sb.append(" | Arma: " + arma.getId() + "-" + arma.getNome());
		}
		if(local != null) {
			sb.append(" | Local: " + local.getId() + "-" + local.getNome());
		}
		if(suspeito != null) {
			sb.append(" | Suspeito: " + suspeito.getId() + "-" + suspeito.getNome());
		}
		return sb.toString();
	}
	
}
