package paquete07;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete06.Departamento;

public class LecturaDepartamento {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivo;

    public LecturaDepartamento(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
            } catch (IOException io) {
                System.out.println("Error al abrir el archivo: " + io.getMessage());
            }
        }
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerDepartamentos() {
        departamentos = new ArrayList<>();
        File file = new File(nombreArchivo);
        if (file.exists() && entrada != null) {
            try {
                while (true) {
                    try {
                        Departamento dep = (Departamento) entrada.readObject();
                        departamentos.add(dep);
                    } catch (EOFException e) {
                        break; // Se alcanzó el final del archivo
                    } catch (ClassNotFoundException e) {
                        System.out.println("Error: Clase no encontrada al leer el archivo.");
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe o no se pudo abrir.");
        }
    }

    public ArrayList<Departamento> obtenerDepartamentos() {
        return departamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder("Lista de Departamentos\n");
        for (int i = 0; i < departamentos.size(); i++) {
            Departamento d = departamentos.get(i);
            cadena.append("(").append(i + 1).append(") ")
                  .append(d.obtenerPropietario()).append(" - ")
                  .append(d.obtenerPrecioMetroCuadrado()).append(" - ")
                  .append(d.obtenerNumeroMetrosCuadrado()).append(" - ")
                  .append(d.obtenerValorMensual()).append(" - ")
                  .append(d.obtenerCostoFinal()).append(" - ")
                  .append(d.obtenerBarrio()).append(" - ")
                  .append(d.obtenerUbicacionDepartamento()).append("\n");
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
