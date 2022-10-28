package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Comanda {
        private Date fecha;
        private Mesa mesa;
        private ArrayList<Pedido> pedidos;
        private String estado; //abierta o cerrada

        //CONSTRUCTOR

        public Comanda() {

                assert mesa.getEstado().equalsIgnoreCase("Libre") : "ERROR : la mesa debe estar en estado libre";

                DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm");
                String fechaActual = dateFormat.format(new Date());

                this.pedidos = new ArrayList<Pedido>();
                this.estado = "Abierta";
        }


        //GETTERS & SETTERS
        public Date getFecha() {
                return fecha;
        }

        public void setFecha(Date fecha) {
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
                assert this.estado.equalsIgnoreCase("Cerrada"):"ERROR: no se puede cerrar una comanda ya cerrada";
                this.estado = "Cerrada";
        }

        public void agregarPedido(Pedido pedido){
                this.pedidos.add(pedido);
        }

}

