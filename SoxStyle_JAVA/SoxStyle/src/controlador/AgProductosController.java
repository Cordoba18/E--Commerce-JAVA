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
	
	AgregarProductos ap = new AgregarProductos();
	Validaciones vali = new Validaciones();
	Consultas consul = new Consultas();
	Administrador a;
	Path Origen;
	String FinFormato;
	public AgProductosController (AgregarProductos ap, Administrador a) {
		
		this.ap = ap;
		this.a = a;
		ap.btnBAImagen.addActionListener(this);
		ap.btnAgregar.addActionListener(this);
		ap.txtNombre.addKeyListener(this);
		ap.txtPrecio.addKeyListener(this);
		ap.txtDescuento.addKeyListener(this);
		box();
		
	}
	

		
//	validacion del signo $ que queda pendiente 
	
//	public void actionPerformed2(ActionEvent e) {
//		if(e.getSource().equals(ap.btnAgregar)){
//		ap.txtPrecio.addKeyListener((KeyListener) new KeyAdapter() {
//		    public void keyTyped(KeyEvent e) {
//		        char c = e.getKeyChar();
//		        if (c != '$') {
//		            e.consume(); 
//		        }else {
//		        	JOptionPane.showMessageDialog(null, "error");
//		        }
//		    }
//		
//		});
//		}
//	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(ap.btnBAImagen)) {

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
					
					ap.btnBAImagen.setVisible(false);
					ap.lblNombreImagen.setText(String.valueOf(Origen));
			
				}
			}
		}
		
		if(e.getSource().equals(ap.btnAgregar)){
			
			Productos produc = new Productos();
			String nompro = ap.txtNombre.getText();
			String preciopro = ap.txtPrecio.getText();
			String descuentopro = ap.txtDescuento.getText();	
			String txtArea = ap.textAreaDescripcion.getText();
			
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

			//Validaciones del campo de descripcion 
			else
				if(txtArea.length() > 500) {
					
					ap.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ap.lblErrorDescripcion.setVisible(true);
				
				}
				else if(Origen == null) {
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
						 Ayudas.uploadFileToFTP(fechayhora+FinFormato,"style-sport.shop","stylespo","ADSI-208ss","/public_html/imgs", new File(String.valueOf(Origen)),FinFormato,true);
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
