package modelo;
import escenarios.EscenarioProductos1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class modificarProductoTest {

    private EscenarioProductos1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioProductos1();
    }

    @DisplayName("Testeando caso con producto distinto de null")
    @Test
    void testModificarProducto1(){

        try {
            Producto producto=this.escenario.cerveceria.getProductos().get(2);
            System.out.println(producto);

            this.escenario.cerveceria.modificarProducto(producto,"Hamburguesa", 30, 60, 3);
            assertEquals("Hamburguesa",producto.getNombre());
            assertEquals(30,producto.getPrecioCosto());
            assertEquals(60,producto.getPrecioVenta());
            assertEquals(3,producto.getStockInicial());

        }
        catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    void testModificarProducto2(){

        try {
            Producto producto=this.escenario.cerveceria.getProductos().get(2);

            this.escenario.cerveceria.modificarProducto(producto,"Hamburguesa", -4, 60, 3);
            assertTrue(false,"No salto la excepcion");

        }
        catch(Exception e){
            assertEquals("El precio de costo es menor a cero",e.getMessage());
        }
    }

    @Test
    void testModificarProducto3(){

        try {
            Producto producto=this.escenario.cerveceria.getProductos().get(2);

            this.escenario.cerveceria.modificarProducto(producto,"Hamburguesa", 30, 10, 3);
            assertTrue(false,"No salto la excepcion");

        }
        catch(Exception e){
            assertEquals("El precio de venta es menor al de costo",e.getMessage());
        }
    }

}
