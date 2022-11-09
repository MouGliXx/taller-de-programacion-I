package modelo;

public class EstadisticaMesa {
    private double totalGastado;
    private int cantidadVentas;

    //CONSTRUCTOR
    public EstadisticaMesa(){
        this.cantidadVentas = 0;
        this.totalGastado = 0.;
    }

    //GETTER Y SETTERS
    public double getTotalGastado() {return totalGastado;}

    public int getCantidadVentas() {return cantidadVentas;}

    public void setTotalGastado(double totalGastado) {this.totalGastado = totalGastado;}

    public void setCantidadVentas(int cantidadVentas) {this.cantidadVentas = cantidadVentas;}
}
