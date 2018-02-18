package br.com.hrmoraes.model;

import java.io.Serializable;

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

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + arma.hashCode();
		result = 31 * result + local.hashCode();
		result = 31 * result + suspeito.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Crime)) {
			return false;
		}
		Crime other = (Crime) o;

		return arma.equals(other.getArma()) &&
				local.equals(other.getLocal()) && 
				suspeito.equals(other.getSuspeito()) ;
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
