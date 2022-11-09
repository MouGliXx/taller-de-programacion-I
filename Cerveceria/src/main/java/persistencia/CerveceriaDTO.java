package persistencia;

import modelo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CerveceriaDTO implements Serializable {
    private String nombreDelLocal;
    private double remuneracionBasica;
    private Administrador administrador;
    private ArrayList<Operario> operarios = new ArrayList<>();
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private HashMap<Integer, Producto> productos = new HashMap<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Comanda> comandas = new ArrayList<>();
    private ArrayList<Factura> facturas = new ArrayList<>();
    private ArrayList<PromocionProducto> promocionesProductos = new ArrayList<>();
    private ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<>();
    private HashMap<Mesa,Mozo> mesasAsignadas = new HashMap<>();
    private HashMap<Mozo, EstadisticaMozo> estadisticasMozos = new HashMap<>();
    private HashMap<Mesa, EstadisticaMesa> estadisticasMesas = new HashMap<>();

    public String getNombreDelLocal() {
        return nombreDelLocal;
    }

    public double getRemuneracionBasica() {
        return remuneracionBasica;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public ArrayList<Operario> getOperarios() {
        return operarios;
    }

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public HashMap<Integer, Producto> getProductos() {
        return productos;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public ArrayList<Comanda> getComandas() {
        return comandas;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public ArrayList<PromocionProducto> getPromocionesProductos() {
        return promocionesProductos;
    }

    public ArrayList<PromocionTemporal> getPromocionesTemporales() {
        return promocionesTemporales;
    }

    public HashMap<Mesa, Mozo> getMesasAsignadas() {
        return mesasAsignadas;
    }

    public HashMap<Mozo, EstadisticaMozo> getEstadisticasMozos() {
        return estadisticasMozos;
    }

    public HashMap<Mesa, EstadisticaMesa> getEstadisticasMesas() {
        return estadisticasMesas;
    }

    public void setNombreDelLocal(String nombreDelLocal) {
        this.nombreDelLocal = nombreDelLocal;
    }

    public void setRemuneracionBasica(double remuneracionBasica) {
        this.remuneracionBasica = remuneracionBasica;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setOperarios(ArrayList<Operario> operarios) {
        this.operarios = operarios;
    }

    public void setMozos(ArrayList<Mozo> mozos) {
        this.mozos = mozos;
    }

    public void setProductos(HashMap<Integer, Producto> productos) {
        this.productos = productos;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public void setComandas(ArrayList<Comanda> comandas) {
        this.comandas = comandas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public void setPromocionesProductos(ArrayList<PromocionProducto> promocionesProductos) {
        this.promocionesProductos = promocionesProductos;
    }

    public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales) {
        this.promocionesTemporales = promocionesTemporales;
    }

    public void setMesasAsignadas(HashMap<Mesa, Mozo> mesasAsignadas) {
        this.mesasAsignadas = mesasAsignadas;
    }

    public void setEstadisticasMozos(HashMap<Mozo, EstadisticaMozo> estadisticasMozos) {
        this.estadisticasMozos = estadisticasMozos;
    }

    public void setEstadisticasMesas(HashMap<Mesa, EstadisticaMesa> estadisticasMesas) {
        this.estadisticasMesas = estadisticasMesas;
    }
}
