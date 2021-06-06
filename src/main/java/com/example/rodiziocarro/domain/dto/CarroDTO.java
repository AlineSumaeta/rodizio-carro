package com.example.rodiziocarro.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarroDTO {
	@JsonProperty("Valor")
	private String valor;
	
	@JsonProperty("Marca")
	private String marca;
	
	@JsonProperty("Modelo")
	private String modelo;
	
	@JsonProperty("AnoModelo")
	private String anoModelo;
	
	@JsonProperty("Combustivel")
	private String combustivel;
	
	@JsonProperty("CodigoFipe")
	private String codigoFipe;
	
	@JsonProperty("MesReferencia")
	private String mesReferencia;
	
	@JsonProperty("TipoVeiculo")
	private int tipoVeiculo;
	
	@JsonProperty("SiglaCombustivel")
	private String siglaCombustive;

	@Override
	public String toString() {
		return "CarroDTO [valor=" + valor + ", marca=" + marca + ", modelo=" + modelo + ", anoModelo=" + anoModelo
				+ ", combustivel=" + combustivel + ", codigoFipe=" + codigoFipe + ", mesReferencia=" + mesReferencia
				+ ", tipoVeiculo=" + tipoVeiculo + ", siglaCombustivel=" + siglaCombustive + "]";
	}

}
