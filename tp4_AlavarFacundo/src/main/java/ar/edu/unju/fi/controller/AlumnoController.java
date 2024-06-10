package ar.edu.unju.fi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

public class AlumnoController {
	
	@GetMapping("/alumnos")
	public String listarAlumnos(Model model) {
		model.addAttribute("alumnos", AlumnoCollection.getAlumnos());
		return "listaAlumnos";
	}
    
	@GetMapping("/alumnos/agregar")
	public String mostrarFormularioAgregar(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "formularioAgregarAlumno";
	}
	
	@PostMapping("/alumnos/agregar")
	public String agregarAlumno(@ModelAttribute Alumno alumno) {
		AlumnoCollection.agregarAlumno(alumno);
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/eliminar/{codigo}")
	public String eliminarAlumno(@PathVariable String codigo) {
		// Lógica.
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/modificar/{codigo}")
	public String mostrarFormularioModificar(@PathVariable String codigo, Model model) {
		// Lógica.
		return "formularioModificarAlumno";
	}
    
	@PostMapping("/alumnos/modificar")
	public String modificarAlumno(@ModelAttribute Alumno alumno) {
		// Lógica.
		return "redirect:/alumnos";
	}
}
