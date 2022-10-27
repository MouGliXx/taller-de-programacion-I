package main.java.excepciones;


/**
 * Se lanza cuando no hay Stock suficiente de producto
 */

public class StockInsufucienteException extends Exception{
    public StockInsufucienteException(String message) {
        super(message);
    }
}
