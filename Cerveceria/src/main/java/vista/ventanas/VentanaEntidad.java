package vista.ventanas;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import vista.interfaces.IVistaEntidad;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaEntidad extends JFrame implements IVistaEntidad, KeyListener {
    private String entidad;
    private JPanel panelPrincipal;
    private JTabbedPane panelCentral;
    private JPanel operarioPanel;
    private JPanel mozoPanel;
    private JPanel productoPanel;
    private JPanel mesaPanel;
    private JLabel accionOperarioLabel;
    private JTextField nombreTextField;
    private JComboBox operarioComboBox;
    private JLabel activoLabel;
    private JLabel nombreDeUsuarioLabel;
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JTextField nombreUsuarioTextField;
    private JTextField apellidoTextField;
    private JPanel panelInferior;
    private JButton accionButton;
    private JButton cancelarButton;
    private JLabel accionMozoLabel;
    private JLabel nombreYApellidoLabel;
    private JLabel fechaDeNacimientoLabel;
    private JLabel estadoLabel;
    private JLabel cantidadDeHijosALabel;
    private JLabel IDLabel;
    private JLabel accionProductoLabel;
    private JLabel idProductoLabel;
    private JLabel stockInicialLabel;
    private JLabel nombreProductoLabel;
    private JLabel precioCostoLabel;
    private JLabel precioVentaLabel;
    private JTextField nombreProductoTextField;
    private JTextField precioCostoTextField;
    private JTextField precioVentaTextField;
    private JTextField stockInicialTextField;
    private JPanel panelPrecios;
    private JPanel panelID;
    private JLabel accionMesaLabel;
    private JLabel numeoDeMesaLabel;
    private JLabel NMesaLabel;
    private JLabel cantidadDeComensalesLabel;
    private JComboBox cantComensalesComboBox;
    private JTextField nombreYApellidoTextField;
    private JTextField fechaNacimientoTextField;
    private JLabel contrasenaLabel;
    private JTextField contrasenaTextField;
    private JComboBox cantHijosComboBox;
    private JComboBox estadoComboBox;
    private JLabel estadoLabel1;
    private JComboBox estadoMesaComboBox;

    @Override
    public void setActionListener(ActionListener controlador) {
        this.accionButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
    }

    @Override
    public void setKeyListener() {
        this.nombreTextField.addKeyListener(this);
        this.apellidoTextField.addKeyListener(this);
        this.nombreUsuarioTextField .addKeyListener(this);
        this.contrasenaTextField.addKeyListener(this);
        this.nombreYApellidoTextField .addKeyListener(this);
        this.fechaNacimientoTextField.addKeyListener(this);
        this.stockInicialTextField.addKeyListener(this);
        this.nombreProductoTextField.addKeyListener(this);
        this.precioVentaTextField.addKeyListener(this);
        this.precioCostoTextField.addKeyListener(this);
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
        this.accionOperarioLabel.setText(accion + " operario");
        this.accionMozoLabel.setText(accion + " mozo");
        this.accionProductoLabel.setText(accion + " producto");
        this.accionMesaLabel.setText(accion + " mesa");
        this.accionButton.setText(accion);
    }

    @Override
    public void setEntidad(String entidad) {
        switch (entidad) {
            case "Operario" -> {
                this.entidad = "Operario";
                this.panelCentral.setSelectedIndex(0);
            }
            case "Mozo" -> {
                this.entidad = "Mozo";
                this.panelCentral.setSelectedIndex(1);
            }
            case "Producto" -> {
                this.entidad = "Producto";
                this.panelCentral.setSelectedIndex(2);
            }
            case "Mesa" -> {
                this.entidad = "Mesa";
                this.panelCentral.setSelectedIndex(3);
                accionButton.setEnabled(true); //No borrar
            }
        }
    }

    @Override
    public String getEntidad() {
        return entidad;
    }

    @Override
    public Operario getOperario() {
        String nombreCompleto = nombreTextField.getText() + " " + apellidoTextField.getText();
        String username = nombreUsuarioTextField.getText();
        String password = contrasenaTextField.getText();
        boolean activo = operarioComboBox.getSelectedIndex() == 0;

        return new Operario(nombreCompleto, username, password, activo);
    }

    @Override
    public Mozo getMozo() {
        String nombreCompleto = nombreYApellidoTextField.getText();
        //FECHA DE NACIMIENTO
        int cantHijos = cantHijosComboBox.getSelectedIndex();
        int estado = estadoComboBox.getSelectedIndex();

//        return new Mozo(nombreCompleto, cantHijos, estado);
        return null;
    }

    @Override
    public Producto getProducto() {
        int idProduct = Integer.parseInt(IDLabel.getText()) ;
        int stockInicial = Integer.parseInt(stockInicialTextField.getText());
        String nombre = nombreProductoTextField.getText() ;
        double precioCosto = Double.parseDouble(precioCostoTextField.getText());
        double precioVenta= Double.parseDouble(precioVentaTextField.getText());

        return new Producto(idProduct,nombre, precioCosto, precioVenta, stockInicial);
    }

    @Override
    public Mesa getMesa() {
        int nro = Integer.parseInt(NMesaLabel.getText());
        int cantidadComensales = cantComensalesComboBox.getSelectedIndex() + 1;
        String estado = estadoMesaComboBox.getSelectedIndex() == 0 ? "Libre" : "Ocupada";

        return new Mesa(nro,cantidadComensales,estado);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        accionButton.setEnabled(true);

        switch (panelCentral.getSelectedIndex()) {
            case 0 -> {
                if (nombreTextField.getText().isEmpty() || apellidoTextField.getText().isEmpty() || nombreUsuarioTextField.getText().isEmpty() || contrasenaTextField.getText().isEmpty()) {
                    accionButton.setEnabled(false);
                }
            }
            case 1 -> {
                if (nombreYApellidoTextField.getText().isEmpty() || fechaNacimientoTextField.getText().isEmpty()) {
                    accionButton.setEnabled(false);
                }
            }
            case 2 -> {
                if (stockInicialTextField.getText().isEmpty() || nombreProductoTextField.getText().isEmpty() || precioVentaTextField.getText().isEmpty() || precioCostoTextField.getText().isEmpty()) {
                    accionButton.setEnabled(false);
                }
            }
        }
    }

    //METODOS NO USADOS
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
