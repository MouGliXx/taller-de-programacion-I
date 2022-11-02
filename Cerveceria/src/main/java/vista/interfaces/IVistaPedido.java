package vista.interfaces;

import modelo.Producto;
import java.util.HashMap;

public interface IVistaPedido extends IVista {

    void setItemListener();

    void setAccion(String accion);

    void setModelos();

    void inicializaComboBox(HashMap<Integer, Producto> productos);
}
