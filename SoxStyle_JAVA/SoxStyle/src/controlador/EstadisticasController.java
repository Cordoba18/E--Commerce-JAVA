package controlador;

import modelo.Productos;
import sql.Consultas;
import vista.Estadisticas;

public class EstadisticasController {

    Estadisticas e; // Referencia_a_la_vista_de_estadísticas
    Consultas consulta = new Consultas(); // Objeto_para_realizar_consultas_a_la_base_de_datos
    Productos producto = new Productos(); // Objeto_para_manejar_datos_de_productos

    public EstadisticasController(Estadisticas e) {
        this.e = e; // Inicialización_de_la_referencia_a_la_vista_de_estadísticas
        CargarTablas(); // Método_para_cargar_los_datos_en_las_tablas_de_estadísticas
    }

    public void CargarTablas() {
        // Cargar_los_productos_más_vendidos_en_la_tabla_de_la_vista
        consulta.CargarProductosVendidos(e.tblProductosMasVendidos, "mas");

        // Cargar_los_productos_menos_vendidos_en_la_tabla_de_la_vista
        consulta.CargarProductosVendidos(e.tblPruductosMenosVendidos, "menos");

        // Cargar_los_usuarios_ingresados_en_el_día_en_la_tabla_de_la_vista
        consulta.CargarMonitorias(e.tblUsuariosIngresadosDia, "15");

        // Cargar_todas_las_monitorias_en_la_tabla_de_la_vista
        consulta.CargarMonitorias(e.tabla_monitorias, "");

        // Contar_el_total_de_productos_registrados_y_mostrarlo_en_la_etiqueta_de_la_vista
        consulta.ContarUsuariosProductos(producto, "productos");
        e.lblTotalProductos.setText(String.valueOf(producto.getCantidad()));

        // Contar_el_total_de_usuarios_registrados_y_mostrarlo_en_la_etiqueta_de_la_vista
        consulta.ContarUsuariosProductos(producto, "Users");
        e.lblTotalUsuarioRegistrados.setText(String.valueOf(producto.getCantidad()));
    }
}
