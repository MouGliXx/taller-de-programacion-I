package main.java.excepciones;


/**
 * Se lanza cuando el precio de venta es menor a cero
 */

public class ErrorPrecioVentaMenorCero extends Exception{
    public ErrorPrecioVentaMenorCero(String message) {
        super(message);
    }
}


