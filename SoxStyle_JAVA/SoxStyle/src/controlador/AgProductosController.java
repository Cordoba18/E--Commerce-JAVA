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
	
	//Se instancia la vista de agregar productos. Esta sera la parte visual de este codigo.
	AgregarProductos ap = new AgregarProductos();
	
	//Se instacia la clase la cual contiene las validaciones de los campos de textos existentes.
	Validaciones vali = new Validaciones();
	
	//Se instancia las consultas para que la vista mande los datos hacia la base de datos.
	Consultas consul = new Consultas();
	
	//Se hace una instacia de la vista de administrador para tomar algunos "id's".
	Administrador a;
	
	//Esta es una variable la cual se guarda la imagen que se subira como principal.
	Path Origen;
	
	//Este es el formato el cual es una ayuda para enviar la imagen.
	String FinFormato;
	
	//Este es el metodo constructor el cual recibe la vista de AgregarProductos y la de Administrador.
	public AgProductosController (AgregarProductos ap, Administrador a) {
		
		this.ap = ap;
		this.a = a;
		
		//Le damos el metodo de "addActionListener" a los botones para que sean escuchados y tengan funcionalidad.
		ap.btnBAImagen.addActionListener(this);
		ap.btnAgregar.addActionListener(this);
		
		//Le damos el metodo de "addKeyListener" a los campos de textos para que los errores se eliminen cuando se escriba alguna letra
		ap.txtNombre.addKeyListener(this);
		ap.txtPrecio.addKeyListener(this);
		ap.txtDescuento.addKeyListener(this);
		
		//Se llama el metodo "box" el cual contiene las categorias. 
		box();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//Con este codigo, le damos una funcionalidad al boton de agregar imagen.
		if(e.getSource().equals(ap.btnBAImagen)) {
			
			//--------------------------------------
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(null);
			File archivo = file.getSelectedFile();
			//--------------------------------------
			
			//En este "if" se valida la imagen que no este vacia y que este en el formato requeruido. Una vez este correcto
			//se desaparece el boton de agregar imagen" y se muestra un lbl con la ruta de la misma.
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
		//-------------------------------------------------------------------------------------------------------------------
		
		//Cuando presionemos el boton de agregar produtos. Se crea un modelo de productos y despues se guarda en variables
		//lo que este en el campo de texto.
		
		if(e.getSource().equals(ap.btnAgregar)){
			
			Productos produc = new Productos();
			String nompro = ap.txtNombre.getText();
			String preciopro = ap.txtPrecio.getText();
			String descuentopro = ap.txtDescuento.getText();	
			String txtArea = ap.textAreaDescripcion.getText();
			
		//---------------------------------------------------------------------------------------------------------------------	
			
			
			//Validaciones de el campo Nombre Producto
			
			if(Validaciones.vacio(nompro)) {
				
				ap.lblErrorNomPro.setText("Campo Vacio");
				ap.lblErrorNomPro.setVisible(true);		
				
			}else 
				if(Validaciones.SoloLetras(nompro)){
				
					ap.lblErrorNomPro.setText("Ingrese Letras");
					ap.lblErrorNomPro.setVisible(true);
				
			}
			
			//Validaciones del campo Precio Productos
			
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
			
			//Validaciones del campo Descuento
			
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

			//Validaciones del campo de descripcion 
			else
				if(txtArea.length() > 500) {
					
					ap.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ap.lblErrorDescripcion.setVisible(true);
				
				}
			
			//Validacion de la imagen. 
			else 
				if(Origen == null) {
					JOptionPane.showMessageDialog(null, "AGREGUE UNA IMAGEN");
				}
				
				else {
					
					//Hacemos las conexiones de los campos con la base de datos
					
					produc.setNombre(ap.txtNombre.getText());
					produc.setPrecio(Integer.parseInt(preciopro));
					produc.setDescuento(Integer.parseInt(ap.txtDescuento.getText()));
					produc.setDescripcion(ap.textAreaDescripcion.getText());
					produc.setNombre_Categoria(String.valueOf(ap.cbxCategoria.getSelectedItem()));
					produc.setId(Integer.parseInt(a.lbl_IdUser.getText()));
					consul.TraerCategoria(produc);
					
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
	
	

	public void box () {
			
			Consultas.comboBox(ap.cbxCategoria);
			
		}
	


	@Override
	public void keyTyped(KeyEvent e) {
		//Metodo el cual al momento de escribir esconda el lbl del error
		
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
	
	public void eventos() {
		
		//En este evento se guardara los datos en la base de datos
		
	}
	
	

}
