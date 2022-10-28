package vista.ventanas;

import vista.interfaces.IVistaPromocion;
import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaPromocion extends JFrame implements IVistaPromocion {
    private JPanel panelPrincipal;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private JTabbedPane panelCentral;
    private JPanel productoEnPromocionPanel;
    private JPanel promocionTemporalPanel;
    private JLabel nuevaPromocionLabel;
    private JButton establecerButton;
    private JButton cancelarButton;
    private JLabel idProductoLabel;
    private JLabel IDLabel;
    private JComboBox estadoMesaComboBox;
    private JPanel primerafilaPanel1;
    private JPanel atriibutosEnComunPanel;
    private JCheckBox lunesCheckBox;
    private JCheckBox domingoCheckBox;
    private JCheckBox martesCheckBox;
    private JPanel segundaFilaPanel1;
    private JCheckBox sabadoCheckBox;
    private JCheckBox miercolesCheckBox;
    private JCheckBox juevesCheckBox;
    private JCheckBox viernesCheckBox;
    private JLabel diasDePromoLabel;
    private JCheckBox activaCheckBox;
    private JLabel productoLabel;
    private JCheckBox aplicaDescuentoXCantidadCheckBox;
    private JCheckBox aplica2x1CheckBox;
    private JPanel terceraFilaPanel1;
    private JLabel cantidadMinimaLabel;
    private JTextField cantidadMinimaTextField;
    private JLabel precioUnitarioLabel;
    private JComboBox porcentajeComboBox;
    private JLabel porcentajeDeDescuentoLabel;
    private JLabel nombreLabel;
    private JTextField nombrePromocionTextField;
    private JPanel primeraFilaPanel2;
    private JPanel segundaFilaPanel2;
    private JLabel formasDePagoLabel;

    @Override
    public void setActionListener(ActionListener controlador) {

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
}
