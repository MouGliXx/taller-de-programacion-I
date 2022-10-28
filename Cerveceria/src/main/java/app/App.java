package app;

import modelo.Operario;
import negocio.ControladorOperario;
import vista.ventanas.VentanaOperario;

public class App {
    public static void main(String[] args) {
//        VentanaLogin ventanaLogin = new VentanaLogin();
//        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
//        ventanaLogin.ejecutar();

        Operario operario = new Operario("Lautaro Bruses","lauta123","123");

        VentanaOperario ventanaOperario = new VentanaOperario();
        ControladorOperario controladorOperario = new ControladorOperario(operario, ventanaOperario);
        ventanaOperario.ejecutar();
    }
}
