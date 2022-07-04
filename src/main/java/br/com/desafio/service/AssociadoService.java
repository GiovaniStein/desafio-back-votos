package br.com.desafio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Associado;
import br.com.desafio.repository.AssociadoRepository;

@Service
public class AssociadoService {

	@Autowired
	private AssociadoRepository repository;

	public List<Associado> findAll() {
		return repository.findAll();
	}

	public Associado findById(String cpf) {
		return repository.findById(cpf).orElse(null);
	}

	@Transactional
	public Associado save(Associado associado) {
		return repository.save(associado);
	}

	@Transactional
	public void delete(Associado associado) {
		repository.delete(associado);
		repository.flush();
	}

}
