package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import herramientas.Validaciones;
import modelo.Usuario;
import sql.Consultas;
import vista.Administrador;
import vista.Perfil_usuario;

public class Perfil_usuarioController implements ActionListener, KeyListener{

	Perfil_usuario pu; 
	Usuario usuario=  new Usuario();
	Consultas consulta = new Consultas();
	Administrador a;
	public  Perfil_usuarioController(Perfil_usuario pu, Usuario usuario, Administrador a) {
		this.pu=pu;
		this.a=a;
		this.usuario=usuario;
		this.pu.cbxDepartamento.addActionListener(this);
		this.pu.btnGuardar.addActionListener(this);
		this.pu.txtNombre.addKeyListener(this);
		this.pu.txtDireccion.addKeyListener(this);
		this.pu.txtDocumento.addKeyListener(this);
		this.pu.txtTelefono.addKeyListener(this);
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
		if(e.getSource().equals(pu.txtNombre)) {
			if (Validaciones.vacio(pu.txtNombre.getText())) {
				pu.lblErrorNombre.setVisible(true);
				pu.lblErrorNombre.setText("CAMPO VACIO");
			}else if(Validaciones.SoloLetras(pu.txtNombre.getText())) {
				pu.lblErrorNombre.setVisible(true);
				pu.lblErrorNombre.setText("NUMEROS NO PERMITIDOS");
			}else {
				pu.lblErrorNombre.setVisible(false);
			}
		}
		if(e.getSource().equals(pu.txtTelefono)) {
			if(Validaciones.SoloNum(pu.txtTelefono.getText())) {
					pu.lblErrorTelefono.setVisible(true);
					pu.lblErrorTelefono.setText("LETRAS NO PERMITIDAS");
				}else if(Validaciones.CantidadTelefono(pu.txtTelefono.getText())) {
					pu.lblErrorTelefono.setVisible(true);
					pu.lblErrorTelefono.setText("TAMAÑO DE TELEFONO INCORRECTO");
				}else {
					pu.lblErrorTelefono.setVisible(false);
				}
		}
		if(e.getSource().equals(pu.txtDocumento)) {
			
		if(Validaciones.vacio(pu.txtDocumento.getText())) {
			pu.lblErrorDocumento.setVisible(true);
			pu.lblErrorDocumento.setText("CAMPO VACIO");
		}else if(Validaciones.SoloNum(pu.txtDocumento.getText())) {
			pu.lblErrorDocumento.setVisible(true);
			pu.lblErrorDocumento.setText("NO SE PERMITEN LETRAS");
		}else if(Validaciones.CantidadCedula(pu.txtDocumento.getText())) {
			pu.lblErrorDocumento.setVisible(true);
			pu.lblErrorDocumento.setText("TAMAÑO DE DOCUMENTO NO PERMITIDO");
		}else {
			pu.lblErrorDocumento.setVisible(false);
	}
	}
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
			if (Validaciones.vacio(pu.txtNombre.getText())) {
				pu.lblErrorNombre.setVisible(true);
				pu.lblErrorNombre.setText("CAMPO VACIO");
			}else if(Validaciones.SoloLetras(pu.txtNombre.getText())) {
				pu.lblErrorNombre.setVisible(true);
				pu.lblErrorNombre.setText("NUMEROS NO PERMITIDOS");}
			else if(!Validaciones.vacio(pu.txtDocumento.getText())&&(Validaciones.SoloNum(pu.txtDocumento.getText())||Validaciones.CantidadCedula(pu.txtDocumento.getText()))) {
				pu.lblErrorDocumento.setVisible(true);
				pu.lblErrorDocumento.setText("DOCUMENTO INCORRECTO");}
			else if(!Validaciones.vacio(pu.txtTelefono.getText())&& (Validaciones.SoloNum(pu.txtTelefono.getText())||Validaciones.CantidadTelefono(pu.txtTelefono.getText()))) {
					pu.lblErrorTelefono.setVisible(true);
					pu.lblErrorTelefono.setText("TELEFONO INCORRECTO");
			}else {
			if (consulta.EditarUsuario(usuario)> 0) {
				consulta.Monitorias(a.lbl_IdUser.getText(), "12", usuario.getNombre());
				JOptionPane.showMessageDialog(null, "USUARIO EDITADO CON EXITO");
			}
			CargarDatos();
			CargarDepartamentos();
			}
		}
	}
}
