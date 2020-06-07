package com.project.autoreg.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.project.autoreg.model.Regulador;
import com.project.autoreg.response.Response;
import com.project.autoreg.service.ReguladorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reguladores")
@CrossOrigin(origins = "*")
public class ReguladorController {

    /* Injeção de dependencia do reguladorService */
    @Autowired                                      
    private ReguladorService reguladorService;

    /* Metodo para listar todos os reguladores*/
    @GetMapping(value = "/{page}/{count}")
    public ResponseEntity<Response<Page<Regulador>>>listAll(HttpServletRequest request, @PathVariable int page, @PathVariable int count) {

        Response<Page<Regulador>> response = new Response<Page<Regulador>>();
        Page<Regulador> regulador = null;
        regulador = reguladorService.listAll(page, count);
        response.setData(regulador);
        return ResponseEntity.ok(response);
    }

    /* Metodo para filtrar um equipamento por algum parametro */
    @GetMapping(value = "/{page}/{count}/{code}/{region}/{feeder}/{bus}")
    public ResponseEntity<Response<Page<Regulador>>>findByParameters(HttpServletRequest request,
                                                                    @PathVariable int pages,
                                                                    @PathVariable int count, 
                                                                    @PathVariable String code,
                                                                    @PathVariable String region, 
                                                                    @PathVariable String feeder, 
                                                                    @PathVariable String bus) {
    
    code = code.equals("uniformed")? "" : code;
    region = region.equals("uniformed")? "" : region;
    feeder = feeder.equals("uniformed")? "" : feeder;
    bus = bus.equals("uniformed")? "" : bus;
    
    Response<Page<Regulador>> response = new Response<Page<Regulador>>();
    Page<Regulador> regulador = null;
    regulador = reguladorService.findByParameters(code, region, feeder, bus, pages, count);
    response.setData(regulador);
    return ResponseEntity.ok(response);
    }

    /* Metodo para criar um novo equipamento */
    @PostMapping()
    public ResponseEntity<Response<Regulador>> createRegulador(HttpServletRequest request, @RequestBody Regulador regulador, BindingResult result) {
        Response<Regulador> response = new Response<Regulador>();
        try {
            validateCreateRegulador(regulador, result);
            if(result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
            regulador = reguladorService.createRegulador(regulador);
            response.setData(regulador);
        
        }   catch (Exception exception) {
                response.getErrors().add(exception.getMessage());
                return ResponseEntity.badRequest().body(response);
            }   

    return ResponseEntity.ok(response);
    }

    private void validateCreateRegulador(Regulador regulador, BindingResult result) {
        if (regulador.getCode() == null) {
            result.addError(new ObjectError("Regulador", "Código do regulador não informado"));
            return;
        }
    }

    @DeleteMapping(value = "/{id}")
    private  ResponseEntity<Response<String>> deleteRegulador (@PathVariable("id") Long id ) {
        Response<String> response = new Response<String>();
        Optional<Regulador> reguladorOptional = reguladorService.findById(id);
        Regulador regulador = reguladorOptional.get();
        if(regulador == null) {
            response.getErrors().add("Registro não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        reguladorService.deleteRegulador(regulador);
        return ResponseEntity.ok(new Response<String>());

    } 











}