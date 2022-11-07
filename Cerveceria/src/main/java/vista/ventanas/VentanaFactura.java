package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaFactura;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa la interfaz cuando se crea una factura.<br>
 */
public class VentanaFactura extends JFrame implements IVistaFactura {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JLabel accionComandaLabel;
    private JPanel fechayMesaPnael;
    private JLabel fechaLabel;
    private JLabel fechaActualLabel;
    private JLabel mesaLabel;
    private JLabel listadoDePedidosAsignadosLabel;
    private JLabel promocionesAplicadasLabel;
    private JLabel numeroMesaLabel;
    private JList<Pedido> listaProductos;
    private JList<Promocion> listaPromociones;
    private JScrollPane productosScrollPane;
    private JScrollPane promocionesScrollPane;
    private JComboBox<String> formasDePagoBox;
    private JButton cancelarButton;
    private JButton crearButton;
    private JLabel formasDePagoLabel;
    private JLabel totalLabel;
    private JLabel montoLabel;
    //MODELOS PARA LISTA
    DefaultListModel<Pedido> modeloProductos = new DefaultListModel<>();
    DefaultListModel<Promocion> modeloPromociones = new DefaultListModel<>();

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
        this.crearButton.addActionListener(controlador);
        this.cancelarButton.addActionListener(controlador);
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
        this.listaProductos.setModel(modeloProductos);
        this.listaPromociones.setModel(modeloPromociones);
    }

    /**
     * Inicializa los distintos DefaultListModel de pedidos y promociones con los conjuntos de datos del modelo, pora su visualizacion en las JList.<br>
     *
     * <b>pre</b> Los DefaultListModel ya han sido seteados a sus JList.<br>
     * <b>post</b> Se pueden visualizar los pedidos y las promociones en sus respectivas listas.<br>
     * @param pedidos Conjunto de pedidos asociados a la factura.<br>
     * @param promociones Conjunto de promociones que aplican a la factura.<br>
     */
    @Override
    public void inicializarListas(ArrayList<Pedido> pedidos, ArrayList<Promocion> promociones) {
        if (pedidos != null && !pedidos.isEmpty()) {
            pedidos.forEach((pedido) -> modeloProductos.add(modeloProductos.size(), pedido));
        }

        if (promociones != null && !promociones.isEmpty()) {
            promociones.forEach((promocion) -> modeloPromociones.add(modeloPromociones.size(), promocion));
        }
    }

    /**
     * Establece los datos de la Factura en los componentes de la ventana, para su visualizacion.<br>
     *
     * <b>pre</b> Los DefaultListModel ya han sido seteados a sus JList.<br>
     * <b>post</b> La ventana se personaliza con los datos recibidos.<br>
     *
     * @param fecha Fecha de la comanda cerrada. Distinto de null e igual a la fecha de la comanda<br>
     * @param NMesa Numero de mesa asociado a la comanda cerrada. Distinto de null e igual al de la comanda<br>
     * @param pedidos Conjunto de pedidos asociados a la comanda cerrada. Distinto de null e igual al de la comanda<br>
     * @param total Monto total a cobrar a la mesa. Disitinto de null<br>
     * @param promociones Conjunto de promociones que aplican a la factura.<br>
     */
    @Override
    public void setDatos(Date fecha, int NMesa, ArrayList<Pedido> pedidos, double total, ArrayList<Promocion> promociones) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm:ss");
        String fechaActual = dateFormat.format(fecha);

        this.fechaActualLabel.setText(fechaActual);
        this.numeroMesaLabel.setText(String.valueOf(NMesa));
        this.montoLabel.setText(String.valueOf(total));
        inicializarListas(pedidos, promociones);
    }

    /**
     * Devuelve la Forma de Pago seleccionada en la ventana.<br>
     *
     * @return Forma de pogo de la Factura.<br>
     */
    @Override
    public String getFormaDePago() {
        return (String) formasDePagoBox.getSelectedItem();
    }
}
