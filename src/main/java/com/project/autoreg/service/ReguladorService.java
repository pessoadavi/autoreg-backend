package com.project.autoreg.service;

import java.util.Optional;

import com.project.autoreg.model.Regulador;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
public interface ReguladorService {

    
    
Page<Regulador> listAll(int page, int count); /* achará um lista (List) de regualdores */

Optional<Regulador> findById(Long id); /* achará um regulador pelo seu id*/

Regulador createRegulador(Regulador regulador); /* salvará um regulador no banco de dados */

void deleteRegulador(Regulador regulador); /*deletará um regulador do banco de dados */

Page<Regulador> findByParameters(String code, String region, String feeder, String bus, int page, int count); /* achará um regulador pelo código do equipamento */

/* teste 
List<Regulador> findAll2(); */


}