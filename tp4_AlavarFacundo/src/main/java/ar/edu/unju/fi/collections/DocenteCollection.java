package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class DocenteCollection {
	private static List<Docente> docentes = new ArrayList<>();
	
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	public static void eliminarDocente(Docente docente) {
		docentes.remove(docente);
	}
	
	public static List<Docente> getDocentes() {
		return docentes;
	}
	// Otros métodos estáticos para buscar, modificar, listar, etc.
}
