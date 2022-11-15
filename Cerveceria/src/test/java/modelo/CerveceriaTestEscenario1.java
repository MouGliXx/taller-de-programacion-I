package modelo;

import escenarios.EscenarioMozos1;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CerveceriaTestEscenario1 {

    private EscenarioMozos1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioMozos1();
    }

    @AfterEach
    public void tearDown(){
        this.escenario.cerveceria.getMozos().clear();
        this.escenario.cerveceria.getEstadisticasMozos().clear();
    }

    @DisplayName("Caso con pocos mozos")
    @Test
    void testAgregarMozo1(){

        try {
            this.escenario.cerveceria.agregarMozo("Tomas", 18, 0);
            Mozo mozo = this.escenario.cerveceria.getMozos().get(this.escenario.cerveceria.getMozos().size() - 1 );
            assertEquals("Tomas", mozo.getNombreYApellido());
            assertEquals(18, mozo.getEdad());
            assertEquals(0, mozo.getCantHijos());
        }
        catch(Exception e){
            assertEquals(false,"Entro en la excepcion ERROR");
        }
    }

    @DisplayName("Caso mozo menor de edad")
    @Test
    void testAgregarMozo3(){
        try {
            System.out.printf(this.escenario.cerveceria.getMozos().toString());
            this.escenario.cerveceria.agregarMozo("Tomas", 15, 0);
            Mozo mozo = this.escenario.cerveceria.getMozos().get(this.escenario.cerveceria.getMozos().size() - 1 );
            assertTrue(false,"Se agrego el mozo error");
        }
        catch(Exception e){
            assertEquals("ERROR : La edad debe superar los 18 anos.",e.getMessage());
        }

    }

    @DisplayName("Caso mozo con cantHijos < 0")
    @Test
    void testAgregarMozo4(){
        try {
            System.out.printf(this.escenario.cerveceria.getMozos().toString());
            this.escenario.cerveceria.agregarMozo("Tomas", 20, -1);
            Mozo mozo = this.escenario.cerveceria.getMozos().get(this.escenario.cerveceria.getMozos().size() - 1 );
            assertTrue(false,"Se agrego el mozo error");
        }
        catch(Exception e){
            assertEquals("ERROR : Cantidad de hijos debe ser mayo o igual a cero",e.getMessage());
        }
    }

}