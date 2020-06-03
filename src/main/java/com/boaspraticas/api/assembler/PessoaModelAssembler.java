package com.boaspraticas.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.boaspraticas.api.model.PessoaModel;
import com.boaspraticas.domain.model.Pessoa;

@Component
public class PessoaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaModel toModel(Pessoa pessoa) {
		
		/*
		 * Usando a biblioteca ModelMapper para fazer a transformação de Pessoa para PessoaModel.
		 * Lembrando que caso o ModelMapper não encontrar o de para, de cada propriedade da classe,
		 * é possível customizar essa informação na mão.
		 */
		
		return modelMapper.map(pessoa,PessoaModel.class);
		
/*		PessoaModel pessoaModel = new PessoaModel();
		
		pessoaModel.setApelido(pessoa.getApelido());
		pessoaModel.setCpf(pessoa.getCpf());
		pessoaModel.setDataNascimento(pessoa.getDataNascimento());
		pessoaModel.setNome(pessoa.getNome());
		pessoaModel.setSobrenome(pessoa.getSobrenome());
		
		return pessoaModel;
*/		
	}
	
	public List<PessoaModel> toCollectionModel(List<Pessoa> pessoas){
		
		/*
		 * Usando o método acima para transformar de pessoa para PessoalModel,
		 * esse método apenas usa um map para retornar uma lista, de PessoaModel.
		 */
		
		return pessoas.stream()
				.map(pessoa -> toModel(pessoa))
				.collect(Collectors.toList());
	}

}
