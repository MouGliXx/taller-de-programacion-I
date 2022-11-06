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
        this.vista.inicializarListas();
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
                        //TODO REMOVER OPERARIO
                        vista.actualizaLista("Operarios");
                    }
                    case "Mozos" -> {
                        Mozo mozo = vista.getMozoSeleccionado();
                        Cerveceria.getInstance().eliminarMozo(mozo);
                        vista.actualizaLista("Mozos");
                    }
                    case "Productos en venta" -> {
                        Producto producto = vista.getProductoSeleccionado();
                        Cerveceria.getInstance().getProductos().remove(producto.getIdProducto());
                        //TODO REMOVER PRODUCTO
                        vista.actualizaLista("Productos en venta");
                    }
                    case "Mesas del local" -> {
                        Mesa mesa = vista.getMesaSeleccionado();
                        try {
                            Cerveceria.getInstance().eliminarMesa(mesa);
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente(ex.getMessage());
                        }
                        vista.actualizaLista("Mesas del local");
                    }
                }
            }
            case "Activar Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en promocion" -> {
                        PromocionProducto productoEnPromocion = vista.getProductoEnPromocionSeleccionado();
                        productoEnPromocion.setActiva(true);
                    }
                    case "promociones temporales" -> {
                        PromocionTemporal promocionTemporal = vista.getPromocionTemporalSeleccionada();
                        promocionTemporal.setActiva(true);
                    }
                }
            }
            case "Desactivar Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en promocion" -> {
                        PromocionProducto productoEnPromocion = vista.getProductoEnPromocionSeleccionado();
                        productoEnPromocion.setActiva(false);

                    }
                    case "promociones temporales" -> {
                        PromocionTemporal promocionTemporal = vista.getPromocionTemporalSeleccionada();
                        promocionTemporal.setActiva(false);

                    }
                }
            }
            case "Nueva Promocion" -> creaOtraVentana("Nueva Promocion");
            case "Eliminar Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en promocion" -> {
                        PromocionProducto productoEnPromocion = vista.getProductoEnPromocionSeleccionado();
                        //TODO ELIMINAR PROMOCION
                        vista.actualizaLista("Productos en promocion");
                    }
                    case "promociones temporales" -> {
                        PromocionTemporal promocionTemporal = vista.getPromocionTemporalSeleccionada();
                        //TODO ELIMINAR PROMOCION
                        vista.actualizaLista("Promociones temporales");
                    }
                }
            }
            case "Generar Estadistica" -> {

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
                ventanaEntidad.ejecutar();
            }
            case "Nueva Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en promocion" -> {
                        VentanaPromocion ventanaPromocion = new VentanaPromocion();
                        ventanaPromocion.setPromocion("Producto en Promocion");
                        ControladorPromocion controladorPromocion = new ControladorPromocion(ventanaPromocion);
                        ventanaPromocion.ejecutar();
                    }
                    case "Promociones temporales" -> {
                        VentanaPromocion ventanaPromocion = new VentanaPromocion();
                        ventanaPromocion.setPromocion("Promocion Temporal");
                        ControladorPromocion controladorPromocion = new ControladorPromocion(ventanaPromocion);
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

    //METODOS NO USADOS
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

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
