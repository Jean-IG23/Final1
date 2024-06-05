package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

import java.io.Serializable;

public class Departamento implements Serializable{
    private Propietario propietario;
    private Barrio barrio;
    private Ciudad ciudad;
    private Constructora constructora;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrado;
    private double valorMensual;
    private double costoFinal;
    private String nombreEdificio;
    private String ubicacionDepartamento;

    public Departamento(String identificacionPropietario, String nombreBarrio, String nombreCiudad, String idEmpresaConstructora, String ciudad, String empresaConstructora, double metrosCuadrados, double precioMetroCuadrado, double valorAlicuotaMensual) {
        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = this.ciudad;
        this.constructora = constructora;
        this.precioMetroCuadrado = this.precioMetroCuadrado;
        this.numeroMetrosCuadrado = numeroMetrosCuadrado;
        this.valorMensual = valorMensual;
        this.costoFinal = costoFinal;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionDepartamento = ubicacionDepartamento;
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    public void setConstructora(Constructora constructora) {
        this.constructora = constructora;
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

    public double getValorMensual() {
        return valorMensual;
    }

    public void setValorMensual(double valorMensual) {
        this.valorMensual = valorMensual;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getUnicacionDepartamento() {
        return ubicacionDepartamento;
    }

    public void setUnicacionDepartamento(String unicacionDepartamento) {
        this.ubicacionDepartamento = unicacionDepartamento;
    }

    public void calcularPrecioFinal () {
        this.costoFinal = getNumeroMetrosCuadrado() * getPrecioMetroCuadrado();
    }
}

