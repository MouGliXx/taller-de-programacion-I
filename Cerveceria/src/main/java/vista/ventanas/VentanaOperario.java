package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaOperario;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class VentanaOperario extends JFrame implements IVistaOperario, ListSelectionListener {
    private JPanel panelPrincipal;
    private JPanel panelIzquierdo;
    private JTabbedPane panelCentral;
    private JButton inicioButton;
    private JButton promocionesButton;
    private JButton facturasButton;
    private JButton mozosButton;
    private JButton comandasButton;
    private JLabel ImagenCerveza;
    private JButton cerrarSesionButton;
    private JButton IniciarJornadaButton;
    private JLabel bienvenidoLabel;
    private JLabel cerveceriaLabel;
    private JLabel NombreApellidoLabel;
    private JPanel inicioPanel;
    private JPanel mozosPanel;
    private JPanel comandasPanel;
    private JPanel facturasPanel;
    private JPanel promocionesPanel;
    private JLabel mozosLabel;
    private JLabel nombreYApellidoLabel;
    private JLabel estadoLabel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JLabel NPLabel6;
    private JLabel NPLabel1;
    private JLabel NPLabel2;
    private JLabel NPLabel3;
    private JLabel NPLabel4;
    private JLabel NPLabel5;
    private JComboBox comboBox6;
    private JLabel mesasAsignadasLabel;
    private JLabel MA1;
    private JLabel MA2;
    private JLabel MA3;
    private JLabel MA4;
    private JLabel MA5;
    private JLabel MA6;
    private JButton asignarMesasButton;
    private JLabel comandasLabel;
    private JLabel listadoDeComandasAbiertasLabel;
    private JButton nuevaComandaButton;
    private JButton cerrarComandaButton;
    private JButton editarComandaButton;
    private JLabel facturasLabel;
    private JLabel historialDeFacturasLabel;
    private JLabel promocionesLabel;
    private JLabel listadoDeProductosEnPromocionLabel;
    private JLabel listadoDePromocionesTemporalesLabel;
    private JList<Comanda> listaComandas;
    private JList<Factura> listaFacturas;
    private JList<ProductoEnPromocion> listaProductosEnPromocion;
    private JList<PromocionTemporal> listaPromocionesTemporales;
    private JScrollPane productoEnPromocionScrollPane;
    private JScrollPane promocionesTemporalesScrollPane;
    private JLabel fechaHoraLabel2;
    //MODELOS PARA LISTA
    DefaultListModel<Comanda> modeloComanda = new DefaultListModel<>();
    DefaultListModel<Factura> modeloFactura = new DefaultListModel<>();
    DefaultListModel<ProductoEnPromocion> modeloProductoEnPromocion = new DefaultListModel<>();
    DefaultListModel<PromocionTemporal> modeloPromocionGeneral = new DefaultListModel<>();

    @Override
    public void setActionListener(ActionListener controlador) {
        inicioButton.addActionListener(controlador);
        mozosButton.addActionListener(controlador);
        comandasButton.addActionListener(controlador);
        facturasButton.addActionListener(controlador);
        promocionesButton.addActionListener(controlador);
        IniciarJornadaButton.addActionListener(controlador);
        cerrarSesionButton.addActionListener(controlador);
        asignarMesasButton.addActionListener(controlador);
        nuevaComandaButton.addActionListener(controlador);
        editarComandaButton.addActionListener(controlador);
        cerrarComandaButton.addActionListener(controlador);
    }

    @Override
    public void setListSelectionListener() {
        this.listaComandas.addListSelectionListener(this);
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

        setNombreLocal();
        setModelos();
        inicializarListas();
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
    public void setNombreLocal() {
        String nombreLocal = Cerveceria.getInstance().getNombreDelLocal();
        if (!nombreLocal.isEmpty()) {
            this.cerveceriaLabel.setText(nombreLocal);
        }
    }

    @Override
    public void setNombreCompleto(String nombreCompleto) {
        this.NombreApellidoLabel.setText(nombreCompleto);
    }

    @Override
    public void setModelos() {
        this.listaComandas.setModel(modeloComanda);
        this.listaFacturas.setModel(modeloFactura);
        this.listaProductosEnPromocion.setModel(modeloProductoEnPromocion);
        this.listaPromocionesTemporales.setModel(modeloPromocionGeneral);
    }

    @Override
    public void inicializarListas() {
        ArrayList<Comanda> comandas = Cerveceria.getInstance().getComandas();
        ArrayList<Factura> facturas = Cerveceria.getInstance().getFacturas();
        ArrayList<IPromocion> promociones = Cerveceria.getInstance().getPromociones();

        comandas.forEach((comanda) -> {
            this.modeloComanda.add(modeloComanda.size(), comanda);
        });

        facturas.forEach((factura) -> {
            this.modeloFactura.add(modeloFactura.size(), factura);
        });

        //RESOLVER TEMA PROMOCIONES
    }

    @Override
    public void actualizaLista() {

    }

    @Override
    public Comanda getComandaSeleccionada() {
        return this.listaComandas.getSelectedValue();
    }

    @Override
    public Factura getFacturaSeleccionada() {
        return this.listaFacturas.getSelectedValue();
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
        this.mozosButton.setBackground(Color.decode("#D9D9D9"));
        this.comandasButton.setBackground(Color.decode("#D9D9D9"));
        this.facturasButton.setBackground(Color.decode("#D9D9D9"));
        this.promocionesButton.setBackground(Color.decode("#D9D9D9"));

        switch (pagina) {
            case 0 -> this.inicioButton.setBackground(Color.decode("#FFFFFF"));
            case 1 -> this.mozosButton.setBackground(Color.decode("#FFFFFF"));
            case 2 -> this.comandasButton.setBackground(Color.decode("#FFFFFF"));
            case 3 -> this.facturasButton.setBackground(Color.decode("#FFFFFF"));
            case 4 -> this.promocionesButton.setBackground(Color.decode("#FFFFFF"));
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //COMANDAS
        this.editarComandaButton.setEnabled(false);
        this.cerrarComandaButton.setEnabled(false);

        if (listaComandas.getSelectedValue() != null) {
            this.editarComandaButton.setEnabled(true);
            this.cerrarComandaButton.setEnabled(true);
        }
    }
}
