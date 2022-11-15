package modelo;

import escenarios.EscenarioComanda1;
import escenarios.EscenarioMozos1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EliminarComanda1 {

    private EscenarioComanda1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioComanda1();
    }

    @AfterEach
    public void tearDown(){
        this.escenario.cerveza.getComandas().clear();
        this.escenario.cerveza.getMozos().clear();
        this.escenario.cerveza.getMesas().clear();
        this.escenario.cerveza.getProductos().clear();
        this.escenario.cerveza.getPromocionesProductos().clear();
        this.escenario.cerveza.getEstadisticasMozos().clear();
    }


    @Test
    public void eliminarComanda() {
        try {
            this.escenario.cerveza.eliminarComanda(this.escenario.cerveza.getComandas().get(0));
            assertEquals(true,this.escenario.cerveza.getComandas().isEmpty());
        }
        catch(Exception e){
            assertTrue( false, e.getMessage());
        }
    }

    @Test
    public void eliminarComanda2(){
        try{
            this.escenario.cerveza.getComandas().get(0).cerrarComanda();
            // cierro la comanda
            this.escenario.cerveza.eliminarComanda(this.escenario.cerveza.getComandas().get(0));
            assertTrue(false,"No se lanzo la excepcion");
        }catch(Exception e){
            assertEquals("ERROR : No se puede cerrar una comanda ya cerrada",e.getMessage());
        }
    }
}
