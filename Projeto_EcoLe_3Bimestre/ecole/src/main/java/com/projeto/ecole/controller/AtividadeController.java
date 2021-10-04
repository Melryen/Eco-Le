package com.projeto.ecole.controller;

import java.util.List;
import com.projeto.ecole.model.AtividadeRepository;
import com.projeto.ecole.model.Questoes;
import com.projeto.ecole.model.QuestoesRepository;
import com.projeto.ecole.model.Atividade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtividadeController {
    Logger log = LoggerFactory.getLogger(AtividadeController.class);

    @Autowired
    AtividadeRepository atividadeRepository;

    @Autowired
    QuestoesRepository questoesRepository;

    //http://localhost:8080/atividade
    @GetMapping("/atividade")
    public List<Atividade> getListarAtividade(){
        return (List<Atividade>) atividadeRepository.findAll();
    }
    
    //http://localhost:8080/atividade/1
    @GetMapping("/atividade/{id}")
    @ResponseBody
    public Atividade getAtividadeById(@PathVariable("id") Atividade atividade){
        return atividade;
    }

    //POST http://localhost:8080/atividade
    @PostMapping("/atividade")
      public Atividade postCriarAtividade(@RequestBody Atividade atividade){
          //return atividadeRepository.save(atividade);
          atividadeRepository.save(atividade);
          if(atividadeRepository.findById(atividade.getId()).isPresent())
              return atividade;
          return null;
      }
    
    //POST http://localhost:8080/atividade/1
    @PostMapping("/atividade/{id}")
      public Questoes postCriarQuestoes(@PathVariable("id") Long id, @RequestBody Questoes questoes){
          if(atividadeRepository.findById(id).isPresent()){
              Atividade atividade = atividadeRepository.findById(id).get();
              log.debug(atividade.getTitulo());
              questoes.setAtividade(atividade);
              questoes = questoesRepository.save(questoes);
              return questoes;
          }
          return null;
      }
    
      //DELETE http://localhost:8080/questoes/1
      @DeleteMapping("/questoes/{id}")
      public Questoes deleteQuestoes(@PathVariable Long id){
          if(questoesRepository.findById(id).isPresent()){
              Questoes questoes = questoesRepository.findById(id).get();
              questoesRepository.delete(questoes);
              return questoes;
          }
          return null;
      }

      //PUT http://localhost:8080/questoes/1
      @PutMapping("/questoes/{id}")
      public Questoes putQuestoes(@PathVariable Long id, @RequestBody Questoes questoes){
          if(questoesRepository.findById(id).isPresent()){
              Questoes questoesBanco = questoesRepository.findById(id).get();
              questoesBanco.setEnunciado(questoes.getEnunciado());
              questoesBanco.setAlternativa(questoes.getAlternativa());
              questoesBanco.setRespostaCorreta(questoes.getRespostaCorreta());
              questoesRepository.save(questoesBanco);
              return questoes;
          }
          return null;
      }

}
