package paquete07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import paquete04.Ciudad;
import paquete05.AppendingObjectOutputStream;

/**
 *
 * @author jeani
 */
public class EscrituraCiudad {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Ciudad ciudad;
    
    
    
    public EscrituraCiudad (String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerCiudad( Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void establecerSalida() {
        File file = new File(nombreArchivo);
        try {
            if (file.exists() == false) {
                salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo));
            }
            salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo, true));
            salida.writeObject(ciudad);
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
