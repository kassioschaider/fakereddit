package br.com.kassioschaider.fakereddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FakeredditApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeredditApplication.class, args);
	}

}
