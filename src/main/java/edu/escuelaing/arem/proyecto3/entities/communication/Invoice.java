package edu.escuelaing.arem.proyecto3.entities.communication;

import edu.escuelaing.arem.proyecto3.entities.Format;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public class Invoice {
    Format f;
    String username;
    String pass;

    public Format getF() {
        return f;
    }

    public void setF(Format f) {
        this.f = f;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
