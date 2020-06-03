package com.boaspraticas.api.assembler;

import org.springframework.stereotype.Controller;

import com.boaspraticas.api.model.input.PessoaInput;
import com.boaspraticas.domain.model.Pessoa;

@Controller
public class PessoaInputDesassembler {
	
	public Pessoa toInput(PessoaInput pessoaInput) {
		
		/*
		 * Esse método foi criado apenas para demonstrar de forma manual, a transformação de PessoaInput
		 * para Pessoa. Nesse caso estamos efetuando a transição na unha, apenas para fins didáticos.
		 * Na classe PessoalModelAssembler temos um mesmo exemplo usando a biblioteca ModelMapper que facilita
		 * muito esse trabalho.
		 */
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setApelido(pessoaInput.getApelido());
		pessoa.setCpf(pessoaInput.getCpf());
		pessoa.setDataNascimento(pessoaInput.getDataNascimento());
		pessoa.setNome(pessoaInput.getNome());
		pessoa.setSobrenome(pessoaInput.getSobrenome());
		
		return pessoa;
		
	}

}
