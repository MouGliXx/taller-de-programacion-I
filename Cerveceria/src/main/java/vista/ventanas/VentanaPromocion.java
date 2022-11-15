package vista.ventanas;

import modelo.Producto;
import vista.interfaces.IVistaPromocion;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa la interfaz cuando se crea una promocion.<br>
 */
public class VentanaPromocion extends JFrame implements IVistaPromocion, ActionListener, KeyListener {
    String promocion;
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
    private JComboBox<Producto>productosComboBox;
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
    private JComboBox<String> porcentajeComboBox;
    private JLabel porcentajeDeDescuentoLabel;
    private JLabel nombreLabel;
    private JTextField nombrePromocionTextField;
    private JPanel primeraFilaPanel2;
    private JPanel segundaFilaPanel2;
    private JLabel formasDePagoLabel;
    private JCheckBox efectivoCheckBox;
    private JCheckBox tarjetaCheckBox;
    private JCheckBox mercadoPagoCheckBox;
    private JCheckBox cuentaDNICheckBox;
    private JCheckBox acumulableCheckBox;
    private JTextField precioUnitarioTextField;
    //MODELO PARA COMBOBOX
    DefaultComboBoxModel<Producto> modeloProducto = new DefaultComboBoxModel<>();

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
        this.establecerButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
        this.lunesCheckBox.addActionListener(this);
        this.martesCheckBox.addActionListener(this);
        this.miercolesCheckBox.addActionListener(this);
        this.juevesCheckBox.addActionListener(this);
        this.viernesCheckBox.addActionListener(this);
        this.sabadoCheckBox.addActionListener(this);
        this.domingoCheckBox.addActionListener(this);

        //PAGINA0
        this.aplica2x1CheckBox.addActionListener(this);
        this.aplicaDescuentoXCantidadCheckBox.addActionListener(this);
        this.productosComboBox.addActionListener(this);

        //PAGINA1
        this.porcentajeComboBox.addActionListener(this);
        this.efectivoCheckBox.addActionListener(this);
        this.tarjetaCheckBox.addActionListener(this);
        this.mercadoPagoCheckBox.addActionListener(this);
        this.cuentaDNICheckBox.addActionListener(this);
        this.acumulableCheckBox.addActionListener(this);


    }

    /**
     * Agrega los KeyListener especificados a los diferentes JTextField de la ventana.<br>
     *
     * <b>pre</b> Deben existir componentes JTextField dentro de la ventana.<br>
     * <b>post</b> Se ha asignado un KeyListener a los TextField que lo necesiten.<br>
     */
    @Override
    public void setKeyListener() {
        //PAGINA0
        this.cantidadMinimaTextField.addKeyListener(this);
        this.precioUnitarioTextField.addKeyListener(this);
        //PAGINA1
        this.nombrePromocionTextField.addKeyListener(this);
    }

    /**
     * Agrega un WindowListener a la ventana, para notificar WindowEvent que ocurran desde esta ventana.<br>
     *
     * <b>pre</b> controlador distinto de null.<br>
     * <b>post</b> Se ha asignado un WindowListener a la ventana.<br>
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
        setSize(960,720); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
        setModelos();
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
     * Establece los modelos a los diferentes componentes que lo necesiten.<br>
     *
     * <b>pre</b> Los modelos deben estar instanciados.<br>
     * <b>post</b> Los componentes quedan con el modelo acorde establecido.<br>
     */
    @Override
    public void setModelos() {
        this.productosComboBox.setModel(modeloProducto);
    }

    /**


    /**
     * Establece los datos de la Promocion en los componentes de la ventana y carga los productos cargados en el sistema, para su visualizacion.<br>
     *
     * <b>pre</b> Los DefaultComboBoxModel ya han sido seteados a sus JComboBox.<br>
     * <b>post</b> La ventana se personaliza con los datos recibidos.<br>
     *
     * @param id Id correspondiente a la promocion que se desea crear.<br>
     * @param productos Productos almacenados en el sistema.<br>
     */
    @Override
    public void setDatos(int id, HashMap<Integer, Producto> productos) {
        this.IDLabel.setText(String.valueOf(id));

        modeloProducto.addElement(null);
        productos.forEach((nro, producto) -> modeloProducto.addElement(producto));
    }

    @Override
    public void setPromocion(String promocion) {
        switch (promocion) {
            case "Producto en Promocion" -> {
                this.promocion = "Producto en Promocion";
                this.panelCentral.setSelectedIndex(0);
            }
            case "Promocion Temporal" -> {
                this.promocion = "Promocion Temporal";
                this.panelCentral.setSelectedIndex(1);
            }
        }
    }

    /**
     * Devuelve el tipo de promocion para la cual se personalizo la ventana.<br>
     *
     * @return Tipo de promocion que se desea crea.<br>
     */
    @Override
    public String getTipoPromocion() {
        return promocion;
    }

    //PROMOCION
    @Override
    public ArrayList<String> getDiasDePromocion() {
        ArrayList<String> aux = new ArrayList<>();

        if (lunesCheckBox.isSelected()) {
            aux.add(lunesCheckBox.getText());
        }
        if (martesCheckBox.isSelected()) {
            aux.add(martesCheckBox.getText());
        }
        if (miercolesCheckBox.isSelected()) {
            aux.add(miercolesCheckBox.getText());
        }
        if (juevesCheckBox.isSelected()) {
            aux.add(juevesCheckBox.getText());
        }
        if (viernesCheckBox.isSelected()) {
            aux.add(viernesCheckBox.getText());
        }
        if (sabadoCheckBox.isSelected()) {
            aux.add(sabadoCheckBox.getText());
        }
        if (domingoCheckBox.isSelected()) {
            aux.add(domingoCheckBox.getText());
        }

        return aux;
    }

    @Override
    public boolean isActiva() {
        return activaCheckBox.isSelected();
    }

    //PRODUCTO EN PROMOCION
    @Override
    public Producto getProducto() {
        return modeloProducto.getElementAt(productosComboBox.getSelectedIndex());
    }

    @Override
    public boolean getAplica2x1() {
        return aplica2x1CheckBox.isSelected();
    }

    @Override
    public boolean getAplicaDescuentoXCantidad() {
        return aplicaDescuentoXCantidadCheckBox.isSelected();
    }

    @Override
    public int getCantidadMinima() throws NumberFormatException {
        return Integer.parseInt(cantidadMinimaTextField.getText());
    }

    @Override
    public double getPrecioUnitario() throws NumberFormatException {
        return Double.parseDouble(precioUnitarioTextField.getText());
    }

    //PROMOCION TEMPORAL
    @Override
    public String getNombrePromocion() throws Exception {
        String nombrePromocion = nombrePromocionTextField.getText();

        if (nombrePromocion.equals(""))
            throw new Exception();

        return nombrePromocion;
    }

    @Override
    public int getPorcentajeDescuento() {
        int porcentaje = -1;

        switch (porcentajeComboBox.getSelectedIndex()) {
            case 0 -> porcentaje = 0;
            case 1 -> porcentaje = 10;
            case 2 -> porcentaje = 25;
            case 3 -> porcentaje = 50;
            case 4 -> porcentaje = 70;
            case 5 -> porcentaje = 100;
        }

        return porcentaje;
    }

    @Override
    public String getFormaDePago() {
        String formaDePago = null;

        if (efectivoCheckBox.isSelected()) {
            formaDePago = "Efectivo";
        } else if (tarjetaCheckBox.isSelected()) {
            formaDePago = "Tarjeta";
        } else if (mercadoPagoCheckBox.isSelected()) {
            formaDePago = "Mercado Pago";
        } else if (cuentaDNICheckBox.isSelected()) {
            formaDePago = "Cuenta DNI";
        }

        return formaDePago;
    }

    @Override
    public boolean isAcumulable() {
        return acumulableCheckBox.isSelected();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.establecerButton.setEnabled(true);

        if (e.getActionCommand().equals("Aplica descuento x cantidad")) {
            if (aplicaDescuentoXCantidadCheckBox.isSelected()) {
                this.cantidadMinimaTextField.setEnabled(true);
                this.precioUnitarioTextField.setEnabled(true);
            } else {
                this.cantidadMinimaTextField.setEnabled(false);
                this.cantidadMinimaTextField.setText("");
                this.precioUnitarioTextField.setEnabled(false);
                this.precioUnitarioTextField.setText("");
            }

            this.establecerButton.setEnabled(false);
        } else {
            switch (panelCentral.getSelectedIndex()) {
                case 0 -> {
                    if (productosComboBox.getSelectedIndex() == -1) {
                        this.establecerButton.setEnabled(false);
                    }

                    if (!aplicaDescuentoXCantidadCheckBox.isSelected() && !aplica2x1CheckBox.isSelected()) {
                        this.establecerButton.setEnabled(false);
                    }

                    if (aplicaDescuentoXCantidadCheckBox.isSelected()) {
                        if (cantidadMinimaTextField.getText().isEmpty() || precioUnitarioTextField.getText().isEmpty()) {
                            this.establecerButton.setEnabled(false);
                        }
                    }
                }
                case 1 -> {
                    if (porcentajeComboBox.getSelectedIndex() == 0) {
                        this.establecerButton.setEnabled(false);
                    }

                    if (!efectivoCheckBox.isSelected() && !tarjetaCheckBox.isSelected() && !mercadoPagoCheckBox.isSelected() && !cuentaDNICheckBox.isSelected()) {
                        this.establecerButton.setEnabled(false);
                    }

                    if (nombrePromocionTextField.getText().isEmpty()) {
                        this.establecerButton.setEnabled(false);
                    }
                }
            }

            if (!lunesCheckBox.isSelected() && !martesCheckBox.isSelected() && !miercolesCheckBox.isSelected() && !juevesCheckBox.isSelected() && !viernesCheckBox.isSelected() && !sabadoCheckBox.isSelected() && !domingoCheckBox.isSelected()) {
                this.establecerButton.setEnabled(false);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.establecerButton.setEnabled(true);

        switch (panelCentral.getSelectedIndex()) {
            case 0 -> {
                if (cantidadMinimaTextField.getText().isEmpty() || precioUnitarioTextField.getText().isEmpty()) {
                    this.establecerButton.setEnabled(false);
                }
            }
            case 1 -> {
                if (porcentajeComboBox.getSelectedIndex() == 0) {
                    this.establecerButton.setEnabled(false);
                }

                if (!efectivoCheckBox.isSelected() && !tarjetaCheckBox.isSelected() && !mercadoPagoCheckBox.isSelected() && !cuentaDNICheckBox.isSelected()) {
                    this.establecerButton.setEnabled(false);
                }
            }
        }

        if (!lunesCheckBox.isSelected() && !martesCheckBox.isSelected() && !miercolesCheckBox.isSelected() && !juevesCheckBox.isSelected() && !viernesCheckBox.isSelected() && !sabadoCheckBox.isSelected() && !domingoCheckBox.isSelected()) {
            this.establecerButton.setEnabled(false);
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
