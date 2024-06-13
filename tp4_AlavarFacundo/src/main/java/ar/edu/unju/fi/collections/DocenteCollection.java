package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Docente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DocenteCollection {
	private static List<Docente> docentes = new ArrayList<>();
	
	/**
	 * Se trabaja sobre la clase docentes
     * Devuelve un arrayList de objetos
     * @return Objeto docente
     */
    public static List<Docente> getDocentes() {
        if (docentes.isEmpty()) {
            docentes.add(new Docente("111", "Jose", "Alvarez", "jose@gmail.com", "3884123456"));
            docentes.add(new Docente("222", "Zoe", "Barrientos", "zoe@gmail.com", "3885123456"));
            docentes.add(new Docente("333", "Rita", "Alvarez", "rita@gmail.com", "3883333333"));
            docentes.add(new Docente("444", "Jose", "Vilte", "jose@gmail.com", "3884444444"));
        }
        return docentes;
    }

    /**
     * Agrega un objeto
     * @param docente Objeto
     */
    public static void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    /**
     * Se elimina un objeto
     * @param legajo Objeto con atributos modificados
     */
    public static void eliminarDocente(String legajo) {
        docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
    }

    /**
     * Se modifica un objeto
     * @param docente Objeto
     */
    public static void modificarDocente(Docente docente) {
        for (Docente d : docentes) {
            if (d.getLegajo().equals(docente.getLegajo())) {
                d.setNombre(docente.getNombre());
                d.setApellido(docente.getApellido());
                d.setEmail(docente.getEmail());
                d.setTelefono(docente.getTelefono());
            }
        }
    }

    /**
     * Busca un objeto
     * @param legajo Objeto
     * @return Objeto docente
     */
    public static Docente buscarDocente(String legajo) {
        Predicate<Docente> filterCodigo = docente -> docente.getLegajo().equals(legajo);
        Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
        return docente.orElse(null);
    }
}
