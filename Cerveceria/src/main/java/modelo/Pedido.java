package modelo;

public class Pedido {
    private Producto producto;
    private int cantidad;

    //CONSTRUCTOR
    public Pedido() {
    }

    public Pedido(Producto producto, int cantidad) throws Exception {
        if (!hayStock(producto,cantidad))
            throw new Exception("ERROR : No hay stock suficiente");
        producto.setStockInicial(producto.getStockInicial()-cantidad);
        this.setProducto(producto);
        this.setCantidad(cantidad);
    }

    //GETTERS && SETTERS
    public void setCantidad(int cantidad) {
        assert cantidad > 0 : "ERROR : La cantidad debe ser mayor a cero";
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        assert producto != null : "ERROR : El producto no debe der null";
        this.producto = producto;
    }

    public boolean hayStock(Producto producto, int cantidad){
        return producto.getStockInicial()>=cantidad;
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

    @Override
    public String toString() {
        return "Prod= "+ producto +
                " Cant= " + cantidad;
    }
}
