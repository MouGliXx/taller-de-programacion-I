package modelo;

public class Mesa {
    private static int sig = 1;
    private int nro;
    private int cantidadComensales;
    private String estado;

    public Mesa (){
        this.nro = sig++;
        this.estado="Libre";
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
    public void setCantidadComensales(int cantidadComensales){
        if (this.nro>0)
            assert cantidadComensales>1:"ERROR: la cantidad de comensales debe ser mayor a 1";
        else
            assert cantidadComensales>0:"ERROR: la cantidad de comensales debe ser mayor a 1";
        this.cantidadComensales = cantidadComensales;
    }

    public void liberar (){
        this.estado = "Libre";
    }

    public void ocupar () {
        this.estado = "Ocupado";
    }

    public String getEstado(){
        return this.estado;
    }
}
