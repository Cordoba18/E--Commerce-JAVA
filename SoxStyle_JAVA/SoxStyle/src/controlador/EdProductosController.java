package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.Productos;
import sql.Consultas;
import vista.Administrador;
import vista.Agregar_imagen;
import vista.ColoresTallas;
import vista.EditarProductos;

public class EdProductosController implements ActionListener, KeyListener, MouseListener {
	
	//Se_instancia_la_vista_de_editar_producto._Esta_sera_la_parte_visual_de_este_codigo.
	EditarProductos ed;
	
	//Se_instacia_la_clase_la_cual_contiene_las_validaciones_de_los_campos_de_textos_existentes.
	Validaciones vali = new Validaciones();
	
	//Se_instancia_el_modelo_sobre_la_cual_trabajaremos.
	Productos pro = new Productos();
	
	//Se_instancia_las_consultas_para_que_la_vista_mande_los_datos_hacia_la_base_de_datos.
	Consultas consulta = new Consultas();
	
	//Este_es_el_formato_el_cual_es_una_ayuda_para_enviar_la_imagen.
	String FinFormato;
	
	//Esta_es_una_variable_la_cual_se_guarda_la_imagen_que_se_subira_como_principal_y_se_establece_nula_para_que_ingrese_una_imagen.
	Path Origen = null;
	
	//-----------------------------
	boolean accioncategoria= false;
	//-----------------------------
	
	//Se_hace_una_instacia_de_la_vista_de_administrador_para_tomar_algunos_"id's".
	Administrador a;
	
	//Este_es_el_metodo_constructor_el_cual_recibe_la_vista_de_Edita_Productos_y_la_de_Administrador.
	public EdProductosController (EditarProductos ed, Productos p, Administrador a) {
		
		this.a = a;
		this.ed = ed;
		this.pro = p;
		
		//Le_damos_el_metodo_de_"addActionListener"_a_los_botones_para_que_sean_escuchados_y_tengan_funcionalidad.
		
		ed.btnActualizar.addActionListener(this);
		ed.btnEdColorTalla.addActionListener(this);
		ed.btnAgregarImagen.addActionListener(this);
		ed.btnEditarImagenes.addActionListener(this);
		ed.btnCancelar.addActionListener(this);
		
		//Le_damos_el_metodo_de_"addKeyListener"_a_los_campos_de_textos_para_que_los_errores_se_eliminen_cuando_se_escriba_alguna_letra.
		
		ed.txtNombre.addKeyListener(this);
		ed.txtPrecio.addKeyListener(this);
		ed.txtDescuento.addKeyListener(this);
		
		//------------------------------------
		ed.cbxCategoria.addMouseListener(this);
		//------------------------------------
		
		//Llamamos_al_metodo_que_trae_y_muestra_lo_que_hay_en_la_base_de_datos_en_los_campos_de_texto.
		
		CargarDatos();
		
		//Se_llama_el_metodo_"box"_el_cual_contiene_las_categorias. 
		
		box();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Con_este_codigo,_le_damos_una_funcionalidad_al_boton_de_agregar_imagen.
		if(e.getSource().equals(ed.btnAgregarImagen)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(null);
			File archivo = file.getSelectedFile();
			
			//En_este_"if"_se_valida_la_imagen_que_no_este_vacia_y_que_este_en_el_formato_requerido._Una_vez_este_correcto
			//se_desaparece_el_boton_de_agregar_imagen,_se_muestra_un_lbl_con_la_ruta_de_la_misma_y_se_muestra_un_boton_para_cancelar.
			
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
					
					ed.btnAgregarImagen.setVisible(false);
					ed.lbl_Imagen.setText(String.valueOf(Origen));
					ed.btnCancelar.setVisible(true);
			
				}
			}
	
		}	
		
		if(e.getSource().equals(ed.btnCancelar)) {
			ed.btnAgregarImagen.setVisible(true);
		ed.btnCancelar.setVisible(false);
		Origen = null;
		}
		
		//Este_boton_cumple_la_funcionalidad_de_llevar_al_administrador_a_la_vista_de_Agregar_Imagenes.
		
		if(e.getSource().equals(ed.btnEditarImagenes)) {
			
			Agregar_imagen ai = new Agregar_imagen();
			new AgregarImagenController(ai, pro, a);
			Ayudas.ActualizarPanel(ai, ed);
		}
		
		//Este_boton_cumple_la_funcionalidad_de_llevar_al_administrador_a_la_vista_de_Editar_Tallas_y_Colores.
		
		if (e.getSource().equals(ed.btnEdColorTalla)) {
			ColoresTallas color_talla = new ColoresTallas();
			new ColoresTallasController(color_talla, pro, a);
			Ayudas.ActualizarPanel(color_talla,ed);
		
			
		}
		
		//Cuando_presionemos_el_boton_de_Actualizar_Producto._Se_crea_un_modelo_de_productos_y_despues_se_guarda_en_variables
		//lo_que_este_en_el_campo_de_texto.
		
		
		if(e.getSource().equals(ed.btnActualizar)) {
			
			String nompro = ed.txtNombre.getText();
			String precio = ed.txtPrecio.getText();
			String descuento = ed.txtDescuento.getText();
			String descripcion = ed.textAreaDescripcion.getText();
			
			//Validaciones_de_el_campo_Nombre_Producto.
			
			if(Validaciones.vacio(nompro)) {
				
				ed.lblErrorNombrePro.setText("Campo Vacio");
				ed.lblErrorNombrePro.setVisible(true);		
				
			}
			else 
				if(Validaciones.SoloLetras(nompro)){
				
					ed.lblErrorNombrePro.setText("Ingrese Letras");
					ed.lblErrorNombrePro.setVisible(true);
	
			}else 
				if(Validaciones.Cantidad_Nombre_Producto(nompro)){
				
					ed.lblErrorNombrePro.setText("Ingrese un nombre mas corto");
					ed.lblErrorNombrePro.setVisible(true);
				
			}
			
			//Validaciones_del_campo_Precio_Producto.
			
			else 
				if(Validaciones.vacio(precio)) {
						
					ed.lblErrorPrecio.setText("Campo Vacio");
					ed.lblErrorPrecio.setVisible(true);
						
					}
				
			else
				if(Validaciones.SoloNum(precio)) {
						
					ed.lblErrorPrecio.setText("Ingrese Numeros");
					ed.lblErrorPrecio.setVisible(true);
						
					}
			
			//Validaciones_del_campo_Descuento.
			
			else
				if(Validaciones.vacio(descuento)) {
					
					ed.lblErrorDescuento.setText("Campo vacio");
					ed.lblErrorDescuento.setVisible(true);
					
				}
			else 
				if(Validaciones.SoloNum(descuento)) {
					
					ed.lblErrorDescuento.setText("Ingrese Numeros");
					ed.lblErrorDescuento.setVisible(true);
					
				}
			
			else 
				if(Validaciones.CantidadDescuento(descuento)) {
					
					ed.lblErrorDescuento.setText("Descuento Incorrecto");
					ed.lblErrorDescuento.setVisible(true);
					
				}
			
			//Validacion_del_campo_Descripcion.
			
			else
				if(descripcion.length() > 500) {
						
					ed.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ed.lblErrorDescripcion.setVisible(true);
					
					}
		
		else {
			
			//Mandamos_los_campos_que_se_actualizaran_en_el_modelo_del_producto,_se_llama_un_metodo_de_traer_categoria_y_traer_la_imagen_principal_para_actualizarlo.
			
			pro.setNombre(ed.txtNombre.getText());
			pro.setPrecio(Integer.parseInt(ed.txtPrecio.getText()));
			pro.setDescuento(Integer.parseInt(ed.txtDescuento.getText()));
			pro.setDescripcion(ed.textAreaDescripcion.getText());
			pro.setNombre_Categoria(String.valueOf(ed.cbxCategoria.getSelectedItem()));
			consulta.TraerCategoria(pro);
			consulta.TraerImagenPrincipal(pro);
			if(consulta.EditarProducto(pro, accioncategoria)>0) {
				
				if (Origen == null) {
					
				} else {
					String fechayhora = Ayudas.obtenerFechaYHoraActual();
					Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)));
					pro.setImagen(fechayhora+FinFormato);
					consulta.EditarImagen(pro);
				}
				consulta.Monitorias(a.lbl_IdUser.getText(), "10", pro.getNombre());
				JOptionPane.showMessageDialog(null, "Exito en la edicion del Producto");;
			    ed.btnAgregarImagen.setVisible(true);
				Origen = null;
				accioncategoria=false;
				ed.btnCancelar.setVisible(false);
				CargarDatos();
			}
		}
		}
		
	}
	
	//Este_es_el_metodo_el_cual_llamamos_en_el_constructor._Trae_una_consulta_y_se_le_dice_que_mande_la_informacion_al 
	//comboBox_correspondiente.
	
	public void box () {
		
		Consultas.comboBox(ed.cbxCategoria);
		
	}
	
	//Metodo_que_trae_los_datos_para_asi_mandarlos_a_sus_respectivos_campos.

	public void CargarDatos() {
		consulta.TraerDatosProducto(pro);
		ed.txtNombre.setText(pro.getNombre());
		ed.textAreaDescripcion.setText(pro.getDescripcion());
		ed.txtDescuento.setText(String.valueOf(pro.getDescuento()));
		ed.txtPrecio.setText(String.valueOf(pro.getPrecio()));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Este_metodo_funciona_para_cuando_se_digite_alguna_tecla_se_borre_el_error_que_aparezca.
		
		
		if(e.getSource().equals(ed.txtNombre)) {
			
			ed.lblErrorNombrePro.setVisible(false);
			
		}
		if(e.getSource().equals(ed.txtPrecio)) {
			
			ed.lblErrorPrecio.setVisible(false);
			
		}

		if(e.getSource().equals(ed.txtDescuento)) {
			
			ed.lblErrorDescuento.setVisible(false);
			
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//----------------------------------------------
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(ed.cbxCategoria)) {
			accioncategoria=true;
		}
		
	//----------------------------------------------
		
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



}
