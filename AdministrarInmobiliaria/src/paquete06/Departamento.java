package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;

public class Departamento  implements Serializable{
    private Propietario propietario;
    private Barrio barrio;
    
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrado;
    private double valorMensual;
    private double costoFinal;
    private String nombreEdificio;
    private String ubicacionDepartamento;

    public Departamento (Propietario propietario, Barrio barrio, double precioMetroCuadrado, double numeroMetrosCuadrado, double valorMensual, 
            String nombreEdificio, String ubicacionDepartamento) {
        this.propietario = propietario;
        this.barrio = barrio;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrado = numeroMetrosCuadrado;
        this.valorMensual = valorMensual;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionDepartamento = ubicacionDepartamento;
    }

    public void establecerPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void establaecerPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public void establecerNumeroMetrosCuadrado(double numeroMetrosCuadrado) {
        this.numeroMetrosCuadrado = numeroMetrosCuadrado;
    }

    public void establecertValorMensual(double valorMensual) {
        this.valorMensual = valorMensual;
    }

    public void calcularCostoFinal() {
        this.costoFinal = (numeroMetrosCuadrado * precioMetroCuadrado) + (valorMensual * 12) * 5;
    }

    public void establecerBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public void establecerNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public void establecerUbicacionDepartamento(String ubicacionDepartamento) {
        this.ubicacionDepartamento = ubicacionDepartamento;
    }

    public Propietario obtenerPropietario() {
        return propietario;
    }

    public double obtenerPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double obtenerNumeroMetrosCuadrado() {
        return numeroMetrosCuadrado;
    }

    public double obtenerValorMensual() {
        return valorMensual;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public Barrio obtenerBarrio() {
        return barrio;
    }

    public String obtenerNombreEdificio() {
        return nombreEdificio;
    }

    public String obtenerUbicacionDepartamento() {
        return ubicacionDepartamento;
    }
    
    @Override
    public String toString() {
      String cadena;
     cadena = String.format("Departamento:\n"
                 + "Propietario: %s- %s- %s\n"
                 + "Precio por metro cuadrado: %.2f\n"
                 + "Número de metros cuadrados: %.2f\n"
                 + "Valor de la alícuota mensual: %.2f\n"
                 + "Barrio: %s\n"
                 + "Nombre del edificio: %s\n"
                 + "Ubicación en el edificio: %s\n"
                 + "Costo Final: %.2f\n",
                propietario.obtenerNombres(), propietario.obtenerApellidos(), propietario.obtenerIdentificacion(),
                precioMetroCuadrado,
                numeroMetrosCuadrado,
                valorMensual,
                barrio.obtenerNombreBarrio(),
                nombreEdificio,
                ubicacionDepartamento,
                costoFinal);
        return cadena;
    }
}
