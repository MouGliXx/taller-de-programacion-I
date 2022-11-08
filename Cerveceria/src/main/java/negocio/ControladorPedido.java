package negocio;

import modelo.Comanda;
import modelo.Pedido;
import modelo.Producto;
import vista.interfaces.IVistaPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPedido implements ActionListener {
    private Comanda comanda;
    private Pedido pedido;
    private IVistaPedido vista;

    public ControladorPedido(Comanda comanda, Pedido pedido, IVistaPedido vista) {
        this.comanda = comanda;
        this.pedido = pedido;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setItemListener();
        this.vista.inicializaComboBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Crear" -> {
                Producto producto = vista.getProductoSeleccionado();
                int cantidad = vista.getCantidadSeleccionada();
                try {
                    pedido = new Pedido(producto, cantidad);
                } catch (Exception ex) {
                    vista.lanzarVentanaEmergente(ex.getMessage());
                }
                comanda.agregarPedido(pedido);
                vista.cerrarVentana();
            }
            case "Cancelar" -> vista.cerrarVentana();
        }
    }
}