package modelo;

import java.util.ArrayList;

public class ProductoEnPromocion {
    int idPromocion;
    Producto producto;
    ArrayList<String> diasPromocion=new ArrayList<String>();
    boolean aplicaDosPorUno;
    boolean aplicaDtoPorCantidad;
    int dtoPorCantidad_CantMinima;
    double dtoPorCantidad_PrecioUnitario;
    boolean activa;
}
