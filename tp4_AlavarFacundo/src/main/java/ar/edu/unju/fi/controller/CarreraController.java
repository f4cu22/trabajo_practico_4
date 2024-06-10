package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.collections.CarreraCollection;

@Controller
public class CarreraController {

    @Autowired
    private CarreraCollection carreraCollection;

    @GetMapping("/carreras")
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", carreraCollection.getCarreras());
        return "listaCarreras";  // Nombre de la plantilla Thymeleaf que mostrará la lista de carreras
    }

    @GetMapping("/carreras/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("carrera", new Carrera());
        return "formularioAgregarCarrera";  // Nombre de la plantilla Thymeleaf para agregar una carrera
    }

    @PostMapping("/carreras/agregar")
    public String agregarCarrera(@ModelAttribute Carrera carrera) {
        // logica
        return "redirect:/carreras";  // Redireccionar a la lista de carreras después de agregar una nueva
    }

    @GetMapping("/carreras/eliminar/{codigo}")
    public String eliminarCarrera(@PathVariable String codigo) {
        // logica
        return "redirect:/carreras";  // Redireccionar a la lista de carreras después de eliminar una
    }

    @GetMapping("/carreras/modificar/{codigo}")
    public String mostrarFormularioModificar(@PathVariable String codigo, Model model) {
    	// logica
        return "formularioModificarCarrera";  // Nombre de la plantilla Thymeleaf para modificar una carrera
    }

    @PostMapping("/carreras/modificar")
    public String modificarCarrera(@ModelAttribute Carrera carrera) {
        // logica
        return "redirect:/carreras";  // Redireccionar a la lista de carreras después de modificar una
    }
}