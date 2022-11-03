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

        public void setPedidos (ArrayList<Pedido> pedidos){
                this.pedidos = pedidos;
        }
        public void cerrarComanda(){
                assert this.estado.equalsIgnoreCase("Cerrada"):"ERROR: no se puede cerrar una comanda ya cerrada";
                this.estado = "Cerrada";
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


        /**
         * <b>pre:</b> El pedido no debe ser null <br>.
         * El metodo setea el Producto y la cantidad de un nuevo pedido
         * @throws Exception Se lanza excepción si el prodcuto es null
         * @throws Exception Se lanza excepción si la cantidad es menor o igual a cero
         * <b>post:</b> Los atributos Pedido y Cantidad del pedido estaran seteados<br>.
         */
        public void nuevoPedido(Pedido pedido, Producto producto, int cantidad) throws Exception {
                assert pedido!=null:"ERROR el pedido no puede der null";
                assert pedido.getProducto()!=null || pedido.getCantidad() != 0 :"ERROR : El pedido no debe ser vacio";
                if (pedido.getProducto().getStockInicial() < pedido.getCantidad() )
                        throw new Exception("ERROR : No se puede completar pedido. Stock insuficiente");

                pedido.setProducto(producto);
                pedido.setCantidad(cantidad);

                this.pedidos.add(pedido);

                // descuenta Stock
                pedido.getProducto().setStockInicial(pedido.getProducto().getStockInicial()-pedido.getCantidad());
        }

}

