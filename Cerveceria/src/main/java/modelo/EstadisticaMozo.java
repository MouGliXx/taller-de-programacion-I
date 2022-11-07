package modelo;

public class EstadisticaMozo {
    private double totalGastado;
    private int mesasAtendidas;

    //CONSTRUCTOR
    public EstadisticaMozo(){
        this.mesasAtendidas = 0;
        this.totalGastado = 0.0;
    }

    //GETTER Y SETTERS
    public double getTotalGastado() {return totalGastado;}

    public int getCantidadVentas() {return mesasAtendidas;}

    public void setTotalGastado(double totalGastado) {this.totalGastado = totalGastado;}

    public void setCantidadVentas(int cantidadVentas) {this.mesasAtendidas = cantidadVentas;}
}
