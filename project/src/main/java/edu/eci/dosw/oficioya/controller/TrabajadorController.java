package edu.eci.dosw.oficioya.controller;

import java.util.ArrayList;
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
import edu.eci.dosw.oficioya.model.EstadoTrabajador;
import edu.eci.dosw.oficioya.model.Trabajador;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {

    public static List<Trabajador> trabajadores = new ArrayList<>();
    private long siguienteId = 1;

    @PostMapping
    public ResponseEntity<Trabajador> crear(@RequestBody Map<String, String> datos) {
        if (faltanDatos(datos)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Trabajador t = new Trabajador();
        t.setId(siguienteId);
        siguienteId++;
        t.setEstado(EstadoTrabajador.ACTIVO);
        guardarDatos(t, datos);

        trabajadores.add(t);
        return ResponseEntity.status(HttpStatus.CREATED).body(t);
    }

    @GetMapping
    public ResponseEntity<List<Trabajador>> listar() {
        return ResponseEntity.ok(trabajadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> get(@PathVariable Long id) {
        for (Trabajador t : trabajadores) {
            if (t.getId().equals(id)) {
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id,
                                                 @RequestBody Map<String, String> datos) {
        for (Trabajador t : trabajadores) {
            if (t.getId().equals(id)) {
                if (t.getEstado() == EstadoTrabajador.INACTIVO) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }
                if (faltanDatos(datos)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
                guardarDatos(t, datos);
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PatchMapping("/{id}/inactivar")
    public ResponseEntity<Trabajador> inactivar(@PathVariable Long id) {
        for (Trabajador t : trabajadores) {
            if (t.getId().equals(id)) {
                t.setEstado(EstadoTrabajador.INACTIVO);
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private void guardarDatos(Trabajador t, Map<String, String> datos) {
        t.setNombre(datos.get("nombre"));
        t.setCorreo(datos.get("correo"));
        t.setTelefono(datos.get("telefono"));
        t.setContrasena(datos.get("contrasena"));

        CategoriaPrincipal oficio = new CategoriaPrincipal();
        oficio.setNombre(datos.get("mainOficio"));
        t.setMainOficio(oficio);
    }

    private boolean faltanDatos(Map<String, String> datos) {
        return datos.get("nombre") == null
                || datos.get("correo") == null
                || datos.get("telefono") == null
                || datos.get("mainOficio") == null
                || datos.get("contrasena") == null;
    }
}