package controlador;

import java.awt.event.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.Productos;
//import sql.Conexion;
import sql.Consultas;
import vista.Administrador;
import vista.Agregar_imagen;


public class AgregarImagenController implements ActionListener, MouseListener{
	
	Agregar_imagen agi;
	Productos p = new Productos();
	Consultas consul = new Consultas();
	String FinFormato;
	Path Origen;
	Administrador a;
	public AgregarImagenController(Agregar_imagen agi, Productos p, Administrador a) {
		this.a = a;
		this.p=p;
		this.agi = agi;
		this.agi.btn_Agregar.addActionListener(this);
		this.agi.table.addMouseListener(this);
		this.agi.btnCancelar.addActionListener(this);
		this.agi.btnEliminar.addActionListener(this);
		CargarTablaImagenes();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(agi.btnCancelar)) {
			agi.btn_Agregar.setVisible(true);
			agi.btnCancelar.setVisible(false);
			agi.btnEliminar.setVisible(false);
		}
		
		if(e.getSource().equals(agi.btnEliminar)) {
			consul.Monitorias(a.lbl_IdUser.getText(), "20", p.getImagen()+",id_producto:"+p.getId());
			consul.EliminarImagen(p);
			agi.btn_Agregar.setVisible(true);
			agi.btnCancelar.setVisible(false);
			agi.btnEliminar.setVisible(false);
			CargarTablaImagenes();
			JOptionPane.showMessageDialog(null, "IMAGEN ELIMINADA CON EXITO");
		}
		   if (e.getSource().equals(agi.btn_Agregar)) {
			   if(agi.lblContadorImagenes.getText().equals("10")) {
				   JOptionPane.showMessageDialog(null, "LIMITE DE IMAGENES ALCANZADO");
			   }else {
				
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
						String fechayhora = Ayudas.obtenerFechaYHoraActual();
						Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)));
						p.setImagen(fechayhora+FinFormato);
						p.setId_Producto(p.getId());
						consul.insertarImagen(p);
						consul.Monitorias(a.lbl_IdUser.getText(), "19", p.getImagen()+",id_producto:"+p.getId_Producto());
						JOptionPane.showMessageDialog(null, "IMAGEN AGREGADA");
						CargarTablaImagenes();
						
					}
					}
				}
		   }
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(agi.table)) {
			int row = agi.table.getSelectedRow();
			p.setId_imagen((String) agi.table.getValueAt(row, 0).toString());
			p.setImagen((String) agi.table.getValueAt(row, 1).toString());
			agi.btn_Agregar.setVisible(false);
			agi.btnCancelar.setVisible(true);
			agi.btnEliminar.setVisible(true);
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
	
	public void CargarTablaImagenes() {
		consul.CargarTablaImagenes(agi.table, p);
		agi.lblContadorImagenes.setText(String.valueOf(p.getCantidad()));
	}

	
	
	
}