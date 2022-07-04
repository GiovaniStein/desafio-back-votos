package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	
	List<Voto> findBySessaoId(Long id);
	
	List<Voto> findBySessaoIdAndAssociadoCpf(Long id, String cpf);

}
