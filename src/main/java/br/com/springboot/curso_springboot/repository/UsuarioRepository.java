package br.com.springboot.curso_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_springboot.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value = "select u from Usuario u where upper(trim(u.nome)) like %?1%") /*o trin retira os espaços da busca e upper não interessa se é maiusculo*/
	List<Usuario> buscarPorNome(String name);

	void deleteById(String iduser);
	
}
