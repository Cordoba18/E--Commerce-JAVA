package controlador;

// En_esta_primera_parte_de_hace_la_importacion_de_las_librerias_necesarias_para_desarrollar_el_Slider_en_su_totalidad
// Primero_tenemos_las_librerias_para_poder_escuchar_las_acciones_de_la_vista_(Slider)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//En_esta_parte_se_encuentra_las_importaciones_de_otras_clases_necesarias_para_desarrollar_el_slider
import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.MdlSlider;
import sql.Consultas;
import vista.Administrador;
import vista.Slider;


public class SliderController implements MouseListener, KeyListener, ActionListener{
	
	Slider vslider;
	boolean editar = false;
	String FinFormato;
	Path Origen = null;
	
//En_esta_parte_se_intancian_las_clase_(_Consultas)_y_el_modelo_(MdlSlider)_para_poder_usar_sus_atrivutos_desde_esta_clase
	Consultas consulta = new Consultas();
	MdlSlider model_s = new MdlSlider();
	Administrador a;
	
// En_esta_parte_se_declara_y_se_agregan_los_escuchadores_a_los_botones, cuadros_de_texto,_labels_y_la_tabla
// Todo_esto_para_pode_escuchar/detectar_lo_que_hace_cada_elemento_de_la_vista
// Tambien_se_llama_el_metodo_(CargarTablaSlider)_para_poder_mostrar_los_datos_de_cada_slider_que_hay_en_el_momento
	
	public SliderController(Slider vslider, Administrador a) {
		this.vslider = vslider;
		this.a=a;
		this.vslider.btnActivar.addActionListener(this);
		this.vslider.btnCancelar.addActionListener(this);
		this.vslider.txtArea.addKeyListener(this);
		this.vslider.txtNombre.addKeyListener(this);
		this.vslider.btnAgregarImagen.addActionListener(this);
		this.vslider.TablaSlider.addMouseListener(this);
		this.vslider.btnGuardar.addActionListener(this);
		CargarTablaSlider();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
//Este_primer bloque_del actionPerformed se_usa para_que cuando_el administrador_le de_al boton_cancelar_deje_los_campos_en_vacio,
//el_boton_editar_lo_ponga_en_estado_(false)_o_sea_que_lo_oculte,_tambien_oculte el boton_"Activar_", el_"Cancelar_"
// y_pone_el_nombre_del_boton_como_"CREAR SLIDER"_y_por_ultimo,_el_boton_"btnAgregarImagen"_lo_pone_en_visible.
		
		if(e.getSource().equals(vslider.btnCancelar)) {
			vslider.txtNombre.setText("");
			vslider.txtArea.setText("");
			editar = false;
			vslider.btnCancelar.setVisible(false);
			vslider.btnActivar.setVisible(false);
			vslider.lblTitulo.setText("CREAR SLIDER");
			vslider.btnAgregarImagen.setVisible(true);
			Origen = null;
		}
		
// En_este_segundo_bloque_cuando_el_administrador_le_da_al_boton_"_Activar_"_pone_los_campos_txtNombre,_txtArea,_en_vacio, 
// los_botones_btnCrear,_btnActivar,_los_pone_en_false_o_sea_los_oculta. 
// manda_a_la_tabla_monitorias_el_id_del_ususario,_el_numero_de_accion_que_hizo_y_el_nombre_del_slider_que_activo. 
// por_ultimo_pone_el_boton_"AgregarImagen"_en_visible_y_recarga_la_tabla_de_sliders.

		if(e.getSource().equals(vslider.btnActivar)) {
				consulta.EliminarSlider(model_s);
				consulta.Monitorias(a.lbl_IdUser.getText(), "25", model_s.getNombre());
				vslider.txtNombre.setText("");
				vslider.txtArea.setText("");
				editar = false;
				vslider.btnCancelar.setVisible(false);
				vslider.btnActivar.setVisible(false);
				vslider.lblTitulo.setText("CREAR SLIDER");
				vslider.btnAgregarImagen.setVisible(true);
				Origen = null;
				CargarTablaSlider();
		}
//En_este_bloque_se_escucha_la accion_del_boton_aregar_imagen,_la_cual_es_la_que_se_manda_al_servidor_y_se_muestra_en_la_web
//,_primero_instanciando_las_clases_JFileChooser_y_File.
// si_el_formato_de_la_imagen_es_diferente_a_._png,_._jpg_o_jpeg
		
		if(e.getSource().equals(vslider.btnAgregarImagen)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(null);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
				int formato = archivo.getName().length() - 4;
				FinFormato = archivo.getName().toString().substring(formato);
				if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")&&!FinFormato.equals("jpeg")) {
					
					JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER png,jpeg o jpg");
				}else {
					if(FinFormato.equals("jpeg")) {
						FinFormato = "."+ FinFormato;
					}
					String Orig = archivo.getPath();
					Origen = Paths.get(Orig);
					
					vslider.btnAgregarImagen.setVisible(false);
					vslider.lblImagen.setText(String.valueOf(Origen));
			
				}
			}
		}
		
//En_este_bloque_se_escucha_la_accion_del_boton"_Guardar_",_que_al_darle_al_boton_le_setea_al_modelo_el_texto_que_toma_del_"_txtnombre_"_y_"_txtarea_
//Se_valida_que_los_acapos_no_puedan_estar_vacios

		if(e.getSource().equals(vslider.btnGuardar)) {
			
			model_s.setNombre(vslider.txtNombre.getText());
			model_s.setInfo(vslider.txtArea.getText());
			if(Validaciones.vacio(model_s.getNombre())) {
				vslider.lblerrorN. setVisible(true);
				vslider.lblerrorN.setText("Rellene el campo nombre");
			}
			if(Validaciones.vacio(model_s.getInfo())) {
				vslider.lblerrorD.setVisible(true);
				vslider.lblerrorD.setText("Rellene el campo");
			}
			 else {
//Si_"editar_"_es_igual_averdadero_y_origen_es_nulo_se_le_seteta_al_modelo_la_imagen_,de_lo_contrario_
//Se_le_asigna _a_la_variable_fechayhora_la_ayuda_de_obtener_fecha_y_hora_actual,_y_se_le_agruega_el_fin_formato_que_puede_ser_jpg,_png_jpeg
			if(editar == true) {
				if(Origen==null) {
					model_s.setImagen("");
				}else {
					String fechayhora = Ayudas.obtenerFechaYHoraActual();
					Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)));
					 model_s.setImagen(fechayhora+FinFormato);
				}
//Por_ultimo_se_llama_la_consulta_editar,_la_consultamonitorias_para_dejar_registro_de_que_se_edito_el_slider,_se_le_seteta_vacio_a_los_campos_
//Se_ponene_en_falso_los_botones_crear_y_activar_,se_pone_el_boton_agregar_imagen_visible;se_carga_la_tabla_de_sliders_y_muestra_un_mensaje_confirmando_la_edicion
				consulta.EditarSlider(model_s);
				consulta.Monitorias(a.lbl_IdUser.getText(), "24", model_s.getNombre());
				vslider.txtNombre.setText("");
				vslider.txtArea.setText("");
				editar = false;
				vslider.btnCancelar.setVisible(false);
				vslider.btnActivar.setVisible(false);
				vslider.lblTitulo.setText("CREAR SLIDER");
				vslider.btnAgregarImagen.setVisible(true);
				Origen = null;
				CargarTablaSlider();
				JOptionPane.showMessageDialog(null, "SLIDER EDITADO");

				}else {
//De_lo_contrario_a_la_varaible_fechayhora_se_le_asigna_el_valor_que_da_obtenerFechaYHoraActual,_se_sube_la_imagen_al_servidor_con_el_tipo_de_formato
//la_fechayhora_,se_le_setea_al_modelo_la_imagen_,se_llama_la_consulta_monitorias_para_dejar_registro_de_lo_que_se_hizo
//Se_dejan_los_campos_en_vacio_,_se_carga_la_tabla_slider_y_se_manda_un_mensaje_de_confirmación_de_slider_creado
					if(Origen==null) {
						//Si_esto_no_se_cumple,_si_origen_es_igual_a_nulo_se_manda_un_mensaje_indicando_que_seleccione_una_imagen				
										
											JOptionPane.showMessageDialog(null, "SELECCIONE UNA IMAGEN");
										}
					else {
				String fechayhora = Ayudas.obtenerFechaYHoraActual();
				Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)));
				consulta.Monitorias(a.lbl_IdUser.getText(), "23", model_s.getNombre());
				model_s.setImagen(fechayhora+FinFormato);
				consulta.InsertarSlider(model_s);
				vslider.txtNombre.setText("");
				vslider.txtArea.setText("");
				vslider.btnAgregarImagen.setVisible(true);
				vslider.lblImagen.setText("");
				CargarTablaSlider();
				Origen = null;
				JOptionPane.showMessageDialog(null, "SLIDER CREADO");
				}
				}
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
//En_este_bloque_se_valida_que_el_campo_nombre_no_pueda_quedar_vacio_y_se_manda_un_mensaje_de_alerta_
		
		if(e.getSource().equals(vslider.txtNombre)){
			String nombre = vslider.txtNombre.getText();
			if(Validaciones.vacio(nombre)) {
				vslider.lblerrorN. setVisible(true);
				vslider.lblerrorN.setText("Rellene el campo nombre");
			}else {
				vslider.lblerrorN. setVisible(false);
			}
		}
//En_este_bloque_se_valida_que_el_campo_area_no_pueda_quedar_vacio_y_se_manda_un_mensaje_de_alerta_		
		if(e.getSource().equals(vslider.txtArea)) {
			String area = vslider.txtArea.getText();
			if(Validaciones.vacio(area)) {
				vslider.lblerrorD.setVisible(true);
				vslider.lblerrorD.setText("Rellene el campo");
			}else {
				vslider.lblerrorD.setVisible(false);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override

	public void mousePressed(MouseEvent e) {
		
		if(e.getSource().equals(vslider.TablaSlider)) {
//Este_es_un_metodo_que_al_dar_click_en_alguno_de_las_filas_de_la_tabla_se_le_setea_a_los_campos_del_modelo_lo_que_trae_de_los_campos_de_la_tabla
			
			int row = vslider.TablaSlider.getSelectedRow();
			model_s.setId((String) vslider.TablaSlider.getValueAt(row, 0).toString());
			model_s.setNombre((String) vslider.TablaSlider.getValueAt(row, 1).toString());
			model_s.setInfo((String) vslider.TablaSlider.getValueAt(row, 2).toString());
			model_s.setEstado((String) vslider.TablaSlider.getValueAt(row, 4).toString());
			
			vslider.txtNombre.setText(model_s.getNombre());
			vslider.txtArea.setText(model_s.getInfo());
//En_esta_parte_se_pone_el_editar_en_verdadero_y_se_muestran_los_botones_cancelar_y_activar_y_se_cambia_el_titulo_			
			editar = true;
			vslider.btnCancelar.setVisible(true);
			vslider.btnActivar.setVisible(true);
			vslider.lblTitulo.setText("EDITAR SLIDER");
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

//Este_es_el_metodo_para_cargar_la_tabla_slider_,_que_llama_la_consulta_MostrarSlider
	public void CargarTablaSlider() {
		consulta.MostrarSlider(vslider.TablaSlider);
	}
	
}
