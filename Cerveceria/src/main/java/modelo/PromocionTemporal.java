package modelo;

import java.util.ArrayList;

public class PromocionTemporal extends Promocion {
    private String nombre;
    private String formaDePago;
    private int porcentajeDescuento;
    private boolean esAcumulable;

    //CONSTRUCTOR
    public PromocionTemporal(ArrayList<String> diasPromocion, boolean activa, String nombre, String formaDePago, int porcentajeDescuento, boolean esAcumulable) {
        super(diasPromocion, activa);
        this.nombre = nombre;
        this.formaDePago = formaDePago;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esAcumulable = esAcumulable;
    }

    //GETTERS && SETTERS

    //FUNCIONALIDADES
}
