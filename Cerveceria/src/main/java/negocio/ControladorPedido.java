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

    public ControladorPedido(Comanda comanda, Pedido modelo, IVistaPedido vista) {
        this.comanda = comanda;
        this.pedido = modelo;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setItemListener();
        this.vista.inicializaComboBox(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Accion" -> {
                Producto producto = vista.getProductoSeleccionado();
                int cantidad = vista.getCantidadSeleccionada();

                if (pedido == null) {
                    pedido = new Pedido(producto, cantidad);
                } else {
                    pedido.setProducto(producto);
                    pedido.setCantidad(cantidad);
                }

                comanda.agregarPedido(pedido); //TODO NO ME SIRVE, NECESITO QUE ME DISCRIMINE ENTRE UNA NUEVA Y UNA YA EXISTENTE
                vista.cerrarVentana();
            }
            case "Cancelar" -> vista.cerrarVentana();
        }
    }
}