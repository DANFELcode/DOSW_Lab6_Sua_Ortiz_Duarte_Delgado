package edu.eci.dosw.oficioya.model;

import java.time.LocalDateTime;

public class Solicitud {

    private String descripcionSolicitud;
    private int cantidadSolicitud;
    private EstadoSolicitud estadoSolicitud;
    private LocalDateTime creacionSolicitud;
    private Trabajador trabajador;
    private Notificacion notificacion;
}
