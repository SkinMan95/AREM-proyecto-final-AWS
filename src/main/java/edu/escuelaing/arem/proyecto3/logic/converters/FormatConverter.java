package edu.escuelaing.arem.proyecto3.logic.converters;

import edu.escuelaing.arem.proyecto3.entities.Format;
import java.util.List;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public interface FormatConverter {

    public Format convertToFormat(String otype, String text) throws FormatConverterException;

    public String convertFormatToString(String dtype, Format f) throws FormatConverterException;
    
    public List<String> getAvailableFormats();
}
