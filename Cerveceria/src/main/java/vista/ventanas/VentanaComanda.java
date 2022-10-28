package vista.ventanas;

import modelo.Pedido;
import vista.interfaces.IVistaComanda;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VentanaComanda extends JFrame implements IVistaComanda {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JLabel accionComandaLabel;
    private JLabel fechaLabel;
    private JLabel fechaActualLabel;
    private JComboBox comboBox1;
    private JLabel listadoDePedidosAsignadosLabel;
    private JButton accionButton;
    private JList listaPedidosAsignados;
    private JButton nuevoPedidoButton;
    private JButton editarPedidoButton;
    private JButton eliminarPedidoButton;
    private JPanel fechayMesaPnael;
    private JLabel mesaLabel;
    private JButton cancelarButton;
    //MODELOS PARA LISTA
    DefaultListModel<Pedido> modeloPedidos = new DefaultListModel<>();

    @Override
    public void setActionListener(ActionListener controlador) {
        nuevoPedidoButton.addActionListener(controlador);
        editarPedidoButton.addActionListener(controlador);
        eliminarPedidoButton.addActionListener(controlador);
        accionButton.addActionListener(controlador);
        cancelarButton.addActionListener(controlador);
    }

    @Override
    public void ejecutar() {
        setTitle("Cerveceria - Grupo 1");
        pack(); //Coloca los componentes
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setSize(800,600); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
        setModelos();
    }

    @Override
    public void cerrarVentana() {
        setVisible(false); //Oculto la ventana
        dispose(); //Cierro la ventana
    }

    @Override
    public void lanzarVentanaEmergente(String mensaje) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }

    @Override
    public void setAccion(String accion) {
        this.accionComandaLabel.setText(accion + " comanda");
        this.accionButton.setText(accion);
    }

    @Override
    public void setFecha(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm:ss");
        String fechaActual = dateFormat.format(new Date());
        this.fechaActualLabel.setText(fechaActual);
    }

    @Override
    public void setModelos() {
        this.listaPedidosAsignados.setModel(modeloPedidos);
    }

    @Override
    public void inicializarLista(ArrayList<Pedido> pedidos) {
        pedidos.forEach((pedido) -> {
            modeloPedidos.add(modeloPedidos.size(), pedido);
        });
    }

    @Override
    public Pedido getPedidoSeleccionado() {
        return (this.listaPedidosAsignados == null ? null : (Pedido) this.listaPedidosAsignados.getSelectedValue());
    }
}
