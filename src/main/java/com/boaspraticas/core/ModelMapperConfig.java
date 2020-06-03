package com.boaspraticas.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boaspraticas.api.model.PessoaModel;
import com.boaspraticas.domain.model.Pessoa;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		/*
		 * O exemplo abaixo mostra a customização de algumas propriedades que devido as diferenças dos 
		 * parâmetros o ModelMapper não irá conseguir fazer o de para. Nesse caso é necessário informar 
		 * ao ModelMapper.
		 */
		
		modelMapper.createTypeMap(Pessoa.class, PessoaModel.class)
			.addMapping(Pessoa::getApelido, PessoaModel::setNomeAlternativo);
		
		return modelMapper;
		
		
	}

}
