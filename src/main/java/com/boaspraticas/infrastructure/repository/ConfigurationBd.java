package com.boaspraticas.infrastructure.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class ConfigurationBd {
	
	@Value("${url_banco}")
	private String dataSourceUrl;
	
	@Value("${username_banco}")
	private String dataSourceUser;
	
	@Value("${password_banco}")
	private String dataSourcePassword;

}
