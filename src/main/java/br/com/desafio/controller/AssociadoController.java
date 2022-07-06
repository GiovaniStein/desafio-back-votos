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

import br.com.desafio.model.Associado;
import br.com.desafio.service.AssociadoService;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

	@Autowired
	private AssociadoService service;
	
    @GetMapping("/{cpf}")
    private ResponseEntity<Associado> findById(@PathVariable String cpf) {
    	Associado associado = service.findById(cpf);
        return associado != null ? ResponseEntity.ok(associado) : ResponseEntity.notFound().build();
    }

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Associado associado) {
		try {
			Associado save = service.save(associado);
			return ResponseEntity.status(HttpStatus.CREATED).body(save);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}



}
