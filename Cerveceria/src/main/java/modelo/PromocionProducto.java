package modelo;

import java.util.ArrayList;

public class PromocionProducto extends Promocion {
    private Producto producto;
    private boolean aplicaDosPorUno;
    private boolean aplicaDtoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double dtoPorCantidad_PrecioUnitario;

    //CONSTRUCTOR
    public PromocionProducto(ArrayList<String> diasPromocion, boolean activa, Producto producto, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario) {
        super(diasPromocion, activa);
        this.producto = producto;
        this.aplicaDosPorUno = aplicaDosPorUno;
        this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
        this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
        this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
    }

    public PromocionProducto(Producto producto, ArrayList<String> diasPromocion, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario, boolean activa) {
        super(diasPromocion, activa);
        this.producto = producto;
        this.aplicaDosPorUno = aplicaDosPorUno;
        this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
        this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
        this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
    }

    public PromocionProducto(Producto producto, ArrayList<String> diasPromocion, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad, boolean activa) {
        super(diasPromocion, activa);
        this.producto = producto;
        this.aplicaDosPorUno = aplicaDosPorUno;
        this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
    }

    //GETTERS && SETTERS
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isAplicaDosPorUno() {
        return aplicaDosPorUno;
    }

    public void setAplicaDosPorUno(boolean aplicaDosPorUno) {
        this.aplicaDosPorUno = aplicaDosPorUno;
    }

    public boolean isAplicaDtoPorCantidad() {
        return aplicaDtoPorCantidad;
    }

    public void setAplicaDtoPorCantidad(boolean aplicaDtoPorCantidad) {
        this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
    }

    public int getDtoPorCantidad_CantMinima() {
        return dtoPorCantidad_CantMinima;
    }

    public void setDtoPorCantidad_CantMinima(int dtoPorCantidad_CantMinima) {
        this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
    }

    public double getDtoPorCantidad_PrecioUnitario() {
        return dtoPorCantidad_PrecioUnitario;
    }

    public void setDtoPorCantidad_PrecioUnitario(double dtoPorCantidad_PrecioUnitario) {
        this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
    }

    //FUNCIONALIDADES
    public double getPrecio() {
        return producto.getPrecioVenta();
    }
}
