package com.boaspraticas.api.exception;

import lombok.Getter;

@Getter
public enum ApiErrorType {

	VALOR_INVALIDO_INFORMADO("/valor-invalido","Valor Inválido") ;
	
	private String title;
	private String path;
	
	ApiErrorType(String path, String title){
		this.path = "Https://meusite.com.br/api/documentacao" + path;
	    this.title = title;
		
	}

	
}
