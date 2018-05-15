/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.controller;

import com.matheus.api.model.Planeta;
import com.matheus.api.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(path="/planeta")
public class PlanetaController {
    @Autowired
    private PlanetaRepository planetaRepository;
    
    @RequestMapping(path="/", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Planeta adicionarPlaneta(@RequestParam("nome") String nome,
                @RequestParam("Clima") String clima,
                @RequestParam("Terreno") String terreno ){
        
        return planetaRepository.save(new Planeta());
    }
}
