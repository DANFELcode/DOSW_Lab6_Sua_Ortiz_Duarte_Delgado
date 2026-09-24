package edu.eci.dosw.oficioya.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.dosw.oficioya.service.TrabajadorService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final TrabajadorService trabajadorService;

    public AuthController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> datos) {
        if (trabajadorService.login(datos.get("correo"), datos.get("contrasena"))) {
            return ResponseEntity.ok("Autenticación exitosa");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}