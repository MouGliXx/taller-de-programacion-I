package modelo;

import escenarios.EscenarioMozos2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CerveceriaTestEscenario2 {

    private EscenarioMozos2 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioMozos2();
    }

    @DisplayName("Testeando caso con mozos completos")
    @Test
    void testAgregarMozo3(){

        try {
            this.escenario.cerveceria.getMozos();
            this.escenario.cerveceria.agregarMozo("Tomas", 18, 0);
            assertTrue(false,"No salto la excepcion");
        }
        catch(Exception e){
            assertEquals("ERROR : No se pueden dar de alta mas mozos. LLego al nro maximo",e.getMessage());
        }
    }


    @Test
    void testAgregarMozo2(){

    }
}
