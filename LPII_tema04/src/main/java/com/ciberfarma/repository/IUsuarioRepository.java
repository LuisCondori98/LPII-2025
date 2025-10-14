package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ciberfarma.entity.Usuario;
import java.util.List;


public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	 public Usuario findByCorreoAndClave(String correo, String clave);
}
