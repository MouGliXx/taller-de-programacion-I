package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaEntidad;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

/**
 * Clase que representa la interfaz cuando se crea/edita una entidad.<br>
 * */
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
    private JComboBox<String> cantComensalesComboBox;
    private JTextField nombreYApellidoTextField;
    private JTextField edadTextField;
    private JLabel contrasenaLabel;
    private JTextField contrasenaTextField;
    private JComboBox<String> cantHijosComboBox;
    private JComboBox<String> estadoMozoComboBox;
    private JLabel estadoLabel1;
    private JComboBox<String> estadoMesaComboBox;
    private JTextField nombreCompletoTextField;

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
        this.accionButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
    }

    /**
     * Agrega los KeyListener especificados a los diferentes JTextField de la ventana.<br>
     *
     * <b>pre</b> Deben existir componentes JTextField dentro de la ventana.<br>
     * <b>post</b> Se ha asignado un KeyListener a los TextField que lo necesiten.<br>
     */
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
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setSize(800,600); //Dimensiones del JFrame
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
        setVisible(false); //Oculto la ventana
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

    /**
     * Establece la accion que sera reflejada en la entidad (crear/editar).<br>
     *
     * <b>pre</b> accion distinto de null, solo puede ser 'crear' o 'editar'.<br>
     * <b>post</b> La ventana se personaliza en base a la accion recibida.<br>
     *
     * @param accion Refleja el proposito de la ventana con la entidad.<br>
     */
    @Override
    public void setAccion(String accion) {
        this.accionOperarioLabel.setText(accion + " operario");
        this.accionMozoLabel.setText(accion + " mozo");
        this.accionProductoLabel.setText(accion + " producto");
        this.accionMesaLabel.setText(accion + " mesa");
        this.accionButton.setText(accion);
    }

    /**
     * Establece el tipo de entidad que sera reflejada en la ventana.<br>
     *
     * <b>pre</b> entidad distinto de null, solo puede ser 'Operario', 'Mozo', 'Producto' o 'Mesa'.<br>
     * <b>post</b> La ventana se personaliza en base a la entidad recibida.<br>
     *
     * @param entidad Refleja el tipo de entidad que se desea crear/editar.<br>
     */
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

    /**
     * Establece los datos del operario en los componentes de la ventana para asi poder editar sus datos.<br>
     *
     * <b>pre</b> operario distinto de null.<br>
     * <b>post</b> La ventana se personaliza en base al operario recibido.<br>
     *
     * @param operario Representa un operario ya existente en el sistema.<br>
     */
    @Override
    public void setDatosOperario(Operario operario) {
        this.nombreCompletoTextField.setText(operario.getNombreCompleto());
        this.nombreUsuarioTextField.setText(operario.getNombreUsuario());
        this.contrasenaTextField.setText(operario.getContrasena());
        this.operarioActivoComboBox.setSelectedIndex(operario.isActivo() ? 0 : 1);
    }

    /**
     * Establece los datos del mozo en los componentes de la ventana para asi poder editar sus datos.<br>
     *
     * <b>pre</b> mozo distinto de null.<br>
     * <b>post</b> La ventana se personaliza en base al mozo recibido.<br>
     *
     * @param mozo Representa un mozo ya existente en el sistema.<br>
     */
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

    /**
     * Establece los datos del producto en los componentes de la ventana para asi poder editar sus datos.<br>
     *
     * <b>pre</b> producto distinto de null.<br>
     * <b>post</b> La ventana se personaliza en base al producto recibido.<br>
     *
     * @param producto Representa un producto ya existente en el sistema.<br>
     */
    @Override
    public void setDatosProducto(Producto producto) {
        this.IDLabel.setText(String.valueOf(producto.getIdProducto()));
        this.stockInicialTextField.setText(String.valueOf(producto.getStockInicial()));
        this.nombreProductoTextField.setText(producto.getNombre());
        this.precioCostoTextField.setText(String.valueOf(producto.getPrecioCosto()));
        this.precioVentaTextField.setText(String.valueOf(producto.getPrecioVenta()));
    }

    /**
     * Establece los datos de la mesa en los componentes de la ventana para asi poder editar sus datos.<br>
     *
     * <b>pre</b> mesa distinto de null.<br>
     * <b>post</b> La ventana se personaliza en base a la mesa recibido.<br>
     *
     * @param mesa Representa una mesa ya existente en el sistema.<br>
     */
    @Override
    public void setDatosMesa(Mesa mesa) {
        this.NMesaLabel.setText(String.valueOf(mesa.getNro()));
        this.cantComensalesComboBox.setSelectedIndex(mesa.getCantidadComensales());
        this.estadoMozoComboBox.setSelectedIndex(mesa.getEstado().equalsIgnoreCase("Libre") ? 0 : 1);
    }

    /**
     * Devuelve el tipo de entidad para la cual se personalizo la ventana.<br>
     *
     * @return Tipo de entidad que se desea crea/editar.<br>
     */
    @Override
    public String getEntidad() {
        return entidad;
    }

    //OPERARIO
    @Override
    public String getNombreCompletoOperario() {
        return nombreCompletoTextField.getText();
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
