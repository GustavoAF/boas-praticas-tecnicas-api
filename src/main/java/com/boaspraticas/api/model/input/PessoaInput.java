package com.boaspraticas.api.model.input;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class PessoaInput {
	
	private String nome;
	
	private String sobrenome;
	
	private String apelido;
	
	private String cpf;
	
	private OffsetDateTime dataNascimento; 


}
