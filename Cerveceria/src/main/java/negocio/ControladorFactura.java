package negocio;

import modelo.*;
import vista.interfaces.IVistaFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFactura implements ActionListener {
    private Factura modelo;
    private IVistaFactura vista;

    public ControladorFactura(Factura modelo, IVistaFactura vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setDatos(modelo.getFecha(), modelo.getMesa().getNro(), modelo.getPedidos(), modelo.getTotal(), modelo.getPromocionesAplicadas());
        this.vista.ejecutar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Crear" -> {
                String formaDePago = vista.getFormaDePago();
                this.modelo.setFormaDePago(formaDePago);
//                Cerveceria.getInstance().agregarFactura(modelo);
                this.vista.cerrarVentana();
            }
            case "Cancelar" -> vista.cerrarVentana();
        }
    }
}


