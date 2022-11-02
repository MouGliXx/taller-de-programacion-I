package app;

import modelo.Cerveceria;
import modelo.Comanda;
import modelo.Operario;
import negocio.ControladorAdministrador;
import negocio.ControladorLogin;
import negocio.ControladorOperario;
import vista.ventanas.VentanaAdministrador;
import vista.ventanas.VentanaLogin;
import vista.ventanas.VentanaOperario;

public class App {
    public static void main(String[] args) {
        Cerveceria cerveceria = Cerveceria.getInstance();

        Operario yop = new Operario("Lautaro Bruses","123","123", true);
        Cerveceria.getInstance().getOperarios().add(yop);

        Cerveceria.getInstance().getComandas().add(new Comanda());

        VentanaLogin ventanaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
        ventanaLogin.ejecutar();

//        VentanaOperario ventanaOperario = new VentanaOperario();
//        ControladorOperario controladorOperario = new ControladorOperario(yop, ventanaOperario);
//        ventanaOperario.ejecutar();

//        VentanaAdministrador ventanaAdministrador = new VentanaAdministrador();
//        Administrador admin = Cerveceria.getInstance().getAdministrador();
//        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(admin,ventanaAdministrador);
//        ventanaAdministrador.ejecutar();
    }
}
