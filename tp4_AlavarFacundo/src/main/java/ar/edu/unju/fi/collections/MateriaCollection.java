package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Materia;

public class MateriaCollection {
	private static List<Materia> materias = new ArrayList<>();
	

    /**
     * Se trabaja sobre la clase materia
     * Se devuelve un arrayList de objetos
     *
     * @return Objeto materia
     */
    public static List<Materia> getMaterias() {
        return materias;
    }

    /**
     * Se agrega un objeto de la clase Materia
     *
     * @param materia Objeto
     */
    public static boolean agregarMateria(Materia materia) {
        materias.add(materia);
        return true;
    }

    /**
     * Se elimina un objeto
     *
     * @param codigoMateria Objeto con atributos modificados
     */
    public static void eliminarMateria(String codigoMateria) {
        Iterator<Materia> iterator = materias.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCodigo().equals(codigoMateria)) {
                iterator.remove();
            }
        }
    }

    /**
     * Modifica un objeto
     *
     * @param materia Objeto 
     */
    public static void modificarMateria(Materia materia) {
        for (Materia m : materias) {
            if (m.getCodigo().equals(materia.getCodigo())) {
                m.setNombre(materia.getNombre());
                m.setCurso(materia.getCurso());
                m.setCantidadHoras(materia.getCantidadHoras());
                m.setModalidad(materia.getModalidad());
                m.setDocente(materia.getDocente());
                m.setCarrera(materia.getCarrera());
            }
        }
    }

    /**
     * Busca un objeto
     *
     * @param codigoMateria Objeto con atributos modificados
     * @return Objeto
     */
    public static Materia buscarMateria(String codigoMateria) {
        Predicate<Materia> filterCodigo = m -> m.getCodigo().equals(codigoMateria);
        Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
        return materia.orElse(null);
    }


}
