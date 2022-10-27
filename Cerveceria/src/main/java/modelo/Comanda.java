package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Comanda {
        private String fecha;
        private Mesa mesa;
        private ArrayList<Pedido> pedido;
        private String estado; //abierta o cerrada

        //CONSTRUCTOR
        public Comanda() {
                DateFormat dateFormat = new SimpleDateFormat("EEEE, HH:mm");
                String fechaActual = dateFormat.format(new Date());
                this.fecha =  fechaActual;
        }

        //GETTERS & SETTERS
        public String getFecha() {
                return fecha;
        }

        public void setFecha(String fecha) {
                this.fecha = fecha;
        }
}

