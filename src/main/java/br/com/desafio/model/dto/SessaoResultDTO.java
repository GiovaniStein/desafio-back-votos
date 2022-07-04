package br.com.desafio.model.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String namePauta;
	private String description;
	private Long numberApprovedVotes;
	private Long numberDisapprovedVotes;
	private Long numberVotes;

}
