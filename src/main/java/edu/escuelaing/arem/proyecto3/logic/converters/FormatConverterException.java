package edu.escuelaing.arem.proyecto3.logic.converters;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public class FormatConverterException extends Exception {

    private static final long serialVersionUID = 6587451546854168465L;

    public FormatConverterException() {
    }

    public FormatConverterException(String message) {
        super(message);
    }

    public FormatConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatConverterException(Throwable cause) {
        super(cause);
    }
}
