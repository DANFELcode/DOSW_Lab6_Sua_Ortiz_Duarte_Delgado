package edu.eci.dosw.oficioya.model;

import java.time.LocalDateTime;

public class Notificacion {

    private Long id;
    private Usuario destinatario;
    private String tipo;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean notificacionLeida;
}
