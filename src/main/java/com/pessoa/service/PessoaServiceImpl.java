package com.pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.model.Pessoa;
import com.pessoa.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Override
	public Pessoa create(Pessoa pessoa) {
		return repository.save(pessoa);
	}


	@Override
	public void delete(Pessoa pessoa) {		
		repository.delete(pessoa);
	}


	@Override
	public List<Pessoa> buscaTodos() {
		return repository.findAll();
	}

	@Override
	public Pessoa buscar(Long id){		
		Optional<Pessoa> pessoa = repository.findById(id);		
		return pessoa.get();
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		return repository.save(pessoa);
	}
}
