package edu.eci.dosw.oficioya.model;

import java.time.LocalDateTime;

public abstract class Usuario {

    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private String contrasena;
    private LocalDateTime fechaRegistro;
    private boolean cuentaActiva;
}
