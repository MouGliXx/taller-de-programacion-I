package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura<Promocion> {

    Date fecha = new Date();
    Mesa mesa;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    double total;
    String formaDePago;
    ArrayList<IPromocion> promociones = new ArrayList<>();

    Factura(Date fecha, Mesa mesa, String formaDePago, ArrayList<Pedido> pedidos, ArrayList<IPromocion> promociones ){
        this.fecha= fecha;
        this.mesa = mesa;
        this.total = 0;
        this.formaDePago = formaDePago;
        this.pedidos = pedidos;
        this.promociones = promociones;
    }

    public double getTotal(){
        for ( Pedido pedido:pedidos){
            this.total = pedido.getPrecio();
        }

        return this.total;
    }
}
