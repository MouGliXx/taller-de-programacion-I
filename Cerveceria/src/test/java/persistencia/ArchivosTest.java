package persistencia;

import escenarios.EscenarioComanda1;
import modelo.Cerveceria;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

public class ArchivosTest {

    EscenarioComanda1 escenario;
    PersistenciaBIN persistenciaBIN;
    CerveceriaDTO cerveceriaDTO;

    @BeforeEach
    void setUp(){
        this.persistenciaBIN = new PersistenciaBIN();
        this.cerveceriaDTO = new CerveceriaDTO();
        this.escenario = new EscenarioComanda1();
        File file = new File("Cerveceria.bin");
        if (file.exists()){
            file.delete();
        }
    }

    @DisplayName("Verificamos que el archivo se crea correctamente")
    @Test
    public void testCrearArchivo() {
        try {
            //Creamos el archivo y persistimos
            persistenciaBIN.abrirOutput("Cerveceria.bin");
            persistenciaBIN.escribir(cerveceriaDTO);
            persistenciaBIN.cerrarOutput();
            File file = new File("Cerveceria.bin");
            assertTrue(file.exists(),"Deberia existir el archivo Cerveceria.bin");

        } catch (IOException e) {
            assertTrue(false,"ERROR: No se creo el archivo correctamente ");
        }
    }

    @DisplayName("Verificando despersistencia test de Cerveceria Vacia")
    @Test
    public void testCerveceriaVacia() {

        //Creamos una cerveceria VACIA
        Cerveceria.setInstance(null);
        Cerveceria.getInstance();

        try {
            persistenciaBIN.abrirOutput("Cerveceria.bin");
            persistenciaBIN.escribir(cerveceriaDTO);
            persistenciaBIN.cerrarOutput();
            //Despersistimos

            try {
                CerveceriaDTO cerveceriaSinPersistir;
                persistenciaBIN.abrirInput("Cerveceria.bin");
                cerveceriaSinPersistir = (CerveceriaDTO) persistenciaBIN.leer();
                persistenciaBIN.cerrarInput();
                assertEquals(cerveceriaSinPersistir,cerveceriaDTO,"Las cervecerias tiene que ser iguales");


            } catch (ClassNotFoundException e) {
                assertTrue(false,"ERROR: No se encontro correctamente el archivo , no deberia pasar");
            }

        } catch (IOException e) {
            assertTrue(false,"ERROR: El arhivo no se creo correctamente");
        }
    }

    @DisplayName("Verificando despersistencia test de Cerveceria con datos")
    @Test
    public void testCerveceriaConDatos(){

        try {
            //Creamos el archivo y persistimos
            persistenciaBIN.abrirOutput("Cerveceria.bin");
            persistenciaBIN.escribir(cerveceriaDTO);
            persistenciaBIN.cerrarOutput();


            try {
                //Abrimos el archivo y despersistimos
                persistenciaBIN.abrirInput("Cerveceria.bin");
                CerveceriaDTO cerveceriaDespersistida = (CerveceriaDTO) persistenciaBIN.leer();
                persistenciaBIN.cerrarOutput();
                assertEquals(cerveceriaDespersistida,cerveceriaDTO,"Las cervecerias deben ser iguales");
            } catch (ClassNotFoundException e) {
                assertTrue(false,"No deberia entrar aca porque el archivo deberia encontrarse sin problema, porque ya fue previamente creado");
            }

        } catch (IOException e) {
            assertTrue(false,"No deberia entrar aca porque el archivo deberia crearse sin problema");
        }

    }

    @DisplayName("Verificando si se lanza excepcion si creamos archivo inexistente")
    @Test
    public void testDespersitirSinArchivo()
    {
        try
        {
            PersistenciaBIN persistenciaBIN = new PersistenciaBIN();
            persistenciaBIN.cerrarOutput();
            assertTrue(false,"ERROR: No se lanzo la excepcion");
        }
        catch (IOException e)
        {
            assertTrue(true,"Se lanzo excepcion");
        }
    }

}
