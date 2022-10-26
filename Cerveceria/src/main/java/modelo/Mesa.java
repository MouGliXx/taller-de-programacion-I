package main.java.modelo;

public class Mesa {

    private static int sig = 1;
    private int nro;
    private int cantidadComensales;
    private String estado;

    public Mesa (){
        this.nro = sig++;
        this.estado="Libre";
        this.cantidadComensales=0;
    }

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
