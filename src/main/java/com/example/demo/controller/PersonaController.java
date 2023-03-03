package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Persona;
import com.example.demo.service.IPersonaService;

@Controller
@RequestMapping("/personas") //Se debe poner en plural el recuso en el URL -> Buena practica
public class PersonaController {//Es un recurso o modelo en la capa controller el objeto
	
	
	@Autowired
	private IPersonaService iPersonaService;
	
	// /personas/nuevaPersona -> Va a este metodo
	@GetMapping("/nuevaPersona")
	public String paginaNuevaPersona(Persona persona) {//Ponemos el modelo asi no lo usemos porque es parte del disenio
		//Retorna un String porque le ponemos el nombre de la 
		//vista que quiero que retorne
		return "vistaNuevaPersona";
	}
	
	@PostMapping("/insertar")
	public String insertarPersona(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "guardado";
		
}
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Persona> lista = this.iPersonaService.buscarTodos();
		modelo.addAttribute("personas",lista);
		return "vistaListaPersonas";
	}
	@DeleteMapping("/borrar/{id}")
	public String borrarPersona(@PathVariable("id") Integer id) {
		this.iPersonaService.eliminar(id);
		
		return "redirect:/personas/buscar";
	}
	
	@GetMapping("/buscarPorId/{id}")
		public String buscarPorId(@PathVariable("id") Integer id, Model modelo) {
			Persona persona = this.iPersonaService.buscarPorId(id);
			modelo.addAttribute("persona", persona);
			return "vistaPersona"; 
		
	}
	@PutMapping("/actualizar/{id}")
	public String actualizarPorId(@PathVariable("id") Integer id, Persona persona) {
		persona.setId(id);
		this.iPersonaService.actualizar(persona);
		return "redirect:/personas/buscar"; 
	}
}
