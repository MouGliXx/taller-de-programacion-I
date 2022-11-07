package vista.ventanas;

import modelo.Cerveceria;
import modelo.Mesa;
import modelo.Pedido;
import vista.interfaces.IVistaComanda;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa la interfaz cuando se crea/edita una comanda.<br>
 * */
public class VentanaComanda extends JFrame implements IVistaComanda, ActionListener, ListSelectionListener {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JLabel accionComandaLabel;
    private JLabel fechaLabel;
    private JLabel fechaActualLabel;
    private JComboBox<String> mesaComboBox;
    private JLabel listadoDePedidosAsignadosLabel;
    private JButton accionButton;
    private JList<Pedido> listaPedidosAsignados;
    private JButton nuevoPedidoButton;
    private JButton eliminarPedidoButton;
    private JPanel fechayMesaPnael;
    private JLabel mesaLabel;
    private JButton cancelarButton;
    private JScrollPane pedidosScrollPane;
    //MODELOS
    DefaultListModel<Pedido> modeloPedidos = new DefaultListModel<>();
    DefaultComboBoxModel<String> modeloMesas = new DefaultComboBoxModel<>();

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
        //BOTONES
        nuevoPedidoButton.addActionListener(controlador);
        eliminarPedidoButton.addActionListener(controlador);
        accionButton.addActionListener(controlador);
        cancelarButton.addActionListener(controlador);
        //COMBO BOX
        mesaComboBox.addActionListener(this);
    }

    /**
     * Agrega los ListSelectionListener especificados a las diferentes JList de la ventana, para notificar cada vez que ocurra un cambio en la selección.<br>
     *
     * <b>pre</b> Deben existir componentes JList dentro de la ventana.<br>
     * <b>post</b> Se han agregado los ListSelectionListener a los JList especificados.<br>
     */
    @Override
    public void setListSelectionListener() {
        listaPedidosAsignados.addListSelectionListener(this);
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
        this.listaPedidosAsignados.setModel(modeloPedidos);
        this.mesaComboBox.setModel(modeloMesas);
    }

    /**
     * Establece la accion que sera reflejada en la comanda (crear/editar).<br>
     *
     * <b>pre</b> accion distinto de null, solo puede ser 'crear' o 'editar'.<br>
     * <b>post</b> La ventana se personaliza en base a la accion recibida.<br>
     *
     * @param accion Refleja el proposito de la ventana con la comanda.<br>
     */
    @Override
    public void setAccion(String accion) {
        this.accionComandaLabel.setText(accion + " comanda");
        this.accionButton.setText(accion);
    }

    /**
     * Establece la fecha de la comanda en la ventana.<br>
     *
     * <b>pre</b> fecha distinto de null.<br>
     * <b>post</b> La ventana se personaliza con la fecha recibida.<br>
     *
     * @param fecha Representa la fecha en la que fue creada la comanda.<br>
     */
    @Override
    public void setFecha(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm:ss");
        String fechaActual = dateFormat.format(new Date());
        this.fechaActualLabel.setText(fechaActual);
    }

    /**
     * Inicializa el DefaultComboBoxModel dependiendo del parametro recibido, pora su visualizacion en la JComboBox.<br>
     *
     * <b>pre</b> El DefaultComboBoxModel ya ha sido seteado a su JComboBox.<br>
     * <b>post</b> Se pueden visualizar o la mesa ingresada o el conjunto de mesas libres en el JComboBox.<br>
     * @param mesa Representa la mesa a la que esta asociada la comanda.<br>
     */
    @Override
    public void inicializaComboBox(Mesa mesa) {
        if (mesa != null) {
            this.mesaComboBox.setEnabled(false);
            this.nuevoPedidoButton.setEnabled(true);
            this.accionButton.setEnabled(true);

            modeloMesas.removeAllElements();
            modeloMesas.addElement(String.valueOf(mesa.getNro()));
        } else {
            ArrayList<Mesa> mesas = Cerveceria.getInstance().getMesas();

            modeloMesas.removeAllElements();
            modeloMesas.addElement(null);
            for (Mesa mesaActual : mesas) {
                if (mesaActual.getEstado().equalsIgnoreCase("Libre")) {
                    modeloMesas.addElement(String.valueOf(mesaActual.getNro()));
                }
            }
        }
    }

    /**
     * Inicializa el DefaultListModel con el conjunto de pedidos de la comanda, pora su visualizacion en la JList.<br>
     *
     * <b>pre</b> El DefaultListModel ya ha sido seteados a su JList.<br>
     * <b>post</b> Se pueden visualizar los distintos pedidos en su respectiva lista.<br>
     * @param pedidos Conjunto de pedidos asociados a una comanda, distinto de null
     */
    @Override
    public void inicializarLista(ArrayList<Pedido> pedidos) {
        if (!pedidos.isEmpty()) {
            this.accionButton.setEnabled(true);

            modeloPedidos.removeAllElements();
            pedidos.forEach((pedido) -> modeloPedidos.add(modeloPedidos.size(), pedido));
        }
    }

    /**
     * Deveulve la el numero de mesa de la Mesa seleccionada en el JComboBox de Mesas.<br>
     *
     * @return Numero de la mesa seleccionada.<br>
     */
    @Override
    public int getNroMesa() {
        return Integer.parseInt(modeloMesas.getElementAt(mesaComboBox.getSelectedIndex()));
    }

    /**
     * Deveulve el conjunto de pedidos asociados a la comanda.<br>
     *
     * @return Pedidos de la comanda.<br>
     */
    @Override
    public ArrayList<Pedido> getPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        for (int i = 0; i < modeloPedidos.size(); i++) {
            pedidos.add(modeloPedidos.getElementAt(i));
        }

        return pedidos;
    }

    /**
     * Elimina el pedido seleccionado en la JList de su modelo asociado.<br>
     *
     * <b>pre</b> El DefaultListModel ya ha sido seteados a su JList.<br>
     * <b>post</b> Se elimina el pedido seleccionado de la lista.<br>
     */
    @Override
    public void eliminaPedidoEnLista() {
        if (!modeloPedidos.isEmpty()) {
            this.modeloPedidos.removeElementAt(listaPedidosAsignados.getSelectedIndex());
        }
    }

    /**
     * Deveulve el Pedido seleccionada en la JList de Pedidos.<br>
     *
     * @return Pedido seleccionada.<br>
     */
    @Override
    public Pedido getPedidoSeleccionado() {
        return this.listaPedidosAsignados.getSelectedValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.nuevoPedidoButton.setEnabled(false);
        this.accionButton.setEnabled(false);

        if (e.getActionCommand().equals("Selecciona Mesa")) {
            if (this.mesaComboBox.getSelectedIndex() != -1) {
                this.accionButton.setEnabled(true);
                this.nuevoPedidoButton.setEnabled(true);
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.eliminarPedidoButton.setEnabled(false);
        this.accionButton.setEnabled(false);

        if (listaPedidosAsignados.getSelectedValue() != null) {
            this.eliminarPedidoButton.setEnabled(true);
        }

        if (this.mesaComboBox.getSelectedIndex() != -1) {
            this.accionButton.setEnabled(true);
            this.nuevoPedidoButton.setEnabled(true);
        }
    }
}
