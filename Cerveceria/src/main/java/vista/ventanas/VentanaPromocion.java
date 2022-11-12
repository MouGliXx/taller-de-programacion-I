package vista.ventanas;

import modelo.Producto;
import modelo.ProductoEnPromocion;
import modelo.PromocionTemporal;
import vista.interfaces.IVistaPromocion;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private JComboBox productosComboBox;
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
    private JCheckBox efectivoCheckBox;
    private JCheckBox tarjetaCheckBox;
    private JCheckBox mercadoPagoCheckBox;
    private JCheckBox cuentaDNICheckBox;
    private JCheckBox acumulableCheckBox;
    private JTextField precioUnitarioTextField;
    //MODELO PARA COMBOBOX
    DefaultComboBoxModel<Producto> modeloProducto = new DefaultComboBoxModel<>();

    @Override
    public void setActionListener(ActionListener controlador) {
        this.establecerButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
        this.activaCheckBox.addActionListener(this);
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

    @Override
    public void setKeyListener() {
        //PAGINA0
        this.cantidadMinimaTextField.addKeyListener(this);
        this.precioUnitarioTextField.addKeyListener(this);

        //PAGINA1
        this.nombrePromocionTextField.addKeyListener(this);
    }

    @Override
    public void setWindowListener(WindowListener controlador) {

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
        this.productosComboBox.setModel(modeloProducto);
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

    @Override
    public String getTipoPromocion() {
        return promocion;
    }

    @Override
    public ArrayList<String> generaDiasDePromocion() {
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
    public ProductoEnPromocion getProductoEnPromocion() {
        int id = Integer.parseInt(IDLabel.getText());
        Producto producto = null; //GESTIONAR ESTO
        ArrayList<String> diasPromocion = generaDiasDePromocion();
        boolean activa = activaCheckBox.isSelected();
        boolean aplicaDosPorUno = aplica2x1CheckBox.isSelected();
        boolean aplicaDtoPorCantidad = aplicaDescuentoXCantidadCheckBox.isSelected();

        if (aplicaDtoPorCantidad) {
            int dtoPorCantidad_CantMinima = Integer.parseInt(cantidadMinimaTextField.getText());
            double dtoPorCantidad_PrecioUnitario = Double.parseDouble(precioUnitarioTextField.getText());

            return new ProductoEnPromocion(id,producto, diasPromocion, aplicaDosPorUno, aplicaDtoPorCantidad, dtoPorCantidad_CantMinima, dtoPorCantidad_PrecioUnitario, activa);
        } else  {
            return new ProductoEnPromocion(id,producto, diasPromocion, aplicaDosPorUno, aplicaDtoPorCantidad, activa);
        }
    }

    @Override
    public PromocionTemporal getPromocionTemporal() {
        return null; //TENGO QUE ESPERAR AL MODELO
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.establecerButton.setEnabled(true);

        if ("Aplica descuento x cantidad".equals(e.getActionCommand())) {
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
                    //FALTA CONDICION CON PRODUCTO COMBOBOX

                    if (!aplicaDescuentoXCantidadCheckBox.isSelected() && !aplica2x1CheckBox.isSelected()) {
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
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.establecerButton.setEnabled(true);

        switch (panelCentral.getSelectedIndex()) {
            case 0 -> {
                if (cantidadMinimaTextField.getText().isEmpty() || precioUnitarioTextField.getText().isEmpty()) {
                    this.establecerButton.setEnabled(false);
                }
            }
            case 1 -> {
                if (nombrePromocionTextField.getText().isEmpty()) {
                    this.establecerButton.setEnabled(false);
                }
            }
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
