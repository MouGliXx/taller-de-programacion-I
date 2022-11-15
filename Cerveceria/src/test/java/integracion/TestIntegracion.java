package integracion;

import escenarios.EscenarioAplicarPromocionesProductos1;
import escenarios.EscenarioIntegracion;
import modelo.Cerveceria;
import modelo.Factura;
import modelo.Pedido;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIntegracion {

    EscenarioIntegracion escenario;

    @BeforeEach
    public void setUp(){
        this.escenario = new EscenarioIntegracion();
    }

    @AfterEach
    public void tearDown(){
        Cerveceria.setInstance(null);
    }



    @Test
    public void agregaPedidoAComanda(){

        Pedido p1 = new Pedido();
        Pedido p2 = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        p1.setProducto(this.escenario.cerveza.getProductos().get(1));
        p1.setCantidad(2);
        pedidos.add(p1);
        p2.setProducto(this.escenario.cerveza.getProductos().get(2));
        p2.setCantidad(3);


        try {
            this.escenario.cerveza.modificarComanda(this.escenario.cerveza.getComandas().get(0),this.escenario.cerveza.getMesas().get(0),pedidos);
            assertTrue(true,"Se modifico correctamente la comanda");
        }catch (Exception e){
            assertTrue(false,"No deberia haber entrado aca");
        }
        //cerveza.getComandas().get(0).agregarPedido(p1);
    }

    @Test
    public void creaComanda(){
        // En vez de agregar los pedidos a una comanda ya existente creamos una.
        Pedido p1 = new Pedido();
        Pedido p2 = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        p1.setProducto(this.escenario.cerveza.getProductos().get(1));
        p1.setCantidad(2);
        pedidos.add(p1);
        p2.setProducto(this.escenario.cerveza.getProductos().get(2));
        p2.setCantidad(3);

        try {
            this.escenario.cerveza.agregarComanda(this.escenario.cerveza.getMesas().get(1), pedidos);
            assertTrue(true, "Se creo la comanda correctamente");
        }
        catch(Exception e){
            assertTrue(false, "Fallo el test");
        }

    }

    @Test
    public void cierroComanda(){
        Pedido p1 = new Pedido();
        Pedido p2 = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        p1.setProducto(this.escenario.cerveza.getProductos().get(1));
        p1.setCantidad(2);
        pedidos.add(p1);
        p2.setProducto(this.escenario.cerveza.getProductos().get(2));
        p2.setCantidad(3);
        System.out.printf(this.escenario.cerveza.getMesas().toString());

        try {
            this.escenario.cerveza.agregarComanda(this.escenario.cerveza.getMesas().get(1), pedidos);
            Factura factura = new Factura(this.escenario.cerveza.getMesas().get(1),pedidos);
            this.escenario.cerveza.agregarFactura(factura);
        }
        catch(Exception e){
            assertTrue(false, "Fallo el test");
        }
    }
}
