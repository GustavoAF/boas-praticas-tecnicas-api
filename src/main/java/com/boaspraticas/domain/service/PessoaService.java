package com.boaspraticas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boaspraticas.domain.model.Pessoa;
import com.boaspraticas.domain.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<Pessoa> listar(){
		
		return (List<Pessoa>) pessoaRepository.findAll();
	}
	
	
	/*
	 * Por default o spring abre uma transação para os métodos do repositório, tornando o processo de alteração na base de dados
	 * altamente confiável. Mas caso no seu método da camada de serviço você efetue qualquer outra transação, será necessário
	 * transacionar todo seu processo. Por exemplo, se antes de deletar algum registro você fizer um update, ou um save, a transação 
	 * será efetuado somente dentro do update ou save, tornando seu delete inconsistente.
	 * Para evitar essa situação, e recomendável anotar todo o método público com a anotação @Transactional do pacote, 
	 * org.springframework.transaction.annotation.Transactional
	 */
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		
		return pessoaRepository.save(pessoa);
	}

}
