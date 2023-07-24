package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.Productos;
import sql.Consultas;
import vista.Agregar_imagen;
import vista.ColoresTallas;
import vista.EditarProductos;

public class EdProductosController implements ActionListener, KeyListener {
	
	EditarProductos ed = new EditarProductos();
	Validaciones vali = new Validaciones();
	Productos pro = new Productos();
	
	public EdProductosController (EditarProductos ed) {
		
		this.ed = ed;
		ed.btnActualizar.addActionListener(this);
		ed.txtNombre.addKeyListener(this);
		ed.txtPrecio.addKeyListener(this);
		ed.txtDescuento.addKeyListener(this);
		box();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(ed.btnAgregarImagen)) {
			
			Agregar_imagen ai = new Agregar_imagen();
			Productos pro = new Productos();
	//		new AgregarImagenController(ai, pro);
		
			Ayudas.ActualizarPanel(ai, ed);
		}
		if(e.getSource().equals(ed.btnEdColorTalla)) {
			
			ColoresTallas ct = new ColoresTallas();
//			new ColoresTallasController(ct, ed);
			
		}
		
		if(e.getSource().equals(ed.btnActualizar)) {
			
			String nompro = ed.txtNombre.getText();
			String precio = ed.txtPrecio.getText();
			String descuento = ed.txtDescuento.getText();
			String descripcion = ed.textAreaDescripcion.getText();
			
			//Validaciones de el campo Nombre Producto
			
			if(Validaciones.vacio(nompro)) {
				
				ed.lblErrorNombrePro.setText("Campo Vacio");
				ed.lblErrorNombrePro.setVisible(true);		
				
			}
			else 
				if(Validaciones.SoloLetras(nompro)){
				
					ed.lblErrorNombrePro.setText("Ingrese Letras");
					ed.lblErrorNombrePro.setVisible(true);
	
			}
			
			//Validaciones del campo Precio Productos
			
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
			
//			//Validaciones del campo Estado Productos
//			
//			else
//				if(Validaciones.vacio(estado)) {
//						
//					ed.lblErrorEstado.setText("Campo Vacio");
//					ed.lblErrorEstado.setVisible(true);
//						
//					}
//				
//			else
//				if(Validaciones.SoloLetras(estado)) {
//						
//					ed.lblErrorEstado.setText("Ingrese Letras");
//					ed.lblErrorEstado.setVisible(true);
//				
//					}
//			
			//Validacion del campo Descuento
			
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
			
			//Validacion del campo Descripcion
			
			else
				if(descripcion.length() > 500) {
						
					ed.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ed.lblErrorDescripcion.setVisible(true);
					
					}
					
		} 
		
		else {
			
			//Aqui podes meter la funcionality de la vista
			
		}
		
		
	}
	
	public void box () {
		
		Consultas.comboBox(ed.cbxCategoria);
		
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Metodo el cual al momento de escribir esconda el lbl del error
		
		
		if(e.getSource().equals(ed.txtNombre)) {
			
			ed.lblErrorNombrePro.setVisible(false);
			
		}
		if(e.getSource().equals(ed.txtPrecio)) {
			
			ed.lblErrorPrecio.setVisible(false);
			
		}
//		if(e.getSource().equals(ed.txtEstado)) {
//			
//			ed.lblErrorEstado.setVisible(false);
//			
//		}
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



}
