package paquete01;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;
import paquete07.Inmobiliaria;
import java.util.Scanner;

public class Ejecutor {
    private static Scanner sc = new Scanner(System.in);
    private static Inmobiliaria inmobiliaria = new Inmobiliaria();

    public static void main(String[] args)  {

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
            System.out.println("7. Agregar constructora");
            System.out.println("8. Ver Lista de constructoras");
            System.out.println("9. Agregar casa");
            System.out.println("10. Ver Lista de casas");
            System.out.println("11. Agregar departamento");
            System.out.println("12. Ver Lista de departamentos");
            System.out.println("0. Salir");
            System.out.println("-------------------------------------------------");

            System.out.print("Ingrese la opción deseada: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    ListaPropietario();
                    break;
                case 2:
                    inmobiliaria.escribirPropietario();
                    break;
                case 3:
                    ListaBarrio();
                    break;
                case 4:
                    inmobiliaria.escribirBarrios();
                    break;
                case 5:
                    ListaCiudad();
                    break;
                case 6:
                    inmobiliaria.escribirCiudad();
                    break;
                case 7:
                    ListaConstructora();
                    break;
                case 8:
                    inmobiliaria.escribirConstructora();
                    break;
                case 9:
                    ListaCasa();
                    break;
                case 10:
                    inmobiliaria.escribirCasa();
                    break;
                case 11:
                    ListaDepartamento();
                    break;
                case 12:
                    inmobiliaria.escribirDepartamento();
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }
    private static void ListaPropietario() {
        System.out.println("________Agregar Propietario________");
        System.out.print("Ingrese el nombre del propietario: ");
        String nombre = sc.next();
        System.out.print("Ingrese el apellido del propietario: ");
        String apellido = sc.next();
        System.out.print("Ingrese la identificación del propietario: ");
        String identificacion = sc.next();

        Propietario propietario = new Propietario(nombre, apellido, identificacion);
        inmobiliaria.ListaPropietarios(propietario);
        inmobiliaria.ArchivoPropietarios();

        System.out.println("Propietario agregado exitosamente.");
    }

    private static void ListaBarrio() {
        System.out.println("________Agregar Barrio________");
        System.out.print("Ingrese el nombre del barrio: ");
        String nombre = sc.next();

        System.out.print("Ingrese la referencia del barrio: ");
        String referencia = sc.next();

        Barrio barrio = new Barrio(nombre, referencia);
        inmobiliaria.ListaBarrio(barrio);
        inmobiliaria.ArchivoBarrio();

        System.out.print("Barrio agregado exitosamente.");
    }

    private static void ListaCiudad() {
        System.out.println("_______Agregar Ciudad________");
        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = sc.next();
        System.out.print("Ingrese el nombre de la provincia: ");
        String nombreProvincia = sc.next();

        Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia);
        inmobiliaria.ListaCiudad(ciudad);
        inmobiliaria.ArchivoCiudad();

        System.out.println("Ciudad agregada exitosamente.");
    }

    private static void ListaConstructora() {
        System.out.println("________Agregar Constructora________");
        System.out.print("Ingrese el nombre de la constructora: ");
        String nombre = sc.next();
        System.out.print("Ingrese el ID de la empresa: ");
        String idEmpresa = sc.next();

        Constructora constructora = new Constructora(nombre, idEmpresa);
        inmobiliaria.ListaConstructora(constructora);
        inmobiliaria.ArchivoConstructora();

        System.out.println("Constructora agregada exitosamente.");
    }

        private static void ListaCasa() {
        System.out.println("________Agregar Casa________");
        System.out.print("Ingrese el nombre del propietario: ");
        String Nombre = sc.next();
        System.out.print("Igrese el apellido del propietario: ");
        String apellido = sc.next();
        System.out.print("Ingrese la identificación del propietario: ");
        String identificacionPropietario = sc.next();
        System.out.print("Ingrese el precio por metro cuadrado: ");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.print("Ingrese el número de metros cuadrados: ");
        double metrosCuadrados = sc.nextDouble();
        System.out.print("Ingrese el nombre del barrio: ");
        String nombreBarrio = sc.next();
        System.out.print("Ingrese la referencia del barrio: ");
        String referencia = sc.next();
        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = sc.next();
        System.out.print("Ingrese el nombre de la provincia: ");
        String nombreProvincia = sc.next();
        System.out.print("Ingrese el nombre de la constructora: ");
        String nombre = sc.next();
        System.out.print("Ingrese el ID de la empresa constructora: ");
        String idEmpresaConstructora = sc.next();
        System.out.print("Ingrese el número de cuartos: ");
        int numeroCuartos = sc.nextInt();
        double CostoFinal = metrosCuadrados * precioMetroCuadrado;

        Casa casa = new Casa(Nombre,apellido,identificacionPropietario, nombreBarrio,referencia, nombreCiudad,nombreProvincia,nombre, idEmpresaConstructora,metrosCuadrados, precioMetroCuadrado, numeroCuartos,CostoFinal);
        inmobiliaria.ListaCasa(casa);
        inmobiliaria.ArchivoCasa();

        System.out.println("Casa agregada exitosamente.");
    }

    private static void ListaDepartamento() {
        System.out.println("________Agregar Departamento________");
        System.out.print("Ingrese el nombre del propietario: ");
        String Nombre = sc.next();
        System.out.print("Igrese el apellido del propietario: ");
        String apellido = sc.next();
        System.out.print("Ingrese la identificación del propietario: ");
        String identificacionPropietario = sc.next();
        System.out.print("Ingrese el precio por metro cuadrado: ");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.print("Ingrese el número de metros cuadrados: ");
        double metrosCuadrados = sc.nextDouble();
        System.out.print("Ingrese el valor de la alícuota mensual: ");
        double valorAlicuotaMensual = sc.nextDouble();
        System.out.print("Ingrese el nombre del barrio: ");
        String nombreBarrio = sc.next();
        System.out.print("Ingrese la referencia del barrio: ");
        String referencia = sc.next();
        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = sc.next();
        System.out.print("Ingrese el nombre de la provincia: ");
        String nombreProvincia = sc.next();
        System.out.print("Ingrese el nombre del edificio: ");
        String edificio = sc.next();
        System.out.print("Ingrese el nombre de la constructora: ");
        String nombre = sc.next();
        System.out.print("Ingrese el ID de la empresa constructora: ");
        String idEmpresaConstructora = sc.next();
        double CostoFinal = (metrosCuadrados * precioMetroCuadrado) + (valorAlicuotaMensual * 12);

        Departamento departamento = new Departamento(Nombre,apellido,identificacionPropietario, nombreBarrio,referencia, nombreCiudad,nombreProvincia,edificio,
                idEmpresaConstructora, metrosCuadrados, precioMetroCuadrado,nombre, valorAlicuotaMensual,CostoFinal);
        inmobiliaria.ListaDepartamento(departamento);
        inmobiliaria.ArchivoDepartamento();

        System.out.println("Departamento agregado exitosamente.");
    }
}
