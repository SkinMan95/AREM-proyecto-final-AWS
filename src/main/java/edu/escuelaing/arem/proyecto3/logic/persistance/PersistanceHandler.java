package edu.escuelaing.arem.proyecto3.logic.persistance;

import edu.escuelaing.arem.proyecto3.entities.Format;
import edu.escuelaing.arem.proyecto3.entities.User;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public interface PersistanceHandler {

    public String queryInvoiceStatus(String fid) throws PersistanceHandlerException;

    public boolean registerInvoice(String username, Format f) throws PersistanceHandlerException;

    public boolean updateInvoice(String fid, Format f) throws PersistanceHandlerException;

    public boolean deleteInvoice(String fid) throws PersistanceHandlerException;

    public boolean registerUser(User u, String passHash) throws PersistanceHandlerException;

    public boolean userExists(String uid);

    public boolean validAuthentication(String uid, String passHash) throws PersistanceHandlerException;
}
