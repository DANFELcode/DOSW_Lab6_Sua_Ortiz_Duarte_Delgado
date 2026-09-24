package edu.eci.dosw.oficioya.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.dosw.oficioya.model.EstadoTrabajador;
import edu.eci.dosw.oficioya.model.Trabajador;

@Service
public class TrabajadorService {

    private List<Trabajador> trabajadores = new ArrayList<>();
    private long siguienteId = 1;

    public TrabajadorService() {
        
    }

    public List<Trabajador> listar() {
        return trabajadores;
    }

    public Trabajador buscar(Long id) {
        for (Trabajador t : trabajadores) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public Trabajador crear(Trabajador trabajador) {
        trabajador.setId(siguienteId);
        siguienteId++;
        trabajador.setEstado(EstadoTrabajador.ACTIVO);
        trabajadores.add(trabajador);
        return trabajador;
    }

    public Trabajador actualizar(Long id, Trabajador nuevo) {
        Trabajador actual = buscar(id);
        if (actual == null || actual.getEstado() == EstadoTrabajador.INACTIVO) {
            return null;
        }
        actual.setNombre(nuevo.getNombre());
        actual.setCorreo(nuevo.getCorreo());
        actual.setTelefono(nuevo.getTelefono());
        actual.setContrasena(nuevo.getContrasena());
        actual.setMainOficio(nuevo.getMainOficio());
        return actual;
    }

    public Trabajador inactivar(Long id) {
        Trabajador t = buscar(id);
        if (t == null) {
            return null;
        }
        t.setEstado(EstadoTrabajador.INACTIVO);
        return t;
    }

    public boolean login(String correo, String contrasena) {
        for (Trabajador t : trabajadores) {
            if (t.getCorreo().equals(correo) && t.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}