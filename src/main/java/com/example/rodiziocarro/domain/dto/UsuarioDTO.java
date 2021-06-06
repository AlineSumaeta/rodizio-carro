package com.example.rodiziocarro.domain.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.example.rodiziocarro.domain.Usuario;
import com.example.rodiziocarro.domain.Veiculo;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Instant dataDeNascimento;
	List<Veiculo> veiculos = new ArrayList<>();
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String email, String cpf, Instant dataDeNascimento,
			List<Veiculo> veiculos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.veiculos = veiculos;
	}
	
	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
		cpf = usuario.getCpf();
		dataDeNascimento = usuario.getDataDeNascimento();
		veiculos = usuario.getVeiculos();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Instant getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(Instant dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
		
}