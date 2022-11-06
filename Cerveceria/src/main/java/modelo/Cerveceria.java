package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cerveceria {
    private static Cerveceria instance = null;
    public static final int totalMaximoMesas = 50;
    private String nombreDelLocal;
    private Administrador administrador;
    private ArrayList<Operario> operarios = new ArrayList<>();
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
//    private HashMap<Integer, Mesa> mesas = new HashMap<>();
    private ArrayList<Comanda> comandas = new ArrayList<>();
    private HashMap<Mesa,Mozo> mesasAsignadas = new HashMap<>();
    private ArrayList<Factura> facturas = new ArrayList<>();
    private ArrayList<Promocion> promociones = new ArrayList<>();
    private HashMap<Integer,Producto> productos = new HashMap<>();
    private double remuneracionBasica;

    //PATRON SINGLETON
    private Cerveceria() {
        this.nombreDelLocal = "Cerveceria";
        this.administrador = new Administrador("ADMIN", "ADMIN1234");
        this.remuneracionBasica = 0;
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

    public double getRemuneracionBasica() {
        return remuneracionBasica;
    }

    public void setRemuneracionBasica(double remuneracionBasica) {
        this.remuneracionBasica = remuneracionBasica;
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

    public ArrayList<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(ArrayList<Promocion> promociones) {
        this.promociones = promociones;
    }

    public HashMap<Integer,Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Integer,Producto> productos) {
        this.productos = productos;
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
            if (operario.getNombreUsuario().equalsIgnoreCase(username)) {
                if (operario.getContrasena().equalsIgnoreCase(password))
                    return operario;

                throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
            }
        }

        throw new ErrorDeUsuarioException("Nombre de usuario invalido: " + username);
    }

    // AGREGAR

    public void agregarAdministrador(String nombre, String contrasena) throws Exception{
        if (nombre.length()<5)
            throw new Exception("ERROR : El nombre de usuario debe tener al menos 5 caracteres");
        if (contrasena.length()<5)
            throw new Exception("ERROR : El nombre de usuario debe tener al menos 8 caracteres");
        this.administrador = new Administrador(nombre, contrasena);
    }

    /**
     * <b>pre:</b> La lista de mesas debe existir <br>.
     * @throws Exception Se lanza excepción si supera el numero maximo de mesas permitidas
     * <b>post:</b> Se agregara una mesa a la lista de mesas <br>.
     */

    public void agregarMesa(int cantidadComensales, String estado) throws Exception{
        if (this.mesas.size() >= totalMaximoMesas)
            throw new Exception("ERROR : No se pueden dar de alta mas mesas. LLego al nro maximo");

        this.mesas.add(new Mesa(cantidadComensales, estado));
    }

    public void agregarMozo(String nombre, int edad, int hijos, String estado) throws Exception {
        if (nombre.equals(""))
            throw new Exception("ERROR : Nombre vacio");
        if (hijos < 0)
            throw new Exception("ERROR : Cantidad de hijos debe ser mayo o igual a cero");

        Mozo mozo = new Mozo(nombre, edad, hijos,estado);

        this.getMozos().add(mozo);
    }

    public void agregarOperario(String nombre, String nombreUsuario, String contrasena, boolean activo ) throws Exception {
        if (nombre == "")
            throw new Exception("ERROR : Nombre vacio");
        if (nombreUsuario.length() < 5)
            throw new Exception("ERROR : El nombre de Usuario debe tener al menos 5 caracteres");
        if (contrasena.length() < 8)
            throw new Exception("ERROR : La contraseña debe tener al menos 8 caracteres");

        Operario operario = new Operario(nombre, nombreUsuario, contrasena, activo);
        this.getOperarios().add(operario);
    }

    /**
     * <b>pre:</b> <br>.
     * El metodo crea añade una nueva factura a la lista de Facturas
     * @throws Exception Se lanza excepción si la comanda es null
     * <b>post:</b> La lista de facturas tendra una nueva<br>.
     */
    public void agregarFactura(Comanda comanda) throws Exception {
        if (comanda == null)
            throw new Exception("ERROR : No se puede crear factura sin comanda");
//        this.facturas.add(new Factura(new Date(), comanda.getMesa(), comanda.getPedidos(), comanda.getTotal(), this.promociones)); //TODO corregir
    }

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
     * <b>pre:</b> mesa y pedidos deben ser distintos de null<br>.
     * @param mesa sobre la cual se va a crear la comanda
     * @throws Exception Se lanza excepción si la mesa esta en estado Ocupado
     * @throws Exception Se lanza excepción si No hay mesas habilitadas en el Negocio
     * @throws Exception Se lanza excepción si la mesa no tiene mozo asignado
     * @throws Exception Se lanza excepción Si el local no tiene Mozos activos
     * @throws Exception Se lanza excepción si no hay dos promociones en estado activo
     * @throws Exception Se lanza excepción si la lista de productos esta vacia.
     * <b>post:</b> Se agregara a la lista de comandas una nueva y la mesa pasara a estado ocupado<br>.
     */
    public void agregarComanda(Mesa mesa, ArrayList<Pedido> pedidos) throws Exception {
        assert mesa != null : "ERROR : La mesa no debe ser null";
        assert pedidos != null : "ERROR : Pedidos no debe ser null";

        if (mesa.getEstado().equalsIgnoreCase("Ocupado"))
            throw new Exception("No se puede crear la Comanda : Mesa Ocupada"); //2. Mesa ocupada
        if (this.mesas.size() == 0)
            throw new Exception("No se puede crear la Comanda : No hay mesas habilitadas"); //1.1 Local sin mesas habilitadas
        if (this.mesasAsignadas.get(mesa) == null)
            throw new Exception("No se puede crear la Comanda : La mesa no esta asignada a ningun mozo"); //1.2 La mesa no esta en el hash de MesasAsignadas -> no tiene mozo
        if (this.mozos.isEmpty())
            throw new Exception("No se puede crear la Comanda : No hay mozos activos"); //1.2 No hay mozos activos
        if (hayDosProductosPromocionActiva() == false)
            throw new Exception("No se puede crear la Comanda : No hay dos productos en promocion"); //1.4 NO hay 2 productos en promocion activa
        if (this.productos.isEmpty())
            throw new Exception("No se puede crear la Comanda : Lista de productos vacia"); //1.5 lista de productos vacia

        mesa.ocupar();
        Comanda comanda = new Comanda();
        comanda.setMesa(mesa);
        comanda.setPedidos(pedidos);
        this.comandas.add(comanda);
    }

    public void agregarProducto (int nro,String nombre, double precioCosto, double precioVenta, int stockInicial) throws Exception {
        if (precioVenta >= precioCosto){
            if(precioVenta > 0){
                if(precioCosto > 0) {
                    if(this.productos.containsKey(nro)){
                        Producto producto = productos.get(nro);
                        producto.setNombre(nombre);
                        producto.setPrecioCosto(precioCosto);
                        producto.setPrecioVenta(precioVenta);
                        producto.setStockInicial(stockInicial);
                    }
                    else this.productos.put(nro,new Producto(nombre, precioCosto, precioVenta, stockInicial));
                }
                else throw new Exception("El precio de costo es menor a cero");
            }
            else throw new Exception("El precio de venta es menor a cero");
        }
        else throw new Exception("El precio de venta es menor al de costo");
    }

    // ELIMINAR
    public void eliminarMozo(Mozo mozoViejo){
        assert mozoViejo != null:"ERROR : El mozo no puede ser null";
        for (int i = 0 ; i < mozos.size() ; i++){
            if (this.mozos.get(i).equals(mozoViejo)) {
                this.mozos.remove(i);
                break;
            }
        }
    }

    public void eliminarMesa(Mesa mesa){
        assert mesa!=null:"ERROR : La mesa no puede ser null";
        this.mesas.remove(mesa);
    }

    public void eliminarOperario (Operario operario){
        assert operario!=null:"ERROR : El operario no puede ser null";
        this.operarios.remove(operario);
    }

    public void eliminarComanda (Comanda comanda){
        assert comanda!=null:"ERROR : La comanda no puede ser null";
        this.comandas.remove(comanda);
    }

    public void eliminarProducto (Producto producto) throws Exception{
        for (int i=0;i<comandas.size();i++){
            ArrayList<Pedido> pedidos=comandas.get(i).getPedidos();
            for (int j=0;j<pedidos.size();j++){
                if(producto.getIdProducto() == pedidos.get(j).getProducto().getIdProducto()){
                    throw new Exception("El producto no se puede eliminar debido a que esta asociado a una comanda");
                }
            }
        }
        this.productos.remove(producto);
    }

    // MODIFICAR
    public void modificarAdministrador(Administrador administrador,String nombre, String contrasena) throws Exception{
        if (nombre.length()<5)
            throw new Exception("ERROR : El nombre de usuario debe tener al menos 5 caracteres");
        if (contrasena.length()<5)
            throw new Exception("ERROR : El nombre de usuario debe tener al menos 8 caracteres");

        this.administrador.setUsername(nombre);
        this.administrador.setPassword(contrasena);
    }

    public void modificarMesa(Mesa mesa, int cantidadComensales) throws Exception {
        assert mesa!=null:"ERROR : La mesa no puede ser null";
        if (cantidadComensales<2)
            throw new Exception("ERROR : La cantidad de comensales no puede ser menor a 2");

        mesa.setCantidadComensales(cantidadComensales);
    }

    public void modificarMozo(Mozo mozo,String nombre, int edad, int hijos, String estado ) throws Exception {
        if (nombre == "")
            throw new Exception("ERROR : Nombre vacio");
        if (hijos <0)
            throw new Exception("ERROR : Cantidad de hijos debe ser mayo o igual a cero");
        if (hijos <0)
            throw new Exception("ERROR : Cantidad de hijos debe ser mayo o igual a cero");

        mozo.setNombreYApellido(nombre);
        mozo.setEdad(edad);
        mozo.setEstado(estado);
        mozo.setCantHijos(hijos);
    }

    public void modificarOperario(Operario operario,String nombre, String nombreUsuario, String contrasena, boolean activo ) throws Exception {
        if (nombre == "")
            throw new Exception("ERROR : Nombre vacio");
        if (nombreUsuario.length() < 5)
            throw new Exception("ERROR : El nombre de Usuario debe tener al menos 5 caracteres");
        if (contrasena.length() < 8)
            throw new Exception("ERROR : La contraseña debe tener al menos 8 caracteres");
        operario.setNombreCompleto(nombre);
        operario.setNombreUsuario(nombreUsuario);
        operario.setContrasena(contrasena);
        operario.setActivo(activo);
    }

    public void modificarProducto (Producto producto,String nombre, double precioCosto, double precioVenta, int stockInicial) throws Exception {
        if (precioVenta>=precioCosto)
            throw new Exception("El precio de venta es menor al de costo");
        if(precioCosto>0)
            throw new Exception("El precio de costo es menor a cero");
        if(precioVenta>0)
            throw new Exception("El precio de venta es menor a cero");

        producto.setNombre(nombre);
        producto.setPrecioCosto(precioCosto);
        producto.setPrecioVenta(precioVenta);
        producto.setStockInicial(stockInicial);
    }

    public void modificarComanda( Comanda comanda, Mesa mesa, ArrayList<Pedido> pedidos) throws Exception {
        assert mesa!=null:"ERROR : La mesa no debe ser null";
        assert comanda != null : "ERROR : La comanda no debe ser null";
        assert pedidos != null : "ERROR : Pedidos no debe ser null";

        comanda.setMesa(mesa);
        comanda.setPedidos(pedidos);
        mesa.ocupar();
    }

    public boolean hayDosProductosPromocionActiva(){return true;}

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

    /**
     * <b>pre:</b> <br>.
     * El metodo crea una lista con los mozos activos a partir de la lista de mozos. Ademas verifica que haya
     * mesas y mozos activos para asignar a cada Mesa un mozo
     * @throws Exception Se lanza excepción si no hay mesas habilitadas en el Negocio
     * @throws Exception Se lanza excepción si no hay mozos en estado activo
     * <b>post:</b> Cada mesa tendra asignada un mozo (mesasAsignadas)<br>.
     */
    public void asignarMesas() throws Exception {
        ArrayList<Mozo> listaMozosActivos = mozosActivos();
        int mozo = 0;

        if (this.mesas.isEmpty())
            throw new Exception("No hay mesas habilitadas. NO se puede Asignar mesas");
        if (listaMozosActivos.isEmpty())
            throw new Exception("No hay mozos activos. NO se puede asignar mesas");

        for (int i = 0; i < this.mesas.size();i++){
            if (mozo >= listaMozosActivos.size())
                mozo = 0;
            this.mesasAsignadas.put(this.mesas.get(i),listaMozosActivos.get(mozo++));
        }
    }

    /**
     * Metodo privado de esta clase que es llamado por asignarMesas. Este genera una lista con los mozos que
     * estan activos.
     * @return ArrayList<Mozo> Lista de mozos activos
     */
    private ArrayList<Mozo> mozosActivos() {
        ArrayList<Mozo> activos = new ArrayList<Mozo>();

        for (int q = 0 ; q < this.mozos.size(); q++){
            if (mozos.get(q).getEstado().equalsIgnoreCase("Activo"))
                activos.add(mozos.get(q));
        }
        return activos;
    }

}