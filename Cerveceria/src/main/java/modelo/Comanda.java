package main.java.modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Comanda {

        private Calendar fecha;
        private Mesa mesa;
        private ArrayList<Pedido> pedido;
        private String estado; //abierta o cerrada

        public Comanda (Calendar fecha, Mesa mesa, ArrayList<Pedido> pedido){
                assert fecha != Calendar.getInstance():"Fecha invalida";

        }
}

