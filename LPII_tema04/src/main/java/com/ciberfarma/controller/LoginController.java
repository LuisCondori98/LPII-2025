package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.entity.Usuario;
import com.ciberfarma.repository.IUsuarioRepository;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public String login(Model m) {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginValidate(Model m,
								@RequestParam("usuario") String usuario,
								@RequestParam("password") String pass) {
		
		Usuario u = usuarioRepository.findByCorreoAndClave(usuario, pass);
		
		if(u != null) {
			
			return "principal";
		} else {
			
			m.addAttribute("mensaje", "usuario o clave incorrecta");
			m.addAttribute("cssmensaje", "alert alert-danger");
			
			return "login";
		}
	}
}
