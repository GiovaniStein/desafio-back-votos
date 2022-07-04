package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
