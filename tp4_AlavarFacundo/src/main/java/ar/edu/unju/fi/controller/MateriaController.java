package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Materia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        model.addAttribute("materia", new Materia("", "", 0, 0, "", null, null));
        model.addAttribute("docentes", DocenteCollection.getDocentes());
        model.addAttribute("carreras", CarreraCollection.getCarreras());
        return "agregarMateria";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("materia") @Validated Materia materia, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("docentes", DocenteCollection.getDocentes());
            model.addAttribute("carreras", CarreraCollection.getCarreras());
            return "agregarMateria";
        }

        MateriaCollection.agregarMateria(materia);
        return "redirect:/materia/listar";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable String codigo, Model model) {
        Materia materia = MateriaCollection.buscarMateria(codigo);
        model.addAttribute("materia", materia);
        model.addAttribute("docentes", DocenteCollection.getDocentes());
        model.addAttribute("carreras", CarreraCollection.getCarreras());
        return "editarMateria";
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Materia materia, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("docentes", DocenteCollection.getDocentes());
            model.addAttribute("carreras", CarreraCollection.getCarreras());
            return "editarMateria";
        }

        MateriaCollection.modificarMateria(materia);
        return "redirect:/materia/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable String codigo) {
        MateriaCollection.eliminarMateria(codigo);
        return "redirect:/materia/listar";
    }
}