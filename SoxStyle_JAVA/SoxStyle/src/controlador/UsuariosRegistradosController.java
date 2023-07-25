package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;

import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.Administrador;
import vista.Login;
import vista.Perfil_usuario;
import vista.UsuariosRegistrados;
import vista.Vpdnuevos;

public class UsuariosRegistradosController implements ActionListener, KeyListener, MouseListener{
	UsuariosRegistrados UR;
	String busqueda = "";
	String peticion = "";
	Consultas consulta = new Consultas();
	Usuario user = new Usuario();
	 Administrador a;
	public UsuariosRegistradosController (UsuariosRegistrados UR, Administrador a) {
		this.UR = UR;
		this.a=a;
		this.UR.btnCancelar.addActionListener(this);
		this.UR.btnEditar.addActionListener(this);
		this.UR.btnEliminar.addActionListener(this);
		this.UR.txtBuscar.addKeyListener(this);
		this.UR.table.addMouseListener(this);
		LlenarTabla();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(UR.table)) {
			
			int row = UR.table.getSelectedRow();
			String id = (String) UR.table.getValueAt(row, 0).toString();
			user.setNombre((String) UR.table.getValueAt(row, 1).toString());
			user.setEstado((String) UR.table.getValueAt(row, 10).toString());
			user.setId(Integer.parseInt(id));
			UR.btnCancelar.setVisible(true);
			UR.btnEditar.setVisible(true);
			UR.btnEliminar.setVisible(true);
			if(user.getEstado().equals("1")) {
				peticion = "2";
				UR.btnEliminar.setText("ELIMINAR");
			}else {
				peticion = "1";
				UR.btnEliminar.setText("ACTIVAR");
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
		if(e.getSource().equals(UR.txtBuscar)) {
			busqueda = UR.txtBuscar.getText();
			LlenarTabla();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(UR.btnCancelar)) {
			UR.btnCancelar.setVisible(false);
			UR.btnEditar.setVisible(false);
			UR.btnEliminar.setVisible(false);
		}
		if(e.getSource().equals(UR.btnEliminar)) {
			if (consulta.EliminarActivarUsuario(String.valueOf(user.getId()), peticion)>0) {
				consulta.Monitorias(a.lbl_IdUser.getText(), "13", user.getNombre());
				UR.btnCancelar.setVisible(false);
				UR.btnEditar.setVisible(false);
				UR.btnEliminar.setVisible(false);
				busqueda = "";
				LlenarTabla();
			}
			
			
		}
		
		if(e.getSource().equals(UR.btnEditar)) {
			
			Perfil_usuario ur = new Perfil_usuario();
			new Perfil_usuarioController(ur,user,a);
			Ayudas.ActualizarPanel(ur, a.panelPrincipal);
		}
	}
	
	public void LlenarTabla() {
		
		consulta.BuscarUsuarios(UR.table, busqueda, a.lbl_IdUser.getText());
	}



}
