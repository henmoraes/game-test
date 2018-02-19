package br.com.hrmoraes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrmoraes.entity.Suspeito;

public interface SuspeitoDAO extends JpaRepository<Suspeito, Integer>{

}
