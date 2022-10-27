package main.java.modelo;

import main.java.modelo.Mesa;
import main.java.modelo.Pedido;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Comanda {
        private String fecha;
        private Mesa mesa;
        private ArrayList<Pedido> pedidos;
        private String estado; //abierta o cerrada

        //CONSTRUCTOR
        public Comanda (Date fecha, Mesa mesa){
                //assert fecha != Date.from():"Fecha invalida";
                assert mesa.getEstado().equalsIgnoreCase("Libre"): "ERROR : la mesa debe estar en estado libre";

                DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm");
                String fechaActual = dateFormat.format(new Date());
                this.fecha =  fechaActual
                this.pedidos = new ArrayList<Pedido>();
                this.mesa = mesa;
                this.estado = "Abierta";

        //GETTERS & SETTERS
        public String getFecha() {
                return fecha;
        }

        public void setFecha(String fecha) {
                this.fecha = fecha;
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

        public void cerrarComanda(){
                assert this.getEstado().equalsIgnoreCase("Cerrada"):"ERROR: no se puede cerrar una comanda ya cerrada";
                this.estado = "Cerrada";
        }

        public void agregarPedido(Pedido pedido){
                this.pedidos.add(pedido);
        }

}

