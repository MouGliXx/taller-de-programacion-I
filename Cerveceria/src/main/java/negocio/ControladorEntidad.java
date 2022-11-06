package negocio;

import modelo.*;
import vista.ventanas.VentanaEntidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEntidad implements ActionListener {
    VentanaEntidad vista;

    public ControladorEntidad(VentanaEntidad vista) {
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setKeyListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Accion" -> {
                switch (vista.getEntidad()) {
                    case "Operario" -> {
                        try {
                            String nombreCompleto = vista.getNombreCompletoOperario();
                            String nombreUsuario = vista.getNombreDeUsuario();
                            String contrasena = vista.getContrasena();
                            boolean estado = vista.getEstadoOperario();

                            Cerveceria.getInstance().agregarOperario(nombreCompleto, nombreUsuario, contrasena, estado); //TODO UNIFICAR METODOS AGREGAR/MODIFICAR
                            this.vista.cerrarVentana();
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente(ex.getMessage());
                        }
                    }
                    case "Mozo" -> {
                        try {
                            String nombreYApellido = vista.getNombreYApellidoMozo();
                            int edad = vista.getEdadMozo();
                            int cantHijos = vista.getCantidadHijosMozo();
                            String estado = vista.getEstadoMozo();

                            Cerveceria.getInstance().agregarMozo(nombreYApellido, edad, cantHijos, estado); //TODO UNIFICAR METODOS AGREGAR/MODIFICAR
                            this.vista.cerrarVentana();
                        } catch (NumberFormatException ex) {
                            vista.lanzarVentanaEmergente("ERROR : " + ex.getMessage());
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente(ex.getMessage());
                        }
                    }
                    case "Producto" -> {
                        try {
                           int id = vista.getIDProducto();
                           int stock = vista.getStockInicial();
                           String nombre = vista.getNombreProducto();
                           double precioCosto = vista.getPrecioCosto();
                           double precioVenta = vista.getPrecioVenta();

                           Cerveceria.getInstance().agregarProducto(id, nombre, precioCosto, precioVenta, stock); //TODO UNIFICAR METODOS AGREGAR/MODIFICAR
                            this.vista.cerrarVentana();
                        } catch (NumberFormatException ex) {
                            vista.lanzarVentanaEmergente("ERROR : " + ex.getMessage());
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente(ex.getMessage());
                        }
                    }
                    case "Mesa" -> {
                        try {
                            int cantComensales = vista.getCantidadComensales();
                            String estado = vista.getEstadoMesa();

                            Cerveceria.getInstance().agregarMesa(cantComensales, estado); //TODO UNIFICAR METODOS AGREGAR/MODIFICAR
                            this.vista.cerrarVentana();
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente(ex.getMessage());
                        }
                    }
                }
            }
            case "Cancelar" -> this.vista.cerrarVentana();
        }
    }
}
