package negocio;

import modelo.Pedido;
import vista.interfaces.IVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPedido implements ActionListener {
    private Pedido pedido;
    private IVista vista;

    public ControladorPedido(Pedido pedido, IVista vista) {
        this.pedido = pedido;
        this.vista = vista;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Accion" -> {
                //ACA DEBO GUARDAR/SOBREESCRIBIR EL PEDIDO
            }
            case "Cancelar" -> vista.cerrarVentana();
        }
    }
}
