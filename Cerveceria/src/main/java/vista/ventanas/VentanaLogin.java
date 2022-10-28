package vista.ventanas;

import vista.interfaces.IVistaLogin;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

public class VentanaLogin extends JFrame implements IVistaLogin, KeyListener {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JButton botonLogin;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JLabel ImagenCerveza;

    @Override
    public void setActionListener(ActionListener controlador) {
        this.botonLogin.addActionListener(controlador);
    }

    @Override
    public void setKeyListener() {
        this.usernameTextField.addKeyListener(this);
        this.passwordTextField.addKeyListener(this);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(650,650); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
    }

    @Override
    public void cerrarVentana() {
        dispose(); //Cierro la ventana
    }

    @Override
    public void lanzarVentanaEmergente(String mensaje) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }

    @Override
    public String getUsername() {
        return this.usernameTextField.getText();
    }

    @Override
    public String getPassword() {
        return this.passwordTextField.getText();
    }

    @Override
    public void nombreUsuarioInvalido() {
        usernameTextField.setText("");
        passwordTextField.setText("");
        botonLogin.setEnabled(false);
    }

    @Override
    public void contrasenaInvalida() {
        passwordTextField.setText("");
        botonLogin.setEnabled(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            botonLogin.setEnabled(false);
        } else {
            botonLogin.setEnabled(true);
        }
    }

    //METODOS NO USADOS
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
