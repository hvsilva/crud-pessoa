package com.pessoa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pessoa.model.Pessoa;
import com.pessoa.model.ResponseModel;
import com.pessoa.service.PessoaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class PessoaController {
	
	@Autowired
	PessoaService service;

	@GetMapping("/pessoa")
	public List<Pessoa> consultar() {
		return service.buscaTodos();
	}

	@GetMapping(path = { "/pessoa/{id}" })
	public Pessoa buscar(@PathVariable("id") Long id) {
		return this.service.buscar(id);
	}

	@PostMapping("/pessoa")
	public @ResponseBody ResponseModel salvar(@Valid @RequestBody Pessoa pessoa) {
		try {

			this.service.create(pessoa);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}

	@PutMapping(path = { "/pessoa/{id}" })
	public @ResponseBody ResponseModel atualizar(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {

		try {

			this.service.update(pessoa);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}

	@DeleteMapping(path = { "/pessoa/{id}" })
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Long id) {

		try {
			Pessoa pessoa = service.buscar(id);

			service.delete(pessoa);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}