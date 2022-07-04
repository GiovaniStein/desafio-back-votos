package br.com.desafio;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import br.com.desafio.model.dto.CpfValidatorResponseDTO;
import br.com.desafio.model.enums.StatusCpfValidator;
import br.com.desafio.utils.HttpClient;

@SpringBootTest(classes = DesafioBackVotosApplicationTests.class)
public class CpfValidatorIntegrationTest {

	@Test
	public void CpfTest() throws Exception {
		CpfValidatorResponseDTO verifyCpf = HttpClient.verifyCpf("98673284007");
		assertNotEquals(null, verifyCpf);

		assertTrue(verifyCpf.getStatus() == StatusCpfValidator.ABLE_TO_VOTE
				|| verifyCpf.getStatus() == StatusCpfValidator.UNABLE_TO_VOTE);
	}

}
