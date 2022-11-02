package negocio;

import modelo.Cerveceria;
import modelo.Pedido;
import vista.interfaces.IVistaPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPedido implements ActionListener {
    private Pedido modelo;
    private IVistaPedido vista;

    public ControladorPedido(Pedido pedido, IVistaPedido vista) {
        this.modelo = pedido;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setItemListener();
        this.vista.inicializaComboBox(Cerveceria.getInstance().getProductos());
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
