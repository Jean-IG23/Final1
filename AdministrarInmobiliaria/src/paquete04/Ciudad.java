package paquete04;

import java.io.Serializable;

public class Ciudad implements Serializable{
    private String nombreCiudad;
    private String nombreProvincia;

    public Ciudad(){

    }

    public Ciudad(String nombreCiudad, String nombreProvincia) {
        this.nombreCiudad = nombreCiudad;
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreCiudad() {

        return nombreCiudad;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreCiudad(String nombreCiudad) {

        this.nombreCiudad = nombreCiudad;
    }

    public void setNombreProvincia(String nombreProvincia) {

        this.nombreProvincia = nombreProvincia;
    }
}
