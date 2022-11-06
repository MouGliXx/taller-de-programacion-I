package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaEntidad;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

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
    private JComboBox operarioActivoComboBox;
    private JLabel activoLabel;
    private JLabel nombreDeUsuarioLabel;
    private JLabel nombreCompletoLabel;
    private JTextField nombreUsuarioTextField;
    private JTextField apellidoTextField;
    private JPanel panelInferior;
    private JButton accionButton;
    private JButton cancelarButton;
    private JLabel accionMozoLabel;
    private JLabel nombreYApellidoLabel;
    private JLabel edadLabel;
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
    private JLabel numeroDeMesaLabel;
    private JLabel NMesaLabel;
    private JLabel cantidadDeComensalesLabel;
    private JComboBox cantComensalesComboBox;
    private JTextField nombreYApellidoTextField;
    private JTextField edadTextField;
    private JLabel contrasenaLabel;
    private JTextField contrasenaTextField;
    private JComboBox cantHijosComboBox;
    private JComboBox estadoMozoComboBox;
    private JLabel estadoLabel1;
    private JComboBox estadoMesaComboBox;
    private JTextField nombreCompletoTextField;

    @Override
    public void setActionListener(ActionListener controlador) {
        this.accionButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
    }

    @Override
    public void setKeyListener() {
        this.nombreCompletoTextField.addKeyListener(this);
        this.nombreUsuarioTextField .addKeyListener(this);
        this.contrasenaTextField.addKeyListener(this);
        this.nombreYApellidoTextField .addKeyListener(this);
        this.edadTextField.addKeyListener(this);
        this.stockInicialTextField.addKeyListener(this);
        this.nombreProductoTextField.addKeyListener(this);
        this.precioVentaTextField.addKeyListener(this);
        this.precioCostoTextField.addKeyListener(this);
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
                this.IDLabel.setText(String.valueOf(Cerveceria.getInstance().getProductos().size()));
            }
            case "Mesa" -> {
                this.entidad = "Mesa";
                this.panelCentral.setSelectedIndex(3);
                this.NMesaLabel.setText(String.valueOf(Cerveceria.getInstance().getMesas().size() + 1) ); //El 0 es la barra
                accionButton.setEnabled(true); //No borrar
            }
        }
    }

    @Override
    public void setDatosOperario(Operario operario) {
        this.nombreCompletoTextField.setText(operario.getNombreCompleto());
        this.nombreUsuarioTextField.setText(operario.getNombreUsuario());
        this.contrasenaTextField.setText(operario.getContrasena());
        this.operarioActivoComboBox.setSelectedIndex(operario.isActivo() ? 0 : 1);
    }

    @Override
    public void setDatosMozo(Mozo mozo) {
        this.nombreYApellidoTextField.setText(mozo.getNombreYApellido());
        this.edadTextField.setText(String.valueOf(mozo.getEdad()));
        this.cantHijosComboBox.setSelectedIndex(mozo.getCantHijos());
        switch (mozo.getEstado()) {
            case "Activo" -> this.estadoMozoComboBox.setSelectedIndex(0);
            case "Franco" -> this.estadoMozoComboBox.setSelectedIndex(1);
            case "Ausente" -> this.estadoMozoComboBox.setSelectedIndex(2);
        }
    }

    @Override
    public void setDatosProducto(Producto producto) {
        this.IDLabel.setText(String.valueOf(producto.getIdProducto()));
        this.stockInicialTextField.setText(String.valueOf(producto.getStockInicial()));
        this.nombreProductoTextField.setText(producto.getNombre());
        this.precioCostoTextField.setText(String.valueOf(producto.getPrecioCosto()));
        this.precioVentaTextField.setText(String.valueOf(producto.getPrecioVenta()));
    }

    @Override
    public void setDatosMesa(Mesa mesa) {
        this.NMesaLabel.setText(String.valueOf(mesa.getNro()));
        this.cantComensalesComboBox.setSelectedIndex(mesa.getCantidadComensales());
        this.estadoMozoComboBox.setSelectedIndex(mesa.getEstado().equalsIgnoreCase("Libre") ? 0 : 1);
    }

    @Override
    public String getEntidad() {
        return entidad;
    }

    //OPERARIO
    @Override
    public String getNombreCompletoOperario() {
        return nombreCompletoLabel.getText();
    }

    @Override
    public String getNombreDeUsuario() {
        return nombreUsuarioTextField.getText();
    }

    @Override
    public String getContrasena() {
        return contrasenaTextField.getText();
    }

    @Override
    public boolean getEstadoOperario() {
        return operarioActivoComboBox.getSelectedIndex() == 0;
    }

    //MOZO
    @Override
    public String getNombreYApellidoMozo() {
        return nombreYApellidoTextField.getText();
    }

    @Override
    public int getEdadMozo() throws NumberFormatException {
        return Integer.parseInt(edadTextField.getText());
    }

    @Override
    public int getCantidadHijosMozo() {
        return cantHijosComboBox.getSelectedIndex();
    }

    @Override
    public String getEstadoMozo() {
        String estado = null;

        switch (estadoMozoComboBox.getSelectedIndex()) {
            case 0 -> estado = "Activo";
            case 1 -> estado = "Franco";
            case 2 -> estado = "Ausente";
        }

        return estado;
    }

    //PRODUCTO
    @Override
    public int getIDProducto() {
        return Integer.parseInt(IDLabel.getText());
    }

    @Override
    public int getStockInicial() throws NumberFormatException  {
        return Integer.parseInt(stockInicialTextField.getText());
    }

    @Override
    public String getNombreProducto() {
        return nombreProductoTextField.getText();
    }

    @Override
    public double getPrecioCosto() throws NumberFormatException {
        return Double.parseDouble(precioCostoTextField.getText());
    }

    @Override
    public double getPrecioVenta() throws NumberFormatException {
        return Double.parseDouble(precioVentaTextField.getText());
    }

    //MESA
    @Override
    public int getCantidadComensales() {
        return cantComensalesComboBox.getSelectedIndex() + 1;
    }

    @Override
    public String getEstadoMesa() {
        return estadoMesaComboBox.getSelectedIndex() == 0 ? "Libre" : "Ocupada";
    }

    @Override
    public void keyReleased(KeyEvent e) {
        accionButton.setEnabled(true);

        switch (panelCentral.getSelectedIndex()) {
            case 0 -> {
                if (nombreCompletoTextField.getText().isEmpty() || nombreUsuarioTextField.getText().isEmpty() || contrasenaTextField.getText().isEmpty()) {
                    accionButton.setEnabled(false);
                }
            }
            case 1 -> {
                if (nombreYApellidoTextField.getText().isEmpty() || edadTextField.getText().isEmpty()) {
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
