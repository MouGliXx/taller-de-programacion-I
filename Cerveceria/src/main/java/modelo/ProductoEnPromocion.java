package modelo;

import java.util.ArrayList;

public class ProductoEnPromocion {
    //FALTA VARIABLE ESTATICA QUE HAGA UNICOS LOS IDS
    private int idPromocion;
    private Producto producto;
    private ArrayList<String> diasPromocion;
    private boolean aplicaDosPorUno;
    private boolean aplicaDtoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double dtoPorCantidad_PrecioUnitario;
    private boolean activa;

    //CONSTRUCTOR
    public ProductoEnPromocion(int idPromocion, Producto producto, ArrayList<String> diasPromocion, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario, boolean activa) {
        this.idPromocion = idPromocion;
        this.producto = producto;
        this.diasPromocion = diasPromocion;
        this.aplicaDosPorUno = aplicaDosPorUno;
        this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
        this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
        this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
        this.activa = activa;
    }

    public ProductoEnPromocion(int idPromocion, Producto producto, ArrayList<String> diasPromocion, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad, boolean activa) {
        this.idPromocion = idPromocion;
        this.producto = producto;
        this.diasPromocion = diasPromocion;
        this.aplicaDosPorUno = aplicaDosPorUno;
        this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
        this.activa = activa;
    }

    //GETTERS && SETTERS
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<String> getDiasPromocion() {
        return diasPromocion;
    }

    public void setDiasPromocion(ArrayList<String> diasPromocion) {
        this.diasPromocion = diasPromocion;
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

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }


    //FUNCIONALIDADES
}
