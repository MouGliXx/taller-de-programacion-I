package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private double total;
    private String formaDePago;
    private ArrayList<IPromocion> promociones;

    //CONSTRUCTOR
    public Factura(Date fecha, Mesa mesa, ArrayList<Pedido> pedidos, double total, ArrayList<IPromocion> promociones) {
        this.fecha = fecha;
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.total = total;
        this.promociones = promociones;
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

    public ArrayList<IPromocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(ArrayList<IPromocion> promociones) {
        this.promociones = promociones;
    }

    public double getTotal(){
        for ( Pedido pedido:pedidos){
            this.total = pedido.getPrecio();
        }

        return this.total;
    }
}
