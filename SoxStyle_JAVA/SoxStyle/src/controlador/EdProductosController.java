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
	
	//Se instancia la vista de editar productos. Esta sera la parte visual de este codigo.
	EditarProductos ed;
	
	//Se instacia la clase la cual contiene las validaciones de los campos de textos existentes.
	Validaciones vali = new Validaciones();
	
	//Se instancia el modelo sobre le cual trabajaremos.
	Productos pro = new Productos();
	
	//Se instancia las consultas para que la vista mande los datos hacia la base de datos.
	Consultas consulta = new Consultas();
	
	//Este es el formato el cual es una ayuda para enviar la imagen.
	String FinFormato;
	
	//Esta es una variable la cual se guarda la imagen que se subira como principal y se establece nula para que ingrese una imagen.
	Path Origen = null;
	
	//-----------------------------
	boolean accioncategoria= false;
	//-----------------------------
	
	//Se hace una instacia de la vista de administrador para tomar algunos "id's".
	Administrador a;
	
	//Este es el metodo constructor el cual recibe la vista de EditarProductos y la de Administrador.
	public EdProductosController (EditarProductos ed, Productos p, Administrador a) {
		
		this.a = a;
		this.ed = ed;
		this.pro = p;
		
		//Le damos el metodo de "addActionListener" a los botones para que sean escuchados y tengan funcionalidad.
		
		ed.btnActualizar.addActionListener(this);
		ed.btnEdColorTalla.addActionListener(this);
		ed.btnAgregarImagen.addActionListener(this);
		ed.btnEditarImagenes.addActionListener(this);
		ed.btnCancelar.addActionListener(this);
		
		//Le damos el metodo de "addKeyListener" a los campos de textos para que los errores se eliminen cuando se escriba alguna letra.
		
		ed.txtNombre.addKeyListener(this);
		ed.txtPrecio.addKeyListener(this);
		ed.txtDescuento.addKeyListener(this);
		
		//------------------------------------
		ed.cbxCategoria.addMouseListener(this);
		//------------------------------------
		
		//Llamamos al metodo que trae y muestra lo que hay en la base de datos en los campos de texto.
		
		CargarDatos();
		
		//Se llama el metodo "box" el cual contiene las categorias. 
		
		box();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Con este codigo, le damos una funcionalidad al boton de agregar imagen.
		if(e.getSource().equals(ed.btnAgregarImagen)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(null);
			File archivo = file.getSelectedFile();
			
			//En este "if" se valida la imagen que no este vacia y que este en el formato requeruido. Una vez este correcto
			//se desaparece el boton de agregar imagen", se muestra un lbl con la ruta de la misma y se muestra un boton para cancelar.
			
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
		
		//Este boton cumple la funcionalidad de llevar al administrador a la vista de Agregar Imagenes.
		
		if(e.getSource().equals(ed.btnEditarImagenes)) {
			
			Agregar_imagen ai = new Agregar_imagen();
			new AgregarImagenController(ai, pro, a);
			Ayudas.ActualizarPanel(ai, ed);
		}
		
		//Este boton cumple la funcionalidad de llevar al administrador a la vista de Editar Tallas y Colores.
		
		if (e.getSource().equals(ed.btnEdColorTalla)) {
			ColoresTallas color_talla = new ColoresTallas();
			new ColoresTallasController(color_talla, pro, a);
			Ayudas.ActualizarPanel(color_talla,ed);
		
			
		}
		
		//Cuando presionemos el boton de Actualizar Productos. Se crea un modelo de productos y despues se guarda en variables
		//lo que este en el campo de texto.
		
		
		if(e.getSource().equals(ed.btnActualizar)) {
			
			String nompro = ed.txtNombre.getText();
			String precio = ed.txtPrecio.getText();
			String descuento = ed.txtDescuento.getText();
			String descripcion = ed.textAreaDescripcion.getText();
			
			//Validaciones de el campo Nombre Producto.
			
			if(Validaciones.vacio(nompro)) {
				
				ed.lblErrorNombrePro.setText("Campo Vacio");
				ed.lblErrorNombrePro.setVisible(true);		
				
			}
			else 
				if(Validaciones.SoloLetras(nompro)){
				
					ed.lblErrorNombrePro.setText("Ingrese Letras");
					ed.lblErrorNombrePro.setVisible(true);
	
			}
			
			//Validaciones del campo Precio Productos.
			
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
			
			//Validaciones del campo Descuento.
			
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
			
			//Validacion del campo Descripcion.
			
			else
				if(descripcion.length() > 500) {
						
					ed.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ed.lblErrorDescripcion.setVisible(true);
					
					}
		
		else {
			
			//Mandamos los campos que se actualizaran en el modelo del producto, se llama un metodo de traer categoria y traer la imagen principal para actualizarlo.
			
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
	
	//Este es el metodo el cual llamamos en el constructor. Trae una consulta y se le dice que mande la informacion al 
	//comboBox correspondiente.
	
	public void box () {
		
		Consultas.comboBox(ed.cbxCategoria);
		
	}
	
	//Metodo que trae los datos para asi mandarlos a sus respectivos campos.

	public void CargarDatos() {
		consulta.TraerDatosProducto(pro);
		ed.txtNombre.setText(pro.getNombre());
		ed.textAreaDescripcion.setText(pro.getDescripcion());
		ed.txtDescuento.setText(String.valueOf(pro.getDescuento()));
		ed.txtPrecio.setText(String.valueOf(pro.getPrecio()));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Este metodo funciona para cuando se digite alguna tecla se borre el error que aparezca.
		
		
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
