	package com.boaspraticas;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Boas Práticas para se Trabalhar com Data e Hora em Rest API
 * 
 *  1 - Use ISO-8601 para formatar Data e Hora
 *  2 - Aceite Qualquer fuso horário
 *  3 - Armazene em UTC
 *  4 - Retorne em UTC
 *  5 - Não Inclua Horário se Não for Necessário
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		/*
		 * Como é uma boa prática sempre usar os campos data no formato UTC, a linha abaixo configura toda
		 * a aplicação nesse formato. Isso dá mais flexibilidade ao client para que trabalhe o off set
		 * de acordo com seu TimeZone.
		 */
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(Application.class, args);
	}

}
