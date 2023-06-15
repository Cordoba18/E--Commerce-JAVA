package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import sql.*;
import modelo.Productos;
import vista.AgregarProductos;
import vista.Agregar_imagen;
import vista.ColoresTallas;
import controlador.*;

public class AgProductosController implements ActionListener, KeyListener{
	
	AgregarProductos ap = new AgregarProductos();
	Validaciones vali = new Validaciones();
	Consultas consul = new Consultas();
	

	public AgProductosController (AgregarProductos ap) {
		
		this.ap = ap;
		ap.btnBATallaColor.addActionListener(this);
		ap.btnBAImagen.addActionListener(this);
		ap.btnAgregar.addActionListener(this);
		ap.txtNombre.addKeyListener(this);
		ap.txtPrecio.addKeyListener(this);
		ap.txtEstado.addKeyListener(this);
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
		
			Agregar_imagen ai = new Agregar_imagen();
			Productos pro = new Productos();
			new AgregarImagenController(ai);
		
			Ayudas.ActualizarPanel(ai, ap);
		}
		if(e.getSource().equals(ap.btnBATallaColor)) {
			
			ColoresTallas ct = new ColoresTallas();
			
			new ColoresTallasController(ct);
			
			Ayudas.ActualizarPanel(ct, ap);				
		}
		
		
		if(e.getSource().equals(ap.btnAgregar)){
			
			Productos produc = new Productos();
			String nompro = ap.txtNombre.getText();
			String preciopro = ap.txtPrecio.getText();
			String estadopro = ap.txtEstado.getText();	
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
			
			//Validaciones del campo Estado Productos
			
			else
				if(Validaciones.vacio(estadopro)) {
					
					ap.lblErrorEstado.setText("Campo Vacio");
					ap.lblErrorEstado.setVisible(true);
					
				}
			
			else
				if(Validaciones.SoloLetras(estadopro)) {
					
					ap.lblErrorEstado.setText("Ingrese Letras");
					ap.lblErrorEstado.setVisible(true);
			
				}
			//Validaciones del campo de descripcion 
			else
				if(txtArea.length() > 500) {
					
					ap.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ap.lblErrorDescripcion.setVisible(true);
				
				}else {
					
					//Hacemos las conexiones de los campos con la base de datos
					
					produc.setNombre(ap.txtNombre.getText());
					produc.setPrecio(Integer.parseInt(preciopro));
					produc.setEstado(ap.txtEstado.getText());
					produc.setDescripcion(ap.textAreaDescripcion.getText());
					produc.setCategoria(Integer.valueOf(ap.cbxCategoria.getSelectedIndex()));
					
					
					if(consul.insertarProductos(produc)) {
						
						//Si todo cumple se mandan los productos a la base de datos
						
						JOptionPane.showMessageDialog(ap, "Exito en la creacion del Producto");;
					    ap.txtNombre.setText("");
					    ap.txtPrecio.setText("");
					    ap.txtEstado.setText("");
					    ap.textAreaDescripcion.setText("");
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
		if(e.getSource().equals(ap.txtEstado)) {
			
			ap.lblErrorEstado.setVisible(false);
			
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
