package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class CarreraCollection {
	private static List<Carrera> carreras = new ArrayList<>();
	
	public static void agregarCarrera(Carrera carrera) {
		carreras.add(carrera);
	}
	
	public static void eliminarCarrera(Carrera carrera) {
		carreras.remove(carrera);
	}
	
	public static List<Carrera> getCarreras() {
		return carreras;
	}
	
    // Otros métodos estáticos para buscar, modificar, listar, etc.
}
