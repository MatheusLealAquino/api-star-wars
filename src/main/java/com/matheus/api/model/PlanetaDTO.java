/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author matheus
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetaDTO {
    private List<String> films;

    public List<String> getFilmes() {
        return films;
    }

    public void setFilmes(List<String> films) {
        this.films = films;
    }
    
}
