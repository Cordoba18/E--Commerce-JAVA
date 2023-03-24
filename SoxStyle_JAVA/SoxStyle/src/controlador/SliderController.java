package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.MdlSlider;
import vista.Slider;

public class SliderController implements MouseListener, KeyListener, ActionListener{
	
	Slider vslider;
	

	
	public Path origen;
	public Path Destino;
	public Path Destino2;


	public SliderController(Slider vslider) {
		this.vslider = vslider;
		this.vslider.btnActivar.addActionListener(this);
		this.vslider.btnCambiar.addActionListener(this);
		this.vslider.btnActualizar.addActionListener(this);
		this.vslider.txtArea.addKeyListener(this);
		this.vslider.txtNombre.addKeyListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
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
