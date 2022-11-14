package modelo;

import escenarios.EscenarioAplicarPromocionesProductos;
import escenarios.EscenarioProductos1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class aplicarPromocionesProductosTest {
    private EscenarioAplicarPromocionesProductos escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioAplicarPromocionesProductos();
    }

    @DisplayName("Testeando caso con mesa distinto de null")
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
