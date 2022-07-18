package com.api.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class PlayList implements Serializable {
    @Id
    private String id;
    private String nome;

    public PlayList(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PlayList() {
    }

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
}
