package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private double total;
    private String formaDePago;
    private ArrayList<Promocion> promocionesAplicadas;

    //CONSTRUCTOR
    public Factura(Date fecha, Mesa mesa, ArrayList<Pedido> pedidos, double total, ArrayList<Promocion> promocionesAplicadas) {
        this.fecha = fecha;
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.total = total;
        this.formaDePago = null;
        this.promocionesAplicadas = promocionesAplicadas;
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

    public ArrayList<Promocion> getPromocionesAplicadas() {
        return promocionesAplicadas;
    }

    public void setPromocionesAplicadas(ArrayList<Promocion> promocionesAplicadas) {
        this.promocionesAplicadas = promocionesAplicadas;
    }

    public double getTotal(){
        //aplicar promociones de producto
        // recorrer promociones
//        for (ProductoEnPromocion producto : promocionesProductos){ //TODO REFACTORIZAR
//            for ( Pedido pedido : pedidos){
//                if (producto.equals(pedido)) {
//                    total = producto.getPrecio();
//                }
//            }
//        }
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
                ", promocionesAplicadas=" + promocionesAplicadas +
                '}';
    }
}
