package edu.escuelaing.arem.proyecto3.entities;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public interface Element {

    public List<Element> getSubElements();

    public String getTag();

    public String getValue();

    public Map<String, String> getAttributes();
}
