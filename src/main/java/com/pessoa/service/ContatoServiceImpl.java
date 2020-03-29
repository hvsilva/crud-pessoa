package com.pessoa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.model.Contato;
import com.pessoa.repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository repository;

	@Override
	public Contato create(Contato contato) {
		return repository.save(contato);
	}

	@Override
	public Contato buscar(Long id) {
		Optional<Contato> contato = repository.findById(id);
		return contato.get();
	}

}
