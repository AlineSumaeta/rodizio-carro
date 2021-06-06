package com.example.rodiziocarro.services;

import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rodiziocarro.domain.Usuario;
import com.example.rodiziocarro.domain.Veiculo;
import com.example.rodiziocarro.domain.dto.UsuarioDTO;
import com.example.rodiziocarro.domain.dto.VeiculoDTO;
import com.example.rodiziocarro.repositories.UsuarioRepository;
import com.example.rodiziocarro.repositories.VeiculoRepository;

/*
na classe de Serviço fica o CRUD, responsável pelas 4 operações basicas de requisição, o Create, retrieve, update, delete
*/
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@org.springframework.transaction.annotation.Transactional	(readOnly = true)
	public UsuarioDTO findById(Long id) {
		UsuarioDTO dto = new UsuarioDTO(repository.findById(id).get());
		for(Veiculo veiculo : dto.getVeiculos()) {
			veiculo.setRodizioAtivo(this.rodizioAtivo(veiculo.getDiaDeRodizio()));
		}
		return new UsuarioDTO(repository.findById(id).get());
	}
	
	@Transactional
	public Usuario insertUsuario(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		this.dtoToUsuario(dto, entity);
		repository.save(entity);
		return entity;
	}
	
	@Transactional
	public Usuario addVeiculo(VeiculoDTO dto, Long usuarioId) {
		Veiculo veiculo = new Veiculo();
		this.dtoToVeiculo(veiculo, dto);
		Usuario usuario = repository.findById(usuarioId).get();
		veiculoRepository.save(veiculo);
		usuario.addVeiculo(veiculo);
		repository.save(usuario);
		return repository.findById(usuarioId).get();
	}
	
	private void dtoToUsuario(UsuarioDTO dto, Usuario entity) {
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setDataDeNascimento(dto.getDataDeNascimento());
	}
	
	private void dtoToVeiculo(Veiculo entity, VeiculoDTO dto) {
		entity.setValor(dto.getValor());
		entity.setMarca(dto.getMarca());
		entity.setModelo(dto.getModelo());
		entity.setAnoModelo(dto.getAnoModelo());
		entity.setMesReferencia(dto.getMesReferencia());
		entity.setCodigoFipe(dto.getCodigoFipe());
		entity.setCombustivel(dto.getCombustivel());
		entity.setNumeroVeiculo(dto.getNumeroVeiculo());
		entity.setSiglaCombustivel(dto.getSiglaCombustivel());
		entity.setDiaDeRodizio(diaDeRodizio(dto.getAnoModelo()));
		entity.setRodizioAtivo(rodizioAtivo(entity.getDiaDeRodizio()));
	}
	
	
	
	public String diaDeRodizio(Integer anoModelo) {
		Integer numeroFinal = anoModelo % 10;
		
		switch (numeroFinal) {
			
		case 0:{
			return "Segunda";
		}
		case 1:{
			return "Segunda";
		}
		case 2:{
			return "Terca";
		}
		case 3:{
			return "Terca";
		}
		case 4:{
			return "Quarta";
		}case 5:{
			return "Quarta";
		}case 6:{
			return "Quinta";
		}
		case 7:{
			return "Quinta";
		}
		case 8:{
			return "Sexta";
		}
		case 9:{
			return "Sexta";
		}
}
		return null;
	}
	
	
	private Boolean rodizioAtivo(String diaDeRodizio) {
		Integer dia;
		if(diaDeRodizio.equals("Segunda")) {
			dia = 2;
		}
		else if(diaDeRodizio.equals("Terca")) {
			dia = 3;
		}
		else if(diaDeRodizio.equals("Quarta")) {
			dia = 4;
		}
		else if(diaDeRodizio.equals("Quinta")) {
			dia = 5;
		}
		else if(diaDeRodizio.equals("Sexta")) {
			dia = 6;
		}
		else {
			dia = 1;
		}

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		if(calendar.DAY_OF_WEEK == dia && calendar.DAY_OF_WEEK != 1) {
			return true;
		}
		return false;
	}	

}
