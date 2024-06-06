
import java.util.ArrayList;
import java.util.Scanner;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete06.Casa;

import paquete07.EscrituraBarrio;
import paquete07.EscrituraCasa;
import paquete07.EscrituraCiudad;
import paquete07.EscrituraPropietario;
import paquete07.LecturaBarrio;
import paquete07.LecturaCasa;
import paquete07.LecturaCiudad;
import paquete07.LecturaPropietario;

public class Ejecutor {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String cadenaPro = "lospropietarios.dat";
        String cadenaBa = "losbarrios.dat";
        String cadenaCiu = "lasciudades.dat";
        String cadenaCa = "miscasas.dat";
        String cadenaDepar = "losdepartamentos.dat";
        
        boolean b = true;
        while (b) {
            System.out.println("----------------------------------------------");
            System.out.println("____Sistema de Gestión de Inmobiliaria____");
            System.out.println("1. Agregar propietario");
            System.out.println("2. Ver Lista de propietarios");
            System.out.println("3. Agregar barrio");
            System.out.println("4. Ver Lista de barrios");
            System.out.println("5. Agregar ciudad");
            System.out.println("6. Ver Lista de ciudades");
            System.out.println("7. Agregar casa");
            System.out.println("8. Ver Lista de casas");
            System.out.println("9. Agregar departamento");
            System.out.println("10. Ver Lista de departamentos");
            System.out.println("0. Salir");
            System.out.println("-------------------------------------------------");

            System.out.print("Ingrese la opción deseada: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    ListaPropietario(cadenaPro);
                    break;
                case 2:
                    LeerPropietarios(cadenaPro);
                    break;
                case 3:
                    ListaBarrio(cadenaBa);
                    break;
                case 4:
                    LeerBarrio(cadenaBa);
                    break;
                case 5:
                    ListaCiudad(cadenaCiu);
                    break;
                case 6:
                    LeerCiudad(cadenaCiu);
                    break;
                case 7:
                    ListaCasa(cadenaCa, cadenaPro, cadenaCiu);
                    break;
                case 8:
                    LeerCasa(cadenaCa);
                    break;
                case 9:
                    
                    break;
                case 10:
               
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    public static void ListaPropietario(String archi) {
        System.out.println("________Agregar Propietario________");
        System.out.print("Ingrese el nombre del propietario: ");
        String nombre = sc.next();
        System.out.print("Ingrese el apellido del propietario: ");
        String apellido = sc.next();
        System.out.print("Ingrese la identificación del propietario: ");
        String identificacion = sc.next();

        Propietario propietario = new Propietario(nombre, apellido, identificacion);

        EscrituraPropietario escritura = new EscrituraPropietario(archi);
        escritura.establecerPropietario(propietario);
        escritura.establecerSalida();
    }

    public static void LeerPropietarios(String nombreArchivo) {
        LecturaPropietario lec = new LecturaPropietario(nombreArchivo);
        lec.establecerPropietario();
        ArrayList<Propietario> pro = lec.obtenerPropietario();

        System.out.println("Propietario registrado:");
            for (Propietario propietario : pro) {
                System.out.println("Nombre: " + propietario.obtenerNombres() + " \nApellido: " + propietario.obtenerApellidos() + " \nIdentificación: " 
                        + propietario.obtenerIdentificacion());
            }
    }

    public static void ListaBarrio(String archi) {
        System.out.println("________Agregar Barrio________");
        System.out.print("Ingrese el nombre del barrio: ");
        String nombre = sc.next();

        System.out.print("Ingrese la referencia del barrio: ");
        String referencia = sc.next();

        Barrio barrio = new Barrio(nombre, referencia);

        EscrituraBarrio escrituraBarrio = new EscrituraBarrio(archi);
        escrituraBarrio.establecerBarrio(barrio);
        escrituraBarrio.establecerSalida();
    }

    public static void LeerBarrio(String archi) {
        LecturaBarrio lec = new LecturaBarrio(archi);
        lec.establecerBarrio();
        ArrayList<Barrio> barrios = lec.obtenerBarrio();

            System.out.println("Barrio registrado:");
                for (Barrio barrio : barrios) {
                    System.out.println("Nombre del Barrio: " + barrio.obtenerNombreBarrio() + "\nReferencia: " 
                            + barrio.obtenerReferencia());
 
    }
                
     public static void ListaCiudad(String archi) {
        System.out.println("_______Agregar Ciudad________");
        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = sc.next();
        System.out.print("Ingrese el nombre de la provincia: ");
        String nombreProvincia = sc.next();

        Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia);           

        EscrituraCiudad escritura = new EscrituraCiudad(archi);
        escritura.establecerCiudad(ciudad);
        escritura.establecerSalida();
    }

    public static void LeerCiudad(String Archi) {
        LecturaCiudad lectura = new LecturaCiudad(Archi);
        lectura.establecerCiudad();
        ArrayList<Ciudad> ciudades = lectura.obtenerCiudad();

            System.out.println("Ciudade registrada:");
                for (Ciudad ciudad : ciudades) {
                    System.out.println("Nombre de la ciudad: " + ciudad.obtenerNombreCiudad() + "\nNombre de la Provincia: " 
                            + ciudad.obtenerNombreProvincia());
                }
    }

    public static void ListaCasa(String Archi, String archivoPro, String archivoCiu) {
        System.out.print("Ingrese identificación del propietario: ");
        String identificacion = sc.nextLine();

        LecturaPropietario lecturaPropietario = new LecturaPropietario(archivoPro);
        lecturaPropietario.establecerPropietario();
        Propietario propietario;
        
        for (Propietario p : lecturaPropietario.obtenerPropietario()) {
            if (p.obtenerIdentificacion().equals(identificacion)) {
                propietario = p;
                break;
            }
        }
        if (propietario == null) {
            System.out.println("Propietario no encontrado");
        }

        System.out.print("Ingrese nombre de la ciudad: ");
        String nombreCiu = sc.nextLine();

        LecturaCiudad lecturaCiudad = new LecturaCiudad(archivoCiu);
        lecturaCiudad.establecerCiudad();
        Ciudad ciudad ;
        for (Ciudad ciu : lecturaCiudad.obtenerCiudad()) {
            if (ciu.obtenerNombreCiudad().equalsIgnoreCase(nombreCiu)) {
                ciudad = ciu;
                break;
            }
        }
        if (ciudad == null) {
            System.out.println("Ciudad no encontrada.");
            return;
        }

        System.out.print("Ingrese precio por metro cuadrado: ");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.print("Ingrese número de metros cuadrados: ");
        double numeroMetrosCuadrados = sc.nextDouble();

        Casa casa = new Casa(propietario, precioMetroCuadrado, numeroMetrosCuadrados, ciudad, 5);
        casa.calcularCostoFinal();

        EscrituraCasa escrituraCasa = new EscrituraCasa(Archi);
        escrituraCasa.establecerCasas(casa);
        escrituraCasa.establecerSalida();
    }
    
    public static void LeerCasa(String Archi) {
        LecturaCasa lec = new LecturaCasa(Archi);
        lec.establecerCasa();
        ArrayList<Casa> casas = lec.obtenerCasa();

        System.out.println("Presentacion de Lista de Casas:");
                for (Casa casa : casas) {
                    System.out.println("Nombre: " + casa.obtenerPropietario().obtenerNombres() + "\nApellido: " + casa.obtenerPropietario().obtenerApellidos() + "\nIdentificacion: " + casa.getPropietario().getIdentificacion());
                    System.out.println("Precio por metro Cuadrado: " + casa.obtenerPrecioMetroCuadrado());
                    System.out.println("Numero de metros Cuadrados: " + casa.obtenerNumeroMetrosCuadrado());                    
                    System.out.println("Ciudad: " + casa.obtenerCiudad().obtenerNombreCiudad() + "\nProvincia: " + casa.obtenerCiudad().obtenerNombreProvincia());
                    System.out.println("Número de cuartos: " + casa.ObtenerNumeroCuartos());
                    System.out.println("Costo final: " + casa.obtenerCostoFinal());
        }
    }
    
    public static void ListarDepartamento() {
        
    }

        public static void LeerDepartamento() {
        
    }
}

   
