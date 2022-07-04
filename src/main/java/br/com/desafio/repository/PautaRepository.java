package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
