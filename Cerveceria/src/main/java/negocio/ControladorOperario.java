package negocio;

import modelo.*;
import vista.interfaces.IVistaOperario;
import vista.ventanas.VentanaComanda;
import vista.ventanas.VentanaFactura;
import vista.ventanas.VentanaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorOperario implements ActionListener, WindowListener {
    private Operario operario;
    private IVistaOperario vista;

    public ControladorOperario(Operario operario, IVistaOperario vista) {
        this.operario = operario;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setWindowListener(this);
        this.vista.setNombreCompleto(operario.getNombreCompleto());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Inicio" -> vista.cambiarPagina(0);
            case "Mozos" -> vista.cambiarPagina(1);
            case "Comandas" -> vista.cambiarPagina(2);
            case "Facturas" -> vista.cambiarPagina(3);
            case "Promociones" -> vista.cambiarPagina(4);
            case "Cerrar Sesion" -> creaOtraVentana("Login");
            case "Nueva Comanda" -> creaOtraVentana("Nueva Comanda");
            case "Editar Comanda" -> creaOtraVentana("Editar Comanda");
            case "Cerrar Comanda" -> creaOtraVentana("Nueva Factura");
            case "Iniciar Jornada" -> {

            }
            case "Asignar Mesas" -> {

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
            case "Nueva Comanda" -> {
                VentanaComanda ventanaNuevaComanda = new VentanaComanda();
                ventanaNuevaComanda.setAccion("Nueva");
                Comanda nuevaComanda = new Comanda();
                ControladorComanda controladorComanda = new ControladorComanda(nuevaComanda, ventanaNuevaComanda);
                ventanaNuevaComanda.ejecutar();
            }
            case "Editar Comanda" -> {
                VentanaComanda ventanaEditarComanda = new VentanaComanda();
                ventanaEditarComanda.setAccion("Editar");
                Comanda comandaSeleccionada = vista.getComandaSeleccionada();
                ControladorComanda controladorComanda = new ControladorComanda(comandaSeleccionada, ventanaEditarComanda);
                ventanaEditarComanda.ejecutar();
            }
            case "Nueva factura" -> {
                Comanda comandaSeleccionada = vista.getComandaSeleccionada();

                try {
                    Cerveceria.getInstance().cerrarComanda(comandaSeleccionada);
                } catch (Exception e) {
                    vista.lanzarVentanaEmergente(e.getMessage());
                }

                double total = 0; //METODO EN COMANDA QUE CALCULE EL TOTAL
                ArrayList<IPromocion> promocionesAplicadas = null; //METODO QUE GESTIONE LAS PROMOCIONES

                Factura nuevaFacura = new Factura(comandaSeleccionada.getFecha(), comandaSeleccionada.getMesa(),  comandaSeleccionada.getPedidos(), total, promocionesAplicadas);
                VentanaFactura ventanaFactura = new VentanaFactura();
                ControladorFactura controladorFactura = new ControladorFactura(nuevaFacura, ventanaFactura);
                ventanaFactura.ejecutar();
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
