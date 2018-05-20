package edu.escuelaing.arem.proyecto3.logic.converters.impl;

import edu.escuelaing.arem.proyecto3.entities.Format;
import edu.escuelaing.arem.proyecto3.logic.converters.FormatConverter;
import edu.escuelaing.arem.proyecto3.logic.converters.FormatConverterException;
import java.util.List;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public class LambdaFormatConverter implements FormatConverter {

    public static final String AWS_BASE = ""; // TODO aws gateway

    @Override
    public Format convertToFormat(String otype, String text) throws FormatConverterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAvailableFormats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String convertFormatToString(String dtype, Format f) throws FormatConverterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
