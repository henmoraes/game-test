package br.com.hrmoraes.bean;

import java.util.Random;

import br.com.hrmoraes.model.Arma;
import br.com.hrmoraes.model.Crime;
import br.com.hrmoraes.model.Local;
import br.com.hrmoraes.model.Suspeito;
import br.com.hrmoraes.util.DadosUtil;

public class AppBean {

	private Crime crimeDaVez;
	
	public Crime getCrimeDaVez() {
		return this.crimeDaVez;
	}
	
	public Crime startNewCrime() {
		int qtdArmas = DadosUtil.getArmas().size();
		int qtdLocais = DadosUtil.getLocais().size();
		int qtdSuspeitos = DadosUtil.getSuspeitos().size();
		
		Arma arma = DadosUtil.getArmas().get( new Random().nextInt(qtdArmas) );
		Local local = DadosUtil.getLocais().get( new Random().nextInt(qtdLocais) );
		Suspeito suspeito = DadosUtil.getSuspeitos().get( new Random().nextInt(qtdSuspeitos) );
		
		crimeDaVez = new Crime(arma,local,suspeito);
		return crimeDaVez;
	}
}
