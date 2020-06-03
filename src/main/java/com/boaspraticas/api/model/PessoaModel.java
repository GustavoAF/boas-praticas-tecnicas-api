package com.boaspraticas.api.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class PessoaModel {

	private String nome;
	
	private String sobrenome;
	
	private String nomeAlternativo;
	
	private String cpf;
	
	private OffsetDateTime dataNascimento; 
}
