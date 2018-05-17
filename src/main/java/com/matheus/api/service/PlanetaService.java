/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.service;

import com.matheus.api.model.Planeta;
import com.matheus.api.repository.PlanetaRepository;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.json.simple.JSONArray;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author matheus
 */
@Service
public class PlanetaService {
    @Autowired 
    PlanetaRepository planetaRepository;
    
    /**
     * Salva um novo planeta
     * 
     * @param nome
     * @param clima
     * @param terreno
     * @return Planeta
     */
    public Planeta salvar(String nome, String clima, String terreno){
        if(!nome.equals("") || !clima.equals("") || !terreno.equals("")){
            int quantidadeDeFilmes = buscarQuantidadeDeFilmes(nome);
            return planetaRepository.save(new Planeta(nome, clima, terreno, quantidadeDeFilmes));
        }else{
            throw new IllegalStateException("Um ou mais parâmetros estão vazio(s).");
        }
    }
    
    /**
     * Busca um planeta por ID
     * 
     * @param idPlaneta
     * @return Optional</Planeta/>
     */
    public Optional<Planeta> buscarPorId(String idPlaneta){
        Optional<Planeta> planeta = planetaRepository.findById(idPlaneta);
        if(planeta.isPresent()){
            return  planeta;
        }else {
            throw new IllegalStateException("Não foi encontrado nenhum planeta com esse ID {"+ idPlaneta + "}");
        }
    }
    
    /**
     * Busca planetas a partir do nome
     * 
     * @param nome
     * @return List</Planeta/>
     */
    public List<Planeta> buscarPorNome(String nome){
        return planetaRepository.findByNomeLike(nome);
    }
    
    /**
     * Lista todos os planetas salvos
     * 
     * @return 
     */
    public List<Planeta> listar(){
        return planetaRepository.findAll();
    }
    
    /**
     * Deleta da collection determinado objeto 
     * a partir do ID
     * 
     * @param id 
     */
    public void deletar(String id){
        planetaRepository.deleteById(id);
    }
    
    /**
     * Realiza busca a partir da api "swapi.co" o(s) planeta(s)
     * e retorna uma String a partir de um JSON
     * 
     * @param nomePlaneta
     * @return String
     */
    public String buscandoJsonDaApi(String nomePlaneta){
        String url = "https://swapi.co/api/planets/?search="+nomePlaneta;
        
        //https://stackoverflow.com/questions/44922261/why-do-i-always-get-403-when-fetching-data-with-resttemplate
        CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);    
        RestTemplate restTemplate = new RestTemplate(requestFactory);  
        
        //Retornando JSON em String
        return restTemplate.getForObject(url, String.class);
    }
    
    /**
     * Retorna quantidade de filmes em que determinado planeta
     * aparece.
     * 
     * @param nomePlaneta
     * @return int
     */
    public int buscarQuantidadeDeFilmes(String nomePlaneta) {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        
        String planetaFilmes = buscandoJsonDaApi(nomePlaneta);
        
        try {
            //Transformando String em JSON
            jsonObject = (JSONObject) parser.parse(planetaFilmes);
        } catch (ParseException ex) {
           throw new IllegalStateException("Não foi possivel converter dados recebidos.");
        }
        
        //Quantidade de resultados obtidos a partir da busca pelo nome
        Long count = (Long) jsonObject.get("count"); 
        
        //Em caso do retorno ser de mais que um planeta, não realiza operação
        if(count == 1L){
            //Recuperando filmes do JSON
            JSONArray result = (JSONArray) jsonObject.get("results");
            JSONObject next = (JSONObject) result.get(0);
            List<String> filmes = (List<String>) next.get("films");
            return filmes.size();
        }else{
            throw new IllegalStateException("Nome buscado {"+nomePlaneta+"} retornou muitos planetas.");
        }
    }
}
