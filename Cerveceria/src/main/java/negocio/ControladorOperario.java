package negocio;

import modelo.Comanda;
import modelo.Operario;
import vista.IVistaOperario;
import vista.VentanaComanda;
import vista.VentanaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
            case "Login":
                VentanaLogin ventanaLogin = new VentanaLogin();
                ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
                ventanaLogin.ejecutar();
                vista.cerrarVentana();
                break;
            case "Nueva Comanda":
                VentanaComanda ventanaNuevaComanda = new VentanaComanda();
                ventanaNuevaComanda.setAccion("Nueva");
                Comanda nuevaComanda = new Comanda();
                ControladorComanda controladorComanda = new ControladorComanda(nuevaComanda, ventanaNuevaComanda);
                ventanaNuevaComanda.ejecutar();
                break;
            case "Editar Comanda":
                VentanaComanda ventanaEditarComanda = new VentanaComanda();
                ventanaEditarComanda.setAccion("Editar");
                //TOMAR LA COMANDA SELECCIONADA
//                ControladorComanda controladorComanda = new ControladorComanda(comandaSeleccionada, ventanaNuevaComanda);
                break;
            case "Nueva factura":

                break;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {

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
