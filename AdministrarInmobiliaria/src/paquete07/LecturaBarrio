package paquete07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete03.Barrio;
import paquete05.AppendingObjectInputStream;

public class LecturaBarrio {
    
    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrio;
    private String nombreArchivo;

    public LecturaBarrio(String n) {
        nombreArchivo = n;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try{
                entrada = new AppendingObjectInputStream(new FileInputStream(n));
            }
            catch (IOException io) {
                System.out.println("Error al abrir el archivo" + io);
            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerBarrio() {
        barrio = new ArrayList<>();
        File file = new File(obtenerNombreArchivo());
        if (file.exists()) {
            while (true) {
                try {
                    Barrio ba = (Barrio) entrada.readObject();
                    barrio.add(ba);
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e);
                } catch (Exception e) {
                    System.out.println("No hay datos en el archivo: " + e);
                }
            }
        }
    }

    public ArrayList<Barrio> obtenerBarrio() {
        return barrio;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Propietarios\n";
        for (int i = 0; i < obtenerBarrio().size(); i++) {
            Barrio barri = obtenerBarrio().get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    barri.obtenerNombreBarrio(),
                    barri.obtenerReferencia());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException io) {
            System.out.println("Error");
        }
    }
}
