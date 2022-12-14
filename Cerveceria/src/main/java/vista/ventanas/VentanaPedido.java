package vista.ventanas;

import modelo.Cerveceria;
import modelo.Pedido;
import modelo.Producto;
import vista.interfaces.IVistaPedido;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class VentanaPedido extends JFrame implements IVistaPedido, ActionListener, ItemListener {
    private JPanel panelPrincipal;
    private JLabel accionPedidoLabel;
    private JPanel panelCentral;
    private JLabel productoLabel;
    private JComboBox<Producto> productoComboBox;
    private JComboBox<String> cantidadComboBox;
    private JButton cancelarButton;
    private JButton accionButton;
    private JPanel productoPane;
    private JPanel cantidadPane;
    private JLabel cantidadLabel;
    //MODELOS
    private DefaultComboBoxModel<Producto> modeloProductos = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> modeloCantidad = new DefaultComboBoxModel<>();

    //FUNCIONALIDADES
    @Override
    public void setActionListener(ActionListener controlador) {
        this.accionButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
        this.cantidadComboBox.addActionListener(this);
    }

    @Override
    public void setItemListener() {
        this.productoComboBox.addItemListener(this);
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
        setSize(800,440); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
        setModelos();
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
    public void setModelos() {
        this.productoComboBox.setModel(modeloProductos);
        this.cantidadComboBox.setModel(modeloCantidad);
    }

    @Override
    public void inicializaComboBox(Pedido pedido) {
        HashMap<Integer, Producto> productos = Cerveceria.getInstance().getProductos();

        if (!productos.isEmpty()) {
            modeloProductos.addElement(null);
            productos.forEach((nro, producto) -> {
                modeloProductos.addElement(producto);
            });
        }
    }

    @Override
    public Producto getProductoSeleccionado() {
        return modeloProductos.getElementAt(productoComboBox.getSelectedIndex());
    }

    @Override
    public int getCantidadSeleccionada() {
        return Integer.parseInt(modeloCantidad.getElementAt(cantidadComboBox.getSelectedIndex()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.accionButton.setEnabled(true);

        if (productoComboBox.getSelectedIndex() == 0 || cantidadComboBox.getSelectedIndex() == 0) {
            this.accionButton.setEnabled(false);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        this.cantidadComboBox.setEnabled(false);
        Producto productoSeleccionado = modeloProductos.getElementAt(productoComboBox.getSelectedIndex());


        if (productoSeleccionado != null) {
            this.cantidadComboBox.setEnabled(true);

            modeloCantidad.removeAllElements();
            for (int i = 0; i <= productoSeleccionado.getStockInicial(); i++) {
                modeloCantidad.addElement(String.valueOf(i));
            }
        } else {
            modeloCantidad.removeAllElements();
        }
    }
}
