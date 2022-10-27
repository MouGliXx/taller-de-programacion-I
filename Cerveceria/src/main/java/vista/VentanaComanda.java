package vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaComanda extends JFrame implements IVistaComanda {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JLabel accionComandaLabel;
    private JLabel fechaLabel;
    private JLabel fechaActualLabel;
    private JComboBox comboBox1;
    private JLabel listadoDeComandasAbiertasLabel;
    private JButton accionButton;
    private JList list1;
    private JButton nuevoPedidoButton;
    private JButton editarPedidoButton;
    private JButton eliminarPedidoButton;
    private JPanel fechayMesaPnael;
    private JLabel mesaLabel;
    private JButton cancelarButton;

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
        setFecha();
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
    public void setFecha() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm");
        String fechaActual = dateFormat.format(new Date());
        this.fechaActualLabel.setText(fechaActual);
    }
}
