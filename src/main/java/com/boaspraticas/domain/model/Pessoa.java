package com.boaspraticas.domain.model;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Table
@Entity(name = "Pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome", length = 60)
	private String nome;
	
	@Column(name = "sobrenome", length = 120)
	private String sobrenome;
	
	@Column(name = "apelido", length = 40)
	private String apelido;
	
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	//O tipo OffsetDateTime é um tipo data especifico para se usar o padrão UTC
	@Column(name = "DataNascimento")
	private OffsetDateTime dataNascimento;

}
