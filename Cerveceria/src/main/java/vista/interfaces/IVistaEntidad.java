package vista.interfaces;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;

public interface IVistaEntidad extends IVista {

    void setKeyListener();

    void setAccion(String accion);

    void setEntidad(String entidad);

    void setDatosOperario(Operario operario);

    void setDatosMozo(Mozo mozo);

    void setDatosProducto(Producto producto);

    void setDatosMesa(Mesa mesa);

    String getEntidad();

    Operario getOperario();

    Mozo getMozo();

    Producto getProducto();

    Mesa getMesa();
}
