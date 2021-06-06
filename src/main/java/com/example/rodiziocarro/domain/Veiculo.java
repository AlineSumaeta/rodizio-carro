package com.example.rodiziocarro.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public Veiculo() {
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
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
		
	}
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
		
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getCodigoFipe() {
		return codigoFipe;
	}
	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}
	public String getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public Integer getNumeroVeiculo() {
		return numeroVeiculo;
	}
	public void setNumeroVeiculo(Integer numeroVeiculo) {
		this.numeroVeiculo = numeroVeiculo;
	}
	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
