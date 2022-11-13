package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.AssertionFailureBuilder.assertionFailure;
class CerveceriaTest{

    EscenarioCerveceria1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioCerveceria1();
    }

    @DisplayName("Testeando caso con pocos mozos")
    @Test
    void testAgregarMozo1(){

        try {
            this.escenario.cerveceria.getMozos();
            this.escenario.cerveceria.agregarMozo("Tomas", 18, 0);
            Mozo mozo = this.escenario.cerveceria.getMozos().get(this.escenario.cerveceria.getMozos().size() - 1 );
            assertEquals("Tomas", mozo.getNombreYApellido());
            assertEquals(18, mozo.getEdad());
            assertEquals(0, mozo.getCantHijos());
        }
        catch(Exception e){
            assertTrue(false,"Entro en la excepcion");
        }
    }


    @Test
    void testAgregarMozo2(){

    }
}