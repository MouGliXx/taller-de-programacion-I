package vista.interfaces;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;

public interface IVistaEntidad extends IVista {

    void setKeyListener();

    void setAccion(String accion);

    void setEntidad(String entidad);

    String getEntidad();

    Operario getOperario();

    Mozo getMozo();

    Producto getProducto();

    Mesa getMesa();
}
