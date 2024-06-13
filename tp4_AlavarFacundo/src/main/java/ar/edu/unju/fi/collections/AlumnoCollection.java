package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Alumno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class AlumnoCollection {
	private static List<Alumno> alumnos = new ArrayList<>();
	
    /**
     * Se trabaja sobre la clase alumnos
     * Devuelve un arrayList de objetos 
     *
     * @return Objeto alumno
     */
    public static List<Alumno> getAlumnos() {
        if (alumnos.isEmpty()) {
            alumnos.add(new Alumno("40710341", "Facundo", "Alavar", "facundo@gmail.com", "3884123456",
                    LocalDate.of(1996, 7, 22), "Tanco 588", "APU4491"));
            alumnos.add(new Alumno("40111111", "Nicolas", "Alvarez", "nicolas@gmail.com", "3884123456",
                    LocalDate.of(1996, 7, 23), "Bustamante 123", "APU222"));
            alumnos.add(new Alumno("40347047", "Mike", "Shinoda", "mike@gmail.com", "3884123456",
                    LocalDate.of(1998, 7, 24), "Perovic", "APU1111"));
        }
        return alumnos;
    }

    /**
     * Se agrega un objeto 
     *
     * @param alumno Objeto
     */
    public static void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    /**
     * Se elimina un objeto 
     *
     * @param dni Objeto con atributos modificados
     */
    public static void eliminarAlumno(String dni) {
        alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
    }

    /**
     * Se modifica un objeto en el arrayList
     *
     * @param alumno Objeto 
     */
    public static void modificarAlumno(Alumno alumno) {
        for (Alumno a : alumnos) {
            if (a.getDni().equals(alumno.getDni())) {
                a.setNombre(alumno.getNombre());
                a.setApellido(alumno.getApellido());
                a.setEmail(alumno.getEmail());
                a.setTelefono(alumno.getTelefono());
                a.setFechaNacimiento(alumno.getFechaNacimiento());
                a.setDomicilio(alumno.getDomicilio());
                a.setLu(alumno.getLu());
            }
        }
    }

    /**
     * Busca un objeto de la clase Alumno en el arrayList
     *
     * @param dni Objeto de la clase Alumno
     * @return Objeto de la clase Alumno
     */
    public static Alumno buscarAlumno(String dni) {
        Predicate<Alumno> filterCodigo = alumno -> alumno.getDni().equals(dni);
        Optional<Alumno> alumno = alumnos.stream().filter(filterCodigo).findFirst();
        return alumno.orElse(null);
    }
}
