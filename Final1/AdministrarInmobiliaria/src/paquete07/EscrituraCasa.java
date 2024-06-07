package paquete07;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import paquete05.AppendingObjectOutputStream;
import paquete06.Casa;

public class EscrituraCasa {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa casa;
    
    public EscrituraCasa(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerCasa(Casa casa) {
        this.casa = casa;
    }

    public void establecerSalida() {
        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            } else {
                salida = new AppendingObjectOutputStream(new FileOutputStream(nombreArchivo, true));
            }
            salida.writeObject(casa);
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo: " + ex.getMessage());
        } finally {
            cerrarArchivo();
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
            System.out.println("Error al cerrar el archivo: " + ioException.getMessage());
        } 
    }
}
