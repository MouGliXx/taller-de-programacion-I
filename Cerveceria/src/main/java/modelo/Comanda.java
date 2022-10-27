package main.java.modelo;

import main.java.modelo.Mesa;
import main.java.modelo.Pedido;
import java.util.ArrayList;
import java.util.Date;

public class Comanda {
        private Date fecha;
        private Mesa mesa;
        private ArrayList<Pedido> pedidos;
        private String estado; //abierta o cerrada

        public Comanda (Date fecha, Mesa mesa){
                //assert fecha != Date.from():"Fecha invalida";
                assert mesa.getEstado().equalsIgnoreCase("Libre"): "ERROR : la mesa debe estar en estado libre";
                this.fecha = fecha;
                this.pedidos = new ArrayList<Pedido>();
                this.mesa = mesa;
                this.estado = "Abierta";
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

