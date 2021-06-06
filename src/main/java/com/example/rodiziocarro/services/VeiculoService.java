package com.example.rodiziocarro.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.rodiziocarro.domain.Veiculo;
import com.example.rodiziocarro.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Veiculo> findAll() {
		return repository.findAll();
	}
}

