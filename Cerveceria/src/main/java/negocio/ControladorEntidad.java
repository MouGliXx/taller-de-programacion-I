package negocio;

import vista.ventanas.VentanaEntidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEntidad implements ActionListener {
    VentanaEntidad vista;

    public ControladorEntidad(VentanaEntidad vista) {
        this.vista = vista;

        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
