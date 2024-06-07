package paquete07;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete03.Barrio;
import paquete05.AppendingObjectInputStream;

public class LecturaBarrio {
    
    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrios;
    private String nombreArchivo;

    public LecturaBarrio(String n) {
        nombreArchivo = n;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try {
                entrada = new AppendingObjectInputStream(new FileInputStream(n));
            } catch (IOException io) {
                System.out.println("Error al abrir el archivo: " + io.getMessage());
            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerBarrio() {
        barrios = new ArrayList<>();
        if (entrada != null) {
            try {
                while (true) {
                    try {
                        Barrio ba = (Barrio) entrada.readObject();
                        barrios.add(ba);
                    } catch (EOFException e) {
                        break; // Salir del bucle al llegar al final del archivo
                    } catch (ClassNotFoundException e) {
                        System.out.println("Clase no encontrada: " + e);
                        break; // Salir del bucle si la clase no se encuentra
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe o no se pudo abrir.");
        }
    }

    public ArrayList<Barrio> obtenerBarrio() {
        return barrios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder("Lista de Barrios\n");
        for (int i = 0; i < barrios.size(); i++) {
            Barrio barri = barrios.get(i);
            cadena.append("(").append(i + 1).append(") ")
                  .append(barri.obtenerNombreBarrio()).append(" - ")
                  .append(barri.obtenerReferencia()).append("\n");
        }
        return cadena.toString();
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException io) {
            System.out.println("Error al cerrar el archivo: " + io.getMessage());
        }
    }
}

