package modelo;

import escenarios.EscenarioMostrarEstadisticaMozo1;
import escenarios.EscenarioMostrarEstadisticaMozo2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
class mostrarEstadisticaMozoTest {

    private EscenarioMostrarEstadisticaMozo2 escenario2;

    @BeforeEach
    public void setUp() {
        this.escenario2 = new EscenarioMostrarEstadisticaMozo2();
    }

    @AfterEach
    public void tearDown(){
            this.escenario2.cerveceria.getComandas().clear();
            this.escenario2.cerveceria.getMozos().clear();
            this.escenario2.cerveceria.setMozos( new ArrayList<>());
            this.escenario2.cerveceria.getMesas().clear();
            this.escenario2.cerveceria.getProductos().clear();
            this.escenario2.cerveceria.getEstadisticasMozos().clear();
            this.escenario2.cerveceria.getPromocionesProductos().clear();
    }


    @DisplayName("Testeando caso con arraylist de mozos con 2 elementos")
    @Test
    void testMostrarEstadisticaMozo2() {

        try {
            Mozo mozo1 = this.escenario2.cerveceria.getMozos().get(0);
            assertEquals(this.escenario2.cerveceria.mostrarEstadisticasMozos().get(0),"Mozo con mayor volumen de ventas: '" + mozo1.getNombreYApellido());
        } catch (Exception e) {
            assertTrue(false, "Entro en la excepcion");
        }
    }
}