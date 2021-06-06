package com.example.rodiziocarro.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaModeloDTO {

	//criando uma lista que pega os valores da classe ModeloDTO
	List<ModeloDTO> list = new ArrayList<>();
	
	public List<ModeloDTO> buscarModelo(){
		return list;
	}
}
