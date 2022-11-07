package negocio;

import modelo.*;
import vista.ventanas.VentanaEntidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEntidad implements ActionListener {
    Object modelo;
    VentanaEntidad vista;

    public ControladorEntidad(Object modelo, VentanaEntidad vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setKeyListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cancelar" -> this.vista.cerrarVentana();
            case "Accion" -> {
                switch (vista.getEntidad()) {
                    case "Operario" -> {
                        try {
                            String nombreCompleto = vista.getNombreCompletoOperario();
                            String nombreUsuario = vista.getNombreDeUsuario();
                            String contrasena = vista.getContrasena();
                            boolean estado = vista.getEstadoOperario();

                            if (modelo == null) { //CREO
                                Cerveceria.getInstance().agregarOperario(nombreCompleto, nombreUsuario, contrasena, estado);
                            } else { //MODIFICO
                                Cerveceria.getInstance().modificarOperario((Operario) modelo, nombreCompleto, nombreUsuario, contrasena, estado);
                            }

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

                            if (modelo == null) { //CREO
                                Cerveceria.getInstance().agregarMozo(nombreYApellido, edad, cantHijos, estado);
                            } else { //MODIFICO
                                Cerveceria.getInstance().modificarMozo((Mozo) modelo, nombreYApellido, edad, cantHijos, estado);
                            }
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

                            if (modelo == null) { //CREO
                                Cerveceria.getInstance().agregarProducto(id, nombre, precioCosto, precioVenta, stock);
                            } else { //MODIFICO
                                Cerveceria.getInstance().modificarProducto((Producto) modelo, nombre, precioCosto, precioVenta, stock);
                            }

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

                            if (modelo == null) { //CREO
                                Cerveceria.getInstance().agregarMesa(cantComensales, estado);
                            } else { //MODIFICO
                                Cerveceria.getInstance().modificarMesa((Mesa) modelo, cantComensales);
                            }

                            this.vista.cerrarVentana();
                        } catch (Exception ex) {
                            vista.lanzarVentanaEmergente(ex.getMessage());
                        }
                    }
                }
            }
        }
    }
}
