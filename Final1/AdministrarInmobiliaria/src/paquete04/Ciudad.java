package paquete04;

import java.io.Serializable;

public class Ciudad implements Serializable {
    private String nombreCiudad;
    private String nombreProvincia;

    public Ciudad(String nombreCiudad, String nombreProvincia) {
       this.nombreCiudad = nombreCiudad;
       this.nombreProvincia = nombreProvincia;
    }

    public void establecerNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public void establecerNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String obtenerNombreCiudad() {
        return nombreCiudad;
    }

    public String obtenerNombreProvincia() {
        return nombreProvincia;
    }
    
     @Override
    public String toString() {
        return String.format("%s - %s", 
                obtenerNombreCiudad(), obtenerNombreProvincia());
    }
}
