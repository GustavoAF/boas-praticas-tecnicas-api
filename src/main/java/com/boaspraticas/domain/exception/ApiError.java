package com.boaspraticas.domain.exception;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class ApiError {

		private Integer status;
		private String type;
		private String title;
		private String detail;
		private List<Object> objects;
		
	/*
	 * Os campos da innerclass abaixo devem ser declarados como uma lista na classe acima, esses devem informar quais campos
	 * sofreram as validações.
	 */
		@Getter
		@Builder
		public static class  Object{
			
			private String name;
			private String userMesage;
		}

}
