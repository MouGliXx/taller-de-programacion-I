package app;

import negocio.ControladorLogin;
import vista.VentanaLogin;

public class App {
    public static void main(String[] args) {
        VentanaLogin ventanaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
        ventanaLogin.ejecutar();
    }
}
