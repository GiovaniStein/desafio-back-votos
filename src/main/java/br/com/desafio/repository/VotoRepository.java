package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.model.Voto;
import br.com.desafio.model.projection.SessaoResultProjection;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	
	List<Voto> findBySessaoId(Long id);
	
	List<Voto> findBySessaoIdAndAssociadoCpf(Long id, String cpf);

	@Query(value = "SELECT p.name AS namePauta "
			+ ",      p.description AS description "
			+ ",     (SELECT COUNT(*) FROM voto v1 WHERE v1.value = 0 AND v1.sessao_id = s.id) AS numberApprovedVotes "
			+ ",     (SELECT COUNT(*) FROM voto v2 WHERE v2.value = 1 AND v2.sessao_id = s.id) AS numberDisapprovedVotes "
			+ ",     (SELECT COUNT(*) FROM voto v3 WHERE v3.sessao_id = s.id) AS numberVotes "
			+ "FROM sessao s "
			+ ",    pauta p "
			+ "WHERE p.id = s.pauta_id "
			+ "AND   s.id = :idSessao ", nativeQuery = true)
	SessaoResultProjection findResultadosSessao(Long idSessao);
}
