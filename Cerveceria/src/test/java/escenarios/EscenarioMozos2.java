package escenarios;

import modelo.Cerveceria;
import modelo.Mozo;

public class EscenarioMozos2 {

    public Cerveceria cerveceria;

    public EscenarioMozos2(){

        this.cerveceria = Cerveceria.getInstance();

        try {
            for ( int i = 0 ;i < 6; i++){
                cerveceria.agregarMozo("Tomas", 30, 4);
            }
        }
        catch (Exception e ){
            System.out.printf(e.getMessage());
        }
    }
}