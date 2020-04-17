package com.project.autoreg.controller;

import javax.validation.Valid;

import com.project.autoreg.model.Regulador;
import com.project.autoreg.service.ReguladorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReguladorController {

    @Autowired      /* ponto de injeção de dependencia da do repositório */
    ReguladorService reguladorService;

    @PostMapping(value = "/cadastrarRegulador")
    public String cadastrarRegulador(@Valid Regulador regulador, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
                
        
        
        } 
           
        reguladorService.save(regulador);
        return "redirect:/cadastrarRegulador";

    
    }

}