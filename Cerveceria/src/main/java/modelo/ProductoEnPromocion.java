package modelo;

import java.util.ArrayList;

public class ProductoEnPromocion {
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

    //FUNCIONALIDADES
}
