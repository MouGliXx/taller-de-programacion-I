package negocio;

import modelo.*;
import persistencia.CerveceriaDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.Util;
import vista.interfaces.IVistaOperario;
import vista.ventanas.VentanaComanda;
import vista.ventanas.VentanaFactura;
import vista.ventanas.VentanaLogin;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorOperario implements ActionListener, ItemListener, WindowListener {
    private Operario modelo;
    private IVistaOperario vista;

    public ControladorOperario(Operario operario, IVistaOperario vista) {
        this.modelo = operario;
        this.vista = vista;

        this.vista.setActionListener(this);
        this.vista.setItemListener(this);
        this.vista.setListSelectionListener();
        this.vista.setWindowListener(this);
        this.vista.setNombreCompleto(operario.getNombreCompleto());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Inicio" -> vista.cambiarPagina(0);
            case "Mozos" -> vista.cambiarPagina(1);
            case "Comandas" -> vista.cambiarPagina(2);
            case "Facturas" -> vista.cambiarPagina(3);
            case "Promociones" -> vista.cambiarPagina(4);
            case "Cerrar Sesion" -> creaOtraVentana("Login");
            case "Nueva Comanda" -> creaOtraVentana("Nueva Comanda");
            case "Editar Comanda" -> creaOtraVentana("Editar Comanda");
            case "Cerrar Comanda" -> creaOtraVentana("Nueva Factura");
            case "Finalizar Jornada" -> {
                try {
                    Cerveceria.getInstance().finalizarJornada();
                    vista.finalizarJornada();
                } catch (Exception ex) {
                    vista.lanzarVentanaEmergente(ex.getMessage());
                }
            }
            case "Asignar Mesas" -> {
                try {
                    Cerveceria.getInstance().asignarMesas();
                    vista.asignarMesas(Cerveceria.getInstance().getMesasAsignadas());
                    vista.lanzarVentanaEmergente("Mesas asignadas con exito!");
                } catch (Exception ex) {
                    vista.lanzarVentanaEmergente(ex.getMessage());
                }
            }
        }
    }

    public void creaOtraVentana(String ventana){
        switch (ventana) {
            case "Login" -> {
                VentanaLogin ventanaLogin = new VentanaLogin();
                ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
                ventanaLogin.ejecutar();
                vista.cerrarVentana();
            }
            case "Nueva Comanda" -> {
                VentanaComanda ventanaNuevaComanda = new VentanaComanda();
                ventanaNuevaComanda.setAccion("Crear");
                Comanda nuevaComanda = new Comanda();
                ControladorComanda controladorComanda = new ControladorComanda(nuevaComanda, ventanaNuevaComanda);
                ventanaNuevaComanda.setWindowListener(this);
                ventanaNuevaComanda.ejecutar();
            }
            case "Editar Comanda" -> {
                VentanaComanda ventanaEditarComanda = new VentanaComanda();
                ventanaEditarComanda.setAccion("Editar");
                Comanda comandaSeleccionada = vista.getComandaSeleccionada();
                ControladorComanda controladorComanda = new ControladorComanda(comandaSeleccionada, ventanaEditarComanda);
                ventanaEditarComanda.setWindowListener(this);
                ventanaEditarComanda.ejecutar();
            }
            case "Nueva Factura" -> {
                try {
                    Comanda comandaSeleccionada = vista.getComandaSeleccionada();
                    Factura nuevaFactura = new Factura(comandaSeleccionada.getMesa(), comandaSeleccionada.getPedidos());
                    VentanaFactura ventanaFactura = new VentanaFactura();
                    ControladorFactura controladorFactura = new ControladorFactura(comandaSeleccionada, nuevaFactura, ventanaFactura);
                    ventanaFactura.addWindowListener(this);
                    ventanaFactura.ejecutar();
                } catch (Exception e) {
                    vista.lanzarVentanaEmergente(e.getMessage());
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        ArrayList<String> estados = vista.getEstadoMozos();
        ArrayList<Mozo> mozos = Cerveceria.getInstance().getMozos();

        for (int i = 0; i < estados.size(); i++) {
            mozos.get(i).setEstado(estados.get(i));
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            IPersistencia bin = new PersistenciaBIN();
            bin.abrirOutput("Cerveceria.bin");
            CerveceriaDTO cerveceriaDTO = Util.cerveceriaDTOFromCerveceria(Cerveceria.getInstance());
            bin.escribir(cerveceriaDTO);
            bin.cerrarOutput();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.vista.inicializarListas();
    }

    //METODOS NO USADOS
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
