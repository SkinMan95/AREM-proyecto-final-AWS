package edu.escuelaing.arem.proyecto3.logic.impl;

import edu.escuelaing.arem.proyecto3.entities.Format;
import edu.escuelaing.arem.proyecto3.entities.User;
import edu.escuelaing.arem.proyecto3.logic.FactServices;
import edu.escuelaing.arem.proyecto3.logic.FactServicesException;
import edu.escuelaing.arem.proyecto3.logic.converters.FormatConverter;
import edu.escuelaing.arem.proyecto3.logic.converters.FormatConverterException;
import edu.escuelaing.arem.proyecto3.logic.persistance.PersistanceHandler;
import edu.escuelaing.arem.proyecto3.logic.persistance.PersistanceHandlerException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
@Service
public class FactServicesImpl implements FactServices {

    @Autowired
    PersistanceHandler persistance;

    @Autowired
    FormatConverter fconverter;

    @Override
    public String convertFormat(String f1, String f2, String f) throws FactServicesException {
        try {
             Format format = fconverter.convertToFormat(f1, f);
             String res = fconverter.convertFormatToString(f2, format);
             return res;
        } catch (FormatConverterException ex) {
            throw new FactServicesException(ex);
        }
    }

    @Override
    public void registerUser(User u, String passHash) throws FactServicesException {
        try {
            persistance.registerUser(u, passHash);
        } catch (PersistanceHandlerException ex) {
            throw new FactServicesException(ex);
        }
    }

    @Override
    public List<String> getAvailableFormats() {
        return fconverter.getAvailableFormats();
    }

    @Override
    public String validateFormat(String fn, String f) throws FactServicesException {
        assert getAvailableFormats().contains("json");
        try {
            convertFormat(fn, "json", f);
            return "Todo correcto";
        } catch (FactServicesException ex) {
            return "Hubo errores en el parseo: " + ex.getMessage();
        }
    }

    @Override
    public void makeInvoice(Format f, String username, String passHash) throws FactServicesException {
        try {
            if (!persistance.validAuthentication(username, passHash)) {
                throw new FactServicesException("Credenciales incorrectas");
            }
        } catch (PersistanceHandlerException ex) {
            throw new FactServicesException(ex);
        }
        
        try {
            persistance.registerInvoice(username, f);
        } catch (PersistanceHandlerException ex) {
            throw new FactServicesException(ex);
        }
    }

    @Override
    public String getInvoiceStatus(String fid) throws FactServicesException {
        try {
            return persistance.queryInvoiceStatus(fid);
        } catch (PersistanceHandlerException ex) {
            throw new FactServicesException(ex);
        }
    }

}
