package com.pessoa.service;

import com.pessoa.model.Contato;


public interface ContatoService {    
    
	Contato create(Contato contato);
	
	Contato buscar(Long id) ;
   
}
