package com.platinum.DTO;

public class Ejecutivo {
    private String rutEjecutivo;
    private String nombre;
    private String departamento;

    public Ejecutivo(String rutEjecutivo, String nombre, String departamento) {
        this.rutEjecutivo = rutEjecutivo;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public String getRutEjecutivo() {
        return rutEjecutivo;
    }

    public void setRutEjecutivo(String rutEjecutivo) {
        this.rutEjecutivo = rutEjecutivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Ejecutivo{" +
               "rutEjecutivo='" + rutEjecutivo + '\'' +
               ", nombre='" + nombre + '\'' +
               ", departamento='" + departamento + '\'' +
               '}';
    }
}
