package br.edu.infnet.pedido.exception;

public class ErroAoConectarException extends RuntimeException{
    public ErroAoConectarException(String message) {
        super(message);
    }

    public ErroAoConectarException(String message, Throwable cause) {
        super(message, cause);
    }
}
