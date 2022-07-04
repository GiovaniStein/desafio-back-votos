package br.com.desafio.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.desafio.model.dto.CpfValidatorResponseDTO;

public class HttpClient {

	public static CpfValidatorResponseDTO verifyCpf(String cpf) throws Exception {

		String url = String.format("https://user-info.herokuapp.com/users/%s", cpf);

		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CpfValidatorResponseDTO> response = restTemplate.getForEntity(url,
					CpfValidatorResponseDTO.class);

			if (response.getStatusCode() == HttpStatus.OK)
				return response.getBody();

			if (response.getStatusCode() == HttpStatus.NOT_FOUND)
				throw new Exception("Cpf informado é inválido");

		} catch (Exception e) {
			throw new Exception(e);
		}

		return null;

	}

}
