package ar.edu.unju.fi.model;

public class Materia {
    private String codigo;
    private String nombre;
    private int curso;
    private int cantidadHoras;
    private String modalidad;
    private String docente;
    private String carrera;

    // Constructor
    public Materia(String codigo, String nombre, int curso, int cantidadHoras, String modalidad, String docente, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.curso = curso;
        this.cantidadHoras = cantidadHoras;
        this.modalidad = modalidad;
        this.docente = docente;
        this.carrera = carrera;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
