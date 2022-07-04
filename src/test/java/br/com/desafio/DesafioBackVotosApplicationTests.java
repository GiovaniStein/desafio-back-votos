package br.com.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@ComponentScan(value = "br.com.desafio")
@EnableJpaRepositories(value = "br.com.desafio")
@EntityScan(basePackages = {"br.com.desafio.model"}, basePackageClasses = {Jsr310JpaConverters.class})
class DesafioBackVotosApplicationTests {

	@Test
	void contextLoads() {
	}

}
