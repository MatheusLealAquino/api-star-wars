/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.repository;

import com.matheus.api.model.Planeta;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author matheus
 */
public interface PlanetaRepository extends MongoRepository<Planeta, String>{
    List<Planeta> findByNome(String nome);

    List<Planeta> findByNomeLike(String nome);
}
