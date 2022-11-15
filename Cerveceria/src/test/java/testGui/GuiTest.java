package testGui;

import modelo.Cerveceria;
import negocio.ControladorAdministrador;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vista.interfaces.IVistaAdministrador;
import vista.ventanas.VentanaAdministrador;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuiTest {
    Cerveceria cerveceria;
    Robot robot;

    ControladorAdministrador controlador;

    public GuiTest()
    {
        try
        {
            robot = new Robot();
            this.cerveceria=Cerveceria.getInstance();
        } catch (AWTException e)
        {
        }
    }

    @Before
    public void setUp() throws Exception
    {
        VentanaAdministrador ventanaAdministrador = new VentanaAdministrador();
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(cerveceria.getAdministrador(), ventanaAdministrador);
        controlador = new ControladorAdministrador(cerveceria.getAdministrador(),ventanaAdministrador);
        ventanaAdministrador.ejecutar();
    }

    @After
    public void tearDown() throws Exception
    {
        //completar
    }

    @Test
    public void testNombreNoModificado()
    {
        try {
            robot.delay(TestUtils.getDelay());
            //obtengo las referencias a los componentes necesarios
            JTextField nombre = (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(), "cerveceriaTextField");
            JButton aceptarEdit = (JButton) TestUtils.getComponentForName((Component) controlador.getVista(), "editarTituloButton");
            //lleno los JTextField
            TestUtils.clickComponent(nombre, robot);
            TestUtils.tipeaTexto("dfassad", robot);
            //verifico los resultados
            assertTrue(aceptarEdit.isEnabled(), "El boton de edicion deberia estar desactivado");
        }
        catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void testCambiaCierraSesion()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton cerrarSesion = (JButton) TestUtils.getComponentForName((Component) controlador.getVista(), "cerrarSesionButton");
        //lleno los JTextField
        TestUtils.clickComponent(cerrarSesion, robot);
        assertTrue(null!=controlador.vistaLogin,"No crea la ventana correctamente");
        //verifico los resultados
    }

    @Test
    public void testCambiaAInicio()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton entidades = (JButton) TestUtils.getComponentForName((Component) controlador.getVista(), "inicioButton");
        //lleno los JTextField
        TestUtils.clickComponent(entidades, robot);
        System.out.println(controlador.getPagina());
        assertFalse(controlador.getPagina()!=0,"La ventana no cambio a inicio");
        //verifico los resultados

    }

    @Test
    public void testCambiaAEntidades()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton entidades = (JButton) TestUtils.getComponentForName((Component) controlador.getVista(), "entidadesButton");
        //lleno los JTextField
        TestUtils.clickComponent(entidades, robot);
        System.out.println(controlador.getPagina());
        assertFalse(controlador.getPagina()!=1,"La ventana no cambio a entidades");
        //verifico los resultados

    }

    @Test
    public void testCambiaAPromociones()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton entidades = (JButton) TestUtils.getComponentForName((Component) controlador.getVista(), "promocionesButton");
        //lleno los JTextField
        TestUtils.clickComponent(entidades, robot);
        System.out.println(controlador.getPagina());
        assertFalse(controlador.getPagina()!=2,"La ventana no cambio a promociones");
        //verifico los resultados

    }

    @Test
    public void testCambiaAEstadisticas()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton entidades = (JButton) TestUtils.getComponentForName((Component) controlador.getVista(), "estadisticasButton");
        //lleno los JTextField
        TestUtils.clickComponent(entidades, robot);
        System.out.println(controlador.getPagina());
        assertFalse(controlador.getPagina()!=3,"La ventana no cambio a estadisticas");
        //verifico los resultados

    }

}
