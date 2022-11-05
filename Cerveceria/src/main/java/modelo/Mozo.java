package modelo;

//Clase de los mozos
public class Mozo {
    private String nombreYApellido;
    private int edad;
    private String nombre;
    private int cantHijos;
    private String estado; // Activo - Ausente - Franco \\ un invariable podria ser que el estado nunca sea != a 0,1,2

    //CONSTRUCTOR
    public Mozo(String nombre, int edad, int cantHijos, String estado) throws Exception {
        this.nombreYApellido = nombre;
        this.estado = estado;
//        if (!this.esMayorDeEdad(fechaNacimiento)) throw new Exception();
        this.edad = edad;
//        if (cantHijos < 0) throw new Exception();
        this.cantHijos = cantHijos;
    }

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