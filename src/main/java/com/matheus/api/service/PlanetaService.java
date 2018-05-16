/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.service;

import com.matheus.api.model.Planeta;
import com.matheus.api.model.PlanetaDTO;
import com.matheus.api.repository.PlanetaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author matheus
 */
@Service
public class PlanetaService {
    @Autowired 
    PlanetaRepository planetaRepository;
    
    public Planeta salvar(String nome, String clima, String terreno){
        Planeta planeta = new Planeta();
        planeta.setNome(nome);
        planeta.setClima(clima);
        planeta.setTerreno(terreno);
        
        return planetaRepository.save(planeta);
    }
    
    public Optional<Planeta> buscarPorId(String id){
        return planetaRepository.findById(id);
    }
    
    public List<Planeta> buscarPorNome(String nome){
        return planetaRepository.findByNomeLike(nome);
    }
    
    public List<Planeta> listar(){
        return planetaRepository.findAll();
    }
    
    public void deletar(String id){
        planetaRepository.deleteById(id);
    }
    
    public PlanetaDTO buscarQuantidadeFilmes(Planeta planeta){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://swapi.co/api/planets/?search="+planeta.getNome();
        PlanetaDTO planetaDTO = restTemplate.getForObject(url, PlanetaDTO.class);
        return planetaDTO;
    }
 
}
