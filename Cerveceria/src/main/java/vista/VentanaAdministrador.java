package vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class VentanaAdministrador extends JFrame implements IVistaAdministrador {

    private JPanel panelPrincipal;

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

    }

    @Override
    public void lanzarVentanaEmergente(String mensaje) {

    }
}
