package com.projeto.ecole.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    
    private static final  Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner iniDataBase(AtividadeRepository repository){
      return args->{
      
       Atividade atividade1 = new Atividade("Aprenda as letras!", "Lingua portuguesa");
       List<Questoes> questoes= new ArrayList<>();
       Questoes questao1 = new Questoes("Quantas letras tem a palavra queijo?","a-4,b-6,c-5,d-7","B-6");
       atividade1.setQuestoes(questoes);
       questoes.add(questao1);
       Questoes questao2 = new Questoes("Quantas letras tem  a palavra rato?", "a-4,b-6,c-5,d-7","A-4");
       atividade1.setQuestoes(questoes);
       questoes.add(questao2);
       atividade1.setQuestoes(questoes);

       Atividade atividade2 = new Atividade("Continhas - soma:", "Matemática");
       questoes = new ArrayList<>();
       questao1 = new Questoes("Quantas letras tem a palavra queijo?","a-4,b-6,c-5,d-7","B-6");
       questao1.setAtividade(atividade2);
       questoes.add(questao1);
       questao2 = new Questoes("Quantas letras tem  a palavra rato?", "a-4,b-6,c-5,d-7","A-4");
       atividade2.setQuestoes(questoes);
       questoes.add(questao2);
       atividade2.setQuestoes(questoes);
       log.info("inserindo"+ repository.save(atividade1));
       log.info("inserindo"+ repository.save(atividade2));

      };
    }
}

    

