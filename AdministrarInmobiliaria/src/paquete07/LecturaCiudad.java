package paquete07;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete04.Ciudad;
import paquete05.AppendingObjectInputStream;

/**
 *
 * @author jeani
 */
public class LecturaCiudad {
    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudad;
    private String nombreArchivo;

    public LecturaCiudad(String n) {
        nombreArchivo = n;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try {
                entrada = new AppendingObjectInputStream(new FileInputStream(n));
            } catch (IOException io) {
                System.out.println(" Error al abrir el archivo" + io);
            }
        }
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerCiudad() {
        ciudad = new ArrayList<>();
        File file = new File(obtenerNombreArchivo());
        if (file.exists() && entrada != null) {

            while (true) {
                try {
                    Ciudad ciu = (Ciudad) entrada.readObject();
                    ciudad.add(ciu);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException e) {
                    System.out.println(" Error al leer el archivo: " + e);
                } catch (Exception e) {
                    System.out.println(" No hay datos en el archivo: " + e);
                }
            }
        }
    }

    public ArrayList<Ciudad> obtenerCiudad() {
        return ciudad;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de ciudades\n";
        for (int i = 0; i < obtenerCiudad().size(); i++) {
            Ciudad c = obtenerCiudad().get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena, i + 1,
                    c.obtenerNombreCiudad(),
                    c.obtenerNombreProvincia());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error");
        } 
    } 
}
