package br.com.hrmoraes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrmoraes.entity.Arma;

public interface ArmaDAO extends JpaRepository<Arma, Integer>{

}
