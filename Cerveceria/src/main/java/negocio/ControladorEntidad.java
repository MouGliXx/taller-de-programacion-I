package negocio;

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

                    }
                    case "Mozo" -> {

                    }
                    case "Producto" -> {

                    }
                    case "Mesa" -> {

                    }
                }
                this.vista.cerrarVentana();
            }
            case "Cancelar" -> {

                this.vista.cerrarVentana();
            }
        }
    }
}
