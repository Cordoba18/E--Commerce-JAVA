package controlador;

/*
 * Se_importa_el_paquete_de_sql_para_hacer_uso_de
 * sentencias_sql_junto_a_la_vista_estadisticas
 */

import modelo.Productos;
import sql.Consultas;
import vista.Estadisticas;

public class EstadisticasController {
	
	/*
	 * Se_hace_instancias_del_algunas_clases_que_seran_necesarias
	 * para_poder_controlar_la_vista_a_cargo_de_este_controlador
	 */
	Estadisticas e;
	Consultas consulta = new Consultas();
	Productos producto = new Productos();

	/*
	 * Se_crea_el_constructor_de_esta_clase_ya_que_sera_el_encargado_de_recibir
	 * un_parametro_de_tipo_vista_en_cual_mediante_dicho_parametro_podremos
	 * utilizar_sus_componentes_como_lo_de_enviar_toda_la_funcionalidad_o
	 * logica_a_dicha_vista
	 */

	public EstadisticasController(Estadisticas e) {
	
	/*
	 * Se_almacena_la_vista_en_una_variable_que_solo_sera_usada_en_esta
	 * clase_y_que_se_podra_llamar_al_momento_de_querer_utilizar_un
	 * componente_de_la_vista_al_cual_se_le_quiera_asignar_una_funcionalidad
	 */
	
		this.e=e;
	
	/*
	 * Se_llama_el_siguiente_metodo_el_cual_contiene_sentencias_de_sql
	 * las_cuales_tienen_como_funcion_mostrar_distintos_datos_obtenidos_en
	 * distintas_tablas_y_siempre_mostraran_dichos_datos_porque_al_estar
	 * en_el_constructor_simpre_iniciara_con_las_funciones_indicadas
	 */
	
		CargarTablas();
	}

	/*
	 * Este_metodo_contiene_unas_consultas_las_cuales_son
	 * para_mostrar_los_registros_obtenidos_de_la_base_de_datos
	 * y_mostrarlos_en_las_distintas_tablas_indicadas
	 */	

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
