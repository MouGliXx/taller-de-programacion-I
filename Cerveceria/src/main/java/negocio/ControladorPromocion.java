package negocio;

import modelo.PromocionProducto;
import modelo.PromocionTemporal;
import vista.interfaces.IVistaPromocion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPromocion implements ActionListener {
    IVistaPromocion vista;

    public ControladorPromocion(IVistaPromocion vista) {
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setKeyListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Establecer" -> {
                switch (vista.getTipoPromocion()) {
                    case "Producto en Promocion" -> {
                        PromocionProducto productoEnPromocion = this.vista.getProductoEnPromocion();
                        //TODO GUARDAR PROMOCION
                    }
                    case "Promocion Temporal" -> {
                        PromocionTemporal promocionTemporal = this.vista.getPromocionTemporal();
                        //TODO GUARDAR PROMOCION
                    }
                }
                this.vista.cerrarVentana();
            }
            case "Cancelar" -> this.vista.cerrarVentana();
        }
    }
}
