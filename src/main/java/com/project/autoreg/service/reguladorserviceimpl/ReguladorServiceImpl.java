package com.project.autoreg.service.reguladorserviceimpl;

import java.util.List;

import com.project.autoreg.model.Regulador;
import com.project.autoreg.repository.ReguladorRepository;
import com.project.autoreg.service.ReguladorService;

import org.springframework.beans.factory.annotation.Autowired;

public class ReguladorServiceImpl implements ReguladorService {

    @Autowired /* Ponto de injeção do repositório */
    ReguladorRepository reguladorRepository;

	@Override
	public List<Regulador> findAll() {
		return (List<Regulador>) reguladorRepository.findAll();
	}

	@Override
	public Regulador findById(Long id) {
		return reguladorRepository.findById(id).get();
	}

	@Override
	public Regulador save(Regulador regulador) {
		return reguladorRepository.save(regulador);
	}

	@Override
	public Regulador delete(Regulador regulador) {
		 this.reguladorRepository.delete(regulador);
		 return null;
	}

	@Override
	public Regulador findByCode(String code) {
		return reguladorRepository.findByCode(code);
	}

}