package modelo;

import java.util.ArrayList;

public abstract class Promocion {
    protected static int N = 0;
    protected int idPromocion;
    protected ArrayList<String> diasPromocion;
    protected boolean activa;

    //CONSTRUCTOR
    public Promocion(ArrayList<String> diasPromocion, boolean activa) {
        this.idPromocion = N;
        N++;
        this.diasPromocion = diasPromocion;
        this.activa = activa;
    }

    //GETTERS && SETTERS
    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
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
