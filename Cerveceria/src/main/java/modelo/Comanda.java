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
                DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm");
                String fechaActual = dateFormat.format(new Date());
                this.fecha = new Date();
                this.mesa = null;
                this.pedidos = new ArrayList<Pedido>();
                this.setEstado("Abierta");
        }

        //GETTERS & SETTERS
        public Date getFecha() {
                return fecha;
        }

        public void setEstado(String estado) {
                assert estado!=null :"ERROR : El estado no debe ser null";
                assert estado!="":"ERROR : El estado no debe ser vacio";
                assert estado!="Abierta" || estado!="Cerrada" :"ERROR : El estado debe ser Ocupado o Libre";
                this.estado = estado;
        }

        public void setFecha(Date fecha) {
                this.fecha = fecha;
        }

        public void setMesa(Mesa mesa){
                assert mesa!= null :"ERROR : La mesa no debe ser null";
                assert mesa.getEstado().equalsIgnoreCase("Libre") : "ERROR : la mesa debe estar en estado libre";
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

        public void cerrarComanda(){
                assert this.estado.equalsIgnoreCase("Cerrada"):"ERROR: no se puede cerrar una comanda ya cerrada";
                this.estado = "Cerrada";
        }

        public void agregarPedido(Pedido pedido){
                this.pedidos.add(pedido);
        }

        @Override
        public String toString() {
                return "Comanda{" +
                        "fecha=" + fecha +
                        ", mesa=" + mesa +
                        ", pedidos=" + pedidos +
                        ", estado='" + estado + '\'' +
                        '}';
        }

        public double getTotal(){
                double total = 0;
                for (Pedido pedido : pedidos) {
                        total = total + pedido.getProducto().getPrecioVenta() * pedido.getCantidad();
                }
                return total;
        }
}

