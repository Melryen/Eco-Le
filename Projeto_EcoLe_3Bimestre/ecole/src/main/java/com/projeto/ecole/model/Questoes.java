package com.projeto.ecole.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Questoes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    
    private Long id;
    private String enunciado;
    private String alternativa;
    private String respostaCorreta;
    @ManyToOne
    @JoinColumn(name = "atividade_fk")
    @JsonBackReference 
    private Atividade atividade;
   
    
    public Questoes() {
    }

    public Questoes( String enunciado, String alternativa, String respostaCorreta) {
        this.enunciado = enunciado;
        this.alternativa = alternativa;
        this.respostaCorreta = respostaCorreta;
        
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    public String getAlternativa() {
        return alternativa;
    }
    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }
    public String getRespostaCorreta() {
        return respostaCorreta;
    }
    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
    public Atividade getAtividade(){
        return atividade;
    }
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
       

    
}
