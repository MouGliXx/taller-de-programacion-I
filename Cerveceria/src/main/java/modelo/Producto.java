package modelo;

public class Producto {
    private static int idProduct=0;
    private int nro;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stockInicial;

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Producto(int nro, String nombre, double precioCosto, double precioVenta, int stockInicial) {
        idProduct++;
        this.nro = idProduct;
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

    @Override
    public String toString() {
        return "Producto{" +
                "nro=" + nro +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
