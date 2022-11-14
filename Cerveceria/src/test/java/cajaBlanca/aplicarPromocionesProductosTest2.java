package cajaBlanca;

import escenarios.EscenarioAplicarPromocionesProductos2;
import modelo.Factura;
import modelo.Cerveceria;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class aplicarPromocionesProductosTest2 {
    private EscenarioAplicarPromocionesProductos2 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioAplicarPromocionesProductos2();
    }

    @AfterEach
    public void tearDown(){
        Cerveceria.setInstance(null);
    }

    @DisplayName("Testeando caso con promociones temporales")
    @Test
    void testAplicarPromocionesProductos2(){

        try {
            Factura factura=this.escenario.cerveceria.getFacturas().get(0);
            factura.setFormaDePago("Efectivo");
            System.out.println(factura);

            assertEquals(135.0,factura.getTotal());

        }
        catch(Exception e){
            assertTrue(false);
        }
    }
}