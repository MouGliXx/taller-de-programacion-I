package escenarios;

import modelo.Cerveceria;
import modelo.Mozo;

import java.util.ArrayList;
import java.util.HashMap;

public class EscenarioMostrarEstadisticaMozo1 {

    public Cerveceria cerveceria;

    public EscenarioMostrarEstadisticaMozo1() {

        this.cerveceria = Cerveceria.getInstance();
        ArrayList<Mozo> mozo = new ArrayList<>();
        this.cerveceria.setMozos(mozo);
    }


}
