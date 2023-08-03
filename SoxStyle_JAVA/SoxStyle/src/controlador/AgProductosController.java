package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import sql.*;
import modelo.Productos;
import vista.Administrador;
import vista.AgregarProductos;
import vista.Agregar_imagen;
import vista.ColoresTallas;
import controlador.*;

public class AgProductosController implements ActionListener, KeyListener{
	
	//Se_instancia_la_vista_de_agregar_productos._Esta_sera_la_parte_visual_de_este_codigo.
	AgregarProductos ap = new AgregarProductos();
	
	//Se_instacia_la_clase_la_cual_contiene_las_validaciones_de_los_campos_de_textos_existentes.
	Validaciones vali = new Validaciones();
	
	//Se_instancia_las_consultas_para_que_la_vista_mande_los_datos_hacia_la_base_de_datos.
	Consultas consul = new Consultas();
	
	//Se_hace_una_instacia_de_la_vista_de_administrador_para_tomar_algunos_"id's".
	Administrador a;
	
	//Esta_es_una_variable_la_cual_se_guarda_la_imagen_que_se_subira_como_principal.
	Path Origen;
	
	//Este_es_una_variable_la_cual_toma_el_formato_de_la_imagen.
	String FinFormato;
	
	//Este_es_el_metodo_constructor_el_cual_recibe_la_vista_de_Agrega_Productos_y_la_de_Administrador.
	public AgProductosController (AgregarProductos ap, Administrador a) {
		
		this.ap = ap;
		this.a = a;
		
		//Le_damos_el_metodo_de_"addActionListener"_a_los_botones_para_que_sean_escuchados_y_tengan_funcionalidad.
		ap.btnBAImagen.addActionListener(this);
		ap.btnAgregar.addActionListener(this);
		
		//Le_damos_el_metodo_de_"addKeyListener"_a_los_campos_de_textos_para_que_los_errores_se_eliminen_cuando_se_escriba_alguna_letra
		ap.txtNombre.addKeyListener(this);
		ap.txtPrecio.addKeyListener(this);
		ap.txtDescuento.addKeyListener(this);
		
		//Se_llama_el_metodo_"box"_el_cual_contiene_las_categorias. 
		box();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//Con_este_codigo_le_damos_una_funcionalidad_al_boton_de_agregar_imagen.
		if(e.getSource().equals(ap.btnBAImagen)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(null);
			File archivo = file.getSelectedFile();
			
			//En_este_"if"_se_valida_la_imagen_que_no_este_vacia_y_que_este_en_el_formato_requeruido._Una_vez_este_correcto
			//se_desaparece_el_boton_de_agregar_imagen_y_se_muestra_un_lbl_con_la_ruta_de_la_misma.
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
					
					ap.btnBAImagen.setVisible(false);
					ap.lblNombreImagen.setText(String.valueOf(Origen));
			
				}
			}
		}
		
		//Cuando_presionemos_el_boton_de_agregar_produtos._Se_crea_un_modelo_de_productos_y_despues_se_guarda_en_variable
		//lo_que_este_en_el_campo_de_texto.
		
		if(e.getSource().equals(ap.btnAgregar)){
			
			Productos produc = new Productos();
			String nompro = ap.txtNombre.getText();
			String preciopro = ap.txtPrecio.getText();
			String descuentopro = ap.txtDescuento.getText();	
			String txtArea = ap.textAreaDescripcion.getText();
			
			//Validaciones_de_el_campo_Nombre_Product		
			if(Validaciones.vacio(nompro)) {
				
				ap.lblErrorNomPro.setText("Campo Vacio");
				ap.lblErrorNomPro.setVisible(true);		
				
			}else 
				if(Validaciones.SoloLetras(nompro)){
				
					ap.lblErrorNomPro.setText("Ingrese Letras");
					ap.lblErrorNomPro.setVisible(true);
				
			}
			
			//Validaciones_del_campo_Precio_Productos
			
			else 
				if(Validaciones.vacio(preciopro)) {
					
					ap.lblErrorPrecio.setText("Campo Vacio");
					ap.lblErrorPrecio.setVisible(true);
					
				}
			
			else
				if(Validaciones.SoloNum(preciopro)) {
					
					ap.lblErrorPrecio.setText("Ingrese Numeros");
					ap.lblErrorPrecio.setVisible(true);
					
				}
			
			//Validaciones_del_campo_Descuento
			
			else
				if(Validaciones.vacio(descuentopro)) {
						
					ap.lblErrorDescuento.setText("Campo vacio");
					ap.lblErrorDescuento.setVisible(true);
						
				}
			else 
				if(Validaciones.SoloNum(descuentopro)) {
						
					ap.lblErrorDescuento.setText("Ingrese Numeros");
					ap.lblErrorDescuento.setVisible(true);
						
				}
				
			else 
				if(Validaciones.CantidadDescuento(descuentopro)) {
						
					ap.lblErrorDescuento.setText("Descuento Incorrecto");
					ap.lblErrorDescuento.setVisible(true);
						
				}

			//Validaciones_el_campo_de_descripcion 
			else
				if(txtArea.length() > 500) {
					
					ap.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ap.lblErrorDescripcion.setVisible(true);
				
				}
			
			//Validacion_de_la_imagen. 
			else 
				if(Origen == null) {
					JOptionPane.showMessageDialog(null, "AGREGUE UNA IMAGEN");
				}
				
				else {
					
					//Mandamos_los_campos_que_se_llenaron_al_modelo_del_producto_y_se_llama_un_metodo_de_traer_categoria
					produc.setNombre(ap.txtNombre.getText());
					produc.setPrecio(Integer.parseInt(preciopro));
					produc.setDescuento(Integer.parseInt(ap.txtDescuento.getText()));
					produc.setDescripcion(ap.textAreaDescripcion.getText());
					produc.setNombre_Categoria(String.valueOf(ap.cbxCategoria.getSelectedItem()));
					produc.setId(Integer.parseInt(a.lbl_IdUser.getText()));
					consul.TraerCategoria(produc);
				
					//Hacemos_un_"if"_el_cual_al_insertar_producto,_llama_la_fecha,_hora,_dia_y_el_formato_de_la_imagen.
					//Luego_muestra_un_"JoptionPane"_el_cual_le_decimos_al_administrador_que_se_guardo_la_imagen_correctamente
					//y_ponemos_que_la_imagen_sea_nula_para_evitar_errores.
					
					if(consul.insertarProductos(produc)) {
						consul.TraerId_Producto(produc);
						String fechayhora = Ayudas.obtenerFechaYHoraActual();
						Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)));
						 produc.setImagen(fechayhora+FinFormato);
						consul.insertarImagen(produc);
						JOptionPane.showMessageDialog(ap, "Exito en la creacion del Producto");
						consul.Monitorias(a.lbl_IdUser.getText(), "9", produc.getNombre_Categoria());
					    ap.txtNombre.setText("");
					    ap.txtPrecio.setText("");
					    ap.txtDescuento.setText("");
					    ap.textAreaDescripcion.setText("");
					    ap.btnBAImagen.setVisible(true);
						ap.lblNombreImagen.setText("");
						Origen = null;
					}
				}
			
		}
		
	}
					
	//Este_es_el_metodo_el_cual_llamamos_en_el_constructor._Trae_una_consulta_y_se_le_dice_que_mande_la_informacion_al 
	//comboBox_correspondiente.

	public void box () {
			
			Consultas.comboBox(ap.cbxCategoria);
			
		}

	@Override
	public void keyTyped(KeyEvent e) {
		//Este_metodo_funciona_para_cuando_se_digite_alguna_tecla_se_borre_el_error_que_aparezca.
		
		if(e.getSource().equals(ap.txtNombre)) {
			
			ap.lblErrorNomPro.setVisible(false);
			
		}
		if(e.getSource().equals(ap.txtPrecio)) {
			
			ap.lblErrorPrecio.setVisible(false);
			
		}
		if(e.getSource().equals(ap.txtDescuento)) {
			
			ap.lblErrorDescuento.setVisible(false);
			
		}
		
		
	}	
	
		
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
