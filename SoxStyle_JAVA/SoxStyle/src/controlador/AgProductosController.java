package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import herramientas.Validaciones;
import modelo.Productos;
import vista.AgregarProductos;

public class AgProductosController implements ActionListener, KeyListener{
	
	AgregarProductos ap = new AgregarProductos();
	Validaciones vali = new Validaciones();
	Productos produ = new Productos();
	

	public AgProductosController (AgregarProductos ap) {
		
		this.ap = ap;
		ap.btnAgregar.addActionListener(this);
		ap.txtNombre.addKeyListener(this);
		ap.txtEstado.addKeyListener(this);
		
	}
	

		
//	validacion del signo $
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
		if(e.getSource().equals(ap.btnAgregar)){
			
			String nompro = ap.txtNombre.getText();
			String preciopro = ap.txtPrecio.getText();
			String estadopro = ap.txtEstado.getText();	 	
			
			//Valaciones de el campo Nombre Produto
			
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
			
		}
		
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
