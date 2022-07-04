package br.com.desafio.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Pauta;
import br.com.desafio.model.Sessao;
import br.com.desafio.model.Voto;
import br.com.desafio.model.dto.SessaoDTO;
import br.com.desafio.model.dto.SessaoResultDTO;
import br.com.desafio.model.enums.VotoValue;
import br.com.desafio.repository.PautaRepository;
import br.com.desafio.repository.SessaoRepository;
import br.com.desafio.repository.VotoRepository;

@Service
public class SessaoService {

	@Autowired
	private SessaoRepository repository;
	@Autowired
	private PautaRepository pautaRepository;
	@Autowired
	private VotoRepository votoRepository;

	public List<Sessao> findAll() {
		return repository.findAll();
	}

	public Sessao findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public SessaoResultDTO findSessaoResults(Long id) {

		List<Voto> votos = votoRepository.findBySessaoId(id);
		
		if(!votos.isEmpty()) {
			SessaoResultDTO result = new SessaoResultDTO();
			
			Sessao sessao = repository.findById(id).orElse(null);
			
			Pauta pauta = pautaRepository.findById(sessao.getPauta().getId()).orElse(null);
			
			result.setNamePauta(pauta.getName());
			result.setDescription(pauta.getDescription());
			result.setNumberApprovedVotes(votos.stream().filter(p -> p.getValue() == VotoValue.SIM).count());
			result.setNumberDisapprovedVotes(votos.stream().filter(p -> p.getValue() == VotoValue.NAO).count());
			result.setNumberVotes(Long.valueOf(votos.size()));
			
			return result;
		}
		
		return null;
	}

	@Transactional
	public Sessao save(SessaoDTO dto) throws Exception {
		Sessao sessao = new Sessao();

		Pauta pauta = pautaRepository.findById(dto.getIdPauta()).orElse(null);

		try {
			if (pauta != null) {
				sessao.setPauta(pauta);

				sessao.setInit(LocalDateTime.now());
				sessao.setClose(LocalDateTime.now().plusMinutes(dto.getDurationTime() != null ? dto.getDurationTime() : 1));

				return repository.save(sessao);
			} else {
				throw new Exception("Pauta não encontrada");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public void delete(Sessao sessao) {
		repository.delete(sessao);
		repository.flush();
	}
}
