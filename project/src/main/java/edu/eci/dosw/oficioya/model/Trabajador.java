package edu.eci.dosw.oficioya.model;

public class Trabajador extends Usuario {
    private String foto;
    private double tarifaAproximada;
    private boolean disponibilidad;
    private int trabajoCompletado;
    private double calificacionPromedio;
    private EstadoTrabajador estado;
    private Oficio mainOficio;
    private HistorialCartera historialCartera;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getTarifaAproximada() {
        return tarifaAproximada;
    }

    public void setTarifaAproximada(double tarifaAproximada) {
        this.tarifaAproximada = tarifaAproximada;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getTrabajoCompletado() {
        return trabajoCompletado;
    }

    public void setTrabajoCompletado(int trabajoCompletado) {
        this.trabajoCompletado = trabajoCompletado;
    }

    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public EstadoTrabajador getEstado() {
        return estado;
    }

    public void setEstado(EstadoTrabajador estado) {
        this.estado = estado;
    }

    public Oficio getMainOficio() {
        return mainOficio;
    }

    public void setMainOficio(Oficio mainOficio) {
        this.mainOficio = mainOficio;
    }

    public HistorialCartera getHistorialCartera() {
        return historialCartera;
    }

    public void setHistorialCartera(HistorialCartera historialCartera) {
        this.historialCartera = historialCartera;
    }
}
