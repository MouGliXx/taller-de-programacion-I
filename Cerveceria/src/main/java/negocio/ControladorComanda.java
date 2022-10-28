package negocio;

import modelo.Comanda;
import modelo.Pedido;
import vista.interfaces.IVistaComanda;
import vista.ventanas.VentanaPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorComanda implements ActionListener {
    private Comanda modelo;
    private IVistaComanda vista;

    public ControladorComanda(Comanda modelo, IVistaComanda vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setFecha(modelo.getFecha());
        this.vista.inicializarLista(modelo.getPedidos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nuevo Pedido" -> creaOtraVentana("Nuevo Pedido");
            case "Editar Pedido" -> creaOtraVentana("Editar Pedido");
            case "Eliminar Pedido" -> {
                Pedido pedidoSeleccionado = vista.getPedidoSeleccionado();
                //ACA TENGO QUE ELIMINAR DEL ARRAY EL PEDIDO
            }
            case "Accion" -> {
                //ACA DEBO GUARDAR/SOBREESCRIBIR LA COMANDA
            }
            case "Cancelar" -> vista.cerrarVentana();
        }
    }

    public void creaOtraVentana(String ventana) {
        switch (ventana) {
            case "Nuevo Pedido" -> {
                VentanaPedido ventanaPedido = new VentanaPedido();
                ventanaPedido.setAccion("Nuevo");
                Pedido nuevoPedido = new Pedido();
                ControladorPedido controladorPedido = new ControladorPedido(nuevoPedido, ventanaPedido);
                ventanaPedido.ejecutar();
            }
            case "Editar Pedido" -> {
                VentanaPedido ventanaPedido = new VentanaPedido();
                ventanaPedido.setAccion("Editar");
                Pedido pedidoSeleccionado = vista.getPedidoSeleccionado();
                ControladorPedido controladorPedido = new ControladorPedido(pedidoSeleccionado, ventanaPedido);
                ventanaPedido.ejecutar();
            }
        }
    }
}
