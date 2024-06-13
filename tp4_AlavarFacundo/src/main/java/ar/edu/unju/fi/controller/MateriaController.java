package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Materia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("materias", MateriaCollection.getMaterias());
        return "listarMaterias";
    }

    @GetMapping("/agregar")
    public String agregar(Model model) {
        model.addAttribute("materia", new Materia("", "", 0, 0, "", "", ""));
        return "agregarMateria";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Materia materia) {
        MateriaCollection.agregarMateria(materia);
        return "redirect:/materia/listar";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable String codigo, Model model) {
        Materia materia = MateriaCollection.buscarMateria(codigo);
        model.addAttribute("materia", materia);
        return "editarMateria";
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Materia materia) {
        MateriaCollection.modificarMateria(materia);
        return "redirect:/materia/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable String codigo) {
        MateriaCollection.eliminarMateria(codigo);
        return "redirect:/materia/listar";
    }
}