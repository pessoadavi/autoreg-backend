package com.project.autoreg.controller;

import javax.validation.Valid;

import com.project.autoreg.model.Regulador;
import com.project.autoreg.service.ReguladorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReguladorController {

    @Autowired                                                      /* ponto de injeção de dependencia da do repositório */
    ReguladorService reguladorService;

    @GetMapping(value ="/cadastrarRegulador")                       /* Método que carrega a view do preenchimento de um novo equipamento */
    public String formulario() {
        return "formEquipamento";
    }
     

    @PostMapping(value = "/cadastrarRegulador")                     /* Método que salva um novo regulador */
    public String cadastrarRegulador(@Valid Regulador regulador, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Campos obrigatórios devem ser preenchidos.");
            return "redirect:/cadastrarRegulador";
        } 
           
        reguladorService.save(regulador);
        attributes.addFlashAttribute("mensagem", "Equipamento salvo");
        return "redirect:/cadastrarRegulador";
    }

    
    @RequestMapping("/equipamentos")                                /* Método para listar os reguladores na view */
    public ModelAndView listarRegulador() {
        ModelAndView modelAndView = new ModelAndView("/index");     /* renderizará a lista de equipamentos na view "index" (possivel que mude o caminho index) */
        Iterable<Regulador> reguladores = reguladorService.findAll();
        modelAndView.addObject("attributeName", reguladores);       /* falta ainda alterar e inseir o local do attributename */

        return modelAndView;
    }

    
}