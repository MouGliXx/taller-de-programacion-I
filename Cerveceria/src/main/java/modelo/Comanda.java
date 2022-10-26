package main.java.modelo;

import main.java.modelo.Mesa;
import main.java.modelo.Pedido;
import java.util.ArrayList;
import java.util.Calendar;

public class Comanda {
        private Calendar fecha;
        private Mesa mesa;
        private ArrayList<Pedido> pedido;
        private String estado; //abierta o cerrada

        public Comanda (Calendar fecha, Mesa mesa){
                assert fecha != Calendar.getInstance():"Fecha invalida";
                assert mesa.getEstado().equalsIgnoreCase("Libre"): "ERROR : la mesa debe estar en estado libre";
                this.fecha = fecha;
                this.pedido = new ArrayList<Pedido>();
                this.mesa = mesa;
                this.estado = "Abierta";
        }

        public String getEstado(){
                return this.estado;
        }

        public Mesa getMesa(){
                return this.mesa;
        }

        public void cerrarComanda(){
                assert this.getEstado().equalsIgnoreCase("Cerrada"):"ERROR: no se puede cerrar una comanda ya cerrada";
                this.estado = "Cerrada";
        }

        public void agregarPedido(Pedido pedido){
                this.pedido.add(pedido);
        }

}

