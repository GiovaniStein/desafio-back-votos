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

import br.com.desafio.model.Pauta;
import br.com.desafio.model.dto.PautaDTO;
import br.com.desafio.service.PautaService;

@RestController
@RequestMapping("/pauta")
public class PautaController {

	@Autowired
	private PautaService service;

	@GetMapping
	public ResponseEntity<List<Pauta>> getAll() {
		List<Pauta> pautas = service.findAll();
		return pautas.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pautas);
	}
	
    @GetMapping("/{id}")
    private ResponseEntity<Pauta> findById(@PathVariable Long id) {
    	Pauta pauta = service.findById(id);
        return pauta != null ? ResponseEntity.ok(pauta) : ResponseEntity.notFound().build();
    }

	@PostMapping
	public ResponseEntity<Pauta> save(@RequestBody @Valid PautaDTO pauta) {
		try {
			Pauta insert = service.save(pauta);
			return ResponseEntity.status(HttpStatus.CREATED).body(insert);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	

}
