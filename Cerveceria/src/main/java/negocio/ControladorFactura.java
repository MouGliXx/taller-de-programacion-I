package negocio;

import modelo.*;
import vista.interfaces.IVistaFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFactura implements ActionListener {
    private Comanda comanda;
    private Factura modelo;
    private IVistaFactura vista;

    public ControladorFactura(Comanda comanda, Factura modelo, IVistaFactura vista) {
        this.comanda = comanda;
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setDatos(modelo.getFecha(), modelo.getMesa().getNro(), modelo.getPedidos(), modelo.getPromocionesAplicadas());
        this.vista.setTotal(modelo.getTotal());
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cancelar" -> vista.cerrarVentana();
            case "Crear" -> {
                try {
                    Cerveceria.getInstance().agregarFactura(modelo);
                    Cerveceria.getInstance().eliminarComanda(comanda);
                    this.vista.cerrarVentana();
                } catch (Exception ex) {
                    vista.lanzarVentanaEmergente(ex.getMessage());
                }
            }
            case "Forma de Pago Seleccionada" -> {
                String formaDePago = vista.getFormaDePago();
                this.modelo.setFormaDePago(formaDePago);
                this.vista.setTotal(modelo.getTotal());
                this.vista.inicializarListas(modelo.getPedidos(), modelo.getPromocionesAplicadas());
            }
        }
    }
}


