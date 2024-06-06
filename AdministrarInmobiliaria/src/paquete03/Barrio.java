package paquete03;

import java.io.Serializable;

public class Barrio implements Serializable {
    private String nombreBarrio;
    private String referencia;

    public Barrio(String nombreBarrio, String referencia) {
        this.nombreBarrio = nombreBarrio;
        this.referencia = referencia;
    }

    public void establecerNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public void establecerReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String obtenerNombreBarrio() {
        return nombreBarrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }
    
     @Override
    public String toString() {
        return String.format("%s - %s", 
                obtenerNombreBarrio(), obtenerReferencia());
    }
}
