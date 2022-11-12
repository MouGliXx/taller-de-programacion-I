package negocio;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
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
                        Operario operario = this.vista.getOperario();
                        //TODO GUARDAR OPERARIO
                    }
                    case "Mozo" -> {
                        Mozo mozo = this.vista.getMozo();
                        //TODO GUARDAR MOZO
                    }
                    case "Producto" -> {
                        Producto producto = this.vista.getProducto();
                        //TODO GUARDAR PRODUCTO
                    }
                    case "Mesa" -> {
                        Mesa mesa = this.vista.getMesa();
                        //TODO GUARDAR MESA
                    }
                }
                this.vista.cerrarVentana();
            }
            case "Cancelar" -> this.vista.cerrarVentana();
        }
    }
}
