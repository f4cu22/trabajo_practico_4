package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@GetMapping("/listar")
	public String listar(Model model) {
	    model.addAttribute("carreras", CarreraCollection.getCarreras());
	    return "listarCarreras";
	}
	
    @GetMapping("/agregar")
    public String agregar(Model model) {
        model.addAttribute("carrera", new Carrera("", "", (byte) 0, true));
        return "agregarCarrera";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Carrera carrera) {
        CarreraCollection.agregarCarrera(carrera);
        return "redirect:/carrera/listar";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable String codigo, Model model) {
        Carrera carrera = CarreraCollection.buscarCarrera(codigo);
        model.addAttribute("carrera", carrera);
        return "editarCarrera";
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Carrera carrera) {
        CarreraCollection.modificarCarrera(carrera);
        return "redirect:/carrera/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable String codigo) {
        CarreraCollection.eliminarCarerra(codigo);
        return "redirect:/carrera/listar";
    }
}