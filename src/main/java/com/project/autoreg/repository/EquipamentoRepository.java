package com.project.autoreg.repository;
import com.project.autoreg.model.Regulador;

import org.springframework.data.repository.CrudRepository;

public interface EquipamentoRepository extends CrudRepository<Regulador, String> {

    Regulador findByCode(String code);

}