package br.com.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.model.Sessao;
import br.com.desafio.model.dto.SessaoDTO;
import br.com.desafio.model.projection.SessaoResultProjection;
import br.com.desafio.service.SessaoService;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
	
	@Autowired
	private SessaoService service;
		
	@GetMapping("/result/{id}")
	public ResponseEntity<SessaoResultProjection> findSessaoResult(@PathVariable Long id) {
		SessaoResultProjection result = service.findSessaoResults(id);
		return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<Sessao> findById(@PathVariable Long id) {
    	Sessao sessao = service.findById(id);
        return sessao != null ? ResponseEntity.ok(sessao) : ResponseEntity.notFound().build();
    }

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid SessaoDTO dto) {
		try {
			Sessao save = service.save(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(save);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
