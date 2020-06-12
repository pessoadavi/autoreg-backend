package com.project.autoreg.repository;

import com.project.autoreg.model.Regulador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReguladorRepository extends JpaRepository <Regulador, Long> {

	Page<Regulador> findByCodeContainingAndRegionContainingAndFeederContainingAndBusContainingOrderByCodeDesc(String code, String region, String feeder, String bus, Pageable pageable);

    
	// ficar atento para o tipo de pages "int pages" , pois no projeto do klay foi posto "pageable pages", sendo que no service e implservice foram colocados o tipo de parametro int. O compilador pediu que eu mudasse para int pages
}