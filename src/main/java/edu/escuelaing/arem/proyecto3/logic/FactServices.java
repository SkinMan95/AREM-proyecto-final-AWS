package edu.escuelaing.arem.proyecto3.logic;

import edu.escuelaing.arem.proyecto3.entities.Format;
import edu.escuelaing.arem.proyecto3.entities.User;
import java.util.List;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public interface FactServices {

    public Format convertFormat(String f1, String f2, Format f) throws FactServicesException;

    public void registerUser(User u, String passHash) throws FactServicesException;

    public List<String> getAvailableFormats();

    public String validateFormat(String fn, Format f) throws FactServicesException;

    public void makeInvoice(Format f, String username, String passHash) throws FactServicesException;

    public String getInvoiceStatus(String fid) throws FactServicesException;
}
