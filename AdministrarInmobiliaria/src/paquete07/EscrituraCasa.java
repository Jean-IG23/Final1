package paquete07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import paquete05.AppendingObjectOutputStream;
import paquete06.Casa;


public class EscrituraCasa{
     private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa casas;
    
    public EscrituraCasa(String nombreArc) {
    this.nombreArchivo = nombreArc; 
    }


    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerCasas( Casa casas) {
        this.casas = casas;
    }

    public void establecerSalida() {
    File f = new File(nombreArchivo);
    try {
        if (!f.exists()) { 
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        } else {
            salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo, true));
        }
        salida.writeObject(casas);
        salida.close();
    } catch (IOException ex) {
        System.out.println("Error al escribir en el archivo");
    }
}
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error");
        } 
    }
}
