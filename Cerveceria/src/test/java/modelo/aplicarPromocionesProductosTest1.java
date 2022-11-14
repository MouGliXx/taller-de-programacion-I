package modelo;

import escenarios.EscenarioAplicarPromocionesProductos1;
import modelo.Cerveceria;
import modelo.Factura;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class aplicarPromocionesProductosTest1 {
    private EscenarioAplicarPromocionesProductos1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioAplicarPromocionesProductos1();
    }

    @AfterEach
    public void tearDown(){
        Cerveceria.setInstance(null);
    }

    @DisplayName("Testeando caso con promociones productos")
    @Test
    void testAplicarPromocionesProductos1(){

        try {
            Factura factura=this.escenario.cerveceria.getFacturas().get(0);
            System.out.println(factura);

            assertEquals(100.0,factura.getTotal());

        }
        catch(Exception e){
            assertTrue(false);
        }
    }
}
