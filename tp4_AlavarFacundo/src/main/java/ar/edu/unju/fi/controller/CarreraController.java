package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@GetMapping("/listar")
	public String listar(Model model) {
	    model.addAttribute("carreras", CarreraCollection.getCarreras());
	    return "listarCarreras";
	}
	
	@GetMapping("/agregar")
	public String mostrarFormularioAgregar(Model model) {
	    Carrera carrera = new Carrera("", "", (byte) 0, false); // Inicialización directa
	    model.addAttribute("carrera", carrera);
	    return "agregarCarrera";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Carrera carrera, RedirectAttributes redirectAttributes) {
	    if (!carrera.getEstado()) {
	        redirectAttributes.addFlashAttribute("error", "Debe confirmar para poder guardar la carrera");
	        return "redirect:/carrera/agregar";
	    }
	    CarreraCollection.agregarCarrera(carrera);
	    return "redirect:/carrera/listar";
	}

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable String codigo, Model model) {
		Carrera carrera = CarreraCollection.buscarCarrera(codigo);
		if (carrera != null) {
			model.addAttribute("carrera", carrera);
			return "editarCarrera";
		} else {
			return "redirect:/carrera/listar";
		}
	}

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Carrera carrera, RedirectAttributes redirectAttributes) {
        if (carrera == null) {
            redirectAttributes.addFlashAttribute("error", "La carrera no puede ser nula");
            return "redirect:/carrera/listar";
        }

        Carrera carreraOriginal = CarreraCollection.buscarCarrera(carrera.getCodigo());


        if (carreraOriginal != null) {

            carreraOriginal.setNombre(carrera.getNombre());
            carreraOriginal.setCantidadAnios(carrera.getCantidadAnios());
            carreraOriginal.setEstado(carrera.getEstado());


            CarreraCollection.modificarCarrera(carreraOriginal);
        } else {
            redirectAttributes.addFlashAttribute("error", "La carrera no existe");
        }

        return "redirect:/carrera/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable String codigo) {
        CarreraCollection.eliminarCarerra(codigo);
        return "redirect:/carrera/listar";
    }
}