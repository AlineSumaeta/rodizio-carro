package com.example.rodiziocarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.rodiziocarro.domain.dto.AnoDTO;
import com.example.rodiziocarro.domain.dto.MarcaDTO;
import com.example.rodiziocarro.domain.dto.ModelosDTO;
import com.example.rodiziocarro.domain.dto.VeiculoDTO;
import com.example.rodiziocarro.services.VeiculoService;

@RestController
public class FipeController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private VeiculoService service;
	
	@GetMapping(value = "/marcas")
	public ResponseEntity<List<MarcaDTO>> getMarcas() {
		String path = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
		
		List<MarcaDTO> marcas = restTemplate.exchange(path,HttpMethod.GET, null, new ParameterizedTypeReference<List<MarcaDTO>>() {}).getBody();
		
		return ResponseEntity.ok().body(marcas);
	}
	
	@GetMapping(value = "/modelos")
	public ResponseEntity<ModelosDTO> getModelos() {
		String path = "https://parallelum.com.br/fipe/api/v1/carros/marcas/23/modelos";
		
		ModelosDTO modelos = restTemplate.getForObject(path, ModelosDTO.class);
		
		return ResponseEntity.ok().body(modelos);
	}
	
	@GetMapping(value = "/anos")
	public ResponseEntity<AnoDTO> getAnos() {
		String path = "https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos";
		
		AnoDTO anos = restTemplate.getForObject(path, AnoDTO.class);
		
		return ResponseEntity.ok().body(anos);
	}
	
	@GetMapping(value = "/valor")
	public ResponseEntity<VeiculoDTO> getValor() {
		String path = "https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3";
		
		VeiculoDTO anos = restTemplate.getForObject(path, VeiculoDTO.class);
		
		return ResponseEntity.ok().body(anos);
	}
	
}