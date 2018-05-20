package edu.escuelaing.arem.proyecto3.logic.converters.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.escuelaing.arem.proyecto3.entities.Element;
import edu.escuelaing.arem.proyecto3.entities.Format;
import edu.escuelaing.arem.proyecto3.entities.ModifiableElement;
import edu.escuelaing.arem.proyecto3.logic.converters.FormatConverter;
import edu.escuelaing.arem.proyecto3.logic.converters.FormatConverterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
@Service
public class DummyFormatConverter implements FormatConverter {

    List<String> formats = Arrays.asList("json", "xml");

    @Override
    public Format convertToFormat(String otype, String origin) throws FormatConverterException {
        if (!formats.contains(otype)) {
            throw new FormatConverterException("alguno de los formatos no es valido para convertir");
        }
        
        return null; // TODO
    }
    
    private Format convertJsonToFormat(String origin) throws JsonParseException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(origin);
        
        Element tree = exploreJson(root);
        
        Format res = new Format();
        res.setRootElement(tree);
        
        return res;
    }
    
    private Element exploreJson(JsonNode root) {
        assert root != null;
        
        String tag = root.get("tag").asText();
        String value = root.get("value").asText();
        
        ModifiableElement res = new ModifiableElement();
        res.setTag(tag);
        res.setValue(value);
        
        Stack<JsonNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            JsonNode u = s.pop();
            Iterator<String> it = u.fieldNames();
            ModifiableElement e = new ModifiableElement();
            List<JsonNode> attNodes = new ArrayList<>();
            List<Element> subElements = new ArrayList<>();
            while(it.hasNext()) {
                String att = it.next();
                JsonNode val = u.get(att);
                if (att.equals("tag") || att.equals("value")) {
                    continue;
                }
                
                if (val.isArray()) {
                    //val.
                }
                res.addSubElement(e);
            }
        }
        
        return null;
    }
    
    private Format convertXmlToFormat(String origin) {
        return null;
    }
    
    @Override
    public List<String> getAvailableFormats() {
        return formats;
    }

    @Override
    public String convertFormatToString(String dtype, Format f) throws FormatConverterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
