package com.project.autoreg.repository;

import com.project.autoreg.model.Regulador;

import org.springframework.data.repository.CrudRepository;

public interface ReguladorRepository extends CrudRepository <Regulador, Long> {

	Regulador findByCode(String code);

    

}