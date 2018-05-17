/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author matheus
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetaServiceTest {
    
    @Autowired
    PlanetaService planetaService;
    @Rule 
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void init(){
    }
    
    
    @Test
    public void salvar_no_banco_de_dados_com_dados_nulos(){
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Um ou mais parâmetros estão vazio(s).");
        
        String nome = "";
        String clima = "";
        String terreno = "";
        
        planetaService.salvar(nome, clima, terreno);
    }
    
    @Test 
    public void buscar_quantidade_de_filmes_com_sucesso(){
        final String nomePlaneta = "Dagobah";
        int result = planetaService.buscarQuantidadeDeFilmes(nomePlaneta);
        
        assertEquals(result, 3);
    }
    
    @Test
    public void buscar_quantidade_de_filmes_com_muitos_resultados(){
        final String nomePlaneta = "a";
        
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Nome buscado {"+nomePlaneta+"} retornou muitos planetas.");
        
        planetaService.buscarQuantidadeDeFilmes(nomePlaneta);
    }
    
    @Test
    public void buscar_planeta_com_id_errado(){
        final String idPlaneta = "a";
        
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Não foi encontrado nenhum planeta com esse ID {"+ idPlaneta + "}");
        
        planetaService.buscarPorId(idPlaneta);
    }
}
