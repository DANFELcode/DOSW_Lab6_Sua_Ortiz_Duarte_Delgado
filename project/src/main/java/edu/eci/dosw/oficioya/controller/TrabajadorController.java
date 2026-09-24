package edu.eci.dosw.oficioya.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.dosw.oficioya.model.CategoriaPrincipal;
import edu.eci.dosw.oficioya.model.Trabajador;
import edu.eci.dosw.oficioya.service.TrabajadorService;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {

    private final TrabajadorService service;

    public TrabajadorController(TrabajadorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Trabajador> crear(@RequestBody Map<String, String> datos) {
        if (faltanDatos(datos)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Trabajador creado = service.crear(armar(datos));
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<Trabajador>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> get(@PathVariable Long id) {
        Trabajador t = service.buscar(id);
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(t);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id,
                                                 @RequestBody Map<String, String> datos) {
        if (faltanDatos(datos)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Trabajador t = service.actualizar(id, armar(datos));
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(t);
    }

    @PatchMapping("/{id}/inactivar")
    public ResponseEntity<Trabajador> inactivar(@PathVariable Long id) {
        Trabajador t = service.inactivar(id);
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(t);
    }

    private Trabajador armar(Map<String, String> datos) {
        Trabajador t = new Trabajador();
        t.setNombre(datos.get("nombre"));
        t.setCorreo(datos.get("correo"));
        t.setTelefono(datos.get("telefono"));
        t.setContrasena(datos.get("contrasena"));
        CategoriaPrincipal oficio = new CategoriaPrincipal();
        oficio.setNombre(datos.get("mainOficio"));
        t.setMainOficio(oficio);
        return t;
    }

    private boolean faltanDatos(Map<String, String> datos) {
        return datos.get("nombre") == null || datos.get("correo") == null
                || datos.get("telefono") == null || datos.get("mainOficio") == null
                || datos.get("contrasena") == null;
    }
}