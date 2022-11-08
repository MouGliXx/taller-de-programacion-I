package vista.ventanas;

import modelo.*;
import vista.interfaces.IVistaAdministrador;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa la interfaz del Administrador.<br>
 * */
public class VentanaAdministrador extends JFrame implements IVistaAdministrador, ActionListener, KeyListener, ListSelectionListener {
    private String tipoEntidadSeleccionada = "Operarios";
    private String promocionSeleccionada = "Productos en Promocion";
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
    private JList<PromocionProducto> listaProductosEnPromocion;
    private JPanel estadisticasPanel;
    private JCheckBox mesasDelLocalCheckBox;
    private JCheckBox productosEnVentaCheckBox;
    private JCheckBox mozosCheckBox;
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
    private JLabel estadisticasDeLosMozosLabel;
    private JScrollPane estadisticasDeLosMozosScrollPane;
    private JLabel estadisticasDeLasMesasLabel;
    private JScrollPane estadisticasDeLasMesasScrollpane;
    private JList listaEstadisticasMozos;
    private JList listasEstadisticasMesas;
    //MODELOS PARA LISTAS
    DefaultListModel<Operario> modeloOperario = new DefaultListModel<>();
    DefaultListModel<Mozo> modeloMozo = new DefaultListModel<>();
    DefaultListModel<Producto> modeloProducto = new DefaultListModel<>();
    DefaultListModel<Mesa> modeloMesa = new DefaultListModel<>();
    DefaultListModel<PromocionProducto> modeloProductoEnPromocion = new DefaultListModel<>();
    DefaultListModel<PromocionTemporal> modeloPromocionTemporal = new DefaultListModel<>();

    /**
     * Agrega los ActionListener a los diferentes componentes de la ventana, para notificar ActionEvent que ocurran dentro de la misma.<br>
     *
     * <b>pre</b> controlador distinto de null.<br>
     * <b>post</b> Se ha asignado un ActionListener a los componentes que lo necesiten.<br>
     *
     * @param controlador Es la clase que recibe los ActionEvent de la ventana.
     */
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
        //CHECKBOXS
        this.operariosCheckBox.addActionListener(this);
        this.mozosCheckBox.addActionListener(this);
        this.productosEnVentaCheckBox.addActionListener(this);
        this.mesasDelLocalCheckBox.addActionListener(this);
        this.productosEnPromocionCheckBox.addActionListener(this);
        this.promocionesTemporalesCheckBox.addActionListener(this);
    }

    /**
     * Agrega los KeyListener especificados a los diferentes JTextField de la ventana, para notificar KeyEvent de los JTextField.<br>
     *
     * <b>pre</b> Deben existir componentes JTextField dentro de la ventana.<br>
     * <b>post</b> Se ha asignado un KeyListener a los TextField que lo necesiten.<br>
     */
    @Override
    public void setKeyListener() {
        this.cerveceriaTextField.addKeyListener(this);
        this.remuneracionTextField.addKeyListener(this);
    }

    /**
     * Agrega los ListSelectionListener especificados a las diferentes JList de la ventana, para notificar cada vez que ocurra un cambio en la selección.<br>
     *
     * <b>pre</b> Deben existir componentes JList dentro de la ventana.<br>
     * <b>post</b> Se han agregado los ListSelectionListener a los JList especificados.<br>
     */
    @Override
    public void setListSelectionListener() {
        this.listaOperarios.addListSelectionListener(this);
        this.listaMozos.addListSelectionListener(this);
        this.listaProductos.addListSelectionListener(this);
        this.listaMesas.addListSelectionListener(this);
        this.listaProductosEnPromocion.addListSelectionListener(this);
        this.listaPromocionesTemporales.addListSelectionListener(this);
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
        this.listaOperarios.setModel(modeloOperario);
        this.listaMozos.setModel(modeloMozo);
        this.listaProductos.setModel(modeloProducto);
        this.listaMesas.setModel(modeloMesa);
        this.listaProductosEnPromocion.setModel(modeloProductoEnPromocion);
        this.listaPromocionesTemporales.setModel(modeloPromocionTemporal);
    }

    /**
     * Elimina de los modelos el elemento de la lista seleccionado, discriminando por cada lista segun su nombre.<br>
     *
     * <b>pre</b> nombreLista distinto de null.<br>
     * <b>post</b> Se elimina el elemento seleccionado de la lista.<br>
     * @param nombreLista Representa el nombre de la lista a la que se le quiere remover el elemento.<br>
     */
    @Override
    public void actualizarLista(String nombreLista) {
        switch (nombreLista) {
            case "Operarios" -> modeloOperario.remove(listaOperarios.getSelectedIndex());
            case "Mozos" -> modeloMozo.remove(listaMozos.getSelectedIndex());
            case "Productos en Venta" -> modeloProducto.remove(listaProductos.getSelectedIndex());
            case "Mesas del Local" -> modeloMesa.remove(listaMesas.getSelectedIndex());
            case "Productos en Promocion" -> modeloProductoEnPromocion.remove(listaProductosEnPromocion.getSelectedIndex());
            case "Promociones Temporales" -> modeloPromocionTemporal.remove(listaPromocionesTemporales.getSelectedIndex());
        }
    }

    /**
     * Inicializa los distintos DefaultListModel de entidades con los conjuntos de datos del modelo, pora su visualizacion en las JList.<br>
     *
     * <b>pre</b> Los DefaultListModel ya han sido seteados a sus JList.<br>
     * <b>post</b> Se pueden visualizar las distintas entidades en sus respectivas listas.<br>
     */
    @Override
    public void inicializarListasEntidades() {
        ArrayList<Operario> operarios = Cerveceria.getInstance().getOperarios();
        ArrayList<Mozo> mozos = Cerveceria.getInstance().getMozos();
        HashMap<Integer,Producto> productos = Cerveceria.getInstance().getProductos();
        ArrayList<Mesa> mesas = Cerveceria.getInstance().getMesas();


        modeloOperario.removeAllElements();
        operarios.forEach((operario) -> this.modeloOperario.add(modeloOperario.size(), operario));

        modeloMozo.removeAllElements();
        mozos.forEach((mozo) -> this.modeloMozo.add(modeloMozo.size(), mozo));

        modeloProducto.removeAllElements();
        productos.forEach((id, producto) -> this.modeloProducto.add(modeloProducto.size(), producto));

        modeloMesa.removeAllElements();
        mesas.forEach((mesa) -> this.modeloMesa.add(modeloMesa.size(), mesa));
   }

    /**
     * Inicializa los distintos DefaultListModel de promociones con los conjuntos de datos del modelo, pora su visualizacion en las JList.<br>
     *
     * <b>pre</b> Los DefaultListModel ya han sido seteados a sus JList.<br>
     * <b>post</b> Se pueden visualizar las distintas promociones en sus respectivas listas.<br>
     */
    @Override
    public void inicializarListasPromociones() {
        ArrayList<PromocionProducto> promocionesProductos = Cerveceria.getInstance().getPromocionesProductos();
        ArrayList<PromocionTemporal> promocionesTemporales = Cerveceria.getInstance().getPromocionesTemporales();

        modeloProductoEnPromocion.removeAllElements();
        promocionesProductos.forEach((promocionProducto) -> this.modeloProductoEnPromocion.add(modeloProductoEnPromocion.size(), promocionProducto));

        modeloPromocionTemporal.removeAllElements();
        promocionesTemporales.forEach((promocionTemporal) -> this.modeloPromocionTemporal.add(modeloPromocionTemporal.size(), promocionTemporal));
    }

    /**
     * Devuelve el nombre del local de la clase Cerveceria.<br>
     *
     * @return Nombre del local.<br>
     */
    @Override
    public String getNombreLocal() {
        return cerveceriaTextField.getText();
    }

    /**
     * Establece el nombre del local de la clase Cerveceria.<br>
     *
     * @param nombreLocal Es el nombre de la cerveceria.<br>
     */
    @Override
    public void setNombreLocal(String nombreLocal) {
        this.cerveceriaTextField.setText(nombreLocal);
    }

    /**
     * Devuelve la remuneracion basica de la clase Cerveceria.<br>
     *
     * @return Remuneracion basica.<br>
     */
    @Override
    public Double getRemuneracion() {
        return Double.parseDouble(remuneracionTextField.getText());
    }

    /**
     * Establece la remuneracion basica de la clase Cerveceria.<br>
     *
     * @param remuneracion Es la remuneracion basica de la cerveceria.<br>
     */
    @Override
    public void setRemuneracion(double remuneracion) {
        this.remuneracionTextField.setText(String.valueOf(remuneracion));
    }

    /**
     * Devuelve el tipo de entidad seleccionada en el panel de Entidades.<br>
     *
     * @return Tipo de entidad seleccionada.<br>
     */
    @Override
    public String getTipoEntidadSeleccionada() {
        return tipoEntidadSeleccionada;
    }

    /**
     * Deveulve el Operario seleccionado en la JList de Operarios.<br>
     *
     * @return Operario seleccionado.<br>
     */
    @Override
    public Operario getOperarioSeleccionado() {
        return this.listaOperarios.getSelectedValue();
    }

    /**
     * Deveulve el mozo seleccionado en la JList de Mozos.<br>
     *
     * @return mozo seleccionado.<br>
     */
    @Override
    public Mozo getMozoSeleccionado() {
        return this.listaMozos.getSelectedValue();
    }

    /**
     * Deveulve el Producto seleccionado en la JList de Productos.<br>
     *
     * @return Producto seleccionado.<br>
     */
    @Override
    public Producto getProductoSeleccionado() {
        return this.listaProductos.getSelectedValue();
    }

    /**
     * Deveulve la Mesa seleccionada en la JList de Mesas.<br>
     *
     * @return Mesa seleccionada.<br>
     */
    @Override
    public Mesa getMesaSeleccionada() {
        return this.listaMesas.getSelectedValue();
    }

    /**
     * Devuelve el tipo de promocion seleccionada en el panel de Promociones.<br>
     *
     * @return Tipo de promocion seleccionada.<br>
     */
    @Override
    public String getTipoPromocionSeleccionada() {
        return promocionSeleccionada;
    }

    /**
     * Deveulve la PromocionProducto seleccionada en la JList de ProductosEnPromocion.<br>
     *
     * @return PromocionProducto seleccionada.<br>
     */
    @Override
    public PromocionProducto getProductoEnPromocionSeleccionado() {
        return this.listaProductosEnPromocion.getSelectedValue();
    }

    /**
     * Deveulve la PromocionTemporal seleccionada en la JList de PromocionesTemporales.<br>
     *
     * @return PromocionTemporal seleccionada.<br>
     */
    @Override
    public PromocionTemporal getPromocionTemporalSeleccionada() {
        return this.listaPromocionesTemporales.getSelectedValue();
    }

    /**
     * Cambia la pagina del JTabbedPane central segun el parametro recibido.<br>
     *
     * <b>pre</b> pagina distinto de null y en el rango entre 0 y 3.<br>
     * <b>post</b> Se cambia la pagina a la establecida en el parametro.<br>
     *
     * @param pagina Numero de pagina al que se quiere cambiar.<br>
     */
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
            case "Productos en Promocion", "Promociones Temporales" -> {
                this.nuevaPromocionButton.setEnabled(true);
                this.eliminarPromocionButton.setEnabled(false);
                this.activarButton.setVisible(false);
                this.desactivarButton.setVisible(false);

                if (this.productosEnPromocionCheckBox.isSelected()) {
                    this.promocionSeleccionada = "Productos en Promocion";
                    this.promocionesTabbedPane.setSelectedIndex(0);

                }

                if (this.promocionesTemporalesCheckBox.isSelected()) {
                    this.promocionSeleccionada = "Promociones Temporales";
                    this.promocionesTabbedPane.setSelectedIndex(1);
                }

                inicializarListasPromociones();
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

        editarTituloButton.setEnabled(!cerveceriaTextField.getText().equals(nombreLocal));
        editarRemuneracionButton.setEnabled(!remuneracionTextField.getText().equals(remuneracionBasica));
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
