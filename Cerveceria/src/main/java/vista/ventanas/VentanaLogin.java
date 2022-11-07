package vista.ventanas;

import vista.interfaces.IVistaLogin;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

/**
 * Clase que representa la interfaz de Login.<br>
 */
public class VentanaLogin extends JFrame implements IVistaLogin, KeyListener {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JButton botonLogin;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JLabel ImagenCerveza;

    /**
     * Agrega los ActionListener a los diferentes componentes de la ventana.<br>
     *
     * <b>pre</b> controlador distinto de null.<br>
     * <b>post</b> Se ha asignado un ActionListener a los componentes que lo necesiten.<br>
     *
     * @param controlador Es la clase que recibe los eventos de acción de la ventana.
     */
    @Override
    public void setActionListener(ActionListener controlador) {
        this.botonLogin.addActionListener(controlador);
    }

    /**
     * Agrega los KeyListener especificados a los diferentes JTextField de la ventana.<br>
     *
     * <b>pre</b> Deben existir componentes JTextField dentro de la ventana.<br>
     * <b>post</b> Se ha asignado un KeyListener a los TextField que lo necesiten.<br>
     */
    @Override
    public void setKeyListener() {
        this.usernameTextField.addKeyListener(this);
        this.passwordTextField.addKeyListener(this);
    }

    /**
     * Agrega un WindowListener a la ventana, para notificar WindowEvent que ocurran desde esta ventana.<br>
     *
     * <b>pre</b> controlador distinto de null.<br>
     * <b>post</b> Se ha asignado un WindowListener a la ventana<br>
     * @param controlador Es la clase que recibe los WindowEvent de la ventana.
     */
    @Override
    public void setWindowListener(WindowListener controlador) {
        this.addWindowListener(controlador);
    }

    /**
     * Establece las caracteristicas principales que defininen a la ventana.<br>
     *
     * <b>post</b> Se ejecuta la ventana.<br>
     */
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

    /**
     * Oculta y cierra la ventana.<br>
     *
     * <b>post</b> Se detiene la ejecucion de la ventana.<br>
     */
    @Override
    public void cerrarVentana() {
        this.setVisible(false);
        dispose(); //Cierro la ventana
    }

    /**
     * Lanza una pequena ventana con un mensaje y boton de confirmacion.<br>
     *
     * <b>pre</b> mensaje distinto de null.<br>
     * <b>post</b> Se abre un JFrame con un mensaje.<br>
     * @param mensaje Es el mensaje que se desea mostrar en la ventana.<br>
     */
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
        botonLogin.setEnabled(!usernameTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty());
    }

    //METODOS NO USADOS
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
