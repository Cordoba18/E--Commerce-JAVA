package controlador;


import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import herramientas.Validaciones;
import vista.AgregarProductos;
import vista.ColoresTallas;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;



	public class ColoresTallasController implements ActionListener, KeyListener{
		
		
		ColoresTallas ct = new ColoresTallas();
		Validaciones vali = new Validaciones();
		
		public ColoresTallasController (ColoresTallas ct) {
			
			this.ct = ct;
			
			ct.BtnAgregar2.addActionListener(this);
			ct.BtnAgregar.addActionListener(this);
			ct.txtTalla.addKeyListener(this);
			ct.txtCantidad.addKeyListener(this);
			ct.txtColor.addKeyListener(this);
			
		}



			public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(ct.BtnAgregar2)){
				
				String color = ct.txtColor.getText();
				
				if(Validaciones.vacio(color)) {
				ct.lblErrorColor.setText("Campo Vacio");
				ct.lblErrorColor.setVisible(true);	
					
				}else 
				if(Validaciones.SoloLetras(color)){
				ct.lblErrorColor.setText("Ingrese Letras");
				ct.lblErrorColor.setVisible(true);
					
					}
			}
			
				if(e.getSource().equals(ct.BtnAgregar)){
				
				String talla = ct.txtTalla.getText();
				String cantidad = ct.txtCantidad.getText();
				
			
				
			
				if(Validaciones.vacio(talla)) {
				
				ct.lblErrorTalla.setText("Campo Vacio");
				ct.lblErrorTalla.setVisible(true);		
				
				
				}else
				if(Validaciones.SoloNum(talla)){
				ct.lblErrorTalla.setText("Ingrese Numeros");
				ct.lblErrorTalla.setVisible(true);
							
						}
					
				
				else 
				if(Validaciones.vacio(cantidad)) {
				ct.lblErrorCantidad.setText("Campo Vacio");
				ct.lblErrorCantidad.setVisible(true);
						
						}
				else
				if(Validaciones.SoloNum(cantidad)) {
				ct.lblErrorCantidad.setText("Ingrese Numeros");
				ct.lblErrorCantidad.setVisible(true);
						
						}
				
				
				}
				
			}
		
	
	
			

		@Override
			public void keyTyped(KeyEvent e) {
			if(e.getSource().equals(ct.txtTalla)) {
				
				ct.lblErrorTalla.setVisible(false);
				
			}
			if(e.getSource().equals(ct.txtCantidad)) {
				
				ct.lblErrorCantidad.setVisible(false);
				
			}
			if(e.getSource().equals(ct.txtColor)) {
				
				ct.lblErrorColor.setVisible(false);
				
			}
			
				
	}
			
			@Override
			public void keyPressed(KeyEvent e) {
					
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
			
			
		
		}
			