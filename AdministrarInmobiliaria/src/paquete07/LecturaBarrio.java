package paquete07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete05.AppendingObjectInputStream;
import paquete06.Casa;
/**
 *
 * @author jeani
 */
public class LecturaCasa {
    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivo;

    public LecturaCasa(String n) {
        nombreArchivo = n;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try {
                entrada = new AppendingObjectInputStream(new FileInputStream(n));
            } catch (IOException io) {
                System.out.println("Error al abrir el archivo" + io);
            } 
        }
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerCasa() {
        casas = new ArrayList<>();
        File file = new File(obtenerNombreArchivo());
        if (file.exists() && entrada != null) {
            while (true) {
                try {
                    Casa ca = (Casa) entrada.readObject();
                    casas.add(ca);
                } catch (IOException e) {
                    System.out.println(" Error al leer el archivo: " + e);
                } catch (Exception e) {
                    System.out.println(" No hay datos en el archivo: " + e);
                }
            }
        }
    }

    public ArrayList<Casa> obtenerCasa() {
        return casas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de casas \n";
        for (int i = 0; i < obtenerCasa().size(); i++) {
            Casa c = obtenerCasa().get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena, i + 1,
                    c.obtenerPropietario(),
                    c.obtenerPrecioMetroCuadrado(),c.obtenerNumeroMetrosCuadrado(),c.obtenerCostoFinal(),
                    c.obtenerCiudad(),c.ObtenerNumeroCuartos());
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
