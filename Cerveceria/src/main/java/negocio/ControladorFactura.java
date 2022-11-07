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
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cancelar" -> vista.cerrarVentana();
            case "Crear" -> {
                try {
                    String formaDePago = vista.getFormaDePago();
                    Cerveceria.getInstance().agregarFactura(modelo, formaDePago);
                    this.vista.cerrarVentana();
                } catch (Exception ex) {
                    vista.lanzarVentanaEmergente(ex.getMessage());
                }
            }

        }
    }
}


