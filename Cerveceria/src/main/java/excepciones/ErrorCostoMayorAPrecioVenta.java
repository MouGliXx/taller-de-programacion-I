package excepciones;

/**
 * Se lanza cuando el precio de costo es mayor al de venta
 */

public class ErrorCostoMayorAPrecioVenta extends Exception{
    public ErrorCostoMayorAPrecioVenta(String message) {
        super(message);
    }
}
