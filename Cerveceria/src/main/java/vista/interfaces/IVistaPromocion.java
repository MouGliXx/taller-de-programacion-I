package vista.interfaces;

import modelo.Producto;
import java.util.ArrayList;
import java.util.HashMap;

public interface IVistaPromocion extends IVista{

    void setKeyListener();

    void setModelos();

    void setDatos(int id, HashMap<Integer, Producto> productos);

    void setPromocion(String promocion);

    String getTipoPromocion();

    //PROMOCION
    ArrayList<String> getDiasDePromocion();

    boolean isActiva();

    //PRODUCTO EN PROMOCION
    Producto getProducto();

    boolean getAplica2x1();

    boolean getAplicaDescuentoXCantidad();

    int getCantidadMinima();

    double getPrecioUnitario();

    //PROMOCION TEMPORAL
    String getNombrePromocion() throws Exception;

    int getPorcentajeDescuento();

    String getFormaDePago();

    boolean isAcumulable();
}
