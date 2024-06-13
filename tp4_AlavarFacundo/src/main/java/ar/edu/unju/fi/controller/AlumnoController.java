package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alumnos", AlumnoCollection.getAlumnos());
        return "listarAlumnos";
    }

    @GetMapping("/agregar")
    public String agregar(Model model) {
        model.addAttribute("alumno", new Alumno("", "", "", "", "", LocalDate.now(), "", ""));
        return "agregarAlumno";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Alumno alumno) {
        AlumnoCollection.agregarAlumno(alumno);
        return "redirect:/alumno/listar";
    }

    @GetMapping("/editar/{dni}")
    public String editar(@PathVariable String dni, Model model) {
        Alumno alumno = AlumnoCollection.buscarAlumno(dni);
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
            return "editarAlumno";
        } else {
            return "redirect:/alumno/listar"; // Manejar el caso de alumno no encontrado
        }
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Alumno alumno) {
        AlumnoCollection.modificarAlumno(alumno);
        return "redirect:/alumno/listar";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminar(@PathVariable String dni) {
        AlumnoCollection.eliminarAlumno(dni);
        return "redirect:/alumno/listar";
    }
}