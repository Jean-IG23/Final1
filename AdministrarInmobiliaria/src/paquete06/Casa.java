package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

import java.io.Serializable;

public class Casa implements Serializable {
    private Propietario propietario;
    private Barrio barrio;
    private Casa casa;

    private Ciudad ciudad;
    private Constructora cosntructora;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrado;
    private double costoFinal;
    private int numeroCuartos;

    public Casa(String nombre, String apellido, String identificacionPropietario, String nombreBarrio, String nombreCiudad, String idEmpresaConstructora, double metrosCuadrados, double precioMetroCuadrado, int numeroCuartos){
    }

    public Casa(Propietario propietario, Barrio barrio, Casa casa, Constructora cosntructora, double precioMetroCuadrado, double numeroMetrosCuadrado, double costoFinal, int numeroCuartos) {
        this.propietario = propietario;
        this.barrio = barrio;
        this.casa = casa;
        this.cosntructora = cosntructora;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrado = numeroMetrosCuadrado;
        this.costoFinal = costoFinal;
        this.numeroCuartos = numeroCuartos;
    }


    public Propietario getPropietario() {
      return propietario;
    }



    public void setPropietario(Propietario propietario) {

        this.propietario = propietario;
    }

    public Barrio getBarrio() {

        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Constructora getCosntructora() {
        return cosntructora;
    }

    public void setCosntructora(Constructora cosntructora) {
        this.cosntructora = cosntructora;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public void setPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public double getNumeroMetrosCuadrado() {
        return numeroMetrosCuadrado;
    }

    public void setNumeroMetrosCuadrado(double numeroMetrosCuadrado) {
        this.numeroMetrosCuadrado = numeroMetrosCuadrado;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public int getNumeroCuartos() {
        return numeroCuartos;
    }

    public void setNumeroCuartos(int numeroCuartos) {
        this.numeroCuartos = numeroCuartos;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void calcularPrecioFinal1 () {
        this.costoFinal = getNumeroMetrosCuadrado() * getPrecioMetroCuadrado();
    }
}
