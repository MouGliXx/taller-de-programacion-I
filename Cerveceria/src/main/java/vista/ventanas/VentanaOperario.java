package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaOperario;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa la interfaz del Operario.<br>
 */
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
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JComboBox<String> comboBox5;
    private JLabel NPLabel1;
    private JLabel NPLabel2;
    private JLabel NPLabel3;
    private JLabel NPLabel4;
    private JLabel NPLabel5;
    private JLabel NPLabel6;
    private JComboBox<String> comboBox6;
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
    private JList<PromocionProducto> listaProductosEnPromocion;
    private JList<PromocionTemporal> listaPromocionesTemporales;
    private JScrollPane productoEnPromocionScrollPane;
    private JScrollPane promocionesTemporalesScrollPane;
    private JButton finalizarJornadaButton;
    private JLabel fechaHoraLabel2;
    //ARRAYLIST DE COMPONENTES PARA MOZOSPANEL
    ArrayList<JLabel> arrayLabels0 = new ArrayList<>(6);
    ArrayList<JComboBox<String>> arrayComboBox = new ArrayList<>(6);
    ArrayList<JLabel> arrayLabels1 = new ArrayList<>(6);
    //MODELOS PARA LISTA
    DefaultListModel<Comanda> modeloComanda = new DefaultListModel<>();
    DefaultListModel<Factura> modeloFactura = new DefaultListModel<>();
    DefaultListModel<PromocionProducto> modeloProductoEnPromocion = new DefaultListModel<>();
    DefaultListModel<PromocionTemporal> modeloPromocionTemporal = new DefaultListModel<>();

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
        nuevaComandaButton.addActionListener(controlador);
        editarComandaButton.addActionListener(controlador);
        cerrarComandaButton.addActionListener(controlador);
    }

    /**
     * Agrega los ActionListener a los diferentes componentes de la ventana.<br>
     *
     * <b>pre</b> controlador distinto de null.<br>
     * <b>post</b> Se ha asignado un ActionListener a los componentes que lo necesiten.<br>
     *
     * @param controlador Es la clase que recibe los eventos de acción de la ventana.
     */
    @Override
    public void setItemListener(ItemListener controlador) {
        this.comboBox1.addItemListener(controlador);
        this.comboBox1.addItemListener(this);
        this.comboBox2.addItemListener(controlador);
        this.comboBox2.addItemListener(this);
        this.comboBox3.addItemListener(controlador);
        this.comboBox3.addItemListener(this);
        this.comboBox4.addItemListener(controlador);
        this.comboBox4.addItemListener(this);
        this.comboBox5.addItemListener(controlador);
        this.comboBox5.addItemListener(this);
        this.comboBox6.addItemListener(controlador);
        this.comboBox6.addItemListener(this);
    }

    /**
     * Agrega los ListSelectionListener especificados a las diferentes JList de la ventana, para notificar cada vez que ocurra un cambio en la selección.<br>
     *
     * <b>pre</b> Deben existir componentes JList dentro de la ventana.<br>
     * <b>post</b> Se han agregado los ListSelectionListener a los JList especificados.<br>
     */
    @Override
    public void setListSelectionListener() {
        this.listaComandas.addListSelectionListener(this);
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
        this.listaComandas.setModel(modeloComanda);
        this.listaFacturas.setModel(modeloFactura);
        this.listaProductosEnPromocion.setModel(modeloProductoEnPromocion);
        this.listaPromocionesTemporales.setModel(modeloPromocionTemporal);
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

    /**
     * Inicializa los distintos DefaultListModel con los conjuntos de datos del modelo, pora su visualizacion en las JList.<br>
     *
     * <b>pre</b> Los DefaultListModel ya han sido seteados a sus JList.<br>
     * <b>post</b> Se pueden visualizar las distintas datos en sus respectivas listas.<br>
     */
    @Override
    public void inicializarListas() {
        ArrayList<Comanda> comandas = Cerveceria.getInstance().getComandas();
        ArrayList<Factura> facturas = Cerveceria.getInstance().getFacturas();
        ArrayList<PromocionProducto> promocionesProductos = Cerveceria.getInstance().getPromocionesProductos();
        ArrayList<PromocionTemporal> promocionesTemporales = Cerveceria.getInstance().getPromocionesTemporales();

        modeloComanda.removeAllElements();
        comandas.forEach((comanda) -> this.modeloComanda.add(modeloComanda.size(), comanda));

        modeloFactura.removeAllElements();
        facturas.forEach((factura) -> this.modeloFactura.add(modeloFactura.size(), factura));

        modeloProductoEnPromocion.removeAllElements();
        promocionesProductos.forEach((promocionProducto) -> this.modeloProductoEnPromocion.add(modeloProductoEnPromocion.size(), promocionProducto));

        modeloPromocionTemporal.removeAllElements();
        promocionesTemporales.forEach((promocionTemporal) -> this.modeloPromocionTemporal.add(modeloPromocionTemporal.size(), promocionTemporal));
    }

    @Override
    public void asignarMesas(HashMap<Mesa,Mozo> mesasAsignadas) {
        this.asignarMesasButton.setEnabled(false);
        this.iniciarJornadaButton.setEnabled(true);

        for (int i = 0; i < 6; i++) {
            if (arrayComboBox.get(i).isVisible()) {
                arrayComboBox.get(i).setEnabled(false);
                arrayLabels1.get(i).setText("");
            } else {
                break;
            }
        }

        mesasAsignadas.forEach((mesa, mozo) -> {
            for (int i = 0; i < arrayLabels0.size(); i++) {
                if (arrayLabels0.get(i).getText().equals(mozo.getNombreYApellido())) {
                    String textoAnterior = arrayLabels1.get(i).getText();
                    arrayLabels1.get(i).setText(textoAnterior + mesa.getNro() + ", ");
                }
            }
        });
    }

    @Override
    public ArrayList<String> getEstadoMozos() {
        ArrayList<String> estadoMozos = new ArrayList<>();

        for (JComboBox<String> comboBox : arrayComboBox) {
            switch (comboBox.getSelectedIndex()) {
                case 0 -> estadoMozos.add("Activo");
                case 1 -> estadoMozos.add("Ausente");
                case 2 -> estadoMozos.add("Franco");
            }
        }

        return estadoMozos;
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
                this.nuevaComandaButton.setEnabled(true);
            }
            case "Finalizar Jornada" -> {
                if (modeloComanda.isEmpty()) {
                    this.iniciarJornadaButton.setVisible(true);
                    this.finalizarJornadaButton.setVisible(false);
                    this.nuevaComandaButton.setEnabled(false);
                } else {
                    lanzarVentanaEmergente("Para finalizar la jornada es necesario cerrar todas las comandas primero.");
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        this.asignarMesasButton.setEnabled(true);

        for (int i = 0; i < 6; i++) {
            if (arrayComboBox.get(i).isVisible()) {
                if (arrayComboBox.get(i).getSelectedIndex() == -1) {
                    this.asignarMesasButton.setEnabled(false);
                }
            } else {
                break;
            }
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
