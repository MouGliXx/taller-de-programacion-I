package vista.interfaces;

import modelo.ProductoEnPromocion;
import modelo.PromocionTemporal;

import java.util.ArrayList;

public interface IVistaPromocion extends IVista{

    void setKeyListener();

    void setModelos();

    void setPromocion(String promocion);

    String getTipoPromocion();

    ArrayList<String> generaDiasDePromocion();

    ProductoEnPromocion getProductoEnPromocion();

    PromocionTemporal getPromocionTemporal();
}
