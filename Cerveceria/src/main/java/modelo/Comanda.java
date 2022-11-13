package modelo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Comanda implements Serializable {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos;
    private String estado; //abierta o cerrada

    //CONSTRUCTOR
    public Comanda(Date fecha, Mesa mesa, ArrayList<Pedido> pedidos) {
        this.fecha = fecha;
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.estado = "Abierta";
    }

    public Comanda() {
        this.fecha = new Date();
        this.mesa = null;
        this.pedidos = new ArrayList<>();
        this.estado = "Abierta";
    }

    //GETTERS & SETTERS
    public Date getFecha() {
        return fecha;
    }

    public void setEstado(String estado) {
        System.out.printf(estado.isEmpty() + "nashe");
        assert estado != null :"ERROR : El estado no debe ser null";
        assert !estado.isEmpty() :"ERROR : El estado no debe ser vacio";
        assert !estado.equals("Abierta") || !estado.equals("Cerrada") :"ERROR : El estado debe ser Abierta o Cerrada";

        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMesa(Mesa mesa){
        assert mesa!= null :"ERROR : La mesa no debe ser null";
        assert !mesa.getEstado().equalsIgnoreCase("Libre") : "ERROR : la mesa debe estar en estado libre";
        this.mesa = mesa;
    }

    public String getEstado(){
        return this.estado;
    }

    public Mesa getMesa(){
        return this.mesa;
    }

    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * cambia el estado de la comanda a "cerrado"
     *
     * <b>pre:</b>la comanda debe ser distinto de null<br>.
     *
     * <b>post:</b> la comanda pasara a estado cerrada<br>.
     */
    public void cerrarComanda() {
        this.estado = "Cerrada";
    }

    /**
     * agrega un pedido a la comanda
     *
     * <b>pre:</b>pedido debe ser distinto de null<br>.
     *
     * @param pedido pedido que se va a agregar a la comanda
     * <b>post:</b> la coleccion de pedidos de la comanda tendra un nuevo elemento<br>.
     */
    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    /**
     * elimina un pedido a la comanda
     *
     * <b>pre:</b>pedido debe ser distinto de null<br>.
     *
     * @param pedido pedido que se va a eliminar de la comanda
     * <b>post:</b> la coleccion de pedidos de la comanda tendra un elemento menos y se sumara al stock del producto<br>.
     */
    public void eliminarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
        pedido.getProducto().setStockInicial(pedido.getProducto().getStockInicial() + pedido.getCantidad());
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm:ss");
        String fechaActual = dateFormat.format(fecha);

        return "Fecha: " + fechaActual +
                " - Mesa: " + mesa.getNro() +
                " - Pedidos: " + (pedidos.isEmpty() ? "Sin pedidos" : pedidos);
    }
}

