package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cerveceria {
    private static Cerveceria instance = null;
    private String nombreDelLocal;
    private Administrador administrador;
    ArrayList<Operario> operarios = new ArrayList<Operario>();
    ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<Comanda> comandas = new ArrayList<Comanda>();
    private HashMap<Mesa,Mozo>mesasAsignadas = new HashMap<Mesa, Mozo>();
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

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public ArrayList<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(ArrayList<Comanda> comandas) {
        this.comandas = comandas;
    }

    public HashMap<Mesa, Mozo> getMesasAsignadas() {
        return mesasAsignadas;
    }

    public void setMesasAsignadas(HashMap<Mesa, Mozo> mesasAsignadas) {
        this.mesasAsignadas = mesasAsignadas;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<IPromocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(ArrayList<IPromocion> promociones) {
        this.promociones = promociones;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public int getCantidadMesasHabilitadas() {
        return cantidadMesasHabilitadas;
    }

    public void setCantidadMesasHabilitadas(int cantidadMesasHabilitadas) {
        this.cantidadMesasHabilitadas = cantidadMesasHabilitadas;
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

    /**
     * <b>pre:</b> mesa debe ser distinto de null<br>.
     * @param mesa sobre la cual se va a crear la comanda
     * @throws Exception Se lanza excepción si la mesa esta en estado Ocupado
     * @throws Exception Se lanza excepción si No hay mesas habilitadas en el Negocio
     * @throws Exception Se lanza excepción si la mesa no tiene mozo asignado
     * @throws Exception Se lanza excepción Si el local no tiene Mozos activos
     * @throws Exception Se lanza excepción si no hay dos promociones en estado activo
     * @throws Exception Se lanza excepción si la lista de productos esta vacia.
     * <b>post:</b> Se agregara a la lista de comandas una nueva y la mesa pasara a estado ocupado<br>.
     */
    public void nuevaComanda( Mesa mesa) throws Exception {
        assert mesa!=null:"ERROR : La mesa no debe ser null";
        if (mesa.getEstado().equalsIgnoreCase("Ocupado"))
            throw new Exception("No se puede crear la Comanda : Mesa Ocupada"); //2. Mesa ocupada
        if (this.cantidadMesasHabilitadas<=0)
            throw new Exception("No se puede crear la Comanda : No hay mesas habilitadas"); //1.1 Local sin mesas habilitadas
        if (this.mesasAsignadas.get(mesa) == null)
            throw new Exception("No se puede crear la Comanda : La mesa no esta asignada a ningun mozo"); //1.2 La mesa no esta en el hash de MesasAsignadas -> no tiene mozo
        if (this.mozos.isEmpty())
            throw new Exception("No se puede crear la Comanda : No hay mozos activos"); //1.2 No hay mozos activos
        if (hayDosProductosPromocionActiva() == false)
            throw new Exception("No se puede crear la Comanda : No hay dos productos en promocion"); //1.4 NO hay 2 productos en promocion activa
        if (this.productos.isEmpty())
            throw new Exception("No se puede crear la Comanda : Lista de productos vacia"); //1.5 lista de productos vacia

        this.comandas.add(new Comanda());
        mesa.ocupar();
    }
    /**
     * <b>pre:</b> comanda y pedido deben ser distintos de null<br>.
     * @param comanda Comanda a la cual se le va a agregar un Pedido
     * @param pedido Pedido que sera agregado a la Comanda
     * @throws Exception Se lanza excepción si la cantidad de Pedido es mayor al Stock del mismo.
     * <b>post:</b> Se agregara a la Comandas un nuevo pedido y se descontara la cantidad del stock <br>.
     */
    public void agregarPedidoAComanda (Comanda comanda,Pedido pedido) throws Exception {
        assert comanda!=null:"ERROR : La comanda no debe ser null";
        assert pedido!=null:"ERROR : El pedido no debe ser null";
        //verificar que haya stock
        if (pedido.getProducto().getStockInicial() < pedido.getCantidad() )
            throw new Exception("ERROR : No se puede completar pedido. Stock insuficiente");
        comanda.agregarPedido(pedido);

        // descuenta Stock
        pedido.getProducto().setStockInicial(pedido.getProducto().getStockInicial()-pedido.getCantidad());

    }

    // TESTEAR -
    // Si se intenta cerrar una comanda que se encuentra cerrada,
    // tiene que lanzar una excepcion
    // pre condicion -> los metodos de pago tienen que ser validos [mercadopago, efectivo,tarjeta]
    // Post condicion -> la mesa de la comanda queda en estado libre
    //

    /**
     * <b>pre:</b> comanda deben ser distintos de null<br>.
     * @throws Exception Se lanza excepción si la comanda a cerrar ya esta en estado cerrada.
     * @param comanda Comanda que se cerrara
     * <b>post:</b> Se cerrará la comanda. La mesa de la comanda queda en estado Libre. Se creará la factura de la comanda a cerrar. Y se removera la comanda de la lista de comandas<br>.
     */
    public void cerrarComanda(Comanda comanda) throws Exception {
        assert comanda!=null:"ERROR : La comanda no debe ser null";
        if (comanda.getEstado().equalsIgnoreCase("Cerrada"))
            throw new Exception("ERROR : No se puede cerrar una comanda ya cerrada");
        comanda.cerrarComanda();
        comanda.getMesa().liberar();

        this.comandas.remove(comanda);
    }

    public void nuevaMesa(){this.mesas.add(new Mesa());}

    public void eliminarMesa(Mesa mesa){
        this.mesas.remove(mesa);
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    /**
     * <b>pre:</b> <br>.
     * El metodo crea una lista con los mozos activos a partir de la lista de mozos. Ademas verifica que haya
     * mesas y mozos activos para asignar a cada Mesa un mozo
     * @throws Exception Se lanza excepción si no hay mesas habilitadas en el Negocio
     * @throws Exception Se lanza excepción si no hay mozos en estado activo
     * <b>post:</b> Cada mesa tendra asignada un mozo (mesasAsignadas)<br>.
     */
    public void asignarMesas () throws Exception {
        ArrayList<Mozo> listaMozosActivos = mozosActivos();
        int mozos,mesas,indiceMesa=0;
        if (this.mesas.isEmpty())
            throw new Exception("No hay mesas habilitadas. NO se puede Asignar mesas");
        if (listaMozosActivos.isEmpty())
            throw new Exception("No hay mozos activos. NO se puede asignar mesas");
        for (mozos=0;mozos<mozosActivos().size();mozos++){
            for (mesas=0; mesas<(this.cantidadMesasHabilitadas/mozosActivos().size());mesas++) {
                this.mesasAsignadas.put(this.mesas.get(indiceMesa++),listaMozosActivos.get(mozos));
            }
        }
    }

    /**
     * Metodo privado de esta clase que es llamado por asignarMesas. Este genera una lista con los mozos que
     * estan activos.
     * @return ArrayList<Mozo> Lista de mozos activos
     */
    private ArrayList<Mozo> mozosActivos(){
        ArrayList<Mozo> activos = new ArrayList<Mozo>();
        for (int q = 0 ; q < this.mozos.size(); q++){
            if (mozos.get(q).getEstado() == 0)
                activos.add(mozos.get(q));
        }
        return activos;

    }
}
