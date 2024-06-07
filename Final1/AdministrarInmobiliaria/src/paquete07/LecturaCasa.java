package paquete07;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete05.AppendingObjectInputStream;
import paquete06.Casa;

public class LecturaCasa {
    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivo;

    public LecturaCasa(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
            } catch (IOException io) {
                System.out.println("Error al abrir el archivo: " + io.getMessage());
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerCasas() {
        casas = new ArrayList<>();
        if (entrada != null) {
            try {
                while (true) {
                    try {
                        Casa casa = (Casa) entrada.readObject();
                        casas.add(casa);
                    } catch (EOFException e) {
                        break; // Salir del bucle al llegar al final del archivo
                    } catch (ClassNotFoundException e) {
                        System.out.println("Clase no encontrada: " + e);
                        break; // Salir del bucle si la clase no se encuentra
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            } finally {
                cerrarArchivo();
            }
        }
    }

    public ArrayList<Casa> obtenerCasas() {
        return casas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder("Lista de casas:\n");
        for (int i = 0; i < casas.size(); i++) {
            Casa casa = casas.get(i);
            cadena.append("(").append(i + 1).append(") ")
                  .append("Propietario: ").append(casa.obtenerPropietario()).append(", ")
                  .append("Precio por metro cuadrado: ").append(casa.obtenerPrecioMetroCuadrado()).append(", ")
                  .append("Número de metros cuadrados: ").append(casa.obtenerNumeroMetrosCuadrado()).append(", ")
                  .append("Costo final: ").append(casa.obtenerCostoFinal()).append(", ")
                  .append("Ciudad: ").append(casa.obtenerCiudad()).append(", ")
                  .append("Número de cuartos: ").append(casa.ObtenerNumeroCuartos())
                  .append("\n");
        }
        return cadena.toString();
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo: " + ioException.getMessage());
        }
    }
}

