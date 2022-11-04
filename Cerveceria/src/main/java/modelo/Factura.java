package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private double total;
    private String formaDePago;
    private ArrayList<ProductoEnPromocion> promocionesProductos;
    private ArrayList<PromocionTemporal> promocionesTemporales;

    //CONSTRUCTOR
    public Factura(Date fecha, Mesa mesa, ArrayList<Pedido> pedidos, double total,private ArrayList<ProductoEnPromocion> promocionesProductos,  ArrayList<PromocionTemporal> promocionesTemporales) {
        this.fecha = fecha;
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.total = total;
        this.promocionesProductos = promocionesProductos;
        this.promocionesTemporales = promocionesTemporales;
    }

    //GETTERS & SETTERS
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public ArrayList<ProductoEnPromocion> getPromocionesProductos() {
        return promocionesProductos;
    }

    public void setPromocionesProductos(ArrayList<ProductoEnPromocion> promocionesProductos) {
        this.promocionesProductos = promocionesProductos;
    }

    public ArrayList<PromocionTemporal> getPromocionesTemporales() {
        return promocionesTemporales;
    }

    public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales) {
        this.promocionesTemporales = promocionesTemporales;
    }

    public double getTotal(){
        //aplicar promociones de producto
        // recorrer promociones
        for ( ProductoEnPromocion producto : promocionesProductos){
            for ( Pedido pedido : pedidos){
                if (producto).equal(pedido){
                    total = producto.getPrecio();
                }
            }
        }
            // verificar dentro de la lista de items si coincide con el producto con descuento


        // aplicar promociones temporales
        return this.total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "fecha=" + fecha +
                ", mesa=" + mesa +
                ", pedidos=" + pedidos +
                ", total=" + total +
                ", formaDePago='" + formaDePago + '\'' +
                ", promociones=" + promociones +
                '}';
    }
}
