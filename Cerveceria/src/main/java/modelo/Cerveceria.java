package modelo;

import excepciones.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Cerveceria {
    private static Cerveceria instance = null;
    private String nombreDelLocal;
    private Administrador administrador;
    ArrayList<Operario> operarios = new ArrayList<Operario>();
    ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    public ArrayList<Mozo> mozosActivos = new ArrayList<Mozo>();
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<Comanda> comandas = new ArrayList<Comanda>();
    private HashMap<Mesa,Mozo>MesasAsignadas = new HashMap<Mesa, Mozo>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private ArrayList<IPromocion> promociones = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<Producto>();
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

    //GETTERS & SETTERS
    public String getNombreDelLocal() {
        return nombreDelLocal;
    }

    public void setNombreDelLocal(String nombreDelLocal) {
        this.nombreDelLocal = nombreDelLocal;
    }

    public ArrayList<IPromocion> getPromociones() { return this.promociones;}

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

    //FUNCIONALIDADES
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
    public void nuevaComanda(Mesa mesa, int cantidadComensales) throws ErrorAlCrearComandaException {
        if (mesa.getEstado().equalsIgnoreCase("Ocupado"))
            throw new ErrorAlCrearComandaException("No se puede crear la Comanda : Mesa Ocupada"); //2. Mesa ocupada
        if (this.cantidadMesasHabilitadas<=0)
            throw new ErrorAlCrearComandaException("No se puede crear la Comanda : No hay mesas habilitadas"); //1.1 Local sin mesas habilitadas
        if (this.MesasAsignadas.get(mesa) == null)
            throw new ErrorAlCrearComandaException("No se puede crear la Comanda : La mesa no esta asignada a ningun mozo"); //1.2 La mesa no esta en el hash de MesasAsignadas -> no tiene mozo
        if (this.mozosActivos.isEmpty())
            throw new ErrorAlCrearComandaException("No se puede crear la Comanda : No hay mozos activos"); //1.2 No hay mozos activos
        if (hayDosProductosPromocionActiva() == false)
            throw new ErrorAlCrearComandaException("No se puede crear la Comanda : No hay dos productos en promocion"); //1.4 NO hay 2 productos en promocion activa
        if (this.productos.isEmpty())
            throw new ErrorAlCrearComandaException("No se puede crear la Comanda : Lista de productos vacia"); //1.5 lista de productos vacia

        this.comandas.add(new Comanda(mesa));
        mesa.ocupar(cantidadComensales);

    }
    public void agregarPedidoAComanda (Comanda comanda,Pedido pedido) throws StockInsufucienteException {
        //verificar que haya stock
        if (pedido.getProducto().getStockInicial() < pedido.getCantidad() )
            throw new StockInsufucienteException("ERROR : No se puede completar pedido. Stock insuficiente");
        comanda.agregarPedido(pedido);

        // descuenta Stock
        pedido.getProducto().setStockInicial(pedido.getProducto().getStockInicial()-pedido.getCantidad());

    }

    // TESTEAR -
    // Si se intenta cerrar una comanda que se encuentra cerrada,
    // tiene que lanzar una excepcion
    // pre condicion -> los metodos de pago tienen que ser validos [mercadopago, efectivo,tarjeta]
    // Post condicion -> la mesa de la comanda queda en estado libre
    public void cerrarComanda(Comanda comanda) {
        if (comanda.getEstado().equalsIgnoreCase("Cerrada"))
            throw new RuntimeException(); // No se puede cerrar una comanda ya cerrada

        comanda.cerrarComanda();
        comanda.getMesa().liberar();

        this.comandas.remove(comanda);
    }

    public void nuevaMesa(){
        this.mesas.add(new Mesa());
    }

    public void eliminarMesa(Mesa mesa){
        this.mesas.remove(mesa);
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public void asignarMesas () throws ErrorAlAsignarMesasException {
        int mozos,mesas,indiceMesa=0;
        if (cantidadMesasHabilitadas<=0)
            throw new ErrorAlAsignarMesasException("No hay mesas habilitadas. NO se puede Asignar mesas");
        if (this.mozosActivos.isEmpty())
            throw new ErrorAlAsignarMesasException("No hay mozos activos. NO se puede asignar mesas");
        for (mozos=0;mozos<this.mozosActivos.size();mozos++){
            for (mesas=0; mesas<(this.cantidadMesasHabilitadas/this.mozosActivos.size());mesas++) {
                this.MesasAsignadas.put(this.mesas.get(indiceMesa++),this.mozosActivos.get(mozos));
            }
        }
    }
}
