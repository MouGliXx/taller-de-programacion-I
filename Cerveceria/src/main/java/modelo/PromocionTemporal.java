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
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEsAcumulable() {
        return esAcumulable;
    }

    public void setEsAcumulable(boolean esAcumulable) {
        this.esAcumulable = esAcumulable;
    }

    //FUNCIONALIDADES

}
