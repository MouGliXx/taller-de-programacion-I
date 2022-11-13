package escenarios;

import modelo.Cerveceria;
import modelo.EstadisticaMozo;
import modelo.Mozo;

import java.util.ArrayList;
import java.util.HashMap;

public class EscenarioMostrarEstadisticaMozo2 {
    public Cerveceria cerveceria;

    public EscenarioMostrarEstadisticaMozo2() {

        try {
            this.cerveceria = Cerveceria.getInstance();
            ArrayList<Mozo> mozos = new ArrayList<>();
            mozos.add(new Mozo("Juan",35,2));
            mozos.add(new Mozo("Carlos",60,3));
            this.cerveceria.setMozos(mozos);
            HashMap<Mozo, EstadisticaMozo> estadisticasMozos = new HashMap<>();
            estadisticasMozos.put(mozos.get(0),new EstadisticaMozo(15000,4));
            estadisticasMozos.put(mozos.get(1),new EstadisticaMozo(12000,2));
            cerveceria.setEstadisticasMozos(estadisticasMozos);
        }
        catch (Exception e ) {
            System.out.printf(e.getMessage());
        }
    }
}
