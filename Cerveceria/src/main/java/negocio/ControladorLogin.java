package negocio;

import modelo.Cerveceria;
import vista.IVistaLogin;
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
        switch (e.getActionCommand()) {
            case "Login" -> this.loguearse();
        }
    }

    public void loguearse() {
        if (vista.getUsername().equals("ADMIN"))
            Cerveceria.getInstance().login(vista.getPassword());
        else
            Cerveceria.getInstance().login(vista.getUsername(), vista.getPassword());
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
