/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.service;

import com.matheus.api.model.Planeta;
import com.matheus.api.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matheus
 */
@Service
public class PlanetaService {
    @Autowired 
    PlanetaRepository planetaRepository;
    
    public Planeta salvar(Planeta planeta){
        return planetaRepository.save(planeta);
    }
}
