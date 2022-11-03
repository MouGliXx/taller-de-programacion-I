package vista.ventanas;

import modelo.Cerveceria;
import modelo.Mesa;
import modelo.Pedido;
import vista.interfaces.IVistaComanda;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VentanaComanda extends JFrame implements IVistaComanda, ActionListener, ListSelectionListener {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JLabel accionComandaLabel;
    private JLabel fechaLabel;
    private JLabel fechaActualLabel;
    private JComboBox<String> mesaComboBox;
    private JLabel listadoDePedidosAsignadosLabel;
    private JButton accionButton;
    private JList<Pedido> listaPedidosAsignados;
    private JButton nuevoPedidoButton;
    private JButton eliminarPedidoButton;
    private JPanel fechayMesaPnael;
    private JLabel mesaLabel;
    private JButton cancelarButton;
    private JScrollPane pedidosScrollPane;
    //MODELOS
    DefaultListModel<Pedido> modeloPedidos = new DefaultListModel<>();
    DefaultComboBoxModel<String> modeloMesas = new DefaultComboBoxModel<>();

    @Override
    public void setActionListener(ActionListener controlador) {
        //BOTONES
        nuevoPedidoButton.addActionListener(controlador);
        eliminarPedidoButton.addActionListener(controlador);
        accionButton.addActionListener(controlador);
        cancelarButton.addActionListener(controlador);
        //COMBO BOX
        mesaComboBox.addActionListener(this);
    }

    @Override
    public void setListSelectionListener() {
        listaPedidosAsignados.addListSelectionListener(this);
    }

    @Override
    public void setWindowListener(WindowListener controlador) {
        this.addWindowListener(controlador);
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
        this.mesaComboBox.setModel(modeloMesas);
    }

    @Override
    public void inicializaComboBox(Mesa mesa) {
        if (mesa != null) {
            this.mesaComboBox.setEnabled(false);
            this.accionButton.setEnabled(true);

            modeloMesas.removeAllElements();
            modeloMesas.addElement(String.valueOf(mesa.getNro()));
        } else {
            ArrayList<Mesa> mesas = Cerveceria.getInstance().getMesas();

            modeloMesas.removeAllElements();
            modeloMesas.addElement(null);
            for (Mesa mesaActual : mesas) {
                if (mesaActual.getEstado().equalsIgnoreCase("Libre")) {
                    modeloMesas.addElement(String.valueOf(mesaActual.getNro()));
                }
            }
        }
    }

    @Override
    public void inicializarLista(ArrayList<Pedido> pedidos) {
        if (!pedidos.isEmpty()) {
            this.accionButton.setEnabled(true);

            modeloPedidos.removeAllElements();
            pedidos.forEach((pedido) -> {
                modeloPedidos.add(modeloPedidos.size(), pedido);
            });
        }
    }

    @Override
    public int getNroMesa() {
        return Integer.parseInt(modeloMesas.getElementAt(mesaComboBox.getSelectedIndex()));
    }

    @Override
    public ArrayList<Pedido> getPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        for (int i = 0; i < modeloPedidos.size(); i++) {
            pedidos.add(modeloPedidos.getElementAt(i));
        }

        return pedidos;
    }

    @Override
    public void eliminaPedidoEnLista() {
        if (!modeloPedidos.isEmpty()) {
            this.modeloPedidos.removeElementAt(listaPedidosAsignados.getSelectedIndex());
        }
    }

    @Override
    public Pedido getPedidoSeleccionado() {
        return (this.listaPedidosAsignados == null ? null : (Pedido) this.listaPedidosAsignados.getSelectedValue());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.nuevoPedidoButton.setEnabled(false);
        this.accionButton.setEnabled(false);

        switch (e.getActionCommand()) {
            case "Selecciona Mesa" -> {
                if (this.mesaComboBox.getSelectedIndex() != -1) {
                    this.accionButton.setEnabled(true);
                    this.nuevoPedidoButton.setEnabled(true);
                }
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.eliminarPedidoButton.setEnabled(false);
        this.accionButton.setEnabled(false);

        if (listaPedidosAsignados.getSelectedValue() != null) {
            this.eliminarPedidoButton.setEnabled(true);
        }

        if (this.mesaComboBox.getSelectedIndex() != -1) {
            this.accionButton.setEnabled(true);
            this.nuevoPedidoButton.setEnabled(true);
        }
    }
}
