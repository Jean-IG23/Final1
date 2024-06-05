package paquete02;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

public class Propietario implements Serializable{
    private String nombres;
    private String apellidos;
    private String identificacion;

    public Propietario(){

    }

    public Propietario(String nombres, String apellidos, String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public String getNombres() {

        return nombres;
    }

    public String getApellidos() {

        return apellidos;
    }

    public String getIdentificacion() {

        return identificacion;
    }

    public void setNombres(String nombres) {

        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;
    }

    public void setIdentificacion(String identificacion) {

        this.identificacion = identificacion;
    }
}

