package modelo;

import java.io.Serializable;

public class Pedido implements Serializable {
    private Producto producto;
    private int cantidad;

    //CONSTRUCTOR
    public Pedido() {
    }

    public Pedido(Producto producto, int cantidad) throws Exception {
        if (!hayStock(producto,cantidad))
            throw new Exception("ERROR : No hay stock suficiente");

        producto.setStockInicial(producto.getStockInicial() - cantidad);

        this.setProducto(producto);
        this.setCantidad(cantidad);
    }

    //GETTERS && SETTERS
    public Producto getProducto (){
        return this.producto;
    }

    public void setProducto(Producto producto) {
        assert producto != null : "ERROR : El producto no debe der null";
        this.producto = producto;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        assert cantidad > 0 : "ERROR : La cantidad debe ser mayor a cero";
        this.cantidad = cantidad;
    }

    //FUNCIONALIDADES

    /**
     * Verifica si hay stock del producto determinado
     *
     * <b>pre:</b>producto debe existir y cantidad mayor o igual a cero<br>.
     * @param producto producto que se desea verificar el stock
     * @param cantidad cantidad que se requiere del producto
     * @return valor booleano que indica si hay stock suficiente
     */
    public boolean hayStock(Producto producto, int cantidad){
        return producto.getStockInicial() >= cantidad;
    }

    /**
     * determina el valor del pedido, haciendo la multiplicacion del precio unitario por la cantidad
     *
     * <b>pre:</b>producto debe existir y cantidad mayor o igual a cero<br>.
     * @return valor real que representa el precio total del pedido
     */
    public double getPrecioConjunto(){
        return this.producto.getPrecioVenta() * this.getCantidad();
    }

    @Override
    public String toString() {
        return "Producto: '" + producto +
                "' - Cantidad = " + cantidad;
    }
}
