package vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class VentanaAdministrador extends JFrame implements IVistaAdministrador {

    private JPanel panelPrincipal;
    private JPanel panelIzquierdo;
    private JButton estadisticasButton;
    private JButton promocionesButton1;
    private JButton entidadesButton;
    private JButton productosButton;
    private JLabel ImagenCerveza;
    private JButton inicioButton;
    private JTabbedPane panelCentral;
    private JPanel inicioPanel;
    private JLabel bienvenidoLabel;
    private JButton cerrarSesionButton;
    private JLabel cerveceriaLabel;
    private JLabel nombreApellidoLabel;
    private JPanel entidadesPanel;
    private JLabel entidadesLabel;
    private JList listaEntidades;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton editarTituloButton;
    private JLabel remuneracionBasicaLabel;
    private JLabel montoLabel;
    private JButton editarRemuneracionButton;
    private JPanel remuneracionPanel;
    private JPanel checkBoxPanel;
    private JCheckBox operariosCheckBox;
    private JPanel productosPanel;
    private JLabel productosLabel;
    private JLabel listadoDeProductosEnPromocionLabel;
    private JList listaProductosEnPromocion;
    private JButton nuevaComandaButton;
    private JButton cerrarComandaButton;
    private JButton desactivarButton;
    private JButton activarButton;
    private JPanel promocionesPanel;
    private JLabel promocionesLabel;
    private JButton nuevaPromocionTemporalButton;
    private JButton eliminarPromocionTemporalButton;
    private JLabel listadoDePromocionesTemporalesLabel;
    private JButton desactivarPTButton;
    private JButton activarPTButton;
    private JList listaPromocionesTemporales;

    @Override
    public void setActionListener(ActionListener controlador) {

    }

    @Override
    public void setWindowListener(WindowListener controlador) {

    }

    @Override
    public void ejecutar() {
        setTitle("Cerveceria - Grupo 1");
        pack(); //Coloca los componentes
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1280,720); //Dimensiones del JFrame
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
