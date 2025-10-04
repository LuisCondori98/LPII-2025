package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciberfarma.repository.ICategoriaRepository;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	@GetMapping
	public String cargarPagina(Model m) {
		
		m.addAttribute("lstCategorias", categoriaRepository.findAll());
		
		return "crudproductos";
	}	
}
