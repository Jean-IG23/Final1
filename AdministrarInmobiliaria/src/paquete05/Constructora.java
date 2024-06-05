package paquete05;

import java.io.Serializable;

public class Constructora implements Serializable{
    private String nombreConstructora;
    private String idEmpresa;

    public Constructora(){

    }
    public Constructora(String nombreConstructora, String idEmpresa) {
        this.nombreConstructora = nombreConstructora;
        this.idEmpresa = idEmpresa;
    }

    public String getNombreConstructora() {
        return nombreConstructora;
    }

    public void setNombreConstructora(String nombreConstructora) {
        this.nombreConstructora = nombreConstructora;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
