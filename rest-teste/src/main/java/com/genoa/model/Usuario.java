package com.genoa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.pojomatic.annotations.AutoProperty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by valdisnei on 23/09/16.
 */
@AutoProperty
@Entity
public class Usuario implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "id")
    private Integer id;

    @JsonProperty("nome")
    @Column(name = "nome")
    private String nome;

    @JsonProperty("idade")
    @Column(name = "idade")
    private Integer idade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
    
    

}
