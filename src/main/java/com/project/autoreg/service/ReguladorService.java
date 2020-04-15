package com.project.autoreg.service;

import java.util.List;

import com.project.autoreg.model.Regulador;

public interface ReguladorService {


List<Regulador> findAll(); /* achará um lista (List) de regualdores */

Regulador findById(Long id); /* achará um regulador pelo seu id*/

Regulador save(Regulador regulador); /* salvará um regulador no banco de dados */

Regulador delete(); /*deletará um regulador do banco de dados */

Regulador findByCode(String code); /* achará um regulador pelo código do equipamento */





}