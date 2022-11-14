package modelo;

import escenarios.EscenarioMozos1;
import escenarios.EscenarioMozos2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.AssertionFailureBuilder.assertionFailure;
class CerveceriaTest{

    private EscenarioMozos1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioMozos1();
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
            assertTrue(false,"Fallo el test");
        }
    }


    @Test
    void testAgregarMozo2(){

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


}