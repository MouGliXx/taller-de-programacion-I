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

    //OPERARIO
    String getNombreCompletoOperario();

    String getNombreDeUsuario();

    String getContrasena();

    boolean getEstadoOperario();

    //MOZO
    String getNombreYApellidoMozo();

    int getEdadMozo();

    int getCantidadHijosMozo();

    String getEstadoMozo();

    //PRODUCTO
    int getIDProducto();

    int getStockInicial();

    String getNombreProducto();

    double getPrecioCosto();

    double getPrecioVenta();

    //MESA
    int getCantidadComensales();

    String getEstadoMesa();
}
