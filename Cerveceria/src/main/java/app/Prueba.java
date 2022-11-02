package app;

import modelo.*;
import negocio.ControladorOperario;
import vista.ventanas.VentanaOperario;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;

public class Prueba {

    public static void main(String[] args) throws Exception {

        Cerveceria cerveza = Cerveceria.getInstance();

        for (int t=0;t<5;t++) {
            try {
                cerveza.agregarMesa(2, "Activo");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        cerveza.agregarMozo("Lautaro", LocalDate.of (2000,12,12),1,"Activo");
        cerveza.agregarMozo("Ignacio", LocalDate.of (2000,12,12),1,"Activo");
        cerveza.agregarMozo("Tomas", LocalDate.of (2000,12,12),1,"Activo");


        System.out.println("AGREGO 3 MOZOS");
        for (Mozo mozo: cerveza.getMozos()){
            System.out.println(mozo);
        }
        cerveza.eliminarMozo(cerveza.getMozos().get(1));
        System.out.println("BORRO UNO DE LOS MOZOS");
        for (Mozo mozo: cerveza.getMozos()){
            System.out.println(mozo);
        }


        cerveza.asignarMesas();

        HashMap<Mesa, Mozo> mA = cerveza.getMesasAsignadas();

        for (HashMap.Entry<Mesa, Mozo> entry : mA.entrySet()) {
            System.out.println(entry.getKey().toString() + " Asignado " + entry.getValue().toString());
        }

        cerveza.agregarProducto(1,"Cerveza",200,260,2);
        cerveza.agregarProducto(2,"Coca-Cola",150,200,20);
        cerveza.agregarProducto(3,"Agua",100,150,20);
        cerveza.agregarProducto(4,"Sprite",250,300,20);

        Pedido p1 = new Pedido();
        cerveza.agregarPedido(p1,cerveza.getProductos().get(2),2);

        try {
            cerveza.agregarComanda(cerveza.getMesas().get(0));
            cerveza.agregarPedidoAComanda(cerveza.getComandas().get(0), p1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        cerveza.agregarFactura(cerveza.getComandas().get(0));
        cerveza.cerrarComanda(cerveza.getComandas().get(0));
        System.out.println(cerveza.getFacturas().get(0).toString());

    }
}

