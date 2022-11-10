package modelo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private double total;
    private String formaDePago;
    private ArrayList<Promocion> promocionesAplicadas = new ArrayList<>();

    //CONSTRUCTOR
    public Factura(Mesa mesa, ArrayList<Pedido> pedidos) {
        this.fecha = new Date();
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.formaDePago = null;
        this.total = 0;
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
        this.total = 0.;
        this.formaDePago = formaDePago;
        this.calcularTotalconPromociones();
    }

    public ArrayList<Promocion> getPromocionesAplicadas() {return promocionesAplicadas;}

    //FUNCIONALIDADES
    public void calcularTotalconPromociones() {
        this.aplicarPromocionesProductos();
        this.aplicarPromocionesTemporales();
    }

    private void aplicarPromocionesTemporales() {
        ArrayList<PromocionTemporal> promoTemp = Cerveceria.getInstance().getPromocionesTemporales();

        for (PromocionTemporal promo : promoTemp)
            if (promo.isActiva() && coincideDiaSemana(promo.getDiasPromocion()) && promo.getFormaDePago().equalsIgnoreCase(this.getFormaDePago()) && promo.isEsAcumulable()) {
                promocionesAplicadas.add(promo);
                this.total = this.total * promo.getPorcentajeDescuento() / 100.;
            }
    }

    private void aplicarPromocionesProductos (){
        ArrayList<PromocionProducto> promoProd = Cerveceria.getInstance().getPromocionesProductos();
        boolean respuesta;
        PromocionProducto promo;
        int pos;

        for (Pedido pedido : this.pedidos) {
            pos = 0;
            respuesta = false;
            while(!respuesta && (pos < promoProd.size())){
                promo = promoProd.get(pos);
                if (pedido.getProducto().equals(promo.getProducto())) {
                    if (promo.isActiva() && coincideDiaSemana(promo.getDiasPromocion())) {
                        if (promo.isAplicaDosPorUno()) {
                            //aplicar 2x1 y sumar al total
                            this.total += (Math.divideExact(pedido.getCantidad(), 2) + Math.ceilMod(pedido.getCantidad(), 2)) * pedido.getProducto().getPrecioVenta();
                            respuesta = true;
                        } else if (promo.isAplicaDtoPorCantidad() && pedido.getCantidad() >= promo.getDtoPorCantidad_CantMinima()) {
                            //aplicar Dto por cantidad y sumar al total
                            this.total += promo.getDtoPorCantidad_PrecioUnitario() * pedido.getCantidad();
                            respuesta = true;
                        }
                    }
                }
                pos++;
            }
            if (respuesta) {
                pos--;
                promocionesAplicadas.add(promoProd.get(pos));
            } else {
                this.total += pedido.getProducto().getPrecioVenta() * pedido.getCantidad();
            }
        }
    }

    private boolean coincideDiaSemana(ArrayList<String> dias){
        int dia = new Date().getDay();
        String nombreDia = null;
        int pos = 0;
        boolean respuesta = false;

        switch (dia) {
            case 0 -> nombreDia = "Domingo";
            case 1 -> nombreDia = "Lunes";
            case 2 -> nombreDia = "Martes";
            case 3 -> nombreDia = "Miercoles";
            case 4 -> nombreDia = "Jueves";
            case 5 -> nombreDia = "Viernes";
            case 6 -> nombreDia = "Sabado";
        }

        while (pos < dias.size() && !respuesta) {
            if (nombreDia.equalsIgnoreCase(dias.get(pos++))) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    public double getTotal(){
        return this.total;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm:ss");
        String fechaActual = dateFormat.format(fecha);

        return  "Fecha: " + fechaActual +
                " - Mesa: " + mesa.getNro() +
                " - Pedidos: " + pedidos +
                " - Total = " + total +
                " - FormaDePago: " + formaDePago +
                " - PromocionesAplicadas:" + promocionesAplicadas;
    }
}
