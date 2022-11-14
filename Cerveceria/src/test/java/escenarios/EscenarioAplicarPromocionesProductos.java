package escenarios;

import modelo.*;

import java.util.ArrayList;

public class EscenarioAplicarPromocionesProductos {
    public Cerveceria cerveceria;
    public EscenarioAplicarPromocionesProductos() {
        this.cerveceria=Cerveceria.getInstance();
        try{
            Mesa mesa=new Mesa(8);
            ArrayList<Pedido> pedidos=new ArrayList<>();
            pedidos.add(new Pedido(new Producto("Hamburguesa",20,40,5),2));
            pedidos.add(new Pedido(new Producto("Pancho",10,20,17),3));

            Factura factura=new Factura(mesa,pedidos);
            cerveceria.getFacturas().add(factura);

        }
        catch (Exception e ){
            System.out.printf(e.getMessage());
        }
    }
}
