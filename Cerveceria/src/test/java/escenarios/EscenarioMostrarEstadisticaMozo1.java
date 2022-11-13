package escenarios;

import modelo.Cerveceria;
import modelo.Mozo;

import java.util.ArrayList;
import java.util.HashMap;

public class EscenarioMostrarEstadisticaMozo1 {

    public Cerveceria cerveceria;

    public EscenarioMostrarEstadisticaMozo1() {

        this.cerveceria = Cerveceria.getInstance();
        cerveceria.setMozos(new ArrayList<>());
    }


}
