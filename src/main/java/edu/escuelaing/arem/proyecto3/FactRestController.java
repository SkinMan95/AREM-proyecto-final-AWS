package edu.escuelaing.arem.proyecto3;

import edu.escuelaing.arem.proyecto3.entities.Format;
import edu.escuelaing.arem.proyecto3.entities.User;
import edu.escuelaing.arem.proyecto3.entities.communication.Invoice;
import edu.escuelaing.arem.proyecto3.entities.communication.UserWithPass;
import edu.escuelaing.arem.proyecto3.logic.FactServices;
import edu.escuelaing.arem.proyecto3.logic.FactServicesException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro Anzola email: alejandro.anzola@mail.escuelaing.edu.co
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/factapi")
public class FactRestController {

    public static final boolean LOGGING = true;

    @Autowired
    FactServices services;

    private void log(String str) {
        if (LOGGING) {
            System.out.println(str);
        }
    }

    private void error(String str) {
        System.err.println(str);
    }

    private String getPassHash(String pass) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                pass.getBytes(StandardCharsets.UTF_8));
            return new String(encodedhash);
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    @GetMapping("/convert")
    public ResponseEntity<?> convertFormat(@RequestParam("f1") String f1, @RequestParam("f2") String f2, @RequestBody Format f) {
        try {
            log("se intenta convertir un formato en otro: " + f1 + " a " + f2);
            services.convertFormat(f1, f2, f);
            log("se convirtio el formato a " + f2);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (FactServicesException ex) {
            error("fallo al convertir el formato: " + ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserWithPass userwp) {
        User u = userwp.getUser();
        String pass = userwp.getPass();

        String passHash = getPassHash(pass);

        try {
            log("se intenta registrar al usuario " + u);
            services.registerUser(u, passHash);
            log("se registro el usuario");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (FactServicesException ex) {
            error("fallo al registrar el usuario: " + ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/formats")
    public List<String> getAvailableFormats() {
        return services.getAvailableFormats();
    }

    @GetMapping("/validateFormat")
    public ResponseEntity<?> validateFormat(@RequestParam("fn") String fn, @RequestBody Format f) {
        try {
            log("se intenta validar el formato " + fn + " " + f);
            String res = services.validateFormat(fn, f);
            log("se valido el formato");
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (FactServicesException ex) {
            error("fallo al validar el formato: " + ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/invoices")
    public ResponseEntity<?> makeInvoice(@RequestBody Invoice invoice) {
        try {
            log("se intenta realizar la facturacion: " + invoice);
            services.makeInvoice(invoice.getF(), invoice.getUsername(), getPassHash(invoice.getPass()));
            log("se realizo la facturacion correctamente correctamnte");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (FactServicesException ex) {
            error("fallo al hacerse la facturacion");
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<?> getInvoiceStatus(String fid) {
        try {
            log("se intenta obtener el estado de la facturacion con id: " + fid);
            String res = services.getInvoiceStatus(fid);
            log("se consulto el estado de la facturacion correctamente");
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (FactServicesException ex) {
            error("fallo al intentar obtenerse el estado de la facturacion");
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
