package paquete07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete02.Propietario;

/**
 *
 * @author jeani
 */
public class LecturaPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietario;
    private String nombreArchivo;
    private String identificacion;
    private Propietario propietarioBuscar;

    public LecturaPropietario(String n) {
        nombreArchivo = n;
        File file = new File(nombreArchivo);
        if (file.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(n));
            } catch (IOException io) {
                System.out.println("Error al abrir el archivo" + io);
            }
        }
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerPropietario() {
        propietario = new ArrayList<>();
        File file = new File(obtenerNombreArchivo());
        if (file.exists()) {
            while (true) {
                try {
                    Propietario pro = (Propietario) entrada.readObject();
                    propietario.add(pro);
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e);
                } catch (Exception e) {
                    System.out.println("No hay datos en el archivo: " + e);
                }
            }
        }
    }

    public void establecerIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public void establecerPropietarioBuscar() {
        File file = new File(obtenerNombreArchivo());
        if (file.exists()) {
            while (true) {
                try {
                    Propietario pro = (Propietario) entrada.readObject();
                    if (pro.obtenerIdentificacion().equals(identificacion)) {
                        propietarioBuscar = pro;
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e);
                } catch (Exception e) {
                    System.out.println("No hay datos en el archivo: " + e);
                }
            }
        }
    }
    
    public ArrayList<Propietario> obtenerPropietario() {
        return propietario;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    public Propietario obtenerPropietarioBuscar() {
        return propietarioBuscar;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Propietarios\n";
        for (int i = 0; i < obtenerPropietario().size(); i++) {
            Propietario p = obtenerPropietario().get(i);
            cadena = String.format("%s(%d) %s-%s-%s\n", cadena,
                    i + 1,
                    p.obtenerNombres(),
                    p.obtenerApellidos(),
                    p.obtenerIdentificacion());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException io) {
            System.out.println("Error.");
        }
    }
}
