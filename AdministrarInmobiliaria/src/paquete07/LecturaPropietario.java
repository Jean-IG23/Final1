package paquete07;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete02.Propietario;

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
                System.out.println("Error al abrir el archivo: " + io);
            }
        }
    }

    public void establecerNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void establecerPropietario() {
        propietario = new ArrayList<>();
        File file = new File(obtenerNombreArchivo());
        if (file.exists() && entrada != null) {
            try {
                while (true) {
                    try {
                        Propietario pro = (Propietario) entrada.readObject();
                        propietario.add(pro);
                    } catch (EOFException e) {
                        break;
                    } catch (ClassNotFoundException e) {
                        System.out.println("Clase no encontrada: " + e);
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e);
            }
        } else {
            
            System.out.println("El archivo no existe o no se pudo abrir.");
        }
    }

    public void establecerIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public void establecerPropietarioBuscar() {
        File file = new File(obtenerNombreArchivo());
        if (file.exists() && entrada != null) {
            try {
                while (true) {
                    try {
                        Propietario pro = (Propietario) entrada.readObject();
                        if (pro.obtenerIdentificacion().equals(identificacion)) {
                            propietarioBuscar = pro;
                            break;
                        }
                    } catch (EOFException e) {
                        break; // Fin del archivo
                    } catch (ClassNotFoundException e) {
                        System.out.println("Clase no encontrada: " + e);
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e);
            }
        } else {
            System.out.println("El archivo no existe o no se pudo abrir.");
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
            System.out.println("Error al cerrar el archivo: " + io);
        }
    }

    public static void LeerPropietarios(String nombreArchivo) {
        LecturaPropietario lec = new LecturaPropietario(nombreArchivo);
        lec.establecerPropietario();
        ArrayList<Propietario> pro = lec.obtenerPropietario();

        System.out.println("Propietarios registrados:");
        for (Propietario propietario : pro) {
            System.out.println("Nombre: " + propietario.obtenerNombres() + 
                               " \nApellido: " + propietario.obtenerApellidos() + 
                               " \nIdentificación: " + propietario.obtenerIdentificacion());
        }
        lec.cerrarArchivo();
    }
}
