package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.Usuario;
import sql.Consultas;
import vista.Administrador;
import vista.Perfil_administrador;

public class Perfil_administradorController implements ActionListener, MouseListener{

	Perfil_administrador PA = new Perfil_administrador();
	Administrador a;
	Consultas consulta = new Consultas();
	Usuario usuario = new Usuario();
	Ayudas ayuda = new Ayudas();
	public Perfil_administradorController(Perfil_administrador PA, Administrador a) {
		this.PA = PA;
		this.a = a;
		this.PA.btnCambiarContrasena.addActionListener(this);
		this.PA.btnGuardar.addActionListener(this);
		this.PA.cbxDepartamento.addActionListener(this);
		CargarDatos();
		CargarDepartamentos();
	}
	
	
	
	public void CargarDatos() {
		String id = a.lbl_IdUser.getText();
		usuario.setId(Integer.parseInt(id));
		consulta.TraerDatosUsuario(usuario);
		PA.txtNombre.setText(usuario.getNombre());
		PA.txtCorreo.setText(usuario.getCorreo());
		PA.txtTelefono.setText(usuario.getTelefono());
		PA.txtDocumento.setText(usuario.getCedula());
		PA.txtDireccion.setText(usuario.getDireccion());
	}

	public void CargarDepartamentos() {
		consulta.CargarDepartamentos(PA.cbxDepartamento);
	}

	public void CargarCiudades(String departamento) {
		consulta.CargarCiudades(PA.cbxCiudad, departamento);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(PA.cbxDepartamento)) {
			CargarCiudades(String.valueOf(PA.cbxDepartamento.getSelectedItem()));
		}
		
		if(e.getSource().equals(PA.btnGuardar)) {
		
			
			usuario.setNombre(PA.txtNombre.getText());
			usuario.setTelefono(PA.txtTelefono.getText());
			usuario.setCedula(PA.txtDocumento.getText());
			usuario.setDireccion(PA.txtDireccion.getText());
			usuario.setCiudad(String.valueOf(PA.cbxCiudad.getSelectedItem()));
			consulta.TraerIdCiudad(usuario);
			if (consulta.EditarUsuario(usuario)> 0) {
				JOptionPane.showMessageDialog(null, "USUARIO EDITADO CON EXITO");
			}
			CargarDatos();
			CargarDepartamentos();
		}
		
		if (e.getSource().equals(PA.btnCambiarContrasena)) {
			
			String contrasenaActual = String.valueOf(PA.txtContrasenaA.getPassword());
			String contrasenaNueva = String.valueOf(PA.txtContrasenaN.getPassword());
			String contrasenaConfirmar = String.valueOf(PA.txtContrasenaC.getPassword());
			
			if (contrasenaNueva.equals(contrasenaConfirmar)) {
				if(Validaciones.vacio(contrasenaNueva)) {
					JOptionPane.showMessageDialog(null,"CONTRASEÑA VACIA");
				}
				else
					if(Validaciones.ValidarContraseña(contrasenaNueva)) {
						JOptionPane.showMessageDialog(null,"CONTRASEÑA NO VALIDA");
		
		}else 
			if (Validaciones.Cantidadcontraseña(contrasenaNueva)) {
			
				JOptionPane.showMessageDialog(null,"LA CONTRASEÑA DEBE SER ENTRE 8 Y 11 CARACTERES");
			}else {
				try {
					ayuda.descifrar(usuario.getContrasena(), contrasenaActual);
					consulta.EditarContraseña(ayuda.Cifra(contrasenaNueva), String.valueOf(usuario.getId()));
					PA.txtContrasenaA.setText("");
					PA.txtContrasenaN.setText("");
					PA.txtContrasenaC.setText("");
					JOptionPane.showMessageDialog(null, "CONTRASEÑA EDITADA");
					CargarDatos();
					CargarDepartamentos();
					
				} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
						| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "LA CONTRASEÑA ACTUAL NO COINCIDE CON EL USUARIO");
				}
			}
				}
			else {
				JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
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
