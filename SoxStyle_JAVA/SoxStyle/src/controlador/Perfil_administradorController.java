package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class Perfil_administradorController implements ActionListener, MouseListener, KeyListener{

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
		this.PA.txtNombre.addKeyListener(this);
		this.PA.txtDireccion.addKeyListener(this);
		this.PA.txtDocumento.addKeyListener(this);
		this.PA.txtTelefono.addKeyListener(this);
		this.PA.txtContrasenaA.addKeyListener(this);
		this.PA.txtContrasenaN.addKeyListener(this);
		this.PA.txtContrasenaC.addKeyListener(this);
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
			if (Validaciones.vacio(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("CAMPO VACIO");
			}else if(Validaciones.SoloLetras(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("NUMEROS NO PERMITIDOS");}
				else if(!Validaciones.vacio(PA.txtDocumento.getText())&&(Validaciones.SoloNum(PA.txtDocumento.getText())||Validaciones.CantidadCedula(PA.txtDocumento.getText()))) {
					PA.lblErrorDocumento.setVisible(true);
					PA.lblErrorDocumento.setText("DOCUMENTO INCORRECTO");}
				else if(!Validaciones.vacio(PA.txtTelefono.getText())&& (Validaciones.SoloNum(PA.txtTelefono.getText())||Validaciones.CantidadTelefono(PA.txtTelefono.getText()))) {
						PA.lblErrorTelefono.setVisible(true);
						PA.lblErrorTelefono.setText("TELEFONO INCORRECTO");
				}else {
			if (consulta.EditarUsuario(usuario)> 0) {
				JOptionPane.showMessageDialog(null, "USUARIO EDITADO CON EXITO");
			}
			CargarDatos();
			CargarDepartamentos();
			}
		}
		
		if (e.getSource().equals(PA.btnCambiarContrasena)) {
			
			String contrasenaActual = String.valueOf(PA.txtContrasenaA.getPassword());
			String contrasenaNueva = String.valueOf(PA.txtContrasenaN.getPassword());
			String contrasenaConfirmar = String.valueOf(PA.txtContrasenaC.getPassword());
			
			if (contrasenaNueva.equals(contrasenaConfirmar)) {
				if(Validaciones.vacio(contrasenaNueva)) {
					PA.lblErrorCNueva.setVisible(true);
					PA.lblErrorCNueva.setText("CAMPO VACIO");
				}
				else
					if(Validaciones.ValidarContraseña(contrasenaNueva)) {
						PA.lblErrorCNueva.setVisible(true);
						PA.lblErrorCNueva.setText("CONTRASEÑA NO VALIDA");
		
		}else 
			if (Validaciones.Cantidadcontraseña(contrasenaNueva)) {
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCNueva.setText("LA CONTRASEÑA DEBE SER ENTRE 8 Y 11 CARACTERES");
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
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCConfirmar.setVisible(true);
				PA.lblErrorCConfirmar.setText("NO COINCIDEN");
				PA.lblErrorCNueva.setText("NO COINCIDEN");
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
		if(e.getSource().equals(PA.txtNombre)) {
			if (Validaciones.vacio(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("CAMPO VACIO");
			}else if(Validaciones.SoloLetras(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("NUMEROS NO PERMITIDOS");
			}else {
				PA.lblErrorNombre.setVisible(false);
			}
		}
		if(e.getSource().equals(PA.txtTelefono)) {
			 if(Validaciones.SoloNum(PA.txtTelefono.getText())) {
					PA.lblErrorTelefono.setVisible(true);
					PA.lblErrorTelefono.setText("LETRAS NO PERMITIDAS");
				}else if(Validaciones.CantidadTelefono(PA.txtTelefono.getText())) {
					PA.lblErrorTelefono.setVisible(true);
					PA.lblErrorTelefono.setText("TAMAÑO DE TELEFONO INCORRECTO");
				}else {
					PA.lblErrorTelefono.setVisible(false);
				}
		}
		if(e.getSource().equals(PA.txtDocumento)) {
			
		if(Validaciones.vacio(PA.txtDocumento.getText())) {
			PA.lblErrorDocumento.setVisible(true);
			PA.lblErrorDocumento.setText("CAMPO VACIO");
		}else if(Validaciones.SoloNum(PA.txtDocumento.getText())) {
			PA.lblErrorDocumento.setVisible(true);
			PA.lblErrorDocumento.setText("NO SE PERMITEN LETRAS");
		}else if(Validaciones.CantidadCedula(PA.txtDocumento.getText())) {
			PA.lblErrorDocumento.setVisible(true);
			PA.lblErrorDocumento.setText("TAMAÑO DE DOCUMENTO NO PERMITIDO");
		}else {
			PA.lblErrorDocumento.setVisible(false);
	}
	}
		
		if(e.getSource().equals(PA.txtContrasenaN)) {
			
			if(Validaciones.vacio(String.valueOf(PA.txtContrasenaN.getPassword()))) {
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCNueva.setText("CAMPO VACIO");
			}
			else
				if(Validaciones.ValidarContraseña(String.valueOf(PA.txtContrasenaN.getPassword()))) {
					PA.lblErrorCNueva.setVisible(true);
					PA.lblErrorCNueva.setText("CONTRASEÑA NO VALIDA");
	
				}else 
					if (Validaciones.Cantidadcontraseña(String.valueOf(PA.txtContrasenaN.getPassword()))){
						PA.lblErrorCNueva.setVisible(true);
						PA.lblErrorCNueva.setText("LA CONTRASEÑA DEBE SER ENTRE 8 Y 11 CARACTERES");
					}else{
						PA.lblErrorCNueva.setVisible(false);
					}
			
			if(!String.valueOf(PA.txtContrasenaN.getPassword()).equals(String.valueOf(PA.txtContrasenaC.getPassword()))){
						PA.lblErrorCNueva.setVisible(true);
						PA.lblErrorCConfirmar.setVisible(true);
						PA.lblErrorCConfirmar.setText("NO COINCIDEN");
						PA.lblErrorCNueva.setText("NO COINCIDEN");
					}else {
						PA.lblErrorCNueva.setVisible(false);
						PA.lblErrorCConfirmar.setVisible(false);
					}
		}
	if(e.getSource().equals(PA.txtContrasenaC)) {
			
			if(Validaciones.vacio(String.valueOf(PA.txtContrasenaC.getPassword()))) {
				PA.lblErrorCConfirmar.setVisible(true);
				PA.lblErrorCConfirmar.setText("CAMPO VACIO");
			}
			else
				if(Validaciones.ValidarContraseña(String.valueOf(PA.txtContrasenaC.getPassword()))) {
					PA.lblErrorCConfirmar.setVisible(true);
					PA.lblErrorCConfirmar.setText("CONTRASEÑA NO VALIDA");
	
				}else 
					if (Validaciones.Cantidadcontraseña(String.valueOf(PA.txtContrasenaC.getPassword()))){
						PA.lblErrorCConfirmar.setVisible(true);
						PA.lblErrorCConfirmar.setText("LA CONTRASEÑA DEBE SER ENTRE 8 Y 11 CARACTERES");
					}else {
						PA.lblErrorCConfirmar.setVisible(false);
					}
			
			if(!String.valueOf(PA.txtContrasenaN.getPassword()).equals(String.valueOf(PA.txtContrasenaC.getPassword()))){
						PA.lblErrorCNueva.setVisible(true);
						PA.lblErrorCConfirmar.setVisible(true);
						PA.lblErrorCConfirmar.setText("NO COINCIDEN");
						PA.lblErrorCNueva.setText("NO COINCIDEN");
					}else {
						PA.lblErrorCNueva.setVisible(false);
						PA.lblErrorCConfirmar.setVisible(false);
					}
		}
		
		}
}
