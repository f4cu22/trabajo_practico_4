package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Carrera;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class CarreraCollection {
	private static List<Carrera> carreras = new ArrayList<>();
	
	/**
	 * Se trabaja sobre la clase Carrera
     * Se devuelve un arrayList de objetos
     *
     * @return Objeto carrera
     */
    public static List<Carrera> getCarreras() {
        if (carreras.isEmpty()) {
            carreras.add(new Carrera("INFO111", "Ingeniería en Informática", (byte) 5, true));
            carreras.add(new Carrera("MINA222", "Ingenieria en Minas", (byte) 5, false));
            carreras.add(new Carrera("INDU333", "Ingeniería Industrial", (byte) 5, true));
            carreras.add(new Carrera("APU444", "A. Programador Universitario", (byte) 5, true));
        }
        return carreras;
    }

    /**
     * Se agrega un objeto de la clase Carrera
     *
     * @param carrera Objeto de la clase Carrera
     */
    public static void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    /**
     * Elimina un objeto
     *
     * @param codigoCarrera Objeto con atributos modificados
     */
    public static void eliminarCarerra(String codigoCarrera) {
        Iterator<Carrera> iterator = carreras.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCodigo().equals(codigoCarrera)) {
                iterator.remove();
            }
        }
    }

    /**
     * Se modifica un objeto
     *
     * @param carrera Objeto
     */
    public static void modificarCarrera(Carrera carrera) {
        for (Carrera c : carreras) {
            if (c.getCodigo().equals(carrera.getCodigo())) {
                c.setNombre(carrera.getNombre());
                c.setCantidadAnios(carrera.getCantidadAnios());
                c.setEstado(carrera.getEstado());
            } else {
                System.out.println("No se encontro la carrera");
            }
        }
    }

    /**
     * Busca un objeto 
     *
     * @param codigoCarrera Objeto atributos modificados
     * @return Objeto 
     */
    public static Carrera buscarCarrera(String codigoCarrera) {
        Predicate<Carrera> filterCodigo = c -> c.getCodigo().equals(codigoCarrera);
        Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
        if (carrera.isPresent()) {
            return carrera.get();
        } else {
            return null;
        }
    }
}

