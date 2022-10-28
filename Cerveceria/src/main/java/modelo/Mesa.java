package modelo;

public class Mesa {
    private static int sig = 1;
    private int nro;
    private int cantidadComensales;
    private String estado;

    public Mesa () {
        this.nro = sig++;
        this.estado="Libre";
    }

    //GETTERS && SETTERS

    public static int getSig(){
        return sig;
    }
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        assert nro>0:"ERROR : El numero de mesa debe ser mayor a cero";
        this.nro = nro;
    }

    public void setEstado(String estado) {
        assert estado!=null :"ERROR : El estado no debe ser null";
        assert estado!="":"ERROR : El estado no debe ser vacio";
        assert estado!="Libre" || estado!="Ocupado" :"ERROR : El estado debe ser Ocupado o Libre";
        this.estado = estado;
    }
    public int getCantidadComensales() {
        return cantidadComensales;
    }

   //FUNCIONALIDADES
    public void setCantidadComensales(int cantidadComensales){
        if (this.nro>0)
            assert cantidadComensales>1:"ERROR: la cantidad de comensales debe ser mayor a 1";
        else
            assert cantidadComensales>0:"ERROR: la cantidad de comensales debe ser mayor a 1";
        this.cantidadComensales = cantidadComensales;
    }

    public void liberar (){
        this.estado = "Libre";
    }

    public void ocupar () {
        this.estado = "Ocupado";
    }

    public String getEstado(){
        return this.estado;
    }

    @Override
    public String toString(){
        return "Mesa n°"+this.nro;
    }
}
