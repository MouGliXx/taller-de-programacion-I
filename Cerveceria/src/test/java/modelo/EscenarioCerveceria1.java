package modelo;

public class EscenarioCerveceria1 {

    Cerveceria cerveceria;

    public EscenarioCerveceria1(){

        this.cerveceria = Cerveceria.getInstance();

        try {
            cerveceria.agregarMozo("Lautaro", 22, 1);
            cerveceria.agregarMozo("Ignacio", 26, 1);
            cerveceria.agregarMozo("Tomas", 33, 1);
        }
        catch (Exception e ){
            System.out.printf(e.getMessage());
        }
    }
}
