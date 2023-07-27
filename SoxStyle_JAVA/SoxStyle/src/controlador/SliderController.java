package controlador;

// En_esta_primera_parte_de_hace_la_importacion_de_las_librerias_necesarias_para_desarrollar_el_Slider_en_su_totalidad
// Priemro_tenemos_las_librerias_para_poder_escuchar_las_acciones_de_la_vista_(Slider)
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

//En esta parte se encuentra las importaciones de otras calses necesarias para desarrollar el slider
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
	
// En_esta_parte_se_decalrar_y_se_agrregan_los_escuchadores_a_los_botones, cuadros_de_texto,_labels_y_la_tabla
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
//Este_primer bloque_del actionPerformed se_usa para_que cuando_el administrador_le de_al boton_cancelar deje_los campos_en_vacio,
//el boton_editar_lo_ponga_en_estado (false) o sea que_lo_oculte,_tambien_oculte el boton_"Activar_", el_"Cancelar_"
// y pone_el nombre_del boton_como "CREAR SLIDER" y por_ultimo, el boton_  "btnAgregarImagen" lo_pone_en visible.
		
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
		
// En_este segundo_bloque_cuando_el_administrador_le_da_al_boton_"_Activar_"_pone_los_campos_txtNombre, txtArea, en_vacio, 
// los_botones btnCrear, btnActivar, los_pone_en false o sea los_oculta. 
// _manda a_la tabla_monitorias el id del_ususario, el_numero de_accion que_hizo y el nombre_del slider que_activo. 
// por_ ultimo_pone el boton_"AgregarImagen" en_visible y recarga_la tabla_de sliders.

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
//En_este bloque_este_bloque_se_escucha_la accion_del_boton_aregar_imagen,_primero_instanciando_las_clases JFileChooser y File.
// si_el_formato_de_la_imagen_es_diferente_a_._png, 
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
			
			if(editar == true) {
				if(Origen==null) {
					model_s.setImagen("");
				}else {
					String fechayhora = Ayudas.obtenerFechaYHoraActual();
					Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)));
					 model_s.setImagen(fechayhora+FinFormato);
				}
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
				if(Origen==null) {
					JOptionPane.showMessageDialog(null, "SELECCIONE UNA IMAGEN");
				}else {
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
		if(e.getSource().equals(vslider.txtNombre)){
			String nombre = vslider.txtNombre.getText();
			if(Validaciones.vacio(nombre)) {
				vslider.lblerrorN. setVisible(true);
				vslider.lblerrorN.setText("Rellene el campo nombre");
			}else {
				vslider.lblerrorN. setVisible(false);
			}
		}
		
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
			
			int row = vslider.TablaSlider.getSelectedRow();
			model_s.setId((String) vslider.TablaSlider.getValueAt(row, 0).toString());
			model_s.setNombre((String) vslider.TablaSlider.getValueAt(row, 1).toString());
			model_s.setInfo((String) vslider.TablaSlider.getValueAt(row, 2).toString());
			model_s.setEstado((String) vslider.TablaSlider.getValueAt(row, 4).toString());
			
			vslider.txtNombre.setText(model_s.getNombre());
			vslider.txtArea.setText(model_s.getInfo());
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
	
	public void CargarTablaSlider() {
		consulta.MostrarSlider(vslider.TablaSlider);
	}
	
}
