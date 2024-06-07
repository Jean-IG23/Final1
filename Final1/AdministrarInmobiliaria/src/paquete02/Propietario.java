package paquete02;

import java.io.Serializable;

public class Propietario implements Serializable {

    private String nombres;
    private String apellidos;
    private String identificacion;

    public Propietario(String nombres, String apellidos, String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public void establecerNombres(String nombres) {
        this.nombres = nombres;
    }

    public void establecerApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void establecerIdeentificaion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerApellidos() {
        return apellidos;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", 
                obtenerNombres(), obtenerApellidos(), obtenerIdentificacion());
    }
}


