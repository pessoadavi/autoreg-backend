package com.project.autoreg.service.reguladorserviceimpl;

import java.util.List;
import java.util.Optional;

import com.project.autoreg.model.Regulador;
import com.project.autoreg.repository.ReguladorRepository;
import com.project.autoreg.service.ReguladorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReguladorServiceImpl implements ReguladorService {

	@Autowired /* Ponto de injeção do repositório */
	ReguladorRepository reguladorRepository;

	@Override
	public Optional<Regulador> findById(Long id) {
		return this.reguladorRepository.findById(id);
	}

	@Override
	public Regulador createRegulador(Regulador regulador) {
		return this.reguladorRepository.save(regulador);
	}

	@Override
	public void deleteRegulador(Regulador regulador) {
		this.reguladorRepository.delete(regulador);

	}

	@Override
	public Page<Regulador> listAll(int page, int count) {
		PageRequest pages = PageRequest.of(page, count);
		return this.reguladorRepository.findAll(pages);
	}

	/* teste 
	@Override
	public List<Regulador> findAll2() {
		return this.reguladorRepository.findAll();
	}*/

	@Override
	public Page<Regulador> findByParameters(String code, String region, String feeder, String bus, int page,
			int count) {

		Pageable pageable = PageRequest.of(page, count);
		return this.reguladorRepository
				.findByCodeContainingAndRegionContainingAndFeederContainingAndBusContainingOrderByCodeDesc(code, region,
						feeder, bus, pageable);
	}

	
	
}