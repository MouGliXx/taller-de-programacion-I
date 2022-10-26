package main.java.modelo;

import main.java.modelo.Producto;
public class Pedido {
    private Producto producto;
    private int cantidad;

    public Pedido (Producto producto, int cantidad){
        this.setCantidad(cantidad);
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        assert cantidad>0:"ERROR : La cantidad debe ser mayor a cero";
        this.cantidad = cantidad;
    }

    private int getCantidad(){
        return this.cantidad;
    }

    public double getPrecio(){
        return this.producto.getPrecioVenta() * this.getCantidad();
    }
}
