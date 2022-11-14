package modelo;

import escenarios.EscenarioAplicarPromocionesTemporales;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class aplicarPromocionesTemporales {
    private EscenarioAplicarPromocionesTemporales escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioAplicarPromocionesTemporales();
    }

    @AfterEach
    public void tearDown(){
        Cerveceria.setInstance(null);
    }

    @DisplayName("Testeando caso con promociones temporales")
    @Test
    void testAplicarPromocionesTemporales(){

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