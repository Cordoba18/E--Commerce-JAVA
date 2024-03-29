package controlador;

import java.awt.event.*;
import javax.swing.*;
/*
 * Se_importan_distintos_paquetes_para 
 * hacer_uso_de_algunas_clases_que_contienen
 */
import modelo.Productos;
import vista.*;
import herramientas.*;
import sql.*;

//Aqui_implemento_unos_escuchadores_para_algunos_componentes_de_la_vista_pdNuevos
public class PdnuevosController implements ActionListener{
	
	
	/*
	 * Hago_instancias_de_distintas_clases_y_de_dos_vistas_para_hacer_uso
	 * de_ellas_en_el_PdnuevosController
	 */
	
	Vpdnuevos vpdnuevos;
	Productos pd = new Productos();
	Consultas consultar = new Consultas();
	Validaciones validar = new Validaciones();
	Administrador a;
	
	/*
	 * Se_crea_un_constructor_el_cual_sera_el_encargado_de_recibir_dos_parametros
	 * que_seran_de_tipo_vista_uno_sera_la_vista_que_controlara_este_controlador
	 * que_sera_la_vista_pdAntiguos_y_el_otro_parametro_es_para_la_vista_administrador
	 */
	
	public PdnuevosController(Vpdnuevos vpdnuevos, Administrador a) {
		
		/*
		 *  Aqui_almaceno_los_dos_parametros_recibidos_mediante_el_contructor
		 *  en_dos_variables_privadas_que_solo_se_podran_usar_en_este_controlador_y
		 *  las_cuales_contendran_las_vistas
		 */
		
		this.vpdnuevos = vpdnuevos;
		this.a = a;
		
		/*
		 * En_este_apartado_estan_los_componentes_que_llevan_el_this_para
		 * poder_ser_escuchados_y_utilizados_en_la_vista
		 */
		
		this.vpdnuevos.btnEditar.addActionListener(this);
		this.vpdnuevos.btnEliminar.addActionListener(this);
		this.vpdnuevos.btnCancelar.addActionListener(this);
				
		/*
		 * Se_llaman_los_siguientes_metodos_los_cuales_estan_al_inicio
		 * porque_dentro_de_ellos_tienen_un_bloque_de_codigo_que_se
		 * debe_ejecutar_al_iniciar_este_controlador
		 */
		
		eventos();
		InfoTbala();
		buscadorN();
	}
	
	/*
	 * Metodo_el_cual_contiene_la_tabla_de_la_vista_de_productosNuevos
	 * y_contiene_la_funcionalidad_de_seleccionar_un_registro_de_la_jtable
	 * y_almacenar_los_datos_en_el_modelo
	 * 
	 * Tambien_se_encuentran_los_botones_de_editar_eliminar_y_cancelar
	 * con_la_funcion_de_colocarse_en_visible_cuando_se_seleccione
	 * un_registro_en_la_jtable
	 */
	
	public void eventos() {
		
			vpdnuevos.tblPdnuevos.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			if(e.getSource().equals(vpdnuevos.tblPdnuevos)) {
				vpdnuevos.btnEditar.setVisible(true);
				vpdnuevos.btnEliminar.setVisible(true);
				vpdnuevos.btnCancelar.setVisible(true);
			}
			
			/*
			 * Esta_parte_de_codigo_es_para_seleccionar_un_registro_y
			 * almacenarlo_mediante_el_modelo_para_despues_poderlo
			 * editar_en_el_jpanel_EdProductos
			 */
			
				int row = vpdnuevos.tblPdnuevos.getSelectedRow();
				pd.setId((Integer.parseInt(vpdnuevos.tblPdnuevos.getValueAt(row, 0).toString())));
				String nombre = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 1).toString();
				pd.setNombre(nombre);
				String precio = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 2).toString();
				pd.setPrecio(Integer.parseInt(precio));
				String descuento = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 3).toString();
				pd.setDescuento(Integer.parseInt(descuento));
				String descripcion = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 4).toString();
				pd.setDescripcion(descripcion);
				String estado = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 7).toString();
				pd.setEstado(String.valueOf(estado));
	
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * Boton_editar_que_se_encarga_de_traer_el_jpanel_EdProductos
		 * para_poder_cambiar_de_jpanel_y_poder_enviar_los_datos_del
		 * registro_a_dicho_jpanel
		 */
		
			if(e.getSource().equals(vpdnuevos.btnEditar)) {
					/*
					 *  Se_hace_instancia_de_la_vista_EdProductos_para_poder_cambiar_de_jpanel
					 *  ademas_se_hace_la_instacia_dentro_del_boton_editar_volviendose_de_manera
					 *  local_porque_solo_sera_usada_en_esta_parte_del_codigo
					 */
					
					EditarProductos ed = new EditarProductos();
					
					/*
					 * Se_hace_instacia_del_controlador_de_EdProductos_para_que_el_jpanel_se
					 * pueda_cambiar_como_tambien_se_pueda_utilizar_ya_que_el_constructor_de
					 * dicho_jpanel_solicita_ciertos_parametros_para_su_funcionamiento
					 */
					
					new EdProductosController(ed, pd,a);
					
					/*
					 * Esto_es_una_ayuda_la_cual_esta_encargada_de_colocar_los_datos_del_registro
					 * seleccionados_en_el_jpanel_mencionado_anteriormente_esta_ayuda_se_crea
					 * con_el_fin_de_no_tener_que_hacer_todo_ese_procedimiento_de_colocar_los
					 * datos_en_los_campos_indicados_en_este_controlador
					 * 
					 * en_vez_de_eso_que_una_ayuda_externa_contenga_eso_y_asi_obtener_un_codigo
					 * más_organizado
					 */
					
					Ayudas.ActualizarPanel(ed, a.panelPrincipal);
			}else {
				/*
				 * El_boton_eliminar_estara_encargado_de_la_desactivacion_de_un_producto
				 * en_la_base_de_datos_solo_cambiara_el_estado_del_producto_más_no_lo
				 * elimina_como_tal
				 */
				if(e.getSource().equals(vpdnuevos.btnEliminar)) {	
					/*
					 * Aqui_se_llama_la_una_consulta_que_tendra_la_sentencia_sql_encargada
					 * del_cambio_de_estado_del_producto_junto_con_un_JOptionPane_el_cual
					 * indicara_con_un_mensaje_que_se_desactivo_el_registro
					 * 
					 * Tambien_se_encuentra_la_consulta_de_monitorias_la_cual_esta_encargada
					 * de_guardar_un_registro_en_la_base_de_datos_de_que_administrador
					 * desactiva_un_producto,_por_eso_el_nombre_de_monitorias
					 */
					consultar.eliminarProducto(pd);
					consultar.EliminarCarritos(String.valueOf(pd.getId()));
					consultar.EliminarListasDeseos(String.valueOf(pd.getId()));
					consultar.Monitorias(a.lbl_IdUser.getText(), "11", pd.getNombre());
					JOptionPane.showMessageDialog(vpdnuevos, "SE DESACTIVO EL REGISTRO");
					vpdnuevos.btnCancelar.setVisible(false);
					vpdnuevos.btnEditar.setVisible(false);
					vpdnuevos.btnEliminar.setVisible(false);
				}else {
					/*
					 * En_esta_parte_esta_solo_el_boton_cancelar_cuya_funcion_solo_sera
					 * la_de_colocar_el_estado_de_visible_a_false_osea_invisible_si_el
					 * registro_seleccionado_anteriormente_no_se_quiere_ni_editar_ni_eliminar
					 */
					if(e.getSource().equals(vpdnuevos.btnCancelar)) {
						vpdnuevos.btnCancelar.setVisible(false);
						vpdnuevos.btnEditar.setVisible(false);
						vpdnuevos.btnEliminar.setVisible(false);
					}
				}
			}
			/* 
			 * llamo_una_funcion_la_cual_se_encarga_de_mostrar_los_registros_obtenidos_de_la
			 * base_de_datos_en_la_tabla 
			 */
			InfoTbala();
	}
	/*
	 * Este_metodo_contiene_una_consulta_la_cual_es_para_mostrar_los_registros_obtenidos
	 * de_la_base_de_datos_y_mostrarlos_solo_en_la_jtable_de_pdAntiguos
	 */	 
	public void InfoTbala() {
		try {
			/*
			 * Consulta_para_mostrar_los_registros_en_la_tabla_pdNuevos
			 * indicando_que_porcentaje_de_registros_se_desea_mostrar
			 */
			consultar.mostrarpdNuevos(vpdnuevos.tblPdnuevos, 0.6);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("La consulta fallo al mostrar los datos" + e);
		}
	}
	
	/*
	 * Esta_parte_del_codigo_es_para_el_textBuscar_el_cual_esta_dentro_de_una
	 * metodo_llamado_buscarinfo_donde_se_buscara_un_producto_mediante_una
	 * referencia_que_este_en_la_BD
	 */
	public void buscarinfo(String buscar) {
		
		/*
		 * Aqui_comienzan_las_validaciones_para_el_textBuscar_restringiendo_algunos
		 * elementos_a_la_hora_de_buscar
		 */
		
		/*
		 * La_primera_validacion_es_la_de_campo_vacio_para_que_no_se_pueda_buscar
		 * en_el_textBuscar, _junto_a_un_JOptionPane_con_un_mensaje_que_indica_que
		 * se_desactivo_el_registro
		 */
		if(Validaciones.vacio(buscar)) {
			InfoTbala(); 
			vpdnuevos.lblError.setText("No se puede buscar 'CAMPO VACIO'");
			vpdnuevos.textBuscarPdNuevos.setText("");
			vpdnuevos.lblError.setVisible(true);
		}else 
			
			/*
			 * La_segunda_validacion_es_para_que_solo_los_parametros_ingresados_en
			 * el_textBuscar_sean_de_tipo_letra_no_numericos_o_caracteres_especiales
			 */
			if(Validaciones.SoloLetras(buscar)) {
				vpdnuevos.lblError.setText("No permitido este tipo de caracteres");
				vpdnuevos.textBuscarPdNuevos.setText("");
				vpdnuevos.lblError.setVisible(true);
		}else 
			
			/*
			 * La_tercera_validacion_es_que_no_permite_espacios_en_blanco_al_inicio
			 */
			if(buscar.isBlank()) {
				vpdnuevos.lblError.setText("No permitido espacios en blanco");
				vpdnuevos.textBuscarPdNuevos.setText("");
				vpdnuevos.lblError.setVisible(true);
		}else {
			//si_no_fueron_necesarias_las_validaciones_entonces_procedera_a_buscar
			vpdnuevos.lblError.setVisible(false);
			consultar.buscarpdNuevos(vpdnuevos.tblPdnuevos, buscar, 0.6);
		}
	}
	
	// Metodo_donde_se_agrega_un_KeyListener_al_textBuscarPdNuevos
	public void buscadorN() {
		vpdnuevos.textBuscarPdNuevos.addKeyListener(new KeyAdapter() {
			@Override
			// Realizara_una_búsqueda_al_soltar_una_tecla_en_el_campo_de_textBuscarPdNuevos
			public void keyReleased(KeyEvent e) {
				buscarinfo(vpdnuevos.textBuscarPdNuevos.getText());
			}
			@Override
			/*
			 *  Si_el_campo_de_textBuscarPdNuevos_está_vacío,mostrara_los_registros_que_ya
			 *  tenia_la_tabla_al_inicio
			 */
			
			public void keyTyped(KeyEvent e) {
				if(vpdnuevos.textBuscarPdNuevos.getText().isEmpty()) {
					InfoTbala();
				}
			}
		});
	}
}
