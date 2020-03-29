package com.pessoa.service;

import java.util.List;

import com.pessoa.model.Pessoa;


public interface PessoaService {    
    
    Pessoa create(Pessoa pessoa);

    void delete(Pessoa pessoa);

    List<Pessoa> buscaTodos();

    Pessoa buscar(Long id) ;

    Pessoa update(Pessoa pessoa);
}
