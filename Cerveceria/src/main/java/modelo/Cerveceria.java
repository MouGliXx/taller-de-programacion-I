package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cerveceria {
    private static Cerveceria instance = null;
    public static final int totalMaximoMesas = 50;
    public static final int totalMaximoMozos = 6;
    private String nombreDelLocal;
    private double remuneracionBasica;
    private Administrador administrador;
    private ArrayList<Operario> operarios = new ArrayList<>();
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private HashMap<Integer,Producto> productos = new HashMap<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Comanda> comandas = new ArrayList<>();
    private ArrayList<Factura> facturas = new ArrayList<>();
    private ArrayList<PromocionProducto> promocionesProductos = new ArrayList<>();
    private ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<>();
    private HashMap<Mesa,Mozo> mesasAsignadas = new HashMap<>();
    private HashMap<Mozo, EstadisticaMozo> estadisticasMozos = new HashMap<>();
    private HashMap<Mesa, EstadisticaMesa> estadisticasMesas = new HashMap<>();

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

    public double getRemuneracionBasica() {
        return remuneracionBasica;
    }

    public void setRemuneracionBasica(double remuneracionBasica) {
        this.remuneracionBasica = remuneracionBasica;
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

    public ArrayList<PromocionTemporal> getPromocionesTemporales() {
        return promocionesTemporales;
    }

    public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales) {
        this.promocionesTemporales = promocionesTemporales;
    }

    public ArrayList<PromocionProducto> getPromocionesProductos() {
        return promocionesProductos;
    }

    public void setPromocionesProductos(ArrayList<PromocionProducto> promocionesProductos) {
        this.promocionesProductos = promocionesProductos;
    }

    public HashMap<Integer, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Integer, Producto> productos) {
        this.productos = productos;
    }

    public HashMap<Mozo, EstadisticaMozo> getEstadisticasMozos() {
        return estadisticasMozos;
    }

    public HashMap<Mesa, EstadisticaMesa> getEstadisticasMesas() {
        return estadisticasMesas;
    }

    public void setEstadisticasMozos(HashMap<Mozo, EstadisticaMozo> estadisticasMozos) {
        this.estadisticasMozos = estadisticasMozos;
    }

    public void setEstadisticasMesas(HashMap<Mesa, EstadisticaMesa> estadisticasMesas) {
        this.estadisticasMesas = estadisticasMesas;
    }

    //FUNCIONALIDADES

    /**
     * Verifica la contrasena del administrador para poder acceder al sistema
     * <b>pre:</b> El administrador debe existir, password distinto de vacio y null<br>.
     * @param password contrasena del administrador
     * @throws ErrorDeContrasenaException Se lanza excepción si la contrasena es invalida
     * @return Administrador devuelve el objeto administrador
     */
    public Administrador login(String password) throws ErrorDeContrasenaException {
        if (password.equalsIgnoreCase(administrador.getPassword())) {
            return this.administrador;
        }

        throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
    }


    /**
     * Verifica la contrasena del Operario para poder acceder al sistema
     * <b>pre:</b> La lista de operarios debe existir, username y password distinto de null y vacio<br>.
     * @param password contrasena del administrador
     * @throws ErrorDeContrasenaException Se lanza excepción si la contrasena es invalida
     * @throws ErrorDeUsuarioException Se lanza excepción si el Usuario no esta en estado activo o si el nombre no es valido
     * @return Operario devuelve una instancia del objeto operario
     */
    public Operario login(String username, String password) throws ErrorDeUsuarioException, ErrorDeContrasenaException {
        for (Operario operario: operarios) {
            if (operario.getNombreUsuario().equalsIgnoreCase(username)) {
                if (operario.getContrasena().equalsIgnoreCase(password)) {
                    if (!operario.isActivo()) {
                        throw new ErrorDeUsuarioException("El usuario ingresado se encuentra INACTIVO, no puede ingresar al sistema");
                    }

                   return operario;
                }

                throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
            }
        }

        throw new ErrorDeUsuarioException("Nombre de usuario invalido: " + username);
    }

    public boolean contieneDigito(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= '0' && cadena.charAt(i) <= '9') {
                return true;
            }
        }

        return false;
    }

    public boolean contieneMayuscula(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    /**
     * crea una nueva mesa y la agrega a la coleccion de mesas
     * Ademas crea un nuevo elemento de la coleccion de estadisticasMesas
     * <b>pre:</b> La lista de mesas debe existir, cantidadComensales entero positivo<br>.
     * @param cantidadComensales cantidad de sillas que tendra la mesa
     * @throws Exception Se lanza excepción si supera el numero maximo de mesas permitidas
     * <b>post:</b> Se agregaran nuevos elementos a las colecciones de mesa y estadisticas mesa <br>.
     */
    public void agregarMesa(int cantidadComensales) throws Exception{
        if (this.mesas.size() >= totalMaximoMesas)
            throw new Exception("ERROR : No se pueden dar de alta mas mesas. LLego al nro maximo");
        Mesa mesa = new Mesa(cantidadComensales);
        this.mesas.add(mesa);
        this.estadisticasMesas.put(mesa,new EstadisticaMesa());
    }

    /**
     * El metodo setea los valores de la promocion de productos y la agrega a la coleccion de promociones productos
     * <b>pre:</b> Promocion producto valido y distinto de null <br>.
     * @param promocionProducto promocion de un producto a agregar
     * @param diasPromocion coleccion de dias en los cuales aplica la promocion
     * @param activa estado de la promocion
     * @param producto producto que  tendra promocion
     * @param aplicaDosPorUno valor booleano que indica si aplica 2 x 1
     * @param aplicaDtoPorCantidad valor booleano que indica si aplica descuento por cantidad
     * @param dtoPorCantidad_CantMinima cantidad minima para que aplique el descuento por cantidad
     * @param dtoPorCantidad_PrecioUnitario precio unitario del producto cuando aplica el descuento por cantidad
     * <b>post:</b> La coleccion de promociones productos tendra un nuevo elemento<br>.
     */
    public void agregarPromocionProducto(PromocionProducto promocionProducto, ArrayList<String> diasPromocion, boolean activa, Producto producto, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario) {
        promocionProducto.setDiasPromocion(diasPromocion);
        promocionProducto.setActiva(activa);
        promocionProducto.setProducto(producto);
        promocionProducto.setAplicaDosPorUno(aplicaDosPorUno);
        promocionProducto.setAplicaDtoPorCantidad(aplicaDtoPorCantidad);
        promocionProducto.setDtoPorCantidad_CantMinima(dtoPorCantidad_CantMinima);
        promocionProducto.setDtoPorCantidad_PrecioUnitario(dtoPorCantidad_PrecioUnitario);

        this.promocionesProductos.add(promocionProducto);
    }

    public void agregarPromocionProducto(PromocionProducto promocionProducto, ArrayList<String> diasPromocion, boolean activa, Producto producto, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad) {
        promocionProducto.setDiasPromocion(diasPromocion);
        promocionProducto.setActiva(activa);
        promocionProducto.setProducto(producto);
        promocionProducto.setAplicaDosPorUno(aplicaDosPorUno);
        promocionProducto.setAplicaDtoPorCantidad(aplicaDtoPorCantidad);

        this.promocionesProductos.add(promocionProducto);
    }

    /**
     * El metodo setea los valores de la promocion temporal y la agrega a la coleccion de promociones temporales
     * <b>pre:</b> Promocion temporal valida y distinto de null<br>.
     * @param promocionTemporal a agregar
     * @param diasPromocion coleccion de dias en los cuales aplica la promocion
     * @param activa estado de la promocion
     * @param nombre de la promocion
     * @param formaDePago forma de pago con la cual aplica la promocion
     * @param porcentajeDescuento porcentaje de descuento de la promocion
     * @param esAcumulable valor booleano que indica si la promocion es acumulable con otras
     * <b>post:</b> La coleccion de promociones temporales tendra un nuevo elemento<br>.
     */
    public void agregarPromocionTemporal(PromocionTemporal promocionTemporal, ArrayList<String> diasPromocion, boolean activa, String nombre, String formaDePago, int porcentajeDescuento, boolean esAcumulable){
        promocionTemporal.setDiasPromocion(diasPromocion);
        promocionTemporal.setActiva(activa);
        promocionTemporal.setNombre(nombre);
        promocionTemporal.setFormaDePago(formaDePago);
        promocionTemporal.setPorcentajeDescuento(porcentajeDescuento);
        promocionTemporal.setEsAcumulable(esAcumulable);

        this.promocionesTemporales.add(promocionTemporal);
    }

    /**
     * El metodo valida los datos correspondientes para crear un nuevo Mozo y agregarlo a la coleccion de mozos
     * Ademas crea un nuevo elemento a la coleccion de estadisticasMozo
     *
     * <b>pre:</b> La coleccion de mozos debe existir, nombre distinto de null y vacio, hijos y edad entero, <br>.
     *
     * @param nombre nombre del mozo
     * @param edad edad del mozo
     * @param hijos cantidad de hijos del mozo
     * @throws Exception Se lanza excepción si numero de mozos llego al maximo (6)
     * @throws Exception Se lanza excepción si Nombre es vacio
     * @throws Exception Se lanza excepción si edad es menor 18
     * @throws Exception Se lanza excepción si cantidad de hijos es menor a cero
     * <b>post:</b> Las colecciones de mozos y de estadisticas de Mozos tendran un nuevo elemento <br>.
     */
    public void agregarMozo(String nombre, int edad, int hijos) throws Exception {
        if (this.mozos.size() >= totalMaximoMozos)
            throw new Exception("ERROR : No se pueden dar de alta mas mozos. LLego al nro maximo");
        if (nombre.equals(""))
            throw new Exception("ERROR : Nombre vacio");
        if (edad < 18)
            throw new Exception("ERROR : La edad debe superar los 18 anos.");
        if (hijos < 0)
            throw new Exception("ERROR : Cantidad de hijos debe ser mayo o igual a cero");

        Mozo mozo = new Mozo(nombre, edad, hijos);
        this.mozos.add(mozo);
        this.estadisticasMozos.put(mozo, new EstadisticaMozo());
    }

    /**
     * El metodo valida los datos correspondientes para crear un nuevo Operario y agregarlo a la coleccion de operarios
     * <b>pre:</b> la coleccion de operarios debe existir<br>.
     * @param nombre nombre del operario
     * @param nombreUsuario nombre de usuario del operario
     * @param contrasena constrasena del operario
     * @param activo estado del operario ( activo / inactivo )
     * @throws Exception Se lanza excepción si Nombre es vacio
     * @throws Exception Se lanza excepción si Nombre de Usuario es menor a 5 caracteres o mayor a 10
     * @throws Exception Se lanza excepción si contresena es menor a 5 caracteres o mayor a 10
     * @throws Exception Se lanza excepción si constresena no tiene un digito numerico
     * @throws Exception Se lanza excepción si constrasena no contiene por lo menos una letra mayuscula
     * <b>post:</b> La coleccion de operarios tendra un nuevo elemento<br>.
     */
    public void agregarOperario(String nombre, String nombreUsuario, String contrasena, boolean activo ) throws Exception {
        if (nombre.equals(""))
            throw new Exception("ERROR : Nombre vacio.");
        if (nombreUsuario.length() < 5 || nombreUsuario.length() > 10)
            throw new Exception("ERROR : El nombre de Usuario debe tener entre 5 y 10 caracteres.");
        if (contrasena.length() < 6 || contrasena.length() > 12)
            throw new Exception("ERROR : La contraseña debe tener entre 6 y 12 caracteres.");
        if (!contieneDigito(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos un digito.");
        if (!contieneMayuscula(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos una mayuscula.");

        Operario operario = new Operario(nombre, nombreUsuario, contrasena, activo);
        this.operarios.add(operario);
    }

    /**
     * El metodo añade una nueva factura a la lista de Facturas y llama a el metodo agregaNuevaEstadistica
     * <b>pre:</b> factura debe ser distinto de null<br>.
     * @param factura que se agregara a la coleccion de facturas
     * <b>post:</b> La coleccion de facturas tendra una nueva factura<br>.
     */
    public void agregarFactura(Factura factura){
        this.facturas.add(factura);
        agregaNuevaEstadistica(factura);
    }

    /**
     * En base a una factura agrega una nueva estadistica a la mesa correspondiente, y otra al mozo que atendio
     * <b>pre:</b> factura debe ser distinto de null<br>.
     * @param factura sobre la cual se calculara una nueva estadista tanto de mozo como de mesa.
     * <b>post:</b> Se agregaran a las colecciones de estadisticasMozos y estadisticasMesas un nuevo dato<br>.
     */
    private void agregaNuevaEstadistica(Factura factura){
        Mesa mesa = factura.getMesa();
        Mozo mozo = mesasAsignadas.get(mesa);
        EstadisticaMozo estadisticasMozo = this.estadisticasMozos.get(mozo);
        estadisticasMozo.setCantidadVentas(estadisticasMozo.getCantidadVentas()+1);
        estadisticasMozo.setTotalGastado(estadisticasMozo.getTotalGastado()+ factura.getTotal());
        this.estadisticasMozos.replace(mozo,estadisticasMozo);
        EstadisticaMesa estadisticasMesa = this.estadisticasMesas.get(mesa);
        estadisticasMesa.setCantidadVentas(estadisticasMesa.getCantidadVentas()+1);
        estadisticasMesa.setTotalGastado(estadisticasMesa.getTotalGastado()+ factura.getTotal());
        this.estadisticasMesas.replace(mesa,estadisticasMesa);
    }

    /**
     * <b>pre:</b> mesa y pedidos deben ser distintos de null<br>.
     * @param mesa sobre la cual se va a crear la comanda
     * @param pedidos lista de pedidos a agregar a la comanda
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
        if (!hayDosProductosPromocionActiva())
            throw new Exception("No se puede crear la Comanda : No hay dos productos en promocion"); //1.4 NO hay 2 productos en promocion activa
        if (this.productos.isEmpty())
            throw new Exception("No se puede crear la Comanda : Lista de productos vacia"); //1.5 lista de productos vacia

        mesa.ocupar();
        Comanda comanda = new Comanda();
        comanda.setMesa(mesa);
        comanda.setPedidos(pedidos);
        this.comandas.add(comanda);
    }

    /**
     * El metodo valida los datos, crea un nuevo producto y lo agrega a la coleccion de productos
     *
     * <b>pre:</b> la coleccion de productos debe existir<br>.
     * @param ID numero unico de identificacion del producto
     * @param nombre nombre del producto
     * @param precioCosto precio de costo del producto
     * @param precioVenta precio de venta del producto
     * @param stockInicial stock del producto
     * @throws Exception Se lanza excepción si el precio de venta es menor al precio de costo
     * @throws Exception Se lanza excepción si el precio de costo es menor a cero
     * @throws Exception Se lanza excepción si el precio de venta es menor a cero
     * <b>post:</b> Se agregara a la lista de productos un nuevo elemento<br>.
     */

    public void agregarProducto (int ID, String nombre, double precioCosto, double precioVenta, int stockInicial) throws Exception {
        if (precioVenta < precioCosto)
            throw new Exception("El precio de venta es menor al de costo");
        if(precioCosto < 0)
            throw new Exception("El precio de costo es menor a cero");
        if(precioVenta < 0)
            throw new Exception("El precio de venta es menor a cero");

        this.productos.put(ID,new Producto(nombre, precioCosto, precioVenta, stockInicial));
    }

    // ELIMINAR

    /**
     * Elimina un mozo determinado
     *
     * <b>pre:</b> la coleccion de mozos debe existir<br>.
     * <b>pre:</b> mozo debe ser distinto de null<br>.
     * @param mozoViejo mozo que se desea eliminar
     * <b>post:</b>La lista de mozos tendra un elemento menos<br>.
     */
    public void eliminarMozo(Mozo mozoViejo){
        assert mozoViejo != null:"ERROR : El mozo no puede ser null";
        for (int i = 0 ; i < mozos.size() ; i++){
            if (this.mozos.get(i).equals(mozoViejo)) {
                this.mozos.remove(i);
                break;
            }
        }
    }

    /**
     * Elimina una mesa determinada
     *
     * <b>pre:</b> la coleccion de mesas debe existir<br>.
     * <b>pre:</b> mesa debe ser distinto de null<br>.
     * @param mesa mesa que se desea eliminar
     * <b>post:</b> la lista de mesa tendra un elemento menos<br>.
     */
    public void eliminarMesa(Mesa mesa){
        assert mesa!=null:"ERROR : La mesa no puede ser null";
        this.mesas.remove(mesa);
    }

    /**
     * Elimina una promocion temporal determinada
     *
     * <b>pre:</b> la coleccion de promociones temporales debe existir<br>.
     * <b>pre:</b> promocion temporal debe ser distinto de null<br>.
     * @param promo promocion temporal  que se desea eliminar
     * <b>post:</b> la lista de promociones temporales tendra un elemento menos<br>.
     */
    public void eliminarPromocionTemporal(PromocionTemporal promo){
        assert promo!=null:"ERROR : La promocion no puede ser null";
        this.promocionesTemporales.remove(promo);
    }

    /**
     * Elimina una promocion de producto determinada
     *
     * <b>pre:</b> la coleccion de promociones producto debe existir<br>.
     * <b>pre:</b> promocion producto debe ser distinto de null<br>.
     * @param promo promocion producto  que se desea eliminar
     * <b>post:</b> la lista de promociones producto tendra un elemento menos<br>.
     */
    public void eliminarPromocionProducto(PromocionProducto promo){
        assert promo!=null:"ERROR : La promocion no puede ser null";
        this.promocionesProductos.remove(promo);
    }

    /**
     * Elimina un operario determinada
     *
     * <b>pre:</b> la coleccion de operarios debe existir<br>.
     * <b>pre:</b> operario debe ser distinto de null<br>.
     * @param operario operario que se desea eliminar
     * <b>post:</b> la lista de operarios tendra un elemento menos<br>.
     */
    public void eliminarOperario (Operario operario){
        assert operario!=null:"ERROR : El operario no puede ser null";
        this.operarios.remove(operario);
    }

    /**
     * Elimina una comanda determinada
     *
     * <b>pre:</b> comanda deben ser distintos de null<br>.
     * <b>pre:</b> la coleccion de comandas debe existir<br>.
     * @throws Exception Se lanza excepción si la comanda a cerrar ya esta en estado cerrada.
     * @param comanda Comanda que se cerrara
     * <b>post:</b> Se cerrará la comanda. La mesa de la comanda queda en estado Libre. La lista de comandas tendra un elemento menos<br>.
     */
    public void eliminarComanda(Comanda comanda) throws Exception {
        assert comanda!=null:"ERROR : La comanda no debe ser null";

        if (comanda.getEstado().equalsIgnoreCase("Cerrada"))
            throw new Exception("ERROR : No se puede cerrar una comanda ya cerrada");

        comanda.cerrarComanda();
        comanda.getMesa().liberar();
        this.comandas.remove(comanda);
    }

    /**
     * Elimina un producto determinada
     *
     * <b>pre:</b> la coleccion de operarios debe existir<br>.
     * <b>pre:</b> produto debe ser distinto de null<br>.
     * @param producto producto que se desea eliminar
     * @throws Exception Se lanza excepción si el producto que se desea eliminar esta asiciado a un pedido
     * <b>post:</b> la coleccion de productos tendra un elemento menos<br>.
     */
    public void eliminarProducto (Producto producto) throws Exception {
        for (Comanda comanda : comandas) {
            ArrayList<Pedido> pedidos = comanda.getPedidos();

            for (Pedido pedido : pedidos) {
                if (producto.getIdProducto() == pedido.getProducto().getIdProducto()) {
                    throw new Exception("El producto no se puede eliminar debido a que esta asociado a una comanda");
                }
            }
        }

        this.productos.remove(producto.getIdProducto());
    }

    // MODIFICAR

    /**
     * Modifica la contrasena del administrador
     *
     * <b>pre:</b> el administrador debe existir<br>.
     * @param contrasena nueva contrasena del administrador
     * @throws Exception Se lanza excepción si la constrasena tiene menos de 6 o mas de 12 digitos
     * @throws Exception Se lanza excepción si la constrasena no tiene un digito numerico
     * @throws Exception Se lanza excepción si la constrasena no tiene un digito en mayuscula
     * <b>post:</b> el administrador tendra nueva contrasena<br>.
     */
    public void modificarAdministrador(String contrasena) throws Exception{
        if (contrasena.length() < 6 || contrasena.length() > 12)
            throw new Exception("ERROR : La contraseña debe tener entre 6 y 12 caracteres.");
        if (!contieneDigito(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos un digito.");
        if (!contieneMayuscula(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos una mayuscula.");

        this.administrador.setPassword(contrasena);
    }

    /**
     * Modifica cantidad de sillas de una mesa determinada
     *
     * <b>pre:</b> la mesa debe ser distinto de null<br>.
     * @param mesa mesa a cambiar parametros
     * @param cantidadComensales cantidad de sillas que posee la mesa
     * @throws Exception Se lanza excepción si la cantidad de comensales es menor a 2
     * <b>post:</b> la mesa tendra nuevo numero de sillas<br>.
     */
    public void modificarMesa(Mesa mesa, int cantidadComensales) throws Exception {
        assert mesa!=null:"ERROR : La mesa no puede ser null";
        if (cantidadComensales < 2)
            throw new Exception("ERROR : La cantidad de comensales no puede ser menor a 2");

        mesa.setCantidadComensales(cantidadComensales);
    }

    /**
     * El metodo valida los datos correspondientes para modificar los paramentros de un  Mozo determinado     *
     * @param mozo mozo a modificar
     * @param nombre nombre del mozo
     * @param edad edad del mozo
     * @param hijos cantidad de hijos del mozo
     * @throws Exception Se lanza excepción si Nombre es vacio
     * @throws Exception Se lanza excepción si edad es menor 18
     * @throws Exception Se lanza excepción si cantidad de hijos es menor a cero
     * <b>post:</b> el mozo tendra nuevos valores en sus atributos <br>.
     */
    public void modificarMozo(Mozo mozo,String nombre, int edad, int hijos) throws Exception {
        if (nombre.equals(""))
            throw new Exception("ERROR : Nombre vacio");
        if (hijos < 0)
            throw new Exception("ERROR : Cantidad de hijos debe ser mayo o igual a cero");
        if (edad < 18)
            throw new Exception("ERROR : Es menor de edad");

        mozo.setNombreYApellido(nombre);
        mozo.setEdad(edad);
        mozo.setCantHijos(hijos);
    }

    /**
     * El metodo valida los datos correspondientes para modificar un Operario determinar
     *
     * <b>pre:</b> operario debe ser distinto de null<br>.
     *
     * @param operario operario a modificar
     * @param nombre nombre del operario
     * @param nombreUsuario nombre de usuario del operario
     * @param contrasena constrasena del operario
     * @param activo estado del operario ( activo / inactivo )
     * @throws Exception Se lanza excepción si Nombre es vacio
     * @throws Exception Se lanza excepción si Nombre de Usuario es menor a 5 caracteres o mayor a 10
     * @throws Exception Se lanza excepción si contresena es menor a 5 caracteres o mayor a 10
     * @throws Exception Se lanza excepción si constresena no tiene un digito numerico
     * @throws Exception Se lanza excepción si constrasena no contiene por lo menos una letra mayuscula
     * <b>post:</b> el operario cambiara el valor de sus atributos<br>.
     */
    public void modificarOperario(Operario operario,String nombre, String nombreUsuario, String contrasena, boolean activo ) throws Exception {
        if (nombre.equals(""))
            throw new Exception("ERROR : Nombre vacio.");
        if (nombreUsuario.length() < 5 || nombreUsuario.length() > 10)
            throw new Exception("ERROR : El nombre de Usuario debe tener entre 5 y 10 caracteres.");
        if (contrasena.length() < 6 || contrasena.length() > 12)
            throw new Exception("ERROR : La contraseña debe tener entre 6 y 12 caracteres.");
        if (!contieneDigito(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos un digito.");
        if (!contieneMayuscula(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos una mayuscula.");

        operario.setNombreCompleto(nombre);
        operario.setNombreUsuario(nombreUsuario);
        operario.setContrasena(contrasena);
        operario.setActivo(activo);
    }

    /**
     * El metodo valida los datos para modificar un producto determinado
     *
     * <b>pre:</b>el producto debe ser distinto de null<br>.
     *
     * @param producto producto que se desea modificar
     * @param nombre nombre del producto
     * @param precioCosto precio de costo del producto
     * @param precioVenta precio de venta del producto
     * @param stockInicial stock del producto
     * @throws Exception Se lanza excepción si el precio de venta es menor al precio de costo
     * @throws Exception Se lanza excepción si el precio de costo es menor a cero
     * @throws Exception Se lanza excepción si el precio de venta es menor a cero
     * <b>post:</b> el producto cambiara el valor de sus atributos<br>.
     */
    public void modificarProducto (Producto producto,String nombre, double precioCosto, double precioVenta, int stockInicial) throws Exception {
        if (precioVenta < precioCosto)
            throw new Exception("El precio de venta es menor al de costo");
        if(precioCosto < 0)
            throw new Exception("El precio de costo es menor a cero");
        if(precioVenta < 0)
            throw new Exception("El precio de venta es menor a cero");

        producto.setNombre(nombre);
        producto.setPrecioCosto(precioCosto);
        producto.setPrecioVenta(precioVenta);
        producto.setStockInicial(stockInicial);
    }

    /**
     * El metodo valida los datos para modificar una comanda determinada
     *
     * <b>pre:</b>la comanda debe ser distinto de null<br>.
     * <b>pre:</b>la mesa debe ser distinto de null<br>.
     * <b>pre:</b> los pedidos debe ser distinto de null<br>.
     *
     * @param comanda comanda que se desea modificar
     * @param mesa mesa asiciada a la comanda
     * @param pedidos lista de pedidos de la comanda

     * <b>post:</b> la comanda cambiara el valor de sus atributos<br>.
     */
    public void modificarComanda( Comanda comanda, Mesa mesa, ArrayList<Pedido> pedidos) {
        assert mesa != null : "ERROR : La mesa no debe ser null";
        assert comanda != null : "ERROR : La comanda no debe ser null";
        assert pedidos != null : "ERROR : Pedidos no debe ser null";

        comanda.setMesa(mesa);
        comanda.setPedidos(pedidos);
        mesa.ocupar();
    }

    /**
     * El metodo verifica que haya dos prodcutos en promocion
     *
     * <b>pre:</b>la coleccion depromociones productos  debe ser distinto de null<br>.
     *
     * @return si es verdadero que hay dos productos en promocion
     */
    public boolean hayDosProductosPromocionActiva(){
        return this.promocionesProductos.size() >= 2;
    }

    /**
     * * El metodo crea una lista con los mozos activos a partir de la lista de mozos. Ademas verifica que haya
     *
     * <b>pre:</b> <br>.
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

        for (Mesa mesa : this.mesas) {
            if (mozo >= listaMozosActivos.size())
                mozo = 0;
            this.mesasAsignadas.put(mesa, listaMozosActivos.get(mozo));
            mozo++;
        }
    }

    /**
     * Metodo privado de esta clase que es llamado por asignarMesas. Este genera una lista con los mozos que
     * estan activos.
     * @return ArrayList<Mozo> Lista de mozos activos
     */
    public ArrayList<Mozo> mozosActivos() {
        ArrayList<Mozo> activos = new ArrayList<>();

        for (Mozo mozo : this.mozos) {
            if (mozo.getEstado().equalsIgnoreCase("Activo"))
                activos.add(mozo);
        }
        return activos;
    }


    /**
     * * El metodo finaliza una joranada laboral
     * @throws Exception Se lanza excepción si hay comandas abiertas
     * <b>post:</b> Cada mozo pasa a estado null<br>.
     */
    public void finalizarJornada() throws Exception {
        if (!comandas.isEmpty())
            throw new Exception("Es necesario que cierre todas las comandas abiertas para finalizar la jornada.");

        for (Mozo mozo : mozos) {
            mozo.setEstado(null);
        }

        mesasAsignadas.clear();
    }


    /**
     * prepara las estadisticas de mozos para mostrarlas
     *
     * @return ArrayList<String> devuelve una lista con la estadisticas de los mozos
     */
    public ArrayList<String> mostrarEstadisticasMozos() {
        ArrayList<String> respuesta = new ArrayList<>();

        if (!estadisticasMozos.isEmpty()) {
            Mozo mozoMaximo = estadisticasMozos.keySet().iterator().next();
            Mozo mozoMinimo = estadisticasMozos.keySet().iterator().next();

            for (Map.Entry < Mozo, EstadisticaMozo> entry : estadisticasMozos.entrySet()) {
                if (entry.getValue().getTotalGastado() > estadisticasMozos.get(mozoMaximo).getTotalGastado())
                    mozoMaximo = entry.getKey();
                if (entry.getValue().getTotalGastado() < estadisticasMozos.get(mozoMinimo).getTotalGastado())
                    mozoMinimo = entry.getKey();
            }

            respuesta.add("Mozo con mayor volumen de ventas: '" + mozoMaximo.getNombreYApellido());
            respuesta.add("Mozo con menor volumen de ventas: '" + mozoMinimo.getNombreYApellido() + "' - Cantidad Ventas = " + estadisticasMozos.get(mozoMinimo).getCantidadVentas() + " - Total Facturado= " + estadisticasMozos.get(mozoMinimo).getTotalGastado());
        }

        return respuesta;
    }


    /**
     * prepara las estadisticas de mesas para mostrarlas
     *
     * @return ArrayList<String> devuelve una lista con la estadisticas de los mesas
     */
    public ArrayList<String> mostrarEstadisticasMesas() {
        ArrayList<String> respuesta = new ArrayList<>();

        for (Map.Entry<Mesa,EstadisticaMesa> entry : estadisticasMesas.entrySet()) {
            int cantidadVentas = entry.getValue().getCantidadVentas();

            String renglon = "Mesa : " + entry.getKey() + " |  Promedio Ventas : " + (cantidadVentas == 0 ? "0" : entry.getValue().getTotalGastado() / cantidadVentas);
            respuesta.add(renglon);
        }

        return respuesta;
    }
}