package paquete07;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;

import java.io.*;
import java.util.*;

public class Inmobiliaria {
    private List<Propietario> propietarios;
    private List<Barrio> barrios;
    private List<Ciudad> ciudades;
    private List<Constructora> constructoras;
    private List<Casa> casas;
    private List<Departamento> departamentos;

    public Inmobiliaria() {
        propietarios = new ArrayList<>();
        barrios = new ArrayList<>();
        ciudades = new ArrayList<>();
        constructoras = new ArrayList<>();
        casas = new ArrayList<>();
        departamentos = new ArrayList<>();
    }

    public void ListaPropietarios(Propietario propietario) {
        propietarios.add(propietario);
    }

    public void ListaBarrio(Barrio barrio) {
        barrios.add(barrio);
    }


    public void ListaCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public void ListaConstructora(Constructora constructora) {

        constructoras.add(constructora);
    }

    public void ListaCasa(Casa casa) {
        casas.add(casa);
    }

    public void ListaDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void ArchivoCiudad() {
        try {
            FileOutputStream ArchivoCi = new FileOutputStream("ciudades.dat");
            ObjectOutputStream sc = new ObjectOutputStream(ArchivoCi);
            sc.writeObject(ciudades);
            sc.close();
            ArchivoCi.close();
            System.out.println("Guardado exitoso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ArchivoCasa() {
        try {
            FileOutputStream ArchivoCa = new FileOutputStream("casas.dat");
            ObjectOutputStream sc = new ObjectOutputStream(ArchivoCa);
            sc.writeObject(casas);
            sc.close();
            ArchivoCa.close();
            System.out.println("Guardado exitoso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ArchivoConstructora() {
        try {
            FileOutputStream ArchivoCo = new FileOutputStream("constructoras.dat");
            ObjectOutputStream sc = new ObjectOutputStream(ArchivoCo);
            sc.writeObject(constructoras);
            sc.close();
            ArchivoCo.close();
            System.out.println("SGuardado exitoso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ArchivoBarrio() {
        try {
            FileOutputStream ArchivoBa = new FileOutputStream("barrios.dat");
            ObjectOutputStream sc = new ObjectOutputStream(ArchivoBa);
            sc.writeObject(barrios);
            sc.close();
            ArchivoBa.close();
            System.out.println("Se han guardado los barrios correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ArchivoPropietarios() {
        try {
            FileOutputStream ArchivosPro = new FileOutputStream("propietarios.dat");
            ObjectOutputStream sc = new ObjectOutputStream(ArchivosPro);
            sc.writeObject(propietarios);
            sc.close();
            ArchivosPro.close();
            System.out.println("Guardado exitoso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ArchivoDepartamento() {
        try {
            FileOutputStream ArchivosDe = new FileOutputStream("departamentos.dat");
            ObjectOutputStream sc = new ObjectOutputStream(ArchivosDe);
            sc.writeObject(departamentos);
            sc.close();
            ArchivosDe.close();
            System.out.println("Guardado exitoso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirPropietario() {
        try {
            FileInputStream ArchivoDe = new FileInputStream("propietarios.dat");
            ObjectInputStream sc = new ObjectInputStream(ArchivoDe);
            List<Propietario> propietarios = (List<Propietario>) sc.readObject();
            sc.close();
            ArchivoDe.close();

            System.out.println("Propietario registrado:");
            for (Propietario propietario : propietarios) {
                System.out.println("Nombre: " + propietario.getNombres() + " \nApellido: " + propietario.getApellidos() + " \nIdentificación: " + propietario.getIdentificacion());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
    }
    }

        public void escribirBarrios() {
            try {
                FileInputStream ArchivoBa = new FileInputStream("barrios.dat");
                ObjectInputStream sc = new ObjectInputStream(ArchivoBa);
                List<Barrio> barrios = (List<Barrio>) sc.readObject();
                sc.close();
                ArchivoBa.close();

                System.out.println("Barrio registrado:");
                for (Barrio barrio : barrios) {
                    System.out.println("Nombre del Barrio: " + barrio.getNombreBarrio() + "\nReferencia: " + barrio.getReferencia());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void escribirCiudad() {
            try {
                FileInputStream ArchivoCi = new FileInputStream("ciudades.dat");
                ObjectInputStream sc = new ObjectInputStream(ArchivoCi);
                List<Ciudad> ciudades = (List<Ciudad>) sc.readObject();
                sc.close();
                ArchivoCi.close();

                System.out.println("Ciudade registrada:");
                for (Ciudad ciudad : ciudades) {
                    System.out.println("Nombre de la ciudad: " + ciudad.getNombreCiudad() + "\nNombre de la Provincia: " + ciudad.getNombreProvincia());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void escribirConstructora() {
            try {
                FileInputStream ArchivoCo = new FileInputStream("constructoras.dat");
                ObjectInputStream sc = new ObjectInputStream(ArchivoCo);
                List<Constructora> constructoras = (List<Constructora>) sc.readObject();
                sc.close();
                ArchivoCo.close();

                System.out.println("Constructora registrada:");
                for (Constructora constructora : constructoras) {
                    System.out.println("Nombre de la constructora: " + constructora.getNombreConstructora() + "\nID Empresa: " + constructora.getIdEmpresa());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void escribirCasa() {
            try {
                FileInputStream ArchivoCa = new FileInputStream("casas.dat");
                ObjectInputStream sc = new ObjectInputStream(ArchivoCa);
                List<Casa> casas = (List<Casa>) sc.readObject();
                sc.close();
                ArchivoCa.close();

                System.out.println("Casa registrada:");
                for (Casa casa : casas) {
                    System.out.println("Nombre: " + casa.getPropietario().getNombres() + "\nApellido: " + casa.getPropietario().getApellidos() + "\nIdentificacion: " + casa.getPropietario().getIdentificacion());
                    System.out.println("Precio por metro Cuadrado: " + casa.getPrecioMetroCuadrado());
                    System.out.println("Numero de metros Cuadrados: " + casa.getNumeroMetrosCuadrado());
                    System.out.println("Barrio: " + casa.getBarrio().getNombreBarrio() + "\nReferencia: " + casa.getBarrio().getReferencia());
                    System.out.println("Ciudad: " + casa.getCiudad().getNombreCiudad() + "\nProvincia: " + casa.getCiudad().getNombreProvincia());
                    System.out.println("Número de cuartos: " + casa.getNumeroCuartos());
                    System.out.println("Constructora: " + casa.getCosntructora().getNombreConstructora() + "\nID Empresa: " + casa.getCosntructora().getIdEmpresa());
                    System.out.println("Costo final: " + casa.getCostoFinal());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public void escribirDepartamento(){
            try {
                FileInputStream fileIn = new FileInputStream("departamentos.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                List<Departamento> departamentos = (List<Departamento>) in.readObject();
                in.close();
                fileIn.close();

                System.out.println("Departamento registrado:");
                for (Departamento departamento : departamentos) {
                    System.out.println("Nombre: " + departamento.getPropietario().getNombres() + "\nApellido: " + departamento.getPropietario().getApellidos()+ "\nIdentificacion: " + departamento.getPropietario().getIdentificacion());
                    System.out.println("Barrio: " + departamento.getBarrio().getNombreBarrio() + "\nReferencia: " + departamento.getBarrio().getReferencia());
                    System.out.println("Ciudad: " + departamento.getCiudad().getNombreCiudad() + "\nProvincia: " + departamento.getCiudad().getNombreProvincia());
                    System.out.println("Edificio: " + departamento.getNombreEdificio());
                    System.out.println("Ubicación: " + departamento.getUnicacionDepartamento());
                    System.out.println("Constructora: " + departamento.getConstructora().getNombreConstructora() + "\nID Empresa: " + departamento.getConstructora().getIdEmpresa());
                    System.out.println("Costo final: " + departamento.getCostoFinal());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
}
