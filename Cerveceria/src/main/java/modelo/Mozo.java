package main.java.modelo;

import java.time.LocalDate;

public class Mozo {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int cantHijos;
    private int estado; // 0-> activo 1->ausente 2->de franco // un invariable podria ser que el estado nunca sea != a 0,1,2

    public Mozo(String nombre, LocalDate fechaNacimiento, int cantHijos, int estado) throws Exception {
        this.nombre = nombre;
        this.estado = estado;
        if (!this.esMayorDeEdad(fechaNacimiento)) throw new Exception();
        this.fechaNacimiento = fechaNacimiento;
        if (cantHijos < 0) throw new Exception();
        this.cantHijos = cantHijos;
    }

    //@precondion : fechaNacimiento tiene que ser != NULL
    // retorna true si la edad es mayor o igual a 18 anos
    public boolean esMayorDeEdad(LocalDate fecha){
        LocalDate start = LocalDate.of( 2010 , 1 , 1 ) ;
        long years = java.time.temporal.ChronoUnit.YEARS.between( start , fecha );
        return years >= 0 ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstadoActivo(){
        this.setEstado(0);
    }

    public void setEstadoAusente(){
        this.setEstado(1);
    }

    public void setEstadoFranco(){
        this.setEstado(2);
    }

    private void setEstado(int estado){
        this.estado = estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mozo mozo = (Mozo) o;
        return getCantHijos() == mozo.getCantHijos() && getEstado() == mozo.getEstado() && getNombre().equals(mozo.getNombre()) && getFechaNacimiento().equals(mozo.getFechaNacimiento());
    }


}