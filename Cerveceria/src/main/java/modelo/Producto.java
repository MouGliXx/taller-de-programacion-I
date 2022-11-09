package modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private static int N = 0;
    private int idProducto;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stockInicial;

    //CONSTRUCTOR
    public Producto(String nombre, double precioCosto, double precioVenta, int stockInicial) {
        this.idProducto = N;
        N++;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stockInicial = stockInicial;
    }

    //GETTERS & SETTERS
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}
