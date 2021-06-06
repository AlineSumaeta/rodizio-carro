package com.example.rodiziocarro.domain.dto;

import com.example.rodiziocarro.domain.Veiculo;
import com.fasterxml.jackson.annotation.JsonSetter;

public class VeiculoDTO {

	private Long id;
	private String valor;
	private String marca;
	private String modelo;
	private Integer anoModelo;
	private String combustivel;
	private String codigoFipe;
	private String mesReferencia;
	private Integer numeroVeiculo;
	private String siglaCombustivel;
	private String diaDeRodizio;
	private Boolean rodizioAtivo;
	
	public VeiculoDTO() {
	}

	public VeiculoDTO(Long id, String valor, String marca, String modelo, Integer anoModelo, String combustivel,
			String codigoFipe, String mesReferencia, Integer numeroVeiculo, String siglaCombustivel) {
		this.id = id;
		this.valor = valor;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.combustivel = combustivel;
		this.codigoFipe = codigoFipe;
		this.mesReferencia = mesReferencia;
		this.numeroVeiculo = numeroVeiculo;
		this.siglaCombustivel = siglaCombustivel;
	}
	
	public VeiculoDTO(Veiculo veiculo) {
		id = veiculo.getId();
		valor = veiculo.getValor();
		marca = veiculo.getMarca();
		modelo = veiculo.getModelo();
		anoModelo = veiculo.getAnoModelo();
		combustivel = veiculo.getCombustivel();
		codigoFipe = veiculo.getCodigoFipe();
		mesReferencia = veiculo.getMesReferencia();
		numeroVeiculo = veiculo.getNumeroVeiculo();
		siglaCombustivel = veiculo.getSiglaCombustivel();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	@JsonSetter(value = "Valor")
	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	@JsonSetter(value = "Marca")
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	@JsonSetter(value = "Modelo")
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	@JsonSetter(value = "AnoModelo")
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	@JsonSetter(value = "Combustivel")
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCodigoFipe() {
		return codigoFipe;
	}

	@JsonSetter(value = "CodigoFipe")
	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	@JsonSetter(value = "MesReferencia")
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Integer getNumeroVeiculo() {
		return numeroVeiculo;
	}

	@JsonSetter(value = "TipoVeiculo")
	public void setNumeroVeiculo(Integer numeroVeiculo) {
		this.numeroVeiculo = numeroVeiculo;
	}

	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}

	@JsonSetter(value = "SiglaCombustivel")
	public void setSiglaCombustivel(String siglaCombustivel) {
		this.siglaCombustivel = siglaCombustivel;
	}

	public String getDiaDeRodizio() {
		return diaDeRodizio;
	}

	public void setDiaDeRodizio(String diaDeRodizio) {
		this.diaDeRodizio = diaDeRodizio;
	}

	public Boolean getRodizioAtivo() {
		return rodizioAtivo;
	}

	public void setRodizioAtivo(Boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
	
}