package com.boaspraticas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boaspraticas.api.assembler.PessoaInputDesassembler;
import com.boaspraticas.api.assembler.PessoaModelAssembler;
import com.boaspraticas.api.model.PessoaModel;
import com.boaspraticas.api.model.input.PessoaInput;
import com.boaspraticas.domain.model.Pessoa;
import com.boaspraticas.domain.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	PessoaModelAssembler pessoaModelAssembler;
	
	@Autowired
	PessoaInputDesassembler pessoaInputDesassembler;
	
	@GetMapping
	public ResponseEntity<List<PessoaModel>> listar(){
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaModelAssembler.toCollectionModel(pessoaService.listar()));
	}
	
	@PostMapping
	public ResponseEntity<PessoaModel> salvar(@RequestBody @Valid PessoaInput pessoaInput){
		//Fazendo passo a passo para um melhor entendimento
		PessoaModel pessoaResponse = new PessoaModel();
		Pessoa pessoa = new Pessoa();
		Pessoa pessoaProcessada = new Pessoa();
		
		//Recebe o tipo PessoaInput e transforma em Pessoa porque a camada de serviço espera um objeto do tipo Pessoa
		pessoa = pessoaInputDesassembler.toInput(pessoaInput);
		
		//usando o objeto pessoa que já esta transformado em pessoa, é passado para o método da camada de serviço
		pessoaProcessada = pessoaService.salvar(pessoa);
		
		//Executado o metodo salvar da camada de serviço devemos transformar o retorno em um objeto Pessoa Model para retornar ao client
		pessoaResponse = pessoaModelAssembler.toModel(pessoaProcessada);
		
		//depois de recebido o tipo input transformado em pessoa, depois transformado em model para poder externalizar para o cliente,
		//o response é providenciado.
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);		
	}
}
