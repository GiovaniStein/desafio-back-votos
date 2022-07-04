package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Associado;


public interface AssociadoRepository extends JpaRepository<Associado, String> {

}
