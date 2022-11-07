package negocio;

import modelo.*;
import vista.interfaces.IVistaAdministrador;
import vista.ventanas.VentanaEntidad;
import vista.ventanas.VentanaLogin;
import vista.ventanas.VentanaPromocion;
import java.awt.event.*;

public class ControladorAdministrador implements ActionListener, WindowListener {
    private Administrador modelo;
    private IVistaAdministrador vista;

    public ControladorAdministrador(Administrador modelo, IVistaAdministrador vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setKeyListener();
        this.vista.setListSelectionListener();
        this.vista.setWindowListener(this);
        this.vista.setNombreLocal(Cerveceria.getInstance().getNombreDelLocal());
        this.vista.setRemuneracion(Cerveceria.getInstance().getRemuneracionBasica());
        this.vista.inicializarListasEntidades();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Inicio" -> vista.cambiarPagina(0);
            case "Entidades" -> vista.cambiarPagina(1);
            case "Promociones" -> vista.cambiarPagina(2);
            case "Estadisticas" -> vista.cambiarPagina(3);
            case "Editar Cerveceria" -> Cerveceria.getInstance().setNombreDelLocal(vista.getNombreLocal());
            case "Editar Remuneracion" -> Cerveceria.getInstance().setRemuneracionBasica(vista.getRemuneracion());
            case "Cerrar Sesion" -> creaOtraVentana("Login");
            case "Agregar" -> creaOtraVentana("Agregar Entidad");
            case "Modificar" -> creaOtraVentana("Modificar Entidad");
            case "Eliminar" -> {
                switch (vista.getTipoEntidadSeleccionada()) {
                    case "Operarios" -> {
                        Operario operario = vista.getOperarioSeleccionado();
                        Cerveceria.getInstance().eliminarOperario(operario);
                        vista.actualizarLista("Operarios");
                    }
                    case "Mozos" -> {
                        Mozo mozo = vista.getMozoSeleccionado();
                        Cerveceria.getInstance().eliminarMozo(mozo);
                        vista.actualizarLista("Mozos");
                    }
                    case "Productos en venta" -> {
                        try {
                            Producto producto = vista.getProductoSeleccionado();
                            Cerveceria.getInstance().eliminarProducto(producto);
                            vista.actualizarLista("Productos en Venta");
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente(ex.getMessage());
                        }
                    }
                    case "Mesas del local" -> {
                        Mesa mesa = vista.getMesaSeleccionado();
                        Cerveceria.getInstance().eliminarMesa(mesa);
                        vista.actualizarLista("Mesas del Local");
                    }
                }
            }
            case "Activar Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en Promocion" -> {
                        PromocionProducto productoEnPromocion = vista.getProductoEnPromocionSeleccionado();
                        productoEnPromocion.setActiva(true);
                    }
                    case "Promociones Temporales" -> {
                        PromocionTemporal promocionTemporal = vista.getPromocionTemporalSeleccionada();
                        promocionTemporal.setActiva(true);
                    }
                }
                vista.inicializarListasEntidades();
            }
            case "Desactivar Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en Promocion" -> {
                        PromocionProducto productoEnPromocion = vista.getProductoEnPromocionSeleccionado();
                        productoEnPromocion.setActiva(false);
                    }
                    case "Promociones Temporales" -> {
                        PromocionTemporal promocionTemporal = vista.getPromocionTemporalSeleccionada();
                        promocionTemporal.setActiva(false);
                    }
                }
                vista.inicializarListasEntidades();
            }
            case "Nueva Promocion" -> creaOtraVentana("Nueva Promocion");
            case "Eliminar Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en Promocion" -> {
                        PromocionProducto productoEnPromocion = vista.getProductoEnPromocionSeleccionado();
                        Cerveceria.getInstance().eliminarPromocionProducto(productoEnPromocion);
                        vista.actualizarLista("Productos en Promocion");
                    }
                    case "Promociones Temporales" -> {
                        PromocionTemporal promocionTemporal = vista.getPromocionTemporalSeleccionada();
                        Cerveceria.getInstance().eliminarPromocionTemporal(promocionTemporal);
                        vista.actualizarLista("Promociones Temporales");
                    }
                }
            }
            case "Generar Estadistica" -> { //TODO GENERAR ESTADISTICAS

            }
        }
    }

    public void creaOtraVentana(String ventana) {
        switch (ventana) {
            case "Login" -> {
                VentanaLogin ventanaLogin = new VentanaLogin();
                ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
                ventanaLogin.ejecutar();
                vista.cerrarVentana();
            }
            case "Agregar Entidad" -> {
                VentanaEntidad ventanaEntidad = new VentanaEntidad();
                ventanaEntidad.setAccion("Crear");
                switch (vista.getTipoEntidadSeleccionada()) {
                    case "Operarios" -> ventanaEntidad.setEntidad("Operario");
                    case "Mozos" -> ventanaEntidad.setEntidad("Mozo");
                    case "Productos en venta" -> ventanaEntidad.setEntidad("Producto");
                    case "Mesas del local" -> ventanaEntidad.setEntidad("Mesa");
                }
                ControladorEntidad controladorEntidad = new ControladorEntidad(ventanaEntidad);
                ventanaEntidad.setWindowListener(this);
                ventanaEntidad.ejecutar();
            }
            case "Modificar Entidad" -> {
                VentanaEntidad ventanaEntidad = new VentanaEntidad();
                ventanaEntidad.setAccion("Modificar");
                switch (vista.getTipoEntidadSeleccionada()) {
                    case "Operarios" -> {
                        ventanaEntidad.setEntidad("Operario");
                        Operario operario = vista.getOperarioSeleccionado();
                        ventanaEntidad.setDatosOperario(operario);
                    }
                    case "Mozos" -> {
                        ventanaEntidad.setEntidad("Mozo");
                        Mozo mozo = vista.getMozoSeleccionado();
                        ventanaEntidad.setDatosMozo(mozo);
                    }
                    case "Productos en venta" -> {
                        ventanaEntidad.setEntidad("Producto");
                        Producto producto = vista.getProductoSeleccionado();
                        ventanaEntidad.setDatosProducto(producto);
                    }
                    case "Mesas del local" -> {
                        ventanaEntidad.setEntidad("Mesa");
                        Mesa mesa = vista.getMesaSeleccionado();
                        ventanaEntidad.setDatosMesa(mesa);
                    }
                }
                ControladorEntidad controladorEntidad = new ControladorEntidad(ventanaEntidad);
                ventanaEntidad.setWindowListener(this);
                ventanaEntidad.ejecutar();
            }
            case "Nueva Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en Promocion" -> {
                        VentanaPromocion ventanaPromocion = new VentanaPromocion();
                        ventanaPromocion.setPromocion("Producto en Promocion");
                        PromocionProducto promocionProducto = new PromocionProducto();
                        ControladorPromocion controladorPromocion = new ControladorPromocion(promocionProducto, ventanaPromocion);
                        ventanaPromocion.setWindowListener(this);
                        ventanaPromocion.ejecutar();
                    }
                    case "Promociones Temporales" -> {
                        VentanaPromocion ventanaPromocion = new VentanaPromocion();
                        ventanaPromocion.setPromocion("Promocion Temporal");
                        PromocionTemporal promocionTemporal = new PromocionTemporal();
                        ControladorPromocion controladorPromocion = new ControladorPromocion(promocionTemporal, ventanaPromocion);
                        ventanaPromocion.setWindowListener(this);
                        ventanaPromocion.ejecutar();
                    }
                }
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //TODO PERSISTIR
    }

    @Override
    public void windowClosed(WindowEvent e) {
        vista.inicializarListasEntidades();
        vista.inicializarListasPromociones();
    }

    //METODOS NO USADOS
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
