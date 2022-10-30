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
                cerveza.agregarMesa();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        cerveza.agregarMozo(new Mozo("Lautaro", LocalDate.of (2000,12,12),1,0));
        cerveza.agregarMozo(new Mozo("Ignacio", LocalDate.of (2000,12,12),1,0));
        cerveza.agregarMozo(new Mozo("Tomas", LocalDate.of (2000,12,12),1,0));

        cerveza.asignarMesas();

        HashMap<Mesa, Mozo> mA = cerveza.getMesasAsignadas();

        for (HashMap.Entry<Mesa, Mozo> entry : mA.entrySet()) {
            System.out.println(entry.getKey().toString() + " Asignado " + entry.getValue().toString());
        }

        cerveza.guardarProducto(1,"Cerveza",200,260,2);
        cerveza.guardarProducto(2,"Coca-Cola",150,200,20);
        cerveza.guardarProducto(3,"Agua",100,150,20);
        cerveza.guardarProducto(4,"Sprite",250,300,20);

        Pedido p1 = new Pedido();
        cerveza.nuevoPedido(p1,cerveza.getProductos().get(2),2);

        try {
            cerveza.nuevaComanda(cerveza.getMesas().get(0));
            cerveza.agregarPedidoAComanda(cerveza.getComandas().get(0), p1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        cerveza.nuevaFactura(cerveza.getComandas().get(0));
        cerveza.cerrarComanda(cerveza.getComandas().get(0));
        System.out.println(cerveza.getFacturas().get(0).toString());

    }
}

