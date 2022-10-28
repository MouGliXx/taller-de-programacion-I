package modelo;

public class Pedido {
    private Producto producto;
    private int cantidad;

    public Pedido( Producto producto, int cantidad) {
        this.producto = producto;
        this.setCantidad(cantidad);
    }


    public void setCantidad(int cantidad) {
        assert cantidad>0:"ERROR : La cantidad debe ser mayor a cero";
        this.cantidad = cantidad;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public double getPrecio(){
        return this.producto.getPrecioVenta() * this.getCantidad();
    }

    public Producto getProducto (){
        return this.producto;
    }
}
