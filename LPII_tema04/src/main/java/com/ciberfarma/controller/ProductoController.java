package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.entity.Producto;
import com.ciberfarma.repository.ICategoriaRepository;
import com.ciberfarma.repository.IProductoRepository;
import com.ciberfarma.repository.IProveedorRepository;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ICategoriaRepository categoriaRepository;
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private IProveedorRepository proveedorRepository;
	
	@GetMapping
	public String cargarPagina(Model m) {
		
		m.addAttribute("lstCategorias", categoriaRepository.findAll());
		m.addAttribute("lstProductos", productoRepository.findAll());
		m.addAttribute("lstProveedores", proveedorRepository.findAll());
		m.addAttribute("producto", new Producto());
		m.addAttribute("cantidad", productoRepository.findAll().size());
		return "crudproductos";
	}
	
	@PostMapping("/grabar")
	public String crearProducto(Model m, @ModelAttribute Producto producto) {

		try {
			
			productoRepository.save(producto);
		} catch(Exception e) {
			
		}
		
		/*m.addAttribute("lstCategorias", categoriaRepository.findAll());
		m.addAttribute("lstProductos", productoRepository.findAll());*/
		
		return "redirect:/productos";
	}
	
	@GetMapping("/editar/{id_prod}")
	public String editarProducto(@PathVariable String id_prod, Model m) {
		
		Producto p = productoRepository.findById(id_prod).get();
		
		m.addAttribute("lstCategorias", categoriaRepository.findAll());
		m.addAttribute("lstProductos", productoRepository.findAll());
		m.addAttribute("lstProveedores", proveedorRepository.findAll());
		m.addAttribute("producto", p);
		
		return "crudproductos";
	}
	
	@PutMapping("/actualizar")
	public String actualizarProductor(Model model) {
	
		
		
		return "crudproductos";
	}
}
