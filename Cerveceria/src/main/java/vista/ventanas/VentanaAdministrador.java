package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaAdministrador;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class VentanaAdministrador extends JFrame implements IVistaAdministrador, ActionListener, KeyListener, ListSelectionListener {
    private String tipoEntidadSeleccionada = "Operarios";
    private String promocionSeleccionada = "Productos en promocion";
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
    private JLabel nombreApellidoLabel;
    private JPanel entidadesPanel;
    private JLabel entidadesLabel;
    private JList<Operario> listaOperarios;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton editarTituloButton;
    private JLabel remuneracionBasicaLabel;
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
    private JList<ProductoEnPromocion> listaProductosEnPromocion;
    private JPanel estadisticasPanel;
    private JCheckBox mesasDelLocalCheckBox;
    private JCheckBox productosEnVentaCheckBox;
    private JCheckBox mozosCheckBox;
    private JButton generarEstadisticasButton;
    private JLabel estadisticasLabel;
    private JCheckBox productosEnPromocionCheckBox;
    private JCheckBox promocionesTemporalesCheckBox;
    private JTextField cerveceriaTextField;
    private JTextField remuneracionTextField;
    private JScrollPane operariosScrollPane;
    private JTabbedPane entidadesTabbedPane;
    private JList<Mozo> listaMozos;
    private JScrollPane mozosScrollPane;
    private JScrollPane productosScrollPane;
    private JScrollPane mesasScrollPane;
    private JList<Producto> listaProductos;
    private JList<Mesa> listaMesas;
    private JTabbedPane promocionesTabbedPane;
    private JScrollPane productosEnPromocionScrollPane;
    private JPanel tiposPromocionesPane;
    private JScrollPane promocionesTemporalesScrollPane;
    private JList<PromocionTemporal> listaPromocionesTemporales;
    //MODELOS PARA LISTAS
    DefaultListModel<Operario> modeloOperario = new DefaultListModel<>();
    DefaultListModel<Mozo> modeloMozo = new DefaultListModel<>();
    DefaultListModel<Producto> modeloProducto = new DefaultListModel<>();
    DefaultListModel<Mesa> modeloMesa = new DefaultListModel<>();
    DefaultListModel<ProductoEnPromocion> modeloProductoEnPromocion = new DefaultListModel<>();
    DefaultListModel<PromocionTemporal> modeloPromocionTemporal = new DefaultListModel<>();

    @Override
    public void setActionListener(ActionListener controlador) {
        //BUTTONS
        this.inicioButton.addActionListener(controlador);
        this.entidadesButton.addActionListener(controlador);
        this.promocionesButton.addActionListener(controlador);
        this.estadisticasButton.addActionListener(controlador);
        this.cerrarSesionButton.addActionListener(controlador);
        this.editarTituloButton.addActionListener(controlador);
        this.editarTituloButton.addActionListener(this);
        this.editarRemuneracionButton.addActionListener(controlador);
        this.editarRemuneracionButton.addActionListener(this);
        this.agregarButton.addActionListener(controlador);
        this.agregarButton.addActionListener(this);
        this.modificarButton.addActionListener(controlador);
        this.modificarButton.addActionListener(this);
        this.eliminarButton.addActionListener(controlador);
        this.eliminarButton.addActionListener(this);
        this.nuevaPromocionButton.addActionListener(controlador);
        this.eliminarPromocionButton.addActionListener(controlador);
        this.activarButton.addActionListener(controlador);
        this.activarButton.addActionListener(this);
        this.desactivarButton.addActionListener(controlador);
        this.desactivarButton.addActionListener(this);
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
    public void setKeyListener() {
        this.cerveceriaTextField.addKeyListener(this);
        this.remuneracionTextField.addKeyListener(this);
    }

    @Override
    public void setListSelectionListener() {
        this.listaOperarios.addListSelectionListener(this);
        this.listaMozos.addListSelectionListener(this);
        this.listaProductos.addListSelectionListener(this);
        this.listaMesas.addListSelectionListener(this);
        this.listaProductosEnPromocion.addListSelectionListener(this);
        this.listaPromocionesTemporales.addListSelectionListener(this);
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
        this.listaOperarios.setModel(modeloOperario);
        this.listaMozos.setModel(modeloMozo);
        this.listaProductos.setModel(modeloProducto);
        this.listaMesas.setModel(modeloMesa);
        this.listaProductosEnPromocion.setModel(modeloProductoEnPromocion);
        this.listaPromocionesTemporales.setModel(modeloPromocionTemporal);
    }

    @Override
    public void actualizaLista(String nombreLista) {
        switch (nombreLista) {
            case "Operarios" -> modeloOperario.remove(listaOperarios.getSelectedIndex());
            case "Mozos" -> modeloMozo.remove(listaMozos.getSelectedIndex());
            case "Productos en venta" -> modeloProducto.remove(listaProductos.getSelectedIndex());
            case "Mesas del local" -> modeloMesa.remove(listaMesas.getSelectedIndex());
            case "Productos en promocion" -> modeloProductoEnPromocion.remove(listaProductosEnPromocion.getSelectedIndex());
            case "Promociones temporales" -> modeloPromocionTemporal.remove(listaPromocionesTemporales.getSelectedIndex());
        }
    }

    @Override
    public void inicializarListas() {
        try {
            modeloMozo.add(modeloMozo.size(), new Mozo("Lautaro", LocalDate.of (2000,12,12),1,0));
            modeloMozo.add(modeloMozo.size(), new Mozo("Ignacio", LocalDate.of (2000,12,12),1,0));
            modeloMozo.add(modeloMozo.size(), new Mozo("Tomas", LocalDate.of (2000,12,12),1,0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Producto p1 = new Producto(2,"Coca-Cola",150,200,20);

        modeloProducto.add(modeloProducto.size(), p1);
        modeloProducto.add(modeloProducto.size(), new Producto(3,"Agua",100,150,20));
        modeloProducto.add(modeloProducto.size(), new Producto(4,"Sprite",250,300,20));

        modeloProductoEnPromocion.add(modeloProductoEnPromocion.size(), new ProductoEnPromocion(1, p1, null, true, false, true));
    }

    @Override
    public String getNombreLocal() {
        return cerveceriaTextField.getText();
    }

    @Override
    public Double getRemuneracion() {
        return Double.parseDouble(remuneracionTextField.getText());
    }

    @Override
    public String getTipoEntidadSeleccionada() {
        return tipoEntidadSeleccionada;
    }

    @Override
    public Operario getOperarioSeleccionado() {
        return this.listaOperarios.getSelectedValue();
    }

    @Override
    public Mozo getMozoSeleccionado() {
        return this.listaMozos.getSelectedValue();
    }

    @Override
    public Producto getProductoSeleccionado() {
        return this.listaProductos.getSelectedValue();
    }

    @Override
    public Mesa getMesaSeleccionado() {
        return this.listaMesas.getSelectedValue();
    }

    @Override
    public String getTipoPromocionSeleccionada() {
        return promocionSeleccionada;
    }

    @Override
    public ProductoEnPromocion getProductoEnPromocionSeleccionado() {
        return this.listaProductosEnPromocion.getSelectedValue();
    }

    @Override
    public PromocionTemporal getPromocionTemporalSeleccionada() {
        return this.listaPromocionesTemporales.getSelectedValue();
    }

    @Override
    public void cambiarPagina(int pagina) {
        panelCentral.setSelectedIndex(pagina);

        this.inicioButton.setBackground(Color.decode("#D9D9D9"));
        this.entidadesButton.setBackground(Color.decode("#D9D9D9"));
        this.promocionesButton.setBackground(Color.decode("#D9D9D9"));
        this.estadisticasButton.setBackground(Color.decode("#D9D9D9"));

        switch (pagina) {
            case 0 -> this.inicioButton.setBackground(Color.decode("#FFFFFF"));
            case 1 -> this.entidadesButton.setBackground(Color.decode("#FFFFFF"));
            case 2 -> this.promocionesButton.setBackground(Color.decode("#FFFFFF"));
            case 3 -> this.estadisticasButton.setBackground(Color.decode("#FFFFFF"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTONES
        switch (e.getActionCommand()) {
            case "Editar Cerveceria" -> editarTituloButton.setEnabled(false);
            case "Editar Remuneracion" -> editarRemuneracionButton.setEnabled(false);
            case "Operarios", "Mozos", "Productos en venta", "Mesas del local" -> {
                this.agregarButton.setEnabled(true);
                this.modificarButton.setEnabled(false);
                this.eliminarButton.setEnabled(false);

                if (this.operariosCheckBox.isSelected()) {
                    this.tipoEntidadSeleccionada = "Operarios";
                    this.entidadesTabbedPane.setSelectedIndex(0);
                }

                if (this.mozosCheckBox.isSelected()) {
                    this.tipoEntidadSeleccionada = "Mozos";
                    this.entidadesTabbedPane.setSelectedIndex(1);
                }

                if (this.productosEnVentaCheckBox.isSelected()) {
                    this.tipoEntidadSeleccionada = "Productos en venta";
                    this.entidadesTabbedPane.setSelectedIndex(2);
                }

                if (this.mesasDelLocalCheckBox.isSelected()) {
                    this.tipoEntidadSeleccionada = "Mesas del local";
                    this.entidadesTabbedPane.setSelectedIndex(3);
                }
            }
            case "Productos en promocion", "Promociones temporales" -> {
                this.nuevaPromocionButton.setEnabled(true);
                this.eliminarPromocionButton.setEnabled(false);
                this.activarButton.setVisible(false);
                this.desactivarButton.setVisible(false);

                if (this.productosEnPromocionCheckBox.isSelected()) {
                    this.promocionSeleccionada = "Productos en promocion";
                    this.promocionesTabbedPane.setSelectedIndex(0);
                }

                if (this.promocionesTemporalesCheckBox.isSelected()) {
                    this.promocionSeleccionada = "Promociones temporales";
                    this.promocionesTabbedPane.setSelectedIndex(1);
                }
            }
            case "Activar Promocion" -> {
                this.activarButton.setVisible(false);
                this.desactivarButton.setVisible(true);
            }
            case "Desactivar Promocion" -> {
                this.activarButton.setVisible(true);
                this.desactivarButton.setVisible(false);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String nombreLocal = Cerveceria.getInstance().getNombreDelLocal();
        String remuneracionBasica = String.valueOf(Cerveceria.getInstance().getRemuneracionBasica());

        if (cerveceriaTextField.getText().equals(nombreLocal)) {
            editarTituloButton.setEnabled(false);
        } else {
            editarTituloButton.setEnabled(true);
        }

        if (remuneracionTextField.getText().equals(remuneracionBasica)) {
            editarRemuneracionButton.setEnabled(false);
        } else {
            editarRemuneracionButton.setEnabled(true);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //ENTIDADES
        this.modificarButton.setEnabled(false);
        this.eliminarButton.setEnabled(false);
        if (listaOperarios.getSelectedValue() != null || listaMozos.getSelectedValue() != null || listaProductos.getSelectedValue() != null || listaMesas.getSelectedValue() != null) {
            this.modificarButton.setEnabled(true);
            this.eliminarButton.setEnabled(true);
        }

        //PROMOCIONES
        this.eliminarPromocionButton.setEnabled(false);
        this.activarButton.setVisible(false);
        this.desactivarButton.setVisible(false);
        if (listaProductosEnPromocion.getSelectedValue() != null || listaPromocionesTemporales.getSelectedValue() != null) {

        }
        if (listaProductosEnPromocion.getSelectedValue() != null) {
            this.eliminarPromocionButton.setEnabled(true);

            if (listaProductosEnPromocion.getSelectedValue().isActiva()) {
                this.desactivarButton.setVisible(true);
            } else {
                this.activarButton.setVisible(true);
            }
        }

        if (listaPromocionesTemporales.getSelectedValue() != null) {
            this.eliminarPromocionButton.setEnabled(true);

            if (listaPromocionesTemporales.getSelectedValue().isActiva()) {
                this.desactivarButton.setVisible(true);
            } else {
                this.activarButton.setVisible(true);
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
