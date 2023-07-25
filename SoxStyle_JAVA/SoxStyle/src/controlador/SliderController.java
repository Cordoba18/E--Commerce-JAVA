package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.MdlSlider;
import sql.Consultas;
import vista.Administrador;
import vista.Slider;

public class SliderController implements MouseListener, KeyListener, ActionListener{
	
	Slider vslider;
	boolean editar = false;
	String FinFormato;
	Path Origen = null;
	Consultas consulta = new Consultas();
	MdlSlider model_s = new MdlSlider();
	Administrador a;
	public SliderController(Slider vslider, Administrador a) {
		this.vslider = vslider;
		this.a=a;
		this.vslider.btnActivar.addActionListener(this);
		this.vslider.btnCancelar.addActionListener(this);
		this.vslider.txtArea.addKeyListener(this);
		this.vslider.txtNombre.addKeyListener(this);
		this.vslider.btnAgregarImagen.addActionListener(this);
		this.vslider.TablaSlider.addMouseListener(this);
		this.vslider.btnGuardar.addActionListener(this);
		CargarTablaSlider();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vslider.btnCancelar)) {
			vslider.txtNombre.setText("");
			vslider.txtArea.setText("");
			editar = false;
			vslider.btnCancelar.setVisible(false);
			vslider.btnActivar.setVisible(false);
			vslider.lblTitulo.setText("CREAR SLIDER");
			vslider.btnAgregarImagen.setVisible(true);
			Origen = null;
		}
		if(e.getSource().equals(vslider.btnActivar)) {
				consulta.EliminarSlider(model_s);
				consulta.Monitorias(a.lbl_IdUser.getText(), "25", model_s.getNombre());
				vslider.txtNombre.setText("");
				vslider.txtArea.setText("");
				editar = false;
				vslider.btnCancelar.setVisible(false);
				vslider.btnActivar.setVisible(false);
				vslider.lblTitulo.setText("CREAR SLIDER");
				vslider.btnAgregarImagen.setVisible(true);
				Origen = null;
				CargarTablaSlider();
		}
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
			
			model_s.setNombre(vslider.txtNombre.getText());
			model_s.setInfo(vslider.txtArea.getText());
			if(Validaciones.vacio(model_s.getNombre())) {
				vslider.lblerrorN. setVisible(true);
				vslider.lblerrorN.setText("Rellene el campo nombre");
			}
			if(Validaciones.vacio(model_s.getInfo())) {
				vslider.lblerrorD.setVisible(true);
				vslider.lblerrorD.setText("Rellene el campo");
			}
			 else {
			
			if(editar == true) {
				if(Origen==null) {
					model_s.setImagen("");
				}else {
					String fechayhora = Ayudas.obtenerFechaYHoraActual();
					 Ayudas.uploadFileToFTP(fechayhora+FinFormato,"style-sport.shop","stylespo","ADSI-208ss","/public_html/imgs", new File(String.valueOf(Origen)),FinFormato,true);
					 model_s.setImagen(fechayhora+FinFormato);
				}
				consulta.EditarSlider(model_s);
				consulta.Monitorias(a.lbl_IdUser.getText(), "24", model_s.getNombre());
				vslider.txtNombre.setText("");
				vslider.txtArea.setText("");
				vslider.btnAgregarImagen.setVisible(true);
				vslider.lblImagen.setText("");
				CargarTablaSlider();
				Origen = null;
				editar = false;
				JOptionPane.showMessageDialog(null, "SLIDER EDITADO");
				
			}else {
				if(Origen==null) {
					JOptionPane.showMessageDialog(null, "SELECIONE UNA IMAGEN");
				}else {
					String fechayhora = Ayudas.obtenerFechaYHoraActual();
				 Ayudas.uploadFileToFTP(fechayhora+FinFormato,"style-sport.shop","stylespo","ADSI-208ss","/public_html/imgs", new File(String.valueOf(Origen)),FinFormato,true);
				 consulta.Monitorias(a.lbl_IdUser.getText(), "23", model_s.getNombre());
				 model_s.setImagen(fechayhora+FinFormato);
				consulta.InsertarSlider(model_s);
				vslider.txtNombre.setText("");
				vslider.txtArea.setText("");
				vslider.btnAgregarImagen.setVisible(true);
				vslider.lblImagen.setText("");
				CargarTablaSlider();
				Origen = null;
				JOptionPane.showMessageDialog(null, "SLIDER CREADO");
				}
			}
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
		
		if(e.getSource().equals(vslider.TablaSlider)) {
			
			int row = vslider.TablaSlider.getSelectedRow();
			model_s.setId((String) vslider.TablaSlider.getValueAt(row, 0).toString());
			model_s.setNombre((String) vslider.TablaSlider.getValueAt(row, 1).toString());
			model_s.setInfo((String) vslider.TablaSlider.getValueAt(row, 2).toString());
			model_s.setEstado((String) vslider.TablaSlider.getValueAt(row, 4).toString());
			
			vslider.txtNombre.setText(model_s.getNombre());
			vslider.txtArea.setText(model_s.getInfo());
			editar = true;
			vslider.btnCancelar.setVisible(true);
			vslider.btnActivar.setVisible(true);
			vslider.lblTitulo.setText("EDITAR SLIDER");
		}
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
