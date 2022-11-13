package modelo;

import java.io.Serializable;

public class EstadisticaMozo implements Serializable {
    private double totalGastado;
    private int mesasAtendidas;

    //CONSTRUCTOR
    public EstadisticaMozo(){
        this.mesasAtendidas = 0;
        this.totalGastado = 0.0;
    }

    public EstadisticaMozo(double totalGastado, int mesasAtendidas) {
        this.totalGastado = totalGastado;
        this.mesasAtendidas = mesasAtendidas;
    }

    //GETTER Y SETTERS
    public double getTotalGastado() {return totalGastado;}

    public int getCantidadVentas() {return mesasAtendidas;}

    public void setTotalGastado(double totalGastado) {this.totalGastado = totalGastado;}

    public void setCantidadVentas(int cantidadVentas) {this.mesasAtendidas = cantidadVentas;}
}
