package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import modelo.Usuario;
import sql.Consultas;
import vista.Perfil_usuario;

public class Perfil_usuarioController implements ActionListener, KeyListener{

	Perfil_usuario pu; 
	Usuario usuario=  new Usuario();
	Consultas consulta = new Consultas();
	public  Perfil_usuarioController(Perfil_usuario pu, Usuario usuario) {
		this.pu=pu;
		this.usuario=usuario;
		this.pu.cbxDepartamento.addActionListener(this);
		this.pu.btnGuardar.addActionListener(this);
		CargarDatos();
		CargarDepartamentos();
	}
	
	
	public void CargarDatos() {
		consulta.TraerDatosUsuario(usuario);
		pu.txtNombre.setText(usuario.getNombre());
		pu.txtCorreo.setText(usuario.getCorreo());
		pu.txtTelefono.setText(usuario.getTelefono());
		pu.txtDocumento.setText(usuario.getCedula());
		pu.txtDireccion.setText(usuario.getDireccion());
	}

	public void CargarDepartamentos() {
		consulta.CargarDepartamentos(pu.cbxDepartamento);
	}

	public void CargarCiudades(String departamento) {
		consulta.CargarCiudades(pu.cbxCiudad, departamento);
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
		if(e.getSource().equals(pu.cbxDepartamento)) {
			if(e.getSource().equals(pu.cbxDepartamento)) {
				CargarCiudades(String.valueOf(pu.cbxDepartamento.getSelectedItem()));
			}
		}
		if(e.getSource().equals(pu.btnGuardar)) {
			usuario.setNombre(pu.txtNombre.getText());
			usuario.setTelefono(pu.txtTelefono.getText());
			usuario.setCedula(pu.txtDocumento.getText());
			usuario.setDireccion(pu.txtDireccion.getText());
			usuario.setCiudad(String.valueOf(pu.cbxCiudad.getSelectedItem()));
			consulta.TraerIdCiudad(usuario);
			if (consulta.EditarUsuario(usuario)> 0) {
				JOptionPane.showMessageDialog(null, "USUARIO EDITADO CON EXITO");
			}
			CargarDatos();
			CargarDepartamentos();
		}
	}
}
