package com.projeto.ecole.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Atividade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String materia;
    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Questoes> questoes;
    

    public Atividade() {
        
    }


    public Atividade(String titulo, String materia) {
        this.titulo = titulo;
        this.materia = materia;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }


    public void setQuestoes(List<Questoes> questoes) {
        this.questoes=questoes;
    }
    public void addQuestao(Questoes questoes){
        this.questoes.add(questoes);
    }
    
}
