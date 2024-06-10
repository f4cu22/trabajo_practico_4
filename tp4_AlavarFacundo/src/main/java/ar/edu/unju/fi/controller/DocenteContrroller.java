package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.collections.DocenteCollection;

@Controller
public class DocenteContrroller {

    @Autowired
    private DocenteCollection docenteCollection;

    @GetMapping("/docentes")
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", docenteCollection.getDocentes());
        return "listaDocentes";  // Nombre de la plantilla Thymeleaf que mostrará la lista de docentes
    }

    @GetMapping("/docentes/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("docente", new Docente());
        return "formularioAgregarDocente";  // Nombre de la plantilla Thymeleaf para agregar un docente
    }

    @PostMapping("/docentes/agregar")
    public String agregarDocente(@ModelAttribute Docente docente) {
    	// logica
        return "redirect:/docentes";  // Redireccionar a la lista de docentes después de agregar uno nuevo
    }

    @GetMapping("/docentes/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable String legajo) {
        // lógica
        return "redirect:/docentes";  // Redireccionar a la lista de docentes después de eliminar uno
    }

    @GetMapping("/docentes/modificar/{legajo}")
    public String mostrarFormularioModificar(@PathVariable String legajo, Model model) {
    	// logica
        return "formularioModificarDocente";  // Nombre de la plantilla Thymeleaf para modificar un docente
    }

    @PostMapping("/docentes/modificar")
    public String modificarDocente(@ModelAttribute Docente docente) {
    	// logica
        return "redirect:/docentes";  // Redireccionar a la lista de docentes después de modificar uno
    }
}