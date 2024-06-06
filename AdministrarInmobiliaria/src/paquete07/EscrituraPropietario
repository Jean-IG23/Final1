package paquete07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import paquete02.Propietario;
import paquete05.AppendingObjectOutputStream;

/**
 *
 * @author jeani
 */
public class EscrituraPropietario {

    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Propietario propietario;

    public EscrituraPropietario(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerNombreArchivo(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void establecerSalida() {        
        File file = new File(nombreArchivo);
        try {
            if (file.exists()) {
                salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            } else {
                salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo, true));
            }
            salida.writeObject(propietario);
            salida.close();
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo");
        }
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }

    public ObjectOutputStream obtenerSalida(){
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
