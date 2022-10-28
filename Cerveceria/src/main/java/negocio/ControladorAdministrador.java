package negocio;

import modelo.*;
import vista.interfaces.IVistaAdministrador;
import vista.ventanas.VentanaEntidad;
import vista.ventanas.VentanaLogin;
import vista.ventanas.VentanaProductoEnPromocion;
import vista.ventanas.VentanaPromocionTemporal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorAdministrador implements ActionListener, WindowListener {
    private Administrador modelo;
    private IVistaAdministrador vista;

    public ControladorAdministrador(Administrador modelo, IVistaAdministrador vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Inicio" -> vista.cambiarPagina(0);
            case "Entidades" -> vista.cambiarPagina(1);
            case "Productos" -> vista.cambiarPagina(2);
            case "Promociones" -> vista.cambiarPagina(3);
            case "Estadisticas" -> vista.cambiarPagina(4);
            case "Cerrar Sesion" -> creaOtraVentana("Login");
            case "Agregar" -> creaOtraVentana("Agregar Entidad");
            case "Modificar" -> creaOtraVentana("Modificar Entidad");
            case "Eliminar" -> {
                switch (vista.getTipoEntidadSeleccionada()) {
                    case "Operarios" -> {
                        Operario operario = vista.getOperarioSeleccionado();
                        //REMOVER OPERARIO
                    }
                    case "Mozos" -> {
                        Mozo mozo = vista.getMozoSeleccionado();
                        //REMOVER MOZO
                    }
                    case "Productos en venta" -> {
                        Producto producto = vista.getProductoSeleccionado();
                        //REMOVER PRODUCTO
                    }
                    case "Mesas del local" -> {
                        Mesa mesa = vista.getMesaSeleccionado();
                        //REMOVER MESA
                    }
                }
            }
            case "Activar Promocion" -> {

            }
            case "Desactivar Promocion" -> {

            }
            case "Nueva Promocion" -> creaOtraVentana("Nueva Promocion");
            case "Eliminar Promocion" -> {

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
                    case "Operario" -> {

                    }
                    case "Mozo" -> {

                    }
                    case "Productos en venta" -> {

                    }
                    case "Mesas del local" -> {

                    }
                }
                //CONTROLADOR
                //ventanaEntidad.ejecutar();
            }
            case "Modificar Entidad" -> {
                VentanaEntidad ventanaEntidad = new VentanaEntidad();
                ventanaEntidad.setAccion("Modificar");
                switch (vista.getTipoEntidadSeleccionada()) {
                    case "Operario" -> {

                    }
                    case "Mozo" -> {

                    }
                    case "Productos en venta" -> {

                    }
                    case "Mesas del local" -> {

                    }
                }
                //CONTROLADOR
                //ventanaEntidad.ejecutar();
            }
            case "Nueva Promocion" -> {
                switch (vista.getTipoPromocionSeleccionada()) {
                    case "Productos en promocion" -> {
                        VentanaProductoEnPromocion ventanaProductoEnPromocion = new VentanaProductoEnPromocion();
                        ProductoEnPromocion promocion = new ProductoEnPromocion();
                        //CONTROLADOR
                        //ventanaProductoEnPromocion.ejecutar()
                    }
                    case "Promociones temporales" -> {
                        VentanaPromocionTemporal ventanaPromocionTemporal = new VentanaPromocionTemporal();
                        PromocionTemporal promocionTemporal = new PromocionTemporal();
                        //CONTROLADOR
                        //ventanaPromocionTemporal.ejecutar()
                    }
                }
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //PERSISTIR
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
