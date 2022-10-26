package main.java.modelo;

import main.java.modelo.Administrador;
import main.java.modelo.Mozo;
import main.java.modelo.Operario;
import main.java.modelo.Mesa;
import main.java.modelo.Comanda;
import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Cerveceria{
    private static Cerveceria instance = null;
    private String nombreDelLocal;
    private Administrador administrador;
    ArrayList<Operario> operarios = new ArrayList<Operario>();
    ArrayList<Mozo> mozos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<Comanda> comandas = new ArrayList<Comanda>();
    private HashMap<Mesa,Mozo>MesasAsignadas = new HashMap<Mesa, Mozo>();
    private ArrayList<Facturas> facturas = new ArrayList<Factura>();
    private ArrayList<IPromocion> promociones = new ArrayList<>();
    private int cantidadMesasHabilitadas;

    //PATRON SINGLETON
    public Cerveceria() {
        this.nombreDelLocal = "CERVECERIA";
        this.administrador = new Administrador("ADMIN", "ADMIN1234");
    }

    public static Cerveceria getInstance() {
        if (instance == null)
            instance = new Cerveceria();
        return instance;
    }

    public Administrador login(String password) throws ErrorDeContrasenaException {

        if (password.equalsIgnoreCase(administrador.getPassword())) {
            return this.administrador;
        }

        throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
    }

    public Operario login(String username, String password) throws ErrorDeUsuarioException, ErrorDeContrasenaException {

        for (Operario operario: operarios) {
            if (operario.getUsername().equalsIgnoreCase(username)) {
                if (operario.getPassword().equalsIgnoreCase(password))
                    return operario;

                throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
            }
        }

        throw new ErrorDeUsuarioException("Nombre de usuario invalido: " + username);
    }

    public static void setInstance(Cerveceria instance) {
        Cerveceria.instance = instance;
    }

    public String getNombreDelLocal() {
        return nombreDelLocal;
    }

    public ArrayList<IPromocion> getPromociones() { return this.promociones;}

    public void setNombreDelLocal(String nombreDelLocal) {
        this.nombreDelLocal = nombreDelLocal;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ArrayList<Operario> getOperarios() {
        return operarios;
    }

    public void setOperarios(ArrayList<Operario> operarios) {
        this.operarios = operarios;
    }

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public void setMozos(ArrayList<Mozo> mozos) {
        this.mozos = mozos;
    }

    public void agregarMozo(Mozo mozo){
        this.getMozos().add(mozo);
    }

    public void eliminarMozo(Mozo mozoViejo){
        for (int i = 0 ; i < this.getMozos().size() ; i++){
            if (this.getMozos().get(i).equals(mozoViejo)) {
                this.getMozos().remove(i);
                break;
            }
        }
    }
    public boolean hayMozosActivos(){return true;}

    public boolean hayDosProductosPromocionActiva(){return true;}

    // Hay que verificar
    //1. No es posible crear una nueva comanda si el local
    //1. no tiene mesas habilitadas
    //2. la mesa asociada debe tener un mozo activo asociado
    //3. no tiene mozos activos
    //4. al menos 2 productos están en promoción activa
    //5. la lista de productos no puede estar vacía
    // 2. La mesa debe estar en estado libre
    //3. Al momento de agregar un PEDIDO la cantidad solicitada no puede superar al stock del producto
    //4. Al momento de guardar la comanda, el estado de la mesa debe pasar a ocupada
    //5. Al momento de guardar la comanda se debe descontar del stock la cantidad pedida de cada producto.
    public void nuevaComanda(Calendar fecha, Mesa mesa, int cantidadComensales){
        if (mesa.getEstado().equalsIgnoreCase("Ocupado"))
            throw new RuntimeException(); //2. Mesa ocupada
        if (this.cantidadMesasHabilitadas<=0)
            throw new RuntimeException(); //1.1 Local sin mesas habilitadas
        if (this.MesasAsignadas.get(mesa) == null)
            throw new RuntimeException(); //1.2 La mesa no esta en el hash de MesasAsignadas -> no tiene mozo
        if (hayMozosActivos() == false)
            throw new RuntimeException(); //1.2 No hay mozos activos
        if (hayDosProductosPromocionActiva() == false)
            throw new RuntimeException(); //1.4 NO hay 2 productos en promocion activa

        // Verificar que la lista de productos NO este vacia

        this.comandas.add(new Comanda(fecha,mesa));
        mesa.ocupar(cantidadComensales);

    }
    public void agregarPedidoAComanda (Comanda comanda,Pedido pedido){
        //verificar que haya stock
        comanda.agregarPedido(pedido);
        //descontar stock
    }

    // TESTEAR -
    // Si se intenta cerrar una comanda que se encuentra cerrada,
    // tiene que lanzar una excepcion
    // pre condicion -> los metodos de pago tienen que ser validos [mercadopago, efectivo,tarjeta]
    // Post condicion -> la mesa de la comanda queda en estado libre
    //
    public void cerrarComanda(Comanda comanda , String metodoDePago){
        if (comanda.getEstado().equalsIgnoreCase("Cerrada"))
            throw new RuntimeException(); // No se puede cerrar una comanda ya cerrada
        comanda.cerrarComanda();
        comanda.getMesa().liberar();
        Factura factura = new Factura( new Date() , comanda.getMesa() ,metodoDePago,  comanda.getPedidos() , this.getPromociones());
        this.comandas.remove(comanda);
    }
    public void nuevaMesa(){
        this.mesas.add(new Mesa());
    }
    public void eliminarMesa(Mesa mesa){
        this.mesas.remove(mesa);
    }

    public void
}
