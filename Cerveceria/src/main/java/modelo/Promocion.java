package modelo;

import java.util.ArrayList;

public abstract class Promocion {
    private static int N = 0;
    private int id;
    private ArrayList<String> diasPromocion;
    private boolean activa;

    //CONSTRUCTOR
    public Promocion(ArrayList<String> diasPromocion, boolean activa) {
        this.id = N;
        N++;
        this.diasPromocion = diasPromocion;
        this.activa = activa;
    }

    //GETTERS && SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getDiasPromocion() {
        return diasPromocion;
    }

    public void setDiasPromocion(ArrayList<String> diasPromocion) {
        this.diasPromocion = diasPromocion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    //FUNCIONALIDADES

}
