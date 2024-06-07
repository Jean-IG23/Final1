package paquete07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete05.AppendingObjectInputStream;
import paquete06.Departamento;

/**
 *
 * @author jeani
 */
public class LecturaDepartamento {
        private ObjectInputStream entrada;
    private ArrayList<Departamento> departamento;
    private String nombreArchivo;

    public LecturaDepartamento(String n) {
        nombreArchivo = n;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try {
                entrada = new AppendingObjectInputStream(new FileInputStream(n));
            }
            catch (IOException io) {
                System.out.println("Error al abrir el archivo." + io);
            }
        }
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerDepa() {
        departamento = new ArrayList<>();
        File file = new File(obtenerNombreArchivo());
        if (file.exists() && entrada != null) {
            while (true) {
                try {
                    Departamento dep = (Departamento) entrada.readObject();
                    departamento.add(dep);
                } catch (IOException e) {
                    System.out.println(" Error al leer el archivo: " + e);
                } catch (Exception e) {
                    System.out.println(" No hay datos en el archivo: " + e);
                }
            }
        }
    }

    public ArrayList<Departamento> obtenerDepartamento() {
        return departamento;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Departamentos\n";
        for (int i = 0; i < obtenerDepartamento().size(); i++) {
            Departamento d = obtenerDepartamento().get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    d.obtenerPropietario(),d.obtenerPrecioMetroCuadrado(),d.obtenerNumeroMetrosCuadrado(),
                    d.obtenerValorMensual(),d.obtenerCostoFinal(),d.obtenerBarrio(),
                    d.obtenerUbicacionDepartamento());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } 
        catch (IOException ioException) {
            System.out.println("Error");
        }
    } 
}
