package paquete06;
import java.io.Serializable;
import paquete02.Propietario;
import paquete04.Ciudad;

public class Casa implements Serializable {
    private Propietario propietario;
    private Ciudad ciudad;
    
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrado;
    private double costoFinal;
    private int numeroCuartos;

    public Casa(Propietario propietario, Ciudad ciudad, double precioMetroCuadrado, 
            double numerosMetrosCuadrados, int numeroDeCuartos) {
        this.propietario = propietario;
        this.ciudad = ciudad;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this. numeroMetrosCuadrado = numerosMetrosCuadrados;
        this.numeroCuartos = numeroDeCuartos;

        
    }

    public void establecerPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void establecerPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public void establecerNumeroMetrosCuadrado(double numeroMetrosCuadrado) {
        this.numeroMetrosCuadrado = numeroMetrosCuadrado;
    }

    public void establecerCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void establecerNumeroCuartos(int numeroCuartos) {
        this.numeroCuartos = numeroCuartos;
    }
    
        public void calcularCostoFinal() {
        costoFinal = (numeroMetrosCuadrado * precioMetroCuadrado)+ 3000;
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

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public int ObtenerNumeroCuartos() {
        return numeroCuartos;
    }
    
    @Override
    public String toString() {
        return String.format("Propietario: %s\nPrecio por metro cuadrado: %.2f\nNúmero de metros cuadrados: %.2f\nCosto final: %.2f\nCiudad: %s\nNúmero de cuartos: %d\n",
              obtenerPropietario(), obtenerPrecioMetroCuadrado(), obtenerNumeroMetrosCuadrado(), obtenerCostoFinal(),
              obtenerCiudad(), ObtenerNumeroCuartos());
    }
}
