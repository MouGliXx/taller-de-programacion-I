package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaOperario;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaOperario extends JFrame implements IVistaOperario, ActionListener, ItemListener, ListSelectionListener {
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
    private JButton iniciarJornadaButton;
    private JLabel bienvenidoLabel;
    private JLabel cerveceriaLabel;
    private JLabel nombreApellidoLabel;
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
    private JLabel NPLabel1;
    private JLabel NPLabel2;
    private JLabel NPLabel3;
    private JLabel NPLabel4;
    private JLabel NPLabel5;
    private JLabel NPLabel6;
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
    private JButton finalizarJornadaButton;
    private JLabel fechaHoraLabel2;
    //ARRAYLIST DE COMPONENTES PARA MOZOSPANEL
    ArrayList<JLabel> arrayLabels0 = new ArrayList<>(6);
    ArrayList<JComboBox> arrayComboBox = new ArrayList<>(6);
    ArrayList<JLabel> arrayLabels1 = new ArrayList<>(6);
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
        iniciarJornadaButton.addActionListener(controlador);
        iniciarJornadaButton.addActionListener(this);
        finalizarJornadaButton.addActionListener(controlador);
        finalizarJornadaButton.addActionListener(this);
        cerrarSesionButton.addActionListener(controlador);
        asignarMesasButton.addActionListener(controlador);
        asignarMesasButton.addActionListener(this);
        nuevaComandaButton.addActionListener(controlador);
        editarComandaButton.addActionListener(controlador);
        cerrarComandaButton.addActionListener(controlador);
    }

    @Override
    public void setItemListener() {
        this.comboBox1.addItemListener(this);
        this.comboBox2.addItemListener(this);
        this.comboBox3.addItemListener(this);
        this.comboBox4.addItemListener(this);
        this.comboBox5.addItemListener(this);
        this.comboBox6.addItemListener(this);
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
        inicializaArrays();
        inicializarMozos();
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
        this.nombreApellidoLabel.setText(nombreCompleto);
    }

    @Override
    public void setModelos() {
        this.listaComandas.setModel(modeloComanda);
        this.listaFacturas.setModel(modeloFactura);
        this.listaProductosEnPromocion.setModel(modeloProductoEnPromocion);
        this.listaPromocionesTemporales.setModel(modeloPromocionGeneral);
    }

    @Override
    public void inicializaArrays() {
        arrayLabels0.add(NPLabel1); arrayLabels0.add(NPLabel2); arrayLabels0.add(NPLabel3);
        arrayLabels0.add(NPLabel4); arrayLabels0.add(NPLabel5); arrayLabels0.add(NPLabel6);

        arrayComboBox.add(comboBox1); arrayComboBox.add(comboBox2); arrayComboBox.add(comboBox3);
        arrayComboBox.add(comboBox4); arrayComboBox.add(comboBox5); arrayComboBox.add(comboBox6);

        arrayLabels1.add(MA1); arrayLabels1.add(MA2); arrayLabels1.add(MA3);
        arrayLabels1.add(MA4); arrayLabels1.add(MA5); arrayLabels1.add(MA6);
    }

    @Override
    public void inicializarMozos() {
        ArrayList<Mozo> mozos = Cerveceria.getInstance().getMozos();
        int i = 0;

        if (mozos != null && !mozos.isEmpty()) {
            for (Mozo mozo : mozos) {
                arrayLabels0.get(i).setText(mozo.getNombreYApellido());
                i++;
            }
        }

        while (i < 6) {
            arrayLabels0.get(i).setVisible(false);
            arrayComboBox.get(i).setVisible(false);
            arrayLabels1.get(i).setVisible(false);
            i++;
        }
    }

    @Override
    public void inicializarListas() {
        ArrayList<Comanda> comandas = Cerveceria.getInstance().getComandas();
        ArrayList<Factura> facturas = Cerveceria.getInstance().getFacturas();
        ArrayList<Promocion> promociones = Cerveceria.getInstance().getPromociones();

        modeloComanda.removeAllElements();
        comandas.forEach((comanda) -> {
            this.modeloComanda.add(modeloComanda.size(), comanda);
        });

        modeloFactura.removeAllElements();
        facturas.forEach((factura) -> {
            this.modeloFactura.add(modeloFactura.size(), factura);
        });

        //RESOLVER TEMA PROMOCIONES
    }

    @Override
    public Comanda getComandaSeleccionada() {
        return this.listaComandas.getSelectedValue();
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
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Iniciar Jornada" -> {
                this.iniciarJornadaButton.setVisible(false);
                this.finalizarJornadaButton.setVisible(true);
            }
            case "Finalizar Jornada" -> {
                this.iniciarJornadaButton.setVisible(true);
                this.finalizarJornadaButton.setVisible(false);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

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
