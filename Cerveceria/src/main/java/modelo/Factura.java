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
        this.aplicarPromocionesProductos();
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

    /**
     * Cambia la forma de pago de la factura haciendo el calculo del total, llamando a los metodos aplicarPromocionesProductos
     * y aplicarPromocionesTemporales
     *
     * <b>pre:</b>forma de pago distinto de null<br>.
     * @param formaDePago forma en que se va a pagar la factura
     *
     * <b>post:</b> La factura tendra un valor total calculado<br>.
     */
    public void setFormaDePago(String formaDePago) {
        this.total = 0.;
        this.formaDePago = formaDePago;
        this.promocionesAplicadas.clear();

        this.aplicarPromocionesProductos();
        this.aplicarPromocionesTemporales();
    }

    public ArrayList<Promocion> getPromocionesAplicadas() {
        return promocionesAplicadas;
    }

    //FUNCIONALIDADES

    /**
     * Verifica la existencia de promociones temporales que se puedan aplicarse al total de la  factura
     *
     * <b>pre:</b>la coleccion de promociones temporales debe existir<br>.
     *
     * <b>post:</b> y la promocion coincide con la factura se agregara un elemento nuevo a la coleccion de promociones aplicadas y se aplicara el descuento<br>.
     */
    public void aplicarPromocionesTemporales() {
        ArrayList<PromocionTemporal> promoTemp = Cerveceria.getInstance().getPromocionesTemporales();
        for (PromocionTemporal promo : promoTemp) {
            if (promo.isActiva() && coincideDiaSemana(promo.getDiasPromocion()) && promo.getFormaDePago().equalsIgnoreCase(this.formaDePago) && promo.isEsAcumulable()) {
                promocionesAplicadas.add(promo);
                this.total = this.total * (1-promo.getPorcentajeDescuento() / 100.);
            }
        }
    }

    /**
     * Verifica la existencia de promociones de productos que se puedan aplicarse a los producots  de la  factura
     *
     * <b>pre:</b>la coleccion de promociones productos debe existir<br>.
     *
     * <b>post:</b> si la promocion coincide con los productos y parametros de la  factura se agregara un elemento
     * nuevo a la coleccion de promociones aplicadas y se aplicara el descuento<br>.
     */
    public void aplicarPromocionesProductos (){
        ArrayList<PromocionProducto> promoProd = Cerveceria.getInstance().getPromocionesProductos();
        boolean respuesta;
        PromocionProducto promo;
        int pos;


        for (Pedido pedido : this.pedidos) {
            System.out.println(promoProd.size());
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


    /**
     * Verifica la coincidencia de un los dias de la semana que aplica una promocion con el dia actual
     *
     * <b>pre:</b>la coleccion de promociones productos debe existir<br>.
     * @param dias coleccion de dias en los cuales aplica la promocion
     *
     * @return respuesta valor booleano que indica si coincide el dia o no.
     */
    public boolean coincideDiaSemana(ArrayList<String> dias){
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
