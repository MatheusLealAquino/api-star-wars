/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.controller;

import com.matheus.api.model.Planeta;
import com.matheus.api.service.PlanetaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matheus
 */
@RestController
@RequestMapping(path="/planetas")
public class PlanetaController {
    @Autowired
    private PlanetaService planetaService;
            
    @RequestMapping(path="/", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Planeta adicionarPlaneta(@RequestParam("nome") String nome,
                @RequestParam("clima") String clima,
                @RequestParam("terreno") String terreno ){
        return planetaService.salvar(nome, clima, terreno);
    }
    
    @RequestMapping(path="", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Planeta> listarPlanetas(){
        return planetaService.listar();
    }
    
    @RequestMapping(path="/", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Planeta> buscarPorNome(@RequestParam("nome") String nome){
        return planetaService.buscarPorNome(nome);
    }
    
    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Planeta> buscarPorId(@PathVariable("id") String id){
        return planetaService.buscarPorId(id);
    }
    
    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePlaneta(@PathVariable("id") String id){
        planetaService.deletar(id);
    }
}
