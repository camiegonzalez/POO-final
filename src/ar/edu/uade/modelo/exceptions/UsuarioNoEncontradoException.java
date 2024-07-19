package ar.edu.uade.modelo.exceptions;

public class UsuarioNoEncontradoException extends Exception {
    public UsuarioNoEncontradoException() {
        super("Usuario no encontrado.");
    }
}
