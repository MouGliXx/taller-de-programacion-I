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
    public Administrador login(String password) throws ErrorDeContrasenaException {
        if (password.equalsIgnoreCase(administrador.getPassword())) {
            return this.administrador;
        }

        throw new ErrorDeContrasenaException("Contrasena invalida: " + password);
    }

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

    //AGREGAR
    /**
     * <b>pre:</b> La lista de mesas debe existir <br>.
     * @throws Exception Se lanza excepción si supera el numero maximo de mesas permitidas
     * <b>post:</b> Se agregara una mesa a la lista de mesas <br>.
     */
    public void agregarMesa(int cantidadComensales) throws Exception{
        if (this.mesas.size() >= totalMaximoMesas)
            throw new Exception("ERROR : No se pueden dar de alta mas mesas. LLego al nro maximo");
        Mesa mesa = new Mesa(cantidadComensales);
        this.mesas.add(mesa);
        this.estadisticasMesas.put(mesa,new EstadisticaMesa());
    }

    public void agregarPromocionProducto(PromocionProducto promocionProducto, ArrayList<String> diasPromocion, boolean activa, Producto producto, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario){
        promocionProducto.setDiasPromocion(diasPromocion);
        promocionProducto.setActiva(activa);
        promocionProducto.setProducto(producto);
        promocionProducto.setAplicaDosPorUno(aplicaDosPorUno);
        promocionProducto.setAplicaDtoPorCantidad(aplicaDtoPorCantidad);
        promocionProducto.setDtoPorCantidad_CantMinima(dtoPorCantidad_CantMinima);
        promocionProducto.setDtoPorCantidad_PrecioUnitario(dtoPorCantidad_PrecioUnitario);

        this.promocionesProductos.add(promocionProducto);
    }

    public void agregarPromocionProducto(PromocionProducto promocionProducto, ArrayList<String> diasPromocion, boolean activa, Producto producto, boolean aplicaDosPorUno, boolean aplicaDtoPorCantidad){
        promocionProducto.setDiasPromocion(diasPromocion);
        promocionProducto.setActiva(activa);
        promocionProducto.setProducto(producto);
        promocionProducto.setAplicaDosPorUno(aplicaDosPorUno);
        promocionProducto.setAplicaDtoPorCantidad(aplicaDtoPorCantidad);

        this.promocionesProductos.add(promocionProducto);
    }

    public void agregarPromocionTemporal(PromocionTemporal promocionTemporal, ArrayList<String> diasPromocion, boolean activa, String nombre, String formaDePago, int porcentajeDescuento, boolean esAcumulable){
        promocionTemporal.setDiasPromocion(diasPromocion);
        promocionTemporal.setActiva(activa);
        promocionTemporal.setNombre(nombre);
        promocionTemporal.setFormaDePago(formaDePago);
        promocionTemporal.setPorcentajeDescuento(porcentajeDescuento);
        promocionTemporal.setEsAcumulable(esAcumulable);

        this.promocionesTemporales.add(promocionTemporal);
    }

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
     * <b>pre:</b> <br>.
     * El metodo crea añade una nueva factura a la lista de Facturas
     * @throws Exception Se lanza excepción si la comanda es null
     * <b>post:</b> La lista de facturas tendra una nueva<br>.
     */
    public void agregarFactura(Factura factura) throws Exception {
        if (factura == null)
            throw new Exception("ERROR : No se puede crear factura sin comanda");
        this.facturas.add(factura);
        agregaNuevaEstadistica(factura);
    }

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

    public void eliminarPromocionTemporal(PromocionTemporal promo){
        assert promo!=null:"ERROR : La promocion no puede ser null";
        this.promocionesTemporales.remove(promo);
    }

    public void eliminarPromocionProducto(PromocionProducto promo){
        assert promo!=null:"ERROR : La promocion no puede ser null";
        this.promocionesProductos.remove(promo);
    }

    public void eliminarOperario (Operario operario){
        assert operario!=null:"ERROR : El operario no puede ser null";
        this.operarios.remove(operario);
    }

    /**
     * <b>pre:</b> comanda deben ser distintos de null<br>.
     * @throws Exception Se lanza excepción si la comanda a cerrar ya esta en estado cerrada.
     * @param comanda Comanda que se cerrara
     * <b>post:</b> Se cerrará la comanda. La mesa de la comanda queda en estado Libre. Se creará la factura de la comanda a cerrar. Y se removera la comanda de la lista de comandas<br>.
     */
    public void eliminarComanda(Comanda comanda) throws Exception {
        assert comanda!=null:"ERROR : La comanda no debe ser null";

        if (comanda.getEstado().equalsIgnoreCase("Cerrada"))
            throw new Exception("ERROR : No se puede cerrar una comanda ya cerrada");

        comanda.cerrarComanda();
        comanda.getMesa().liberar();
        this.comandas.remove(comanda);
    }

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
    public void modificarAdministrador(String contrasena) throws Exception{
        if (contrasena.length() < 6 || contrasena.length() > 12)
            throw new Exception("ERROR : La contraseña debe tener entre 6 y 12 caracteres.");
        if (!contieneDigito(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos un digito.");
        if (!contieneMayuscula(contrasena))
            throw new Exception("ERROR : La contraseña debe contener al menos una mayuscula.");

        this.administrador.setPassword(contrasena);
    }

    public void modificarMesa(Mesa mesa, int cantidadComensales) throws Exception {
        assert mesa!=null:"ERROR : La mesa no puede ser null";
        if (cantidadComensales < 2)
            throw new Exception("ERROR : La cantidad de comensales no puede ser menor a 2");

        mesa.setCantidadComensales(cantidadComensales);
    }

    public void modificarMozo(Mozo mozo,String nombre, int edad, int hijos) throws Exception {
        if (nombre.equals(""))
            throw new Exception("ERROR : Nombre vacio");
        if (hijos < 0)
            throw new Exception("ERROR : Cantidad de hijos debe ser mayo o igual a cero");

        mozo.setNombreYApellido(nombre);
        mozo.setEdad(edad);
        mozo.setCantHijos(hijos);
    }

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

    public void modificarComanda( Comanda comanda, Mesa mesa, ArrayList<Pedido> pedidos) {
        assert mesa != null : "ERROR : La mesa no debe ser null";
        assert comanda != null : "ERROR : La comanda no debe ser null";
        assert pedidos != null : "ERROR : Pedidos no debe ser null";

        comanda.setMesa(mesa);
        comanda.setPedidos(pedidos);
        mesa.ocupar();
    }

    public boolean hayDosProductosPromocionActiva(){
        return this.promocionesProductos.size() >= 2;
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

    public void finalizarJornada() throws Exception {
        if (!comandas.isEmpty())
            throw new Exception("Es necesario que cierre todas las comandas abiertas para finalizar la jornada.");

        for (Mozo mozo : mozos) {
            mozo.setEstado(null);
        }

        mesasAsignadas.clear();
    }

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

            respuesta.add("Mozo con mayor volumen de ventas: '" + mozoMaximo.getNombreYApellido() + "' - Cantidad Ventas = " + estadisticasMozos.get(mozoMaximo).getCantidadVentas() + " - Total Facturado= " + estadisticasMozos.get(mozoMaximo).getTotalGastado());
            respuesta.add("Mozo con menor volumen de ventas: '" + mozoMinimo.getNombreYApellido() + "' - Cantidad Ventas = " + estadisticasMozos.get(mozoMinimo).getCantidadVentas() + " - Total Facturado= " + estadisticasMozos.get(mozoMinimo).getTotalGastado());
        }

        return respuesta;
    }

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