package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.collections.MateriaCollection;

@Controller
public class MateriaController {

    @Autowired
    private MateriaCollection materiaCollection;

    @GetMapping("/materias")
    public String listarMaterias(Model model) {
        model.addAttribute("materias", materiaCollection.getMaterias());
        return "listaMaterias";  // Nombre de la plantilla Thymeleaf que mostrará la lista de materias
    }

    @GetMapping("/materias/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("materia", new Materia());
        return "formularioAgregarMateria";  // Nombre de la plantilla Thymeleaf para agregar una materia
    }

    @PostMapping("/materias/agregar")
    public String agregarMateria(@ModelAttribute Materia materia) {
    	// logica
        return "redirect:/materias";  // Redireccionar a la lista de materias después de agregar una nueva
    }

    @GetMapping("/materias/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable String codigo) {
    	// logica
        return "redirect:/materias";  // Redireccionar a la lista de materias después de eliminar una
    }

    @GetMapping("/materias/modificar/{codigo}")
    public String mostrarFormularioModificar(@PathVariable String codigo, Model model) {
    	// logica
        return "formularioModificarMateria";  // Nombre de la plantilla Thymeleaf para modificar una materia
    }

    @PostMapping("/materias/modificar")
    public String modificarMateria(@ModelAttribute Materia materia) {
    	// logica
        return "redirect:/materias";  // Redireccionar a la lista de materias después de modificar una
    }
}