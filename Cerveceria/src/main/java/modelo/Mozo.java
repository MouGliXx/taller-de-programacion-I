package modelo;

//Clase de los mozos
public class Mozo {
    private String nombreYApellido;
    private int edad;
    private String nombre;
    private int cantHijos;
    private String estado; // Activo - Ausente - Franco

    //CONSTRUCTOR
    public Mozo(String nombre, int edad, int cantHijos, String estado) throws Exception {
        this.nombreYApellido = nombre;
        this.estado = estado;
        this.edad = edad;
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

    //FUNCIONALIDADES

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