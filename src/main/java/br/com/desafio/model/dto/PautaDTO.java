package br.com.desafio.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;
	@NotNull
	private String description;
	
}
