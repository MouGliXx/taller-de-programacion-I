package app;

import modelo.Cerveceria;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import negocio.ControladorOperario;
import vista.ventanas.VentanaOperario;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;

public class Prueba {

    public static void main(String[] args) throws Exception {

        Cerveceria cerveza = Cerveceria.getInstance();

        for (int t=0;t<5;t++) {
            try {
                cerveza.agregarMesa();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        cerveza.agregarMozo(new Mozo("Lautaro", LocalDate.of (2000,12,12),1,0));
        cerveza.agregarMozo(new Mozo("Ignacio", LocalDate.of (2000,12,12),1,0));
        cerveza.agregarMozo(new Mozo("Tomas", LocalDate.of (2000,12,12),1,0));

        cerveza.asignarMesas();

        HashMap<Mesa, Mozo> mA = cerveza.getMesasAsignadas();

        for (HashMap.Entry<Mesa, Mozo> entry : mA.entrySet()) {
            System.out.println(entry.getKey().toString() + " Asignado " + entry.getValue().toString());
        }

        cerveza.a
    }
}

