package escenarios;

import modelo.*;

import java.util.ArrayList;
import java.util.HashMap;

public class EscenarioIntegracion {

        public Cerveceria cerveza;

        public EscenarioIntegracion() {

                this.cerveza = Cerveceria.getInstance();
                try {

                        // AGREGO MESAS
                        for (int t = 0; t < 5; t++) {
                                this.cerveza.agregarMesa(t + 3);
                        }

                        for (Mesa mesa : this.cerveza.getMesas()) {
                                mesa.setEstado("abierta");
                        }

                        // AGREGO MOZOS
                        this.cerveza.agregarMozo("Lautaro", 22, 1);
                        this.cerveza.agregarMozo("Ignacio", 26, 1);
                        this.cerveza.agregarMozo("Tomas", 33, 1);
                        for (Mozo mozo : this.cerveza.getMozos()) {
                                mozo.setEstado("activo");
                        }

                        // ASIGNO MESAS
                        this.cerveza.asignarMesas();

                        HashMap<Mesa, Mozo> mA = this.cerveza.getMesasAsignadas();
                        // AGREGO PRODUCTOS

                        this.cerveza.agregarProducto(1, "this.cerveza", 200, 260, 2);
                        this.cerveza.agregarProducto(2, "Coca-Cola", 150, 200, 20);
                        this.cerveza.agregarProducto(3, "Agua", 100, 150, 20);
                        this.cerveza.agregarProducto(4, "Sprite", 250, 300, 20);


                        PromocionProducto promocion1 = new PromocionProducto();
                        PromocionProducto promocion2 = new PromocionProducto();
                        promocion1.setAplicaDosPorUno(true);
                        promocion2.setAplicaDosPorUno(true);

                        Pedido p1 = new Pedido();
                        Pedido p2 = new Pedido();
                        ArrayList<Pedido> pedidos = new ArrayList<>();
                        p1.setProducto(this.cerveza.getProductos().get(1));
                        p1.setCantidad(2);
                        pedidos.add(p1);
                        ArrayList<String> dias = new ArrayList<>();
                        dias.add("lunes");

                        this.cerveza.agregarPromocionProducto(new PromocionProducto(), dias, true, this.cerveza.getProductos().get(1), true, false);

                        p2.setProducto(this.cerveza.getProductos().get(2));
                        p2.setCantidad(3);
                        this.cerveza.agregarPromocionProducto(new PromocionProducto(), dias, true, this.cerveza.getProductos().get(2), true, false);
                        this.cerveza.agregarComanda(this.cerveza.getMesas().get(0), pedidos);
                        this.cerveza.getComandas().get(0).agregarPedido(p1);
                        this.cerveza.getComandas().get(0).setEstado("Abierta");

                } catch (Exception e) {
                        System.out.printf(e.getMessage());
                }

        }
}
