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
        if(!nome.equals("") || !clima.equals("") || !terreno.equals("")){
            /* int quantidaDeFilmes = buscarQuantidadeFilmes(nome);
            Planeta planeta = new Planeta(nome, clima, terreno, quantidaDeFilmes);*/
            Planeta planeta = new Planeta(nome, clima, terreno);
            return planetaRepository.save(planeta);
        }else{
            throw new IllegalStateException("Um ou mais parâmetros estão vazio(s).");
        }
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
    
    public PlanetaDTO buscarQuantidadeFilmes(String nomePlaneta){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://swapi.co/api/planets/?search="+nomePlaneta;
        PlanetaDTO planetaDTO = restTemplate.getForObject(url, PlanetaDTO.class);
        return planetaDTO;
    }
 
}
