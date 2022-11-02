package vista.ventanas;

import modelo.IPromocion;
import modelo.Pedido;
import vista.interfaces.IVistaFactura;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VentanaFactura extends JFrame implements IVistaFactura {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JLabel accionComandaLabel;
    private JPanel fechayMesaPnael;
    private JLabel fechaLabel;
    private JLabel fechaActualLabel;
    private JLabel mesaLabel;
    private JLabel listadoDePedidosAsignadosLabel;
    private JLabel promocionesAplicadasLabel;
    private JLabel numeroMesaLabel;
    private JList listaProductos;
    private JList listaPromociones;
    private JScrollPane productosScrollPane;
    private JScrollPane promocionesScrollPane;
    private JComboBox<String> formasDePagoBox;
    private JButton cancelarButton;
    private JButton crearButton;
    private JLabel formasDePagoLabel;
    private JLabel totalLabel;
    private JLabel montoLabel;
    //MODELOS PARA LISTA
    DefaultListModel<Pedido> modeloProductos = new DefaultListModel<>();
    DefaultListModel<IPromocion> modeloPromociones = new DefaultListModel<>();

    //GETTERS & SETTERS

    //FUNCIONALIDADES
    @Override
    public void setActionListener(ActionListener controlador) {
        this.crearButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
    }

    @Override
    public void setWindowListener(WindowListener controlador) {

    }

    @Override
    public void ejecutar() {
        setTitle("Cerveceria - Grupo 1");
        pack(); //Coloca los componentes
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setSize(960,720); //Dimensiones del JFrame
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
    public void setModelos() {
        this.listaProductos.setModel(modeloProductos);
        this.listaPromociones.setModel(modeloPromociones);
    }

    @Override
    public void inicializarListas(ArrayList<Pedido> pedidos, ArrayList<IPromocion> promociones) {
        pedidos.forEach((pedido) -> {
            modeloProductos.add(modeloProductos.size(), pedido);
        });

        promociones.forEach((promocion) -> {
            modeloPromociones.add(modeloPromociones.size(), promocion);
        });
    }

    @Override
    public void setDatos(Date fecha, int NMesa, ArrayList<Pedido> pedidos, double total, ArrayList<IPromocion> promociones) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm:ss");
        String fechaActual = dateFormat.format(fecha);

        this.fechaActualLabel.setText(fechaActual);
        this.numeroMesaLabel.setText(String.valueOf(NMesa));
        inicializarListas(pedidos, promociones);
        this.montoLabel.setText(String.valueOf(total));
    }

    @Override
    public String getFormaDePago() {
        return (String) formasDePagoBox.getSelectedItem();
    }
}
