package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class AlumnoCollection {
	private static List<Alumno> alumnos = new ArrayList<>();
	
	public static void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	public static void eliminarAlumno(Alumno alumno) {
		alumnos.remove(alumno);
	}
    
	public static List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	// Otros métodos estáticos para buscar, modificar, listar, etc.
}
