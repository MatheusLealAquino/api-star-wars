/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.service;

import com.matheus.api.model.Planeta;
import com.matheus.api.repository.PlanetaRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
    
}
