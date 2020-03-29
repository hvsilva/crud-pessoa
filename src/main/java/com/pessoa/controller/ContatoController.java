package com.pessoa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pessoa.model.Contato;
import com.pessoa.model.ResponseModel;
import com.pessoa.service.ContatoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class ContatoController {
	@Autowired
	ContatoService service;

	@PostMapping("/contato")
	public @ResponseBody ResponseModel salvar(@Valid @RequestBody Contato contato) {
		try {

			contato.setPessoa(contato.getPessoa()); 
			this.service.create(contato);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@GetMapping(path = { "/contato/{id}" })
	public Contato buscar(@PathVariable("id") Long id) {
		return this.service.buscar(id);
	}

}