package controlador;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Productos;
import herramientas.Validaciones;
import vista.Administrador;
import vista.AgregarProductos;
import vista.ColoresTallas;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sql.Consultas;


public class ColoresTallasController implements ActionListener, KeyListener,MouseListener{
	
	
    Validaciones vali = new Validaciones();
    Consultas consult = new Consultas();
    Productos p = new Productos();
    ColoresTallas ct;
    Administrador a;
	public ColoresTallasController (ColoresTallas ct, Productos p, Administrador a) {
		this.ct = ct;
		this.p =p;
		this.a = a;
		ct.BtnAgregarTalla.addActionListener(this);
        ct.BtnAgregarC.addActionListener(this);
        ct.BtnBorrarTalla.addActionListener(this);
        ct.BtnBorrarC.addActionListener(this);
        ct.BtnEditarTalla.addActionListener(this);
        ct.BtnCancelarC.addActionListener(this);
        ct.BtncancelarTalla.addActionListener(this);
        ct.txtTalla.addKeyListener(this);
        ct.txtCantidad.addKeyListener(this);
        ct.txtColor.addKeyListener(this);
        ct.TablaTalla.addMouseListener(this);
        ct.TablaColores.addMouseListener(this);
   
		p.setId_Producto(p.getId());
		CargarColores();
		CargarTallas();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(ct.TablaColores)) {
			int row = ct.TablaColores.getSelectedRow();
			p.setId_color((String) ct.TablaColores.getValueAt(row, 0).toString());
			p.setColor((String) ct.TablaColores.getValueAt(row, 1).toString());
			ct.BtnBorrarC.setVisible(true);
			ct.BtnCancelarC.setVisible(true);
			ct.BtnAgregarC.setVisible(false);
		}
		
		if(e.getSource().equals(ct.TablaTalla)) {
			int row = ct.TablaTalla.getSelectedRow();
			p.setId_talla((String) ct.TablaTalla.getValueAt(row, 0).toString());
			p.setTalla((String) ct.TablaTalla.getValueAt(row, 2).toString());
			p.setCantidad(Integer.parseInt((String) ct.TablaTalla.getValueAt(row, 1).toString()));
			ct.txtTalla.setText(p.getTalla());
			ct.txtCantidad.setText(String.valueOf(p.getCantidad()));
			ct.BtnBorrarTalla.setVisible(true);
			ct.BtnEditarTalla.setVisible(true);
			ct.BtncancelarTalla.setVisible(true);
			ct.BtnAgregarTalla.setVisible(false);
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ct.BtnAgregarTalla)) {
			p.setCantidad(Integer.parseInt(ct.txtCantidad.getText()));
			p.setTalla(ct.txtTalla.getText());
			consult.insertarTalla(p);
			consult.Monitorias(a.lbl_IdUser.getText(), "16", p.getTalla()+",id_producto:"+p.getId_Producto());
			ct.txtCantidad.setText("");
			ct.txtTalla.setText("");
			CargarTallas();
			
		}
		
		if(e.getSource().equals(ct.BtnAgregarC)) {
			
			p.setColor(ct.txtColor.getText());
			ct.txtColor.setText("");
			consult.insertarColor(p);
			consult.Monitorias(a.lbl_IdUser.getText(), "21", p.getColor()+",id_producto:"+p.getId_Producto());
			CargarColores();
		}
		
		if (e.getSource().equals(ct.BtnEditarTalla)) {
			p.setCantidad(Integer.parseInt(ct.txtCantidad.getText()));
			p.setTalla(ct.txtTalla.getText());
			consult.Monitorias(a.lbl_IdUser.getText(), "17", p.getTalla()+",id_producto:"+p.getId_Producto());
			consult.actualizarTallas(p);
			ct.BtnBorrarTalla.setVisible(false);
			ct.BtnEditarTalla.setVisible(false);
			ct.BtncancelarTalla.setVisible(false);
			ct.BtnAgregarTalla.setVisible(true);
			ct.txtTalla.setText("");
			ct.txtCantidad.setText("");
			CargarTallas();
		}
		
		if(e.getSource().equals(ct.BtnBorrarC)) {
			ct.txtColor.setText("");
			consult.Monitorias(a.lbl_IdUser.getText(), "22", p.getColor()+",id_producto:"+p.getId_Producto());
			consult.EliminarColor(p);
			CargarColores();
			ct.BtnBorrarC.setVisible(false);
			ct.BtnCancelarC.setVisible(false);
			ct.BtnAgregarC.setVisible(true);
		}
		if(e.getSource().equals(ct.BtnBorrarTalla)) {
			consult.EliminarTalla(p);
			consult.Monitorias(a.lbl_IdUser.getText(), "18", p.getTalla()+",id_producto:"+p.getId_Producto());
			ct.BtnBorrarTalla.setVisible(false);
			ct.BtnEditarTalla.setVisible(false);
			ct.BtncancelarTalla.setVisible(false);
			ct.BtnAgregarTalla.setVisible(true);
			ct.txtTalla.setText("");
			ct.txtCantidad.setText("");
			CargarTallas();
		}
		if(e.getSource().equals(ct.BtncancelarTalla)) {
			ct.BtnBorrarTalla.setVisible(false);
			ct.BtnEditarTalla.setVisible(false);
			ct.BtncancelarTalla.setVisible(false);
			ct.BtnAgregarTalla.setVisible(true);
			ct.txtTalla.setText("");
			ct.txtCantidad.setText("");
		}
		if(e.getSource().equals(ct.BtnCancelarC)) {
			
			ct.BtnBorrarC.setVisible(false);
			ct.BtnCancelarC.setVisible(false);
			ct.BtnAgregarC.setVisible(true);
			
		}
	}
	
	public void CargarTallas() {
	                
		consult.CargarTallas(ct.TablaTalla, p);
}
	public void CargarColores() {
		consult.CargarColores(ct.TablaColores, p);
}	
		}	