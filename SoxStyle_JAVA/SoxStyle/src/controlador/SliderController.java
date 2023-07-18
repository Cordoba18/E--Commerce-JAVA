package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.MdlSlider;
import sql.Consultas;
import vista.Slider;

public class SliderController implements MouseListener, KeyListener, ActionListener{
	
	Slider vslider;
	boolean editar = false;
	String FinFormato;
	Path Origen;
	Consultas consulta = new Consultas();
	MdlSlider model_s = new MdlSlider();
	public SliderController(Slider vslider) {
		this.vslider = vslider;
		this.vslider.btnActivar.addActionListener(this);
		this.vslider.btnCancelar.addActionListener(this);
		this.vslider.btnActivar.addActionListener(this);
		this.vslider.txtArea.addKeyListener(this);
		this.vslider.txtNombre.addKeyListener(this);
		this.vslider.btnAgregarImagen.addActionListener(this);
		this.vslider.TablaSlider.addMouseListener(this);
		CargarTablaSlider();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vslider.btnAgregarImagen)) {
			
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
					
					vslider.btnAgregarImagen.setVisible(false);
					vslider.lblImagen.setText(String.valueOf(Origen));
			
				}
			}
		}
	
		if(e.getSource().equals(vslider.btnGuardar)) {
			
			if(editar == false) {
			
			}else {
				
			}
		}
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
	
	public void CargarTablaSlider() {
		consulta.MostrarSlider(vslider.TablaSlider);
	}
	
}
