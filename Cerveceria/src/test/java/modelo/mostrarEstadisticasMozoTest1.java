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
class mostrarEstadisticaMozoTest1 {

    private EscenarioMostrarEstadisticaMozo1 escenario;

    @BeforeEach
    public void setUp() {
        this.escenario = new EscenarioMostrarEstadisticaMozo1();
    }

    @AfterEach
    public void tearDown(){
        this.escenario.cerveceria.getComandas().clear();
        this.escenario.cerveceria.getMozos().clear();
        this.escenario.cerveceria.getMesas().clear();
        this.escenario.cerveceria.getProductos().clear();
        this.escenario.cerveceria.getEstadisticasMozos().clear();
        this.escenario.cerveceria.getPromocionesProductos().clear();
    }

    @DisplayName("Testeando caso con arraylist de mozos vacio")
    @Test
    void testMostrarEstadisticaMozo1() {

        try {
            this.escenario.cerveceria.getEstadisticasMozos();
            System.out.printf(this.escenario.cerveceria.getMozos().toString());
            assertEquals(0, this.escenario.cerveceria.getEstadisticasMozos().size());
        } catch (Exception e) {
            assertTrue(false, "Entro en la excepcion");
        }
    }

}