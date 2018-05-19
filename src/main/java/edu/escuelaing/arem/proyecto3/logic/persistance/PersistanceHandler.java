package edu.escuelaing.arem.proyecto3.logic.persistance;

import edu.escuelaing.arem.proyecto3.entities.Format;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public interface PersistanceHandler {

    public Format queryInvoice(String fid);

    public boolean registerInvoice(String username, Format f);

    public boolean updateInvoice(String fid, Format f);

    public boolean deleteInvoice(String fid);
}
