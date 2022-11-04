package modelo;

import java.time.LocalDate;

//Clase de los mozos

public class Mozo {
<<<<<<< Updated upstream
    private String nombreYApellido;
    private int edad;
=======
    /*
    Constructor de la clase mozo
    @param nombre nombre del mozo
    @param fechaNacimiento fecha en la que nacio el mozo, el mozo siempre tiene 18 anos o mas
    @param estado estado del mozo durante dia laboral 0 -> activo , 1-> ausente 2-> franco
     */
    private String nombre;
    private LocalDate fechaNacimiento; //RESOLVER
>>>>>>> Stashed changes
    private int cantHijos;
    private String estado; // Activo - Ausente - Franco \\ un invariable podria ser que el estado nunca sea != a 0,1,2

<<<<<<< Updated upstream
    //CONSTRUCTOR
    public Mozo(String nombre, int edad, int cantHijos, String estado) throws Exception {
        this.nombreYApellido = nombre;
=======
    public Mozo(String nombre, LocalDate fechaNacimiento, int cantHijos, int estado) throws Exception {
        this.nombre = nombre;
>>>>>>> Stashed changes
        this.estado = estado;
//        if (!this.esMayorDeEdad(fechaNacimiento)) throw new Exception();
        this.edad = edad;
//        if (cantHijos < 0) throw new Exception();
        this.cantHijos = cantHijos;
    }

    // este metodo podria ir en utils
    // @precondion : fechaNacimiento tiene que ser != NULL
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
    public String toString() {
        return "Mozo{" +
                "nombreYApellido='" + nombreYApellido + '\'' +
                ", edad=" + edad +
                ", cantHijos=" + cantHijos +
                ", estado='" + estado + '\'' +
                '}';
    }
}