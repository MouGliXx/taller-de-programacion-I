package vista.interfaces;

import modelo.PromocionProducto;
import modelo.PromocionTemporal;

import java.util.ArrayList;

public interface IVistaPromocion extends IVista{

    void setKeyListener();

    void setModelos();

    void setPromocion(String promocion);

    String getTipoPromocion();

    ArrayList<String> generaDiasDePromocion();

    PromocionProducto getProductoEnPromocion();

    PromocionTemporal getPromocionTemporal();
}
