package br.com.desafio.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.desafio.model.enums.VotoValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {

	@NotNull
	@Size(min = 11, max = 11)
	private String cpf;
	@NotNull
	private Long idSessao;
	@NotNull
	private VotoValue value;

}
