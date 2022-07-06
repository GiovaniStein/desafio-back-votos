package br.com.desafio.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Associado;
import br.com.desafio.model.Sessao;
import br.com.desafio.model.Voto;
import br.com.desafio.model.dto.CpfValidatorResponseDTO;
import br.com.desafio.model.dto.VotoDTO;
import br.com.desafio.model.enums.StatusCpfValidator;
import br.com.desafio.repository.AssociadoRepository;
import br.com.desafio.repository.SessaoRepository;
import br.com.desafio.repository.VotoRepository;
import br.com.desafio.utils.HttpClient;

@Service
public class VotoService {

	@Autowired
	private VotoRepository repository;
	@Autowired
	private AssociadoRepository associadoRepository;
	@Autowired
	private SessaoRepository sessaoRepository;

	public Voto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Voto> findAllBySessao(Long idSessao) {
		return repository.findBySessaoId(idSessao);
	}

	@Transactional
	public Voto save(VotoDTO dto, boolean validateCpf) throws Exception {

		try {

			Sessao sessao = sessaoRepository.findById(dto.getIdSessao()).orElse(null);

			if (sessao == null)
				throw new Exception("Sessão informada não foi encontrada");

			LocalDateTime now = LocalDateTime.now();

			if (now.isAfter(sessao.getClose()))
				throw new Exception("A sessão informada já foi finalizada");

			Associado associado = associadoRepository.findById(dto.getCpf()).orElse(null);

			if (associado == null)
				throw new Exception("Associado informado não foi encontrato");

			List<Voto> votosUsuario = repository.findBySessaoIdAndAssociadoCpf(dto.getIdSessao(), dto.getCpf());

			if (!votosUsuario.isEmpty())
				throw new Exception("Usuário já possui Voto na sessão informada");

			if (validateCpf) {
				CpfValidatorResponseDTO verifyCpf = HttpClient.verifyCpf(dto.getCpf());

				if (verifyCpf.getStatus() == StatusCpfValidator.UNABLE_TO_VOTE)
					throw new Exception("O Cpf informado não está liberado para votar");
			}

			Voto voto = new Voto();
			voto.setAssociado(associado);
			voto.setSessao(sessao);
			voto.setValue(dto.getValue());

			return repository.save(voto);

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	//Somente utilizado para testes
	@Transactional
	public void delete(Voto voto) {
		repository.delete(voto);
		repository.flush();
	}

}
