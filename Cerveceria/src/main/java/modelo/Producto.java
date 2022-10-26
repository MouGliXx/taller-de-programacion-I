package main.java.modelo;

public class Producto {
    
    int idProduct;
    String nombre;
    double precioCosto;
    double precioVenta;
    int stockInicial;

    public Producto(int idProduct, String nombre, double precioCosto, double precioVenta, int stockInicial) {
        this.idProduct = idProduct;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stockInicial = stockInicial;
    }

    public int getidProduct() {
        return idProduct;
    }

    public void setidProduct(int idProduct) {
        this.idProduct = idProduct;
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
}
