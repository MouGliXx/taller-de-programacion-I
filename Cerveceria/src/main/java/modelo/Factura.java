package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private double total;
    private String formaDePago;
    private ArrayList<PromocionProducto> promocionesProductosAplicadas;
    private ArrayList<PromocionTemporal> promocionesTemporalesAplicadas;
    private ArrayList<Promocion> promocionesAplicadas;
    //CONSTRUCTOR
    public Factura(Mesa mesa, ArrayList<Pedido> pedidos,String formaPago) {
        this.fecha = new Date();
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.formaDePago = formaPago;
        this.total = calculaTotal();
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

    public ArrayList<PromocionProducto> getPromocionesProductosAplicadas() {
        return promocionesProductosAplicadas;
    }

    public void setPromocionesProductosAplicadas(ArrayList<PromocionProducto> promocionesProductosAplicadas) {
        this.promocionesProductosAplicadas = promocionesProductosAplicadas;
    }

    public ArrayList<Promocion> getPromocionesAplicadas() {
        return promocionesAplicadas;
    }

    //FUNCIONALIDADES
    public void aplicarPromocionesTemporales() {
        ArrayList<PromocionTemporal> promoTempAplicar = new ArrayList<PromocionTemporal>();
        ArrayList<PromocionTemporal> promoTemp = Cerveceria.getInstance().getPromocionesTemporales();
        for (PromocionTemporal promos : promoTemp)
            if (promos.isActiva())
                promoTempAplicar.add(promos);
    }

    private void aplicarPromocionesProductos(){}

    private boolean productoEstaEnPromocion (Producto producto){
        boolean respuesta = false;
        int pos = 0;
        ArrayList<PromocionProducto> promoProd =  Cerveceria.getInstance().getPromocionesProductos();
        while (!respuesta && pos<promoProd.size()) {
            if (promoProd.get(pos++).getProducto().equals(producto))
                respuesta = true;
        }
        return respuesta;
    }

    public double calculaTotal() { //TODO REFACTORIZAR
        //aplicar promociones de producto
        // recorrer promociones
//        for (ProductoEnPromocion producto : promocionesProductos){
//            for ( Pedido pedido : pedidos){
//                if (producto.equals(pedido)) {
//                    total = producto.getPrecio();
//                }
//            }
//        }
        // verificar dentro de la lista de items si coincide con el producto con descuento
        // aplicar promociones temporales
        return 2.2;
    }

    public double getTotal(){
        return this.total;
    }

    @Override
    public String toString() {
        return  "fecha= " + fecha +
                ", mesa=" + mesa +
                ", pedidos=" + pedidos +
                ", total=" + total +
                ", formaDePago='" + formaDePago + '\'' +
                ", promocionesAplicadas=" + promocionesProductosAplicadas + promocionesTemporalesAplicadas;
    }
}
