package modelo;

import escenarios.EscenarioAplicarPromocionesProductos3;
import modelo.Cerveceria;
import modelo.Factura;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class aplicarPromocionesProductosTest3 {
    private EscenarioAplicarPromocionesProductos3 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioAplicarPromocionesProductos3();
    }

    @AfterEach
    public void tearDown(){
        Cerveceria.setInstance(null);
    }

    @DisplayName("Testeando caso sin promociones de ningun tipo")
    @Test
    void testAplicarPromocionesProductos2(){

        try {
            Factura factura=this.escenario.cerveceria.getFacturas().get(0);
            System.out.println(factura);

            assertEquals(180.0,factura.getTotal());

        }
        catch(Exception e){
            assertTrue(false);
        }
    }
}