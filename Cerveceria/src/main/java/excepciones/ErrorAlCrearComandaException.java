package excepciones;

/**
 * Se lanza cuando no puede crear una comanda
 */

public class ErrorAlCrearComandaException extends Exception{
    public ErrorAlCrearComandaException(String message) {
        super(message);
    }
}
