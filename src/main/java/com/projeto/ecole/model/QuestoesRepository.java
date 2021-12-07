package com.projeto.ecole.model;

import org.springframework.data.repository.CrudRepository;

public interface QuestoesRepository extends CrudRepository <Questoes,Long> {
    
    String save(Atividade atividade1);
    
}