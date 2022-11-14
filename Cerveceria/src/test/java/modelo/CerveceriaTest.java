package modelo;

import escenarios.EscenarioMozos1;
import escenarios.EscenarioMozos2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.AssertionFailureBuilder.assertionFailure;
class CerveceriaTest{

    private EscenarioMozos1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioMozos1();
    }

    @AfterEach
    public void tearDown(){
        System.out.printf( "\n" + this.escenario.cerveceria.getMozos().size()  );
        this.escenario.cerveceria.getMozos().clear();

    }

    @DisplayName("Caso con pocos mozos")
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
            assertTrue(false,"Fallo el test");
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

    @Test
    void testModificarProducto1(){
        try {
            Producto producto=new Producto("Hamburgueysa",25,50,2);
            this.escenario.cerveceria.modificarProducto(producto,"Hamburguesa",30,60,3);
            Producto producto2=this.escenario.cerveceria.getProductos().get(this.escenario.cerveceria.getProductos().size()-1);
            assertEquals(producto,producto2);
        }
        catch (Exception e){
            assertTrue(false,"Fallo el test");
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