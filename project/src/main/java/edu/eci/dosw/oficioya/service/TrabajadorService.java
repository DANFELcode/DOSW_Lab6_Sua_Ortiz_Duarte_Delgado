package edu.eci.dosw.oficioya.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.eci.dosw.oficioya.model.CategoriaPrincipal;
import edu.eci.dosw.oficioya.model.EstadoTrabajador;
import edu.eci.dosw.oficioya.model.Trabajador;

@Service
public class TrabajadorService {

    private static final Logger log = LoggerFactory.getLogger(TrabajadorService.class);

    private List<Trabajador> trabajadores = new ArrayList<>();
    private long siguienteId = 1;

    public TrabajadorService() {
        crear(datosSimulados("Andres Cantor", "andres@ejemplo.com", "3001234567", "clave123", "Plomero"));
        crear(datosSimulados("Marta Ruiz", "marta@ejemplo.com", "3109876543", "clave456", "Costurera"));
    }

    private Trabajador datosSimulados(String nombre, String correo, String telefono,
                                      String contrasena, String oficio) {
        Trabajador trabajador = new Trabajador();
        trabajador.setNombre(nombre);
        trabajador.setCorreo(correo);
        trabajador.setTelefono(telefono);
        trabajador.setContrasena(contrasena);
        CategoriaPrincipal principal = new CategoriaPrincipal();
        principal.setNombre(oficio);
        trabajador.setMainOficio(principal);
        return trabajador;
    }

    public List<Trabajador> listar() {
        log.debug("Listando todos los trabajadores");
        return trabajadores;
    }

    public Trabajador buscar(Long id) {
        log.debug("Buscando trabajador con id: {}", id);
        for (Trabajador t : trabajadores) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        log.warn("Trabajador con id {} no encontrado", id);
        return null;
    }

    public Trabajador crear(Trabajador trabajador) {
        trabajador.setId(siguienteId);
        siguienteId++;
        trabajador.setEstado(EstadoTrabajador.ACTIVO);
        trabajadores.add(trabajador);
        log.info("Trabajador creado con id: {}", trabajador.getId());
        return trabajador;
    }

    public Trabajador actualizar(Long id, Trabajador nuevo) {
        log.debug("Actualizando trabajador con id: {}", id);
        Trabajador actual = buscar(id);
        if (actual == null || actual.getEstado() == EstadoTrabajador.INACTIVO) {
            log.warn("No se puede actualizar trabajador con id {}", id);
            return null;
        }
        actual.setNombre(nuevo.getNombre());
        actual.setCorreo(nuevo.getCorreo());
        actual.setTelefono(nuevo.getTelefono());
        actual.setContrasena(nuevo.getContrasena());
        actual.setMainOficio(nuevo.getMainOficio());
        log.info("Trabajador actualizado con id: {}", id);
        return actual;
    }

    public Trabajador inactivar(Long id) {
        log.debug("Inactivando trabajador con id: {}", id);
        Trabajador t = buscar(id);
        if (t == null) {
            log.warn("No se puede inactivar: trabajador con id {} no encontrado", id);
            return null;
        }
        t.setEstado(EstadoTrabajador.INACTIVO);
        log.info("Trabajador inactivado con id: {}", id);
        return t;
    }

    public boolean login(String correo, String contrasena) {
        log.debug("Intento de login para correo: {}", correo);
        for (Trabajador t : trabajadores) {
            if (t.getCorreo().equals(correo) && t.getContrasena().equals(contrasena)) {
                log.info("Login exitoso para correo: {}", correo);
                return true;
            }
        }
        log.warn("Login fallido para correo: {}", correo);
        return false;
    }
}