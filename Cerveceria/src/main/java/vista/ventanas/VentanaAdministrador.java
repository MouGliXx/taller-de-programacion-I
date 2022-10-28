package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaAdministrador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class VentanaAdministrador extends JFrame implements IVistaAdministrador, ActionListener {
    private String entidadSeleccionada;
    private String promocionSeleccionada;
    private JPanel panelPrincipal;
    private JPanel panelIzquierdo;
    private JButton estadisticasButton;
    private JButton promocionesButton;
    private JButton entidadesButton;
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
    private JButton nuevaPromocionButton;
    private JButton eliminarPromocionButton;
    private JButton desactivarButton;
    private JButton activarButton;
    private JPanel promocionesPanel;
    private JLabel promocionesLabel;
    private JList listaPromocionesTemporales;
    private JPanel estadisticasPanel;
    private JCheckBox mesasDelLocalCheckBox;
    private JCheckBox productosEnVentaCheckBox;
    private JCheckBox mozosCheckBox;
    private JButton generarEstadisticasButton;
    private JLabel estadisticasLabel;
    private JCheckBox productosEnPromocionCheckBox;
    private JCheckBox promocionesTemporalesCheckBox;
    //MODELOS PARA LISTAS
    DefaultListModel<Operario> modeloOperario = new DefaultListModel<>();
    DefaultListModel<Mozo> modeloMozo = new DefaultListModel<>();
    DefaultListModel<Producto> modeloProducto = new DefaultListModel<>();
    DefaultListModel<Mesa> modeloMesa = new DefaultListModel<>();
    DefaultListModel<ProductoEnPromocion> modeloProductoEnPromocion = new DefaultListModel<>();
    DefaultListModel<PromocionTemporal> modeloPromocionGeneral = new DefaultListModel<>();

    @Override
    public void setActionListener(ActionListener controlador) {
        //BUTTONS
        this.inicioButton.addActionListener(controlador);
        this.entidadesButton.addActionListener(controlador);
        this.promocionesButton.addActionListener(controlador);
        this.estadisticasButton.addActionListener(controlador);
        this.cerrarSesionButton.addActionListener(controlador);
        this.editarTituloButton.addActionListener(controlador);
        this.editarRemuneracionButton.addActionListener(controlador);
        this.agregarButton.addActionListener(controlador);
        this.modificarButton.addActionListener(controlador);
        this.eliminarButton.addActionListener(controlador);
        this.nuevaPromocionButton.addActionListener(controlador);
        this.eliminarPromocionButton.addActionListener(controlador);
        this.activarButton.addActionListener(controlador);
        this.desactivarButton.addActionListener(controlador);
        this.generarEstadisticasButton.addActionListener(controlador);
        //CHECKBOXS
        this.operariosCheckBox.addActionListener(this);
        this.mozosCheckBox.addActionListener(this);
        this.productosEnVentaCheckBox.addActionListener(this);
        this.mesasDelLocalCheckBox.addActionListener(this);
        this.productosEnPromocionCheckBox.addActionListener(this);
        this.promocionesTemporalesCheckBox.addActionListener(this);
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

    @Override
    public void setModelos() {

    }

    @Override
    public void setModeloEntidad() {
        switch (this.entidadSeleccionada) {
            case "Operarios" -> this.listaEntidades.setModel(modeloOperario);
            case "Mozos" -> this.listaEntidades.setModel(modeloMozo);
            case "Productos en venta" -> this.listaEntidades.setModel(modeloProducto);
            case "Mesas del local" -> this.listaEntidades.setModel(modeloMesa);
        }
    }

    @Override
    public void inicializarListas() {

    }

    @Override
    public String getTipoEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    @Override
    public Operario getOperarioSeleccionado() {
        return (this.listaEntidades == null ? null : (Operario) this.listaEntidades.getSelectedValue());
    }

    @Override
    public Mozo getMozoSeleccionado() {
        return (this.listaEntidades == null ? null : (Mozo) this.listaEntidades.getSelectedValue());
    }

    @Override
    public Producto getProductoSeleccionado() {
        return (this.listaEntidades == null ? null : (Producto) this.listaEntidades.getSelectedValue());
    }

    @Override
    public Mesa getMesaSeleccionado() {
        return (this.listaEntidades == null ? null : (Mesa) this.listaEntidades.getSelectedValue());
    }

    @Override
    public String getTipoPromocionSeleccionada() {
        return null;
    }

    @Override
    public String getPromocionSeleccionada() {
        return promocionSeleccionada;
    }

    @Override
    public void cambiarPagina(int pagina) {
        panelCentral.setSelectedIndex(pagina);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ENTIDADES
        if (this.operariosCheckBox.isSelected()) {
            this.entidadSeleccionada = "Operario";
        }

        if (this.mesasDelLocalCheckBox.isSelected()) {
            this.entidadSeleccionada = "Mozo";
        }

        if (this.productosEnVentaCheckBox.isSelected()) {
            this.entidadSeleccionada = "Productos en venta";
        }

        if (this.mesasDelLocalCheckBox.isSelected()) {
            this.entidadSeleccionada = "Mesas del local";
        }

        setModeloEntidad();

        //PROMOCIONES
        if (this.productosEnPromocionCheckBox.isSelected()) {
            this.promocionSeleccionada = "Productos en promocion";
        }

        if (this.promocionesTemporalesCheckBox.isSelected()) {
            this.promocionSeleccionada = "Promociones temporales";
        }
    }
}
