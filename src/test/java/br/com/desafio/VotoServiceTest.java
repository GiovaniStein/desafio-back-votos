package br.com.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.desafio.model.Associado;
import br.com.desafio.model.Pauta;
import br.com.desafio.model.Sessao;
import br.com.desafio.model.Voto;
import br.com.desafio.model.dto.PautaDTO;
import br.com.desafio.model.dto.SessaoDTO;
import br.com.desafio.model.dto.SessaoResultDTO;
import br.com.desafio.model.dto.VotoDTO;
import br.com.desafio.model.enums.VotoValue;
import br.com.desafio.service.AssociadoService;
import br.com.desafio.service.PautaService;
import br.com.desafio.service.SessaoService;
import br.com.desafio.service.VotoService;

@SpringBootTest(classes = DesafioBackVotosApplicationTests.class)
public class VotoServiceTest {

	@Autowired
	private AssociadoService associadoService;
	@Autowired
	private SessaoService sessaoService;
	@Autowired
	private VotoService votoService;
	@Autowired
	private PautaService pautaService;

	@Test
	public void VotoServiceTeste() throws Exception {
		// Insert
		Associado insertAssoaciado = new Associado("98673284007", "Teste Teste");
		Associado saveAssoaciado = associadoService.save(insertAssoaciado);
		assertNotEquals(null, saveAssoaciado);

		PautaDTO insertPauta = new PautaDTO("Pauta teste", "Teste teste");
		Pauta savePauta = pautaService.save(insertPauta);
		assertNotEquals(null, savePauta);

		SessaoDTO insertSessao = new SessaoDTO(10, savePauta.getId());
		Sessao saveSessao = sessaoService.save(insertSessao);
		assertNotEquals(null, saveSessao);

		VotoDTO insertVoto = new VotoDTO(saveAssoaciado.getCpf(), saveSessao.getId(), VotoValue.SIM);
		Voto saveVoto = votoService.save(insertVoto, false);
		assertNotEquals(null, saveSessao);

		// Find
		List<Voto> votos = votoService.findAllBySessao(saveSessao.getId());
		assertTrue(votos.size() == 1);

		// Find results
		SessaoResultDTO result = sessaoService.findSessaoResults(saveSessao.getId());
		assertNotEquals(null, result);
		assertTrue(result.getNumberApprovedVotes().equals(Long.valueOf(1)));

		// Delete
		votoService.delete(saveVoto);
		Voto votoDb = votoService.findById(saveVoto.getId());
		assertEquals(null, votoDb);

		sessaoService.delete(saveSessao);
		
		pautaService.delete(savePauta);
		associadoService.delete(saveAssoaciado);

	}
	
	

}
