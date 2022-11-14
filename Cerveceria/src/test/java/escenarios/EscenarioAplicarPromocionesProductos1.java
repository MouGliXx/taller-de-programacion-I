package escenarios;

import modelo.*;

import java.util.ArrayList;

public class EscenarioAplicarPromocionesProductos1 {
    public Cerveceria cerveceria;
    public EscenarioAplicarPromocionesProductos1() {
        this.cerveceria=Cerveceria.getInstance();
        try{
            Mesa mesa=new Mesa(8);
            ArrayList<Pedido> pedidos=new ArrayList<>();
            Producto producto=new Producto("Hamburguesa",20,40,5);
            pedidos.add(new Pedido(producto,2));
            pedidos.add(new Pedido(new Producto("Pancho",10,20,17),3));

            ArrayList<PromocionProducto> promocionesProductos = new ArrayList<>();
            ArrayList<String> diasPromo=new ArrayList<>();
            diasPromo.add("Domingo");

            promocionesProductos.add(new PromocionProducto(diasPromo,true,producto,true,false,0,0));
            cerveceria.setPromocionesProductos(promocionesProductos);

            Factura factura=new Factura(mesa,pedidos);
            cerveceria.getFacturas().add(factura);

        }
        catch (Exception e ){
            System.out.printf(e.getMessage());
        }
    }
}
