package edu.eci.dosw.oficioya.model;

public class CategoriaPrincipal implements Oficio {
    private Oficio tipoOficio;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
