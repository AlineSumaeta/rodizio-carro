package com.example.rodiziocarro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.rodiziocarro.domain.dto.CarroDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class RodizioCarroApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RodizioCarroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.getForEntity("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3", String.class);
		
		ObjectMapper mapper = new ObjectMapper();
				
		CarroDTO carroDTO = mapper.readValue(response.getBody(), CarroDTO.class);
		
		System.out.println(response.getBody());
//		System.out.println(carroDTO);
	}

}
