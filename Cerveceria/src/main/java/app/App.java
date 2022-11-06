package app;

import modelo.Cerveceria;
import modelo.Operario;
import modelo.Producto;
import negocio.ControladorLogin;
import vista.ventanas.VentanaLogin;

public class App {
    public static void main(String[] args) {
        Cerveceria cerveceria = Cerveceria.getInstance();

        //MOZOS
        try {
            cerveceria.agregarMozo("Lautaro", 18,1,null);
            cerveceria.agregarMozo("Ignacio", 25,1,null);
            cerveceria.agregarMozo("Tomas", 33,1,null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //MESAS
        try {
            cerveceria.agregarMesa(2, "Libre");
            cerveceria.agregarMesa(6, "Ocupada");
            cerveceria.agregarMesa(7, "Libre");
            cerveceria.agregarMesa(8, "Libre");
            cerveceria.agregarMesa(3, "Libre");
            cerveceria.agregarMesa(4, "Libre");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //PRODUCTOS
        Producto p1 = new Producto("Coca-Cola",150,200,5);
        Producto p2 = new Producto("Agua",100,150,9);
        Producto p3 = new Producto("Sprite",250,300,100);

        cerveceria.getProductos().put(1, p1);
        cerveceria.getProductos().put(2, p2);
        cerveceria.getProductos().put(3, p3);

        //OPERARIOS
        Operario yop = new Operario("Lautaro Bruses","123","123", true);
        Cerveceria.getInstance().getOperarios().add(yop);

        //EJECUCION NORMAL
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
