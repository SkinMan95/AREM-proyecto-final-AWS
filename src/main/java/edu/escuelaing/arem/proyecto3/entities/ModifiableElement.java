package edu.escuelaing.arem.proyecto3.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
public class ModifiableElement implements Element {

    List<Element> subElements = new ArrayList<>();
    String tag = "";
    String value = "";
    Map<String, String> attributes = new HashMap<>();
    
    @Override
    public List<Element> getSubElements() {
        return new ArrayList<>(subElements);
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Map<String, String> getAttributes() {
        return new HashMap<>(attributes);
    }
    
    public void addSubElement(Element newElement) {
        subElements.add(newElement);
    }
    
    public void setSubElements(List<Element> subElements) {
        if (subElements != null) {
            this.subElements = subElements;
        }
    }
    
    public void setTag(String tag) {
        if (tag != null) {
            this.tag = tag;
        }
    }
    
    public void setValue(String value) {
        if (value != null) {
            this.value = value;
        }
    }
}
