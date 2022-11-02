package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Mozo {
    private String nombreYApellido;
    private LocalDate fechaNacimiento; //RESOLVER
    private int cantHijos;
    private String estado; // 0-> activo 1->ausente 2->de franco // un invariable podria ser que el estado nunca sea != a 0,1,2

    //CONSTRUCTOR
    public Mozo(String nombre, LocalDate fechaNacimiento, int cantHijos, String estado) throws Exception {
        this.nombreYApellido = nombre;
        this.estado = estado;
//        if (!this.esMayorDeEdad(fechaNacimiento)) throw new Exception();
        this.fechaNacimiento = fechaNacimiento;
//        if (cantHijos < 0) throw new Exception();
        this.cantHijos = cantHijos;
    }

    //@precondion : fechaNacimiento tiene que ser != NULL
    // retorna true si la edad es mayor o igual a 18 anos
    //public boolean esMayorDeEdad(Date fecha){
       // Date start = Date.from( 2010 , 1 , 1 ) ;
        //long years = java.time.temporal.ChronoUnit.YEARS.between( start , fecha );
        //return years >= 0 ;
    //}

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
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

    public String getEstado() {
        return estado;
    }

    public void setEstadoActivo(){
        this.setEstado("Activo");
    }

    public void setEstadoAusente(){
        this.setEstado("Ausente");
    }

    public void setEstadoFranco(){
        this.setEstado("Franco");
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mozo mozo = (Mozo) o;
        return getCantHijos() == mozo.getCantHijos() && getEstado() == mozo.getEstado() && getNombreYApellido().equals(mozo.getNombreYApellido()) && getFechaNacimiento().equals(mozo.getFechaNacimiento());
    }

    @Override
    public String toString() {
        return "Mozo{" +
                "nombre='" + nombreYApellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", cantHijos=" + cantHijos +
                ", estado=" + estado +
                '}';
    }

}