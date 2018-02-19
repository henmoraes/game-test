package br.com.hrmoraes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrmoraes.entity.Local;

public interface LocalDAO extends JpaRepository<Local, Integer>{

}
