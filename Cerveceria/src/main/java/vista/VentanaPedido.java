package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaPedido extends JFrame implements IVistaPedido {
    private JPanel panelPrincipal;
    private JLabel accionPedidoLabel;
    private JPanel panelCentral;
    private JLabel productoLabel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton cancelarButton;
    private JLabel cantidadLabel;
    private JButton accionButton;

    //GETTERS & SETTERS


    //FUNCIONALIDADES
    @Override
    public void setActionListener(ActionListener controlador) {
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
        setSize(800,440); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
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
        this.accionPedidoLabel.setText(accion + " comanda");
        this.accionButton.setText(accion);
    }
}
