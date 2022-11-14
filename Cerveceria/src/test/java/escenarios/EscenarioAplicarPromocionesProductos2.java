package escenarios;

import modelo.*;

import java.util.ArrayList;
import java.util.Date;

public class EscenarioAplicarPromocionesProductos2 {
    public Cerveceria cerveceria;
    public EscenarioAplicarPromocionesProductos2() {
        this.cerveceria=Cerveceria.getInstance();
        try{
            Mesa mesa=new Mesa(8);
            ArrayList<Pedido> pedidos=new ArrayList<>();
            Producto producto=new Producto("Hamburguesa",20,40,5);
            pedidos.add(new Pedido(producto,5));
            pedidos.add(new Pedido(new Producto("Pancho",10,20,17),3));

            ArrayList<PromocionProducto> promocionesProductos = new ArrayList<>();
            ArrayList<String> diasPromo=new ArrayList<>();
            diasPromo.add("Lunes");
            diasPromo.add("Martes");
            diasPromo.add("Miercoles");
            diasPromo.add("Jueves");
            diasPromo.add("Viernes");
            diasPromo.add("Sabado");
            diasPromo.add("Domingo");

            promocionesProductos.add(new PromocionProducto(diasPromo,true,producto,false,true,3,35));
            cerveceria.setPromocionesProductos(promocionesProductos);

            Factura factura=new Factura(mesa,pedidos);
            cerveceria.getFacturas().add(factura);

        }
        catch (Exception e ){
            System.out.printf(e.getMessage());
        }
    }
}