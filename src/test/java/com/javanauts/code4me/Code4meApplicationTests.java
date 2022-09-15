package com.javanauts.code4me;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Code4meApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void passwordDoesNotMatch(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String results = encoder.encode("Wade");
		assertThat(encoder.matches("Watts",results)).isFalse();
	}

	@Test
	void passwordDoesMatch(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String results = encoder.encode("DeadPool");
		assertThat(encoder.matches("DeadPool", results)).isTrue();
	}

}
