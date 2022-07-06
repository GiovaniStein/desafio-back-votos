package br.com.desafio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Pauta;
import br.com.desafio.model.dto.PautaDTO;
import br.com.desafio.repository.PautaRepository;

@Service
public class PautaService {

	@Autowired
	private PautaRepository repository;

	public List<Pauta> findAll() {
		return repository.findAll();
	}

	public Pauta findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public Pauta save(PautaDTO dto) {
		Pauta pauta = new Pauta();
		BeanUtils.copyProperties(dto, pauta);
		return repository.save(pauta);
	}
	
	//Somente utilizado para testes
	@Transactional
	public void delete(Pauta pauta) {
		repository.delete(pauta);
		repository.flush();
	}

}
