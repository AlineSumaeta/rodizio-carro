package com.example.rodiziocarro.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rodiziocarro.domain.Usuario;
import com.example.rodiziocarro.domain.dto.UsuarioDTO;
import com.example.rodiziocarro.services.UsuarioService;

/*
 * no controlador fica a parte dos endpoints.
 * estamos dizendo que quando o usuario digitar "usuarios" na url, ele vai buscar todos os usuarios
 * 
 * */


@RestController
@RequestMapping(value = "/usuarios") //Caminho da url
public class UsuarioController {

	@Autowired
	private UsuarioService service; //injecao de dependencia com a classe responssavel pelo crud
	
	//o @GetMapping substitui o @RequestMapping(value = RequestMapping.get)
	
	@GetMapping(value = "/{id}") //retorna o usuario de acordo com o id requisitado
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
		UsuarioDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
	
	@PostMapping //post insere um novo usuario
	public ResponseEntity<Usuario> insertUsuario(@RequestBody UsuarioDTO dto){
		Usuario entity = service.insertUsuario(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(entity); //created  o status 201 que retornado como resposta da requisicao
	}
}