package br.com.hrmoraes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrmoraes.bean.AppBean;
import br.com.hrmoraes.model.Arma;
import br.com.hrmoraes.model.Crime;
import br.com.hrmoraes.model.Local;
import br.com.hrmoraes.model.Suspeito;

@RestController
@RequestMapping(value = AppController.REQUEST_MAPPING)
public class AppController {

	private static final Logger LOG = Logger.getLogger(AppController.class);

	static final String REQUEST_MAPPING = "/";
	private static final String REQUEST_NEW_CRIME = "/novo-crime";
	private static final String REQUEST_CRIME = "/crime";
	private static final String REQUEST_VALIDATE_CRIME = "/validar-teoria-crime";
	
	private static final String REQUEST_ARMAS = "/armas";
	private static final String REQUEST_LOCAIS = "/locais";
	private static final String REQUEST_SUSPEITOS = "/suspeitos";

	@Autowired
	private AppBean appBean;

	@RequestMapping(value=REQUEST_VALIDATE_CRIME, method = RequestMethod.POST)
	public ResponseEntity<String> validarTeoria(@RequestBody Crime crimeToValidate) {
		LOG.info("Validando teoria do crime...");

		try {
			if( crimeToValidate == null ) {
				return new ResponseEntity<String>("Você deve dizer qual teoria deseja validar!", HttpStatus.BAD_REQUEST);
			}
			Crime crimeDaVez = appBean.getCrimeDaVez();
			if( crimeDaVez == null ) {
				crimeDaVez = appBean.startNewCrime();
			}
			
			if ( crimeToValidate.equals(crimeDaVez) ) {
				return new ResponseEntity<String>("Parabéns, você resolveu o crime !", HttpStatus.OK);
			}else {
				List<String> erros = new ArrayList<>();
				if( ! crimeToValidate.getArma().equals(crimeDaVez.getArma()) ) {
					erros.add("Arma incorreta!");
				}
				if( ! crimeToValidate.getLocal().equals(crimeDaVez.getLocal()) ) {
					erros.add("Local incorreto!");
				}
				if( ! crimeToValidate.getSuspeito().equals(crimeDaVez.getSuspeito()) ) {
					erros.add("Suspeito incorreto!");
				}
				int idRet = new Random().nextInt(erros.size());
				return new ResponseEntity<String>(erros.get(idRet), HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Erro durante execucao", e);
			return new ResponseEntity<String>("Ops, ocorreu um problema!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value=REQUEST_CRIME, method = RequestMethod.GET)
	public ResponseEntity<String> getCrime() {
		LOG.info("Obtendo crime atual...");

		Crime crime = appBean.getCrimeDaVez();
		if( crime == null) {
			return new ResponseEntity<String>("Ainda não há crime ! ", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Crime da vez é: " + crime.toString(), HttpStatus.OK);
	}

	@RequestMapping(value=REQUEST_NEW_CRIME, method = RequestMethod.POST)
	public ResponseEntity<String> iniciarNovoCrime() {
		LOG.info("Iniciando novo crime...");
		Crime crime = appBean.startNewCrime();
		return new ResponseEntity<String>(crime.toString(), HttpStatus.OK);
	}

	@RequestMapping(value=REQUEST_ARMAS, method = RequestMethod.GET)
	public ResponseEntity<List<Arma>> getArmas() {
		return new ResponseEntity<List<Arma>>(appBean.getArmas(), HttpStatus.OK);
	}
	
	@RequestMapping(value=REQUEST_LOCAIS, method = RequestMethod.GET)
	public ResponseEntity<List<Local>> getLocais() {
		return new ResponseEntity<List<Local>>(appBean.getLocais(), HttpStatus.OK);
	}
	
	@RequestMapping(value=REQUEST_SUSPEITOS, method = RequestMethod.GET)
	public ResponseEntity<List<Suspeito>> getSuspeitos() {
		return new ResponseEntity<List<Suspeito>>(appBean.getSuspeitos(), HttpStatus.OK);
	}
}
