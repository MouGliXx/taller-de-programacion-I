package negocio;

import modelo.Comanda;
import modelo.Pedido;
import vista.IVistaComanda;
import vista.VentanaPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorComanda implements ActionListener {
    private Comanda comanda;
    private IVistaComanda vista;

    public ControladorComanda(Comanda comanda, IVistaComanda vista) {
        this.comanda = comanda;
        this.vista = vista;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
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
                //ACA TENGO QUE OBTENER EL PEDIDO SELECCIONADO
//                ControladorPedido controladorPedido = new ControladorPedido(nuevoPedido, ventanaPedido);
                ventanaPedido.ejecutar();
            }
            case "Eliminar Pedido" -> {

            }
            case "Accion" -> {
                //ACA DEBO GUARDAR/SOBREESCRIBIR LA COMANDA
            }
            case "Cancelar" -> vista.cerrarVentana();
        }
    }

    public void creaOtraVentana(String ventana) {
        switch (ventana) {
            case "Nuevo Pedido":
                VentanaPedido ventanaPedido = new VentanaPedido();
                Pedido pedido = new Pedido();
                ControladorPedido controladorPedido = new ControladorPedido(pedido, ventanaPedido);
                ventanaPedido.ejecutar();
                break;
        }
    }
}
