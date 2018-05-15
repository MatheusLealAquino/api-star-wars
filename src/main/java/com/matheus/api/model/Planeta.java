/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author matheus
 */
@Document(collection = "planeta")
public class Planeta {
    @Id
    private String id;
    
    private String nome;
    private String clima;
    private String terreno;
    private int quantidadeAparicoesEmFilmes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getQuantidadeAparicoesEmFilmes() {
        return quantidadeAparicoesEmFilmes;
    }

    public void setQuantidadeAparicoesEmFilmes(int quantidadeAparicoesEmFilmes) {
        this.quantidadeAparicoesEmFilmes = quantidadeAparicoesEmFilmes;
    }    
}
