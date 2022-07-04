package br.com.desafio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "associado")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Associado implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(unique = true, nullable = false)
	@Size(min = 11, max = 11)
	private String cpf;
	@Column(nullable = false)
	private String nome;
	
}
