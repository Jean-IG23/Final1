package paquete07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import paquete05.AppendingObjectOutputStream;
import paquete03.Barrio;

public class EscrituraBarrio {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio barrio;
    
    public EscrituraBarrio(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerBarrio( Barrio b) {
        barrio = b;
    }

    public void establecerSalida() {
        File file = new File(nombreArchivo);
        try {
                        if (file.exists() && file.length() > 0) {
                salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo, true));
            } else {
                salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            }
                salida.writeObject(barrio); 
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
        try{
            if (salida != null) {
                salida.close();
            }
        }
        catch (IOException ioException) {
            System.out.println("Error");
        }
    }
}
