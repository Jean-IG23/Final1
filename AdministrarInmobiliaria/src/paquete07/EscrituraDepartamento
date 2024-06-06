package paquete07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import paquete05.AppendingObjectOutputStream;
import paquete06.Departamento;

/**
 *
 * @author jeani
 */
public class EscrituraDepartamento {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento departamento;
    
    public EscrituraDepartamento(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void establecerSalida() {
        File file = new File(nombreArchivo);
        try {
            if (file.exists() == false) {
                salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo));
            }
            salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo, true));
            salida.writeObject(departamento); 
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
    



