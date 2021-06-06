package com.example.rodiziocarro.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.rodiziocarro.domain.Usuario;

/*passo 2: implementar um repository, para usar o jpa para mapear os atributos da tabela Usuario
trocamos o JpaRepository pelo CrudRepository devido a função de buscar um usuario pelo id dele




*/
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
}

