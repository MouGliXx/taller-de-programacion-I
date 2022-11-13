package escenarios;

import modelo.Cerveceria;
import modelo.Producto;

public class EscenarioProductos1 {

    public Cerveceria cerveceria;

    public EscenarioProductos1(){

        this.cerveceria = Cerveceria.getInstance();

        try {
            cerveceria.agregarProducto(2,"Hamburguesa",25,50,2);
        }
        catch (Exception e ){
            System.out.printf(e.getMessage());
        }
    }
}