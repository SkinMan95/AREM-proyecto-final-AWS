package edu.escuelaing.arem.proyecto3.entities;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public abstract class AbstractFormat {

    Element rootElement;
    String type;

    final public Element getRootElement() {
        return rootElement;
    }

    final public void setRootElement(Element rootElement) {
        if (this.rootElement == null) {
            this.rootElement = rootElement;
        }
    }

    final public String getType() {
        return type;
    }

    final public void setType(String type) {
        if (this.type == null || this.type.equals("")) {
            this.type = type;
        }
    }

}
