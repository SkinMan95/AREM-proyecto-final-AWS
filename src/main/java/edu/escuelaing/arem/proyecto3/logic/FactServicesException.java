package edu.escuelaing.arem.proyecto3.logic;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public class FactServicesException extends Exception {

    private static final long serialVersionUID = 16451684653165L;

    public FactServicesException() {
    }

    public FactServicesException(String message) {
        super(message);
    }

    public FactServicesException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactServicesException(Throwable cause) {
        super(cause);
    }
}
