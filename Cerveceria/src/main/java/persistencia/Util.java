package persistencia;

import modelo.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Util {
    public static CerveceriaDTO cerveceriaDTOFromCerveceria(Cerveceria cerveceria){
        CerveceriaDTO respuesta = new CerveceriaDTO();
        String nombreDelLocal;
        double remuneracionBasica;
        Administrador administrador;
        ArrayList<Operario> operarios = new ArrayList<>();
        ArrayList<Mozo> mozos = new ArrayList<>();
        HashMap<Integer, Producto> productos = new HashMap<>();
        ArrayList<Mesa> mesas = new ArrayList<>();
        ArrayList<Comanda> comandas = new ArrayList<>();
        ArrayList<Factura> facturas = new ArrayList<>();
        ArrayList<PromocionProducto> promocionesProductos = new ArrayList<>();
        ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<>();
        HashMap<Mesa,Mozo> mesasAsignadas = new HashMap<>();
        HashMap<Mozo, EstadisticaMozo> estadisticasMozos = new HashMap<>();
        HashMap<Mesa, EstadisticaMesa> estadisticasMesas = new HashMap<>();

        estadisticasMesas.putAll(cerveceria.getEstadisticasMesas());
        estadisticasMozos.putAll(cerveceria.getEstadisticasMozos());
        mesasAsignadas.putAll(cerveceria.getMesasAsignadas());
        promocionesTemporales.addAll(cerveceria.getPromocionesTemporales());
        promocionesProductos.addAll(cerveceria.getPromocionesProductos());
        facturas.addAll(cerveceria.getFacturas());
        comandas.addAll(cerveceria.getComandas());
        mesas.addAll(cerveceria.getMesas());
        productos.putAll(cerveceria.getProductos());
        mozos.addAll(cerveceria.getMozos());
        operarios.addAll(cerveceria.getOperarios());
        administrador = cerveceria.getAdministrador();
        remuneracionBasica = cerveceria.getRemuneracionBasica();
        nombreDelLocal = cerveceria.getNombreDelLocal();

        respuesta.setNombreDelLocal(nombreDelLocal);
        respuesta.setRemuneracionBasica(remuneracionBasica);
        respuesta.setAdministrador(administrador);
        respuesta.setOperarios(operarios);
        respuesta.setMozos(mozos);
        respuesta.setProductos(productos);
        respuesta.setMesas(mesas);
        respuesta.setComandas(comandas);
        respuesta.setFacturas(facturas);
        respuesta.setPromocionesProductos(promocionesProductos);
        respuesta.setPromocionesTemporales(promocionesTemporales);
        respuesta.setMesasAsignadas(mesasAsignadas);
        respuesta.setEstadisticasMozos(estadisticasMozos);
        respuesta.setEstadisticasMesas(estadisticasMesas);

        return respuesta;
    }

    public static void cerveceriaFromCerveceriaDTO(CerveceriaDTO cerveceriaDTO) throws Exception {
        String nombreDelLocal;
        double remuneracionBasica;
        Administrador administrador;
        ArrayList<Operario> operarios = new ArrayList<>();
        ArrayList<Mozo> mozos = new ArrayList<>();
        HashMap<Integer, Producto> productos = new HashMap<>();
        ArrayList<Mesa> mesas = new ArrayList<>();
        ArrayList<Comanda> comandas = new ArrayList<>();
        ArrayList<Factura> facturas = new ArrayList<>();
        ArrayList<PromocionProducto> promocionesProductos = new ArrayList<>();
        ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<>();
        HashMap<Mesa,Mozo> mesasAsignadas = new HashMap<>();
        HashMap<Mozo, EstadisticaMozo> estadisticasMozos = new HashMap<>();
        HashMap<Mesa, EstadisticaMesa> estadisticasMesas = new HashMap<>();

        estadisticasMesas.putAll(cerveceriaDTO.getEstadisticasMesas());
        estadisticasMozos.putAll(cerveceriaDTO.getEstadisticasMozos());
        mesasAsignadas.putAll(cerveceriaDTO.getMesasAsignadas());
        promocionesTemporales.addAll(cerveceriaDTO.getPromocionesTemporales());
        promocionesProductos.addAll(cerveceriaDTO.getPromocionesProductos());
        facturas.addAll(cerveceriaDTO.getFacturas());
        comandas.addAll(cerveceriaDTO.getComandas());
        mesas.addAll(cerveceriaDTO.getMesas());
        productos.putAll(cerveceriaDTO.getProductos());
        mozos.addAll(cerveceriaDTO.getMozos());
        operarios.addAll(cerveceriaDTO.getOperarios());
        administrador = cerveceriaDTO.getAdministrador();
        remuneracionBasica = cerveceriaDTO.getRemuneracionBasica();
        nombreDelLocal = cerveceriaDTO.getNombreDelLocal();

        Cerveceria.getInstance().setNombreDelLocal(nombreDelLocal);
        Cerveceria.getInstance().setRemuneracionBasica(remuneracionBasica);
        Cerveceria.getInstance().setAdministrador(administrador);
        Cerveceria.getInstance().setOperarios(operarios);
        Cerveceria.getInstance().setMozos(mozos);
        Cerveceria.getInstance().setProductos(productos);
        Cerveceria.getInstance().setMesas(mesas);
        Cerveceria.getInstance().setComandas(comandas);
        Cerveceria.getInstance().setFacturas(facturas);
        Cerveceria.getInstance().setPromocionesProductos(promocionesProductos);
        Cerveceria.getInstance().setPromocionesTemporales(promocionesTemporales);
        Cerveceria.getInstance().setMesasAsignadas(mesasAsignadas);
        Cerveceria.getInstance().setEstadisticasMozos(estadisticasMozos);
        Cerveceria.getInstance().setEstadisticasMesas(estadisticasMesas);
    }
}