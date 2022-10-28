package app;

import modelo.Administrador;
import modelo.Cerveceria;
import modelo.Operario;
import negocio.ControladorAdministrador;
import negocio.ControladorOperario;
import vista.ventanas.VentanaAdministrador;
import vista.ventanas.VentanaOperario;

public class App {
    public static void main(String[] args) {
//        VentanaLogin ventanaLogin = new VentanaLogin();
//        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
//        ventanaLogin.ejecutar();

//        Operario operario = new Operario("Lautaro Bruses","lauta123","123");
//
//        VentanaOperario ventanaOperario = new VentanaOperario();
//        ControladorOperario controladorOperario = new ControladorOperario(operario, ventanaOperario);
//        ventanaOperario.ejecutar();

        Cerveceria cerveceria = new Cerveceria();

        VentanaAdministrador ventanaAdministrador = new VentanaAdministrador();
        Administrador admin = Cerveceria.getInstance().getAdministrador();
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(admin,ventanaAdministrador);
        ventanaAdministrador.ejecutar();
    }
}
