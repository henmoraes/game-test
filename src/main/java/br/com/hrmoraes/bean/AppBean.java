package br.com.hrmoraes.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.hrmoraes.dao.ArmaDAO;
import br.com.hrmoraes.dao.LocalDAO;
import br.com.hrmoraes.dao.SuspeitoDAO;
import br.com.hrmoraes.model.Arma;
import br.com.hrmoraes.model.Crime;
import br.com.hrmoraes.model.Local;
import br.com.hrmoraes.model.Suspeito;

public class AppBean {

	private Crime crimeDaVez;
	
	private List<Arma> armas;
	private List<Local> locais;
	private List<Suspeito> suspeitos;
	
	@Autowired
	private ArmaDAO armaDAO;
	
	@Autowired
	private LocalDAO localDAO;
	
	@Autowired
	private SuspeitoDAO suspeitoDAO;
	
	@PostConstruct
	public void postConstruct() {
		if ( armas == null ) {
			armas = new ArrayList<>();
			for(br.com.hrmoraes.entity.Arma a : armaDAO.findAll()) {
				Arma arma = new Arma();
				BeanUtils.copyProperties(a, arma);
				armas.add(arma);
			}
			
			locais = new ArrayList<>();
			for(br.com.hrmoraes.entity.Local a : localDAO.findAll()) {
				Local local = new Local();
				BeanUtils.copyProperties(a, local);
				locais.add(local);
			}
			
			suspeitos = new ArrayList<>();
			for(br.com.hrmoraes.entity.Suspeito a : suspeitoDAO.findAll()) {
				Suspeito suspeito = new Suspeito();
				BeanUtils.copyProperties(a, suspeito);
				suspeitos.add(suspeito);
			}
		}
	}
	
	public Crime getCrimeDaVez() {
		return this.crimeDaVez;
	}
	
	public Crime startNewCrime() {
		int qtdArmas = armas.size();
		int qtdLocais = locais.size();
		int qtdSuspeitos = suspeitos.size();
		
		Arma arma = armas.get( new Random().nextInt(qtdArmas) );
		Local local = locais.get( new Random().nextInt(qtdLocais) );
		Suspeito suspeito = suspeitos.get( new Random().nextInt(qtdSuspeitos) );
		
		crimeDaVez = new Crime(arma,local,suspeito);
		return crimeDaVez;
	}

	public List<Arma> getArmas() {
		return armas;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public List<Suspeito> getSuspeitos() {
		return suspeitos;
	}
}
