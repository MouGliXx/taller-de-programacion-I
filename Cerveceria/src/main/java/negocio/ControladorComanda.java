package negocio;

import modelo.*;
import vista.interfaces.IVistaComanda;
import vista.ventanas.VentanaPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorComanda implements ActionListener, WindowListener {
    private Comanda modelo;
    private IVistaComanda vista;

    public ControladorComanda(Comanda modelo, IVistaComanda vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setListSelectionListener();
        this.vista.setFecha(modelo.getFecha());
        this.vista.inicializaComboBox(modelo.getMesa());
        this.vista.inicializarLista(modelo.getPedidos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nuevo Pedido" -> {
                creaOtraVentana("Nuevo Pedido");
            }
            case "Eliminar Pedido" -> {
                Pedido pedidoSeleccionado = vista.getPedidoSeleccionado();
                modelo.eliminarPedido(pedidoSeleccionado);
                vista.eliminaPedidoEnLista();
            }
            case "Accion" -> {
                Mesa mesa = Cerveceria.getInstance().getMesas().get(vista.getNroMesa() - 1); //TODO RESOLVER TEMA BARRA [index = nroMesa???]
                ArrayList<Pedido> pedidos = vista.getPedidos();

                if (mesa.getEstado().equals("Libre")) {
                    try {
                        Cerveceria.getInstance().agregarComanda(mesa, pedidos);
                    } catch (Exception ex) {
                        vista.lanzarVentanaEmergente(ex.getMessage());
                    }
                } else {
                    //TODO METODO EDITAR COMANDA
                    System.out.println("METODO EDITAR COMANDA");
                }

                vista.cerrarVentana();
            }
            case "Cancelar" -> vista.cerrarVentana();
        }
    }

    public void creaOtraVentana(String ventana) {
        VentanaPedido ventanaPedido = new VentanaPedido();
        ventanaPedido.setWindowListener(this);
        ControladorPedido controladorPedido = new ControladorPedido(modelo, null, ventanaPedido);
        ventanaPedido.ejecutar();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        vista.inicializarLista(modelo.getPedidos());
    }

    //METODOS NO USADOS
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
