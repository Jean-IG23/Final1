package paquete03;

import java.io.Serializable;

public class Barrio implements Serializable{
    private String nombreBarrio;
    private String referencia;

    public Barrio(){

    }

    public Barrio(String nombreBarrio, String referencia) {
        this.nombreBarrio = nombreBarrio;
        this.referencia = referencia;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setNombreBarrio(String nombreBarrio) {

        this.nombreBarrio = nombreBarrio;
    }

    public void setReferencia(String referencia) {

        this.referencia = referencia;
    }
}
