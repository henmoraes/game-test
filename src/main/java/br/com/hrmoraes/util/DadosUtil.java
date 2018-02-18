package br.com.hrmoraes.util;

import java.util.ArrayList;
import java.util.List;

import br.com.hrmoraes.model.Arma;
import br.com.hrmoraes.model.Local;
import br.com.hrmoraes.model.Suspeito;

public class DadosUtil {

	private static List<Arma> armas;
	private static List<Local> locais;
	private static List<Suspeito> suspeitos;
	
	public static List<Arma> getArmas() {
		if ( armas == null ) {
			armas = new ArrayList<>();
			armas.add(new Arma(1,"Cajado Devastador"));
			armas.add(new Arma(2,"Phaser"));
			armas.add(new Arma(3,"Peixeira"));
			armas.add(new Arma(4,"Trezoitão"));
			armas.add(new Arma(5,"Sabre de Luz"));
			armas.add(new Arma(6,"Bomba"));
		}
		return armas;
	}
	public static List<Local> getLocais() {
		if ( locais == null ) {
			locais = new ArrayList<>();
			locais.add(new Local(1,"Etérnia"));
			locais.add(new Local(2,"Vulcano"));
			locais.add(new Local(3,"Tatooine"));
			locais.add(new Local(4,"Springfield"));
			locais.add(new Local(5,"Gotham"));
			locais.add(new Local(6,"Nova York"));
			locais.add(new Local(7,"Sibéria"));
			locais.add(new Local(8,"Machu Picchu"));
			locais.add(new Local(9,"Show do Katinguele"));
			locais.add(new Local(10,"São Paulo"));
		}
		return locais;
	}
	public static List<Suspeito> getSuspeitos() {
		if ( suspeitos == null ) {
			suspeitos = new ArrayList<>();
			suspeitos.add(new Suspeito(1,"Esqueleto"));
			suspeitos.add(new Suspeito(2,"Khan"));
			suspeitos.add(new Suspeito(3,"Darth vader"));
			suspeitos.add(new Suspeito(4,"Sideshow Bob"));
			suspeitos.add(new Suspeito(5,"Coringa"));
			suspeitos.add(new Suspeito(6,"Duende Verde"));
		}
		return suspeitos;
	}
	
}
