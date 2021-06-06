package com.example.rodiziocarro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.rodiziocarro.domain.Usuario;
import com.example.rodiziocarro.domain.Veiculo;
import com.example.rodiziocarro.domain.dto.AnoDTO;
import com.example.rodiziocarro.domain.dto.MarcaDTO;
import com.example.rodiziocarro.domain.dto.ModeloDTO;
import com.example.rodiziocarro.domain.dto.ModelosDTO;
import com.example.rodiziocarro.domain.dto.VeiculoDTO;
import com.example.rodiziocarro.domain.dto.VeiculosDadosDTO;
import com.example.rodiziocarro.services.UsuarioService;
import com.example.rodiziocarro.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RestTemplate template = new RestTemplate();
	
	private List<MarcaDTO> marcas;
	private List<ModeloDTO> modelos;
	private List<AnoDTO> anos;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll(){
		List<Veiculo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/novoVeiculo")
	public ResponseEntity<Usuario> insertVeiculoToUsuario(@RequestBody VeiculosDadosDTO dados) {
		VeiculoDTO dto = defineVeiculo(dados);
		Usuario usuario = usuarioService.addVeiculo(dto, dados.getIdUsuario());
		
		return ResponseEntity.ok().body(usuario);
	}
	
	private VeiculoDTO defineVeiculo(VeiculosDadosDTO dados) {
		String path = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
	
		String marca = dados.getMarca();
		String modelo = dados.getModelo();
		String ano = dados.getAno();
		
		String marcaId = "";
		marcas = template.exchange(path,HttpMethod.GET, null, new ParameterizedTypeReference<List<MarcaDTO>>() {}).getBody();
		for(MarcaDTO m : marcas) {
			if(m.getNome().equals(marca))marcaId = m.getCodigo();
		}
		
		Integer modeloId = 0;
		String pathModelos = path + "/" + marcaId + "/modelos";
		modelos = template.getForObject(pathModelos, ModelosDTO.class).getModelos();
		for(ModeloDTO m : modelos) {
			if(m.getNome().equals(modelo))modeloId = m.getCodigo();
		}
		
		String anoId = "";
		anos = template.exchange(pathModelos + "/" + modeloId + "/anos",HttpMethod.GET, null, new ParameterizedTypeReference<List<AnoDTO>>() {}).getBody();
		for(AnoDTO m : anos) {
			if(m.getNome().subSequence(0, 4).toString().equals(ano))anoId = m.getCodigo();
		}
		
		VeiculoDTO veiculo = template.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marcaId + "/modelos/" 
				+ modeloId + "/anos/"
				+ anoId, VeiculoDTO.class);
		
		
		
		return veiculo;
	}
	
}
