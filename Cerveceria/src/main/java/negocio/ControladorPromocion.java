package negocio;

import modelo.*;
import vista.interfaces.IVistaPromocion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorPromocion implements ActionListener {
    Promocion modelo;
    IVistaPromocion vista;

    public ControladorPromocion(Promocion modelo, IVistaPromocion vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setKeyListener();
        this.vista.setDatos(modelo.getIdPromocion(), Cerveceria.getInstance().getProductos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Establecer" -> {
                switch (vista.getTipoPromocion()) {
                    case "Producto en Promocion" -> {
                        ArrayList<String> diasPromocion = vista.getDiasDePromocion();
                        boolean activa = vista.isActiva();
                        Producto producto = vista.getProducto();
                        boolean aplicaDosPorUno = vista.getAplica2x1();
                        boolean aplicaDtoPorCantidad = vista.getAplicaDescuentoXCantidad();
                        if (aplicaDtoPorCantidad) {
                            try {
                                int cantidadMinima = vista.getCantidadMinima();
                                double precioUnitario = vista.getPrecioUnitario();

                                Cerveceria.getInstance().agregarPromocionProducto(diasPromocion, activa, producto, aplicaDosPorUno, aplicaDtoPorCantidad, cantidadMinima, precioUnitario);
                                this.vista.cerrarVentana();
                            } catch (NumberFormatException ex) {
                                vista.lanzarVentanaEmergente("ERROR : Ingrese una cantidad o precio valido");
                            }
                        } else {
                            Cerveceria.getInstance().agregarPromocionProducto(diasPromocion, activa, producto, aplicaDosPorUno, aplicaDtoPorCantidad);
                            this.vista.cerrarVentana();
                        }
                    }
                    case "Promocion Temporal" -> {
                        try {
                            ArrayList<String> diasPromocion = vista.getDiasDePromocion();
                            boolean activa = vista.isActiva();
                            String nombre = vista.getNombrePromocion();
                            String formaDePago = vista.getFormaDePago();
                            int porcentajeDescuento = vista.getPorcentajeDescuento();
                            boolean acumulable = vista.isAcumulable();

                            Cerveceria.getInstance().agregarPromocionTemporal(diasPromocion, activa, nombre, formaDePago, porcentajeDescuento, acumulable);
                            this.vista.cerrarVentana();
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente("ERROR : Nombre de la promocion invalido.");
                        }
                    }
                }
            }
            case "Cancelar" -> this.vista.cerrarVentana();
        }
    }
}
