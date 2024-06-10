package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;

public class MateriaCollection {
	private static List<Materia> materias = new ArrayList<>();
	
	public static void agregarMateria(Materia materia) {
		materias.add(materia);
	}
	
	public static void eliminarMateria(Materia materia) {
		materias.remove(materia);
	}
	
	public static List<Materia> getMaterias() {
		return materias;
	}
	
	// Otros métodos estáticos para buscar, modificar, listar, etc.
}
