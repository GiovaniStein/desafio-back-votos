package br.com.desafio.model.dto;

import java.io.Serializable;

import br.com.desafio.model.enums.StatusCpfValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpfValidatorResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public StatusCpfValidator status;
}
