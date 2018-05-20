package edu.escuelaing.arem.proyecto3.logic.persistance;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public class PersistanceHandlerException extends Exception {

    private static final long serialVersionUID = 16451684653165L;

    public PersistanceHandlerException() {
    }

    public PersistanceHandlerException(String message) {
        super(message);
    }

    public PersistanceHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistanceHandlerException(Throwable cause) {
        super(cause);
    }
}
