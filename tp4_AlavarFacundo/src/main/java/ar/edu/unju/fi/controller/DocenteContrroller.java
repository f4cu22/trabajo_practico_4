package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/docente")
public class DocenteContrroller {

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("docentes", DocenteCollection.getDocentes());
        return "listarDocentes";
    }

    @GetMapping("/agregar")
    public String agregar(Model model) {
        model.addAttribute("docente", new Docente("", "", "", "", ""));
        return "agregarDocente";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Docente docente) {
        DocenteCollection.agregarDocente(docente);
        return "redirect:/docente/listar";
    }

    @GetMapping("/editar/{legajo}")
    public String editar(@PathVariable String legajo, Model model) {
        Docente docente = DocenteCollection.buscarDocente(legajo);
        model.addAttribute("docente", docente);
        return "editarDocente";
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Docente docente) {
        DocenteCollection.modificarDocente(docente);
        return "redirect:/docente/listar";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminar(@PathVariable String legajo) {
        DocenteCollection.eliminarDocente(legajo);
        return "redirect:/docente/listar";
    }
}