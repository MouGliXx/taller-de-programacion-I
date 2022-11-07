package negocio;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.Administrador;
import modelo.Cerveceria;
import modelo.Operario;
import vista.interfaces.IVistaLogin;
import vista.ventanas.VentanaAdministrador;
import vista.ventanas.VentanaOperario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorLogin implements ActionListener, WindowListener {
    private IVistaLogin vista;

    public ControladorLogin(IVistaLogin vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
        this.vista.setKeyListener();
        this.vista.setWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Login".equals(e.getActionCommand())) {
            try {
                if (vista.getUsername().equals("ADMIN")) {
                    Administrador admin = Cerveceria.getInstance().login(vista.getPassword());
                    loguearAdministrador(admin);
                } else {
                    Operario operario = Cerveceria.getInstance().login(vista.getUsername(), vista.getPassword());
                    loguearOperario(operario);
                }
            } catch (ErrorDeUsuarioException e1) {
                vista.lanzarVentanaEmergente(e1.getMessage());
                vista.nombreUsuarioInvalido();
            } catch (ErrorDeContrasenaException e2) {
                vista.lanzarVentanaEmergente(e2.getMessage());
                vista.contrasenaInvalida();
            }
        }
    }

    public void loguearAdministrador(Administrador admin) {
        VentanaAdministrador ventanaAdministrador = new VentanaAdministrador();
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(admin, ventanaAdministrador);
        ventanaAdministrador.ejecutar();
        vista.cerrarVentana();
    }

    public void loguearOperario(Operario operario) {
        VentanaOperario ventanaOperario = new VentanaOperario();
        ControladorOperario controladorOperario = new ControladorOperario(operario, ventanaOperario);
        ventanaOperario.ejecutar();
        vista.cerrarVentana();
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
