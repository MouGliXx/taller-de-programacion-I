package modelo;

import excepciones.ErrorCostoMayorAPrecioVenta;
import excepciones.ErrorPrecioCostoMenorCero;
import excepciones.ErrorPrecioVentaMenorCero;

public class Producto {
    
    private int idProduct;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stockInicial;

    public Producto(int idProduct, String nombre, double precioCosto, double precioVenta, int stockInicial) throws ErrorCostoMayorAPrecioVenta, ErrorPrecioVentaMenorCero, ErrorPrecioCostoMenorCero {
        this.idProduct = idProduct;
        this.nombre = nombre;
        if (precioVenta>=precioCosto){
            if(precioVenta>0){
                this.precioVenta = precioVenta;
                if(precioCosto>0)
                    this.precioCosto=precioCosto;
                else throw new ErrorPrecioCostoMenorCero("El precio de costo es menor a cero");
            }
            else throw new ErrorPrecioVentaMenorCero("El precio de venta es menor a cero");
        }
        else throw new ErrorCostoMayorAPrecioVenta("El precio de venta es menor al de costo");
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
