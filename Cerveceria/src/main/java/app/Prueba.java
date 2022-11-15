package app;

import modelo.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Prueba {

    public static void main(String[] args) throws Exception {

        Cerveceria cerveza = Cerveceria.getInstance();



        Administrador admin = new Administrador("ADMIN","ADMIN1234");
        cerveza.setAdministrador(admin);


        cerveza.eliminarMozo(cerveza.getMozos().get(1));


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
        Pedido p2 = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        p1.setProducto(cerveza.getProductos().get(1));
        p1.setCantidad(2);
        pedidos.add(p1);
        p2.setProducto(cerveza.getProductos().get(2));
        p2.setCantidad(3);


        try {
            cerveza.agregarComanda(cerveza.getMesas().get(0),pedidos);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        cerveza.getComandas().get(0).agregarPedido(p1);

//        cerveza.agregarFactura(cerveza.getComandas().get(0),"Debito");
        cerveza.eliminarComanda(cerveza.getComandas().get(0));
        System.out.println(cerveza.getFacturas().get(0).toString());

    }
}

