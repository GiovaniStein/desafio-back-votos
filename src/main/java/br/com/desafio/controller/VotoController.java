package br.com.desafio.controller;

import java.util.List;

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

import br.com.desafio.model.Voto;
import br.com.desafio.model.dto.VotoDTO;
import br.com.desafio.service.VotoService;

@RestController
@RequestMapping("/voto")
public class VotoController {

	@Autowired
	private VotoService service;

	@GetMapping("/{id}")
	private ResponseEntity<List<Voto>> findAllBySessao(@PathVariable Long id) {
		List<Voto> votos = service.findAllBySessao(id);
		return votos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(votos);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid VotoDTO dto) {
		try {
			Voto save = service.save(dto, true);
			return ResponseEntity.status(HttpStatus.CREATED).body(save);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
