package modelo;

public class Mesa {
    private static int sig = 1;
    private int nro;
    private int cantidadComensales;
    private String estado;

    //CONSTRUCTOR
    public Mesa (){
        this.nro = sig++;
        this.estado = "Libre";
        this.cantidadComensales = 0;
    }

    //GETTERS && SETTERS
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getCantidadComensales() {
        return cantidadComensales;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //FUNCIONALIDADES
    public void ocupar (int cantidadComensales){
        this.setCantidadComensales(cantidadComensales);
        this.estado = "Ocupado";
    }

    public void setCantidadComensales(int cantidadComensales){
        if (this.nro>0)
            assert cantidadComensales>1:"ERROR: la cantidad de comensales debe ser mayor a 1";
        else
            assert cantidadComensales>0:"ERROR: la cantidad de comensales debe ser mayor a 1";
        this.cantidadComensales = cantidadComensales;
    }

    public void liberar (){
        this.estado = "Libre";
        this.cantidadComensales = 0;
    }

    public String getEstado(){
        return this.estado;
    }
}
