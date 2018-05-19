package edu.escuelaing.arem.proyecto3.entities.communication;

import edu.escuelaing.arem.proyecto3.entities.User;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public class UserWithPass {

    User user;
    String pass;

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
