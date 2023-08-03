/**
 * CONTROLADOR PARA LA VENTANA DE PERFILES DE ADMINISTRADOR.
 * SE ENCARGA DE MANEJAR LOS EVENTOS DE ACCIÓN, CLIC DEL MOUSE Y TECLAS.
 * REALIZA ACCIONES COMO CAMBIAR CONTRASEÑA, GUARDAR DATOS, CARGAR INFORMACIÓN DEL USUARIO Y DEPARTAMENTOS.
 */
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

public class Perfil_administradorController implements ActionListener, MouseListener, KeyListener {

	Perfil_administrador PA = new Perfil_administrador();
	Administrador a;
	Consultas consulta = new Consultas();
	Usuario usuario = new Usuario();
	Ayudas ayuda = new Ayudas();

	/**
	 * CONSTRUCTOR DE LA CLASE Perfil_administradorController.
	 * RECIBE COMO PARÁMETROS LA VENTANA DE Perfil_administrador Y LA VENTANA DE_Administrador.
	 * ASIGNA EVENTOS A LOS BOTONES Y CAMPOS DE TEXTO DE LA VENTANA DE Perfil_administrador.
	 * CARGA LOS DATOS DEL USUARIO LOGUEADO Y LOS DEPARTAMENTOS DISPONIBLES.
	 * @param PA VENTANA DE Perfil_administrador.
	 * @param a VENTANA DE_Administrador.
	 */
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

	/**
	 * CARGA LOS DATOS DEL USUARIO LOGUEADO EN LA VENTANA DE Perfil_administrador.
	 */
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

	/**
	 * CARGA LOS DEPARTAMENTOS DISPONIBLES EN EL COMBOBOX DEPARTAMENTO EN LA VENTANA DE Perfil_administrador.
	 */
	public void CargarDepartamentos() {
		consulta.CargarDepartamentos(PA.cbxDepartamento);
	}

	/**
	 * CARGA LAS CIUDADES CORRESPONDIENTES AL DEPARTAMENTO SELECCIONADO EN EL COMBOBOX CIUDAD.
	 * @param departamento NOMBRE DEL DEPARTAMENTO SELECCIONADO.
	 */
	public void CargarCiudades(String departamento) {
		consulta.CargarCiudades(PA.cbxCiudad, departamento);
	}

	// MÉTODOS DE LAS INTERFACES ActionListener, MouseListener y KeyListener.
	// IMPLEMENTARLOS SEGÚN LAS NECESIDADES DEL PROGRAMA.
	
	@Override
	/**
	 * MANEJA LOS EVENTOS DE ACCIÓN REALIZADOS EN LA VENTANA DE Perfil_administrador.
	 * COMPRUEBA EL COMPONENTE FUENTE DEL EVENTO PARA DETERMINAR LA ACCIÓN A REALIZAR.
	 * REALIZA ACCIONES COMO CARGAR CIUDADES SEGÚN EL DEPARTAMENTO SELECCIONADO,
	 * GUARDAR LOS DATOS EDITADOS DEL USUARIO Y CAMBIAR LA CONTRASEÑA DEL USUARIO.
	 * @param e OBJETO ACTIONEVENT QUE CONTIENE INFORMACIÓN SOBRE EL EVENTO DE ACCIÓN.
	 */
	public void actionPerformed(ActionEvent e) {
		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL COMBOBOX DEPARTAMENTO.
		if(e.getSource().equals(PA.cbxDepartamento)) {
			// CARGAR LAS CIUDADES SEGÚN EL DEPARTAMENTO SELECCIONADO.
			CargarCiudades(String.valueOf(PA.cbxDepartamento.getSelectedItem()));
		}

		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL BOTÓN 'GUARDAR'.
		if(e.getSource().equals(PA.btnGuardar)) {
			// OBTENER LOS DATOS INGRESADOS POR EL USUARIO EN LOS CAMPOS DE TEXTO.
			usuario.setNombre(PA.txtNombre.getText());
			usuario.setTelefono(PA.txtTelefono.getText());
			usuario.setCedula(PA.txtDocumento.getText());
			usuario.setDireccion(PA.txtDireccion.getText());
			usuario.setCiudad(String.valueOf(PA.cbxCiudad.getSelectedItem()));
			consulta.TraerIdCiudad(usuario);

			// REALIZAR VALIDACIONES Y GUARDAR LOS DATOS EDITADOS DEL USUARIO.
			if (Validaciones.vacio(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("CAMPO VACIO");
			} else if (Validaciones.SoloLetras(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("NUMEROS NO PERMITIDOS");
			} else if (!Validaciones.vacio(PA.txtDocumento.getText()) && 
					   (Validaciones.SoloNum(PA.txtDocumento.getText()) || Validaciones.CantidadCedula(PA.txtDocumento.getText()))) {
				PA.lblErrorDocumento.setVisible(true);
				PA.lblErrorDocumento.setText("DOCUMENTO INCORRECTO");
			} else if (!Validaciones.vacio(PA.txtTelefono.getText()) && 
					   (Validaciones.SoloNum(PA.txtTelefono.getText()) || Validaciones.CantidadTelefono(PA.txtTelefono.getText()))) {
				PA.lblErrorTelefono.setVisible(true);
				PA.lblErrorTelefono.setText("TELEFONO INCORRECTO");
			} else {
				// SI LAS VALIDACIONES SON EXITOSAS, EDITAR EL USUARIO Y MOSTRAR MENSAJE DE ÉXITO.
				if (consulta.EditarUsuario(usuario) > 0) {
					JOptionPane.showMessageDialog(null, "USUARIO EDITADO CON ÉXITO");
					CargarDatos();
					CargarDepartamentos();
				}
			}
		}

		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL BOTÓN 'CAMBIAR CONTRASEÑA'.
		if (e.getSource().equals(PA.btnCambiarContrasena)) {
			// OBTENER LAS CONTRASEÑAS INGRESADAS POR EL USUARIO.
			String contrasenaActual = String.valueOf(PA.txtContrasenaA.getPassword());
			String contrasenaNueva = String.valueOf(PA.txtContrasenaN.getPassword());
			String contrasenaConfirmar = String.valueOf(PA.txtContrasenaC.getPassword());

			// COMPROBAR SI LAS CONTRASEÑAS NUEVA Y CONFIRMADA COINCIDEN.
			if (contrasenaNueva.equals(contrasenaConfirmar)) {
				if (Validaciones.vacio(contrasenaNueva)) {
					PA.lblErrorCNueva.setVisible(true);
					PA.lblErrorCNueva.setText("CAMPO VACIO");
				} else if (Validaciones.ValidarContraseña(contrasenaNueva)) {
					PA.lblErrorCNueva.setVisible(true);
					PA.lblErrorCNueva.setText("CONTRASEÑA NO VÁLIDA");
				} else if (Validaciones.Cantidadcontraseña(contrasenaNueva)) {
					PA.lblErrorCNueva.setVisible(true);
					PA.lblErrorCNueva.setText("LA CONTRASEÑA DEBE SER ENTRE 8 Y 11 CARACTERES");
				} else {
					try {
						// DESCIFRAR LA CONTRASEÑA ACTUAL DEL USUARIO Y CAMBIARLA POR LA NUEVA.
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
						// EN CASO DE ERROR, MOSTRAR MENSAJE DE CONTRASEÑA ACTUAL INCORRECTA.
						JOptionPane.showMessageDialog(null, "LA CONTRASEÑA ACTUAL NO COINCIDE CON EL USUARIO");
					}
				}
			} else {
				// SI LAS CONTRASEÑAS NUEVA Y CONFIRMADA NO COINCIDEN, MOSTRAR MENSAJES DE ERROR.
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
	/**
	 * MANEJA LOS EVENTOS CUANDO SE SUELTA UNA TECLA EN LOS CAMPOS DE TEXTO EN LA VENTANA DE Perfil_administrador.
	 * COMPRUEBA EL COMPONENTE FUENTE DEL EVENTO PARA DETERMINAR LA ACCIÓN A REALIZAR.
	 * REALIZA VALIDACIONES SEGÚN EL CAMPO DE TEXTO Y MUESTRA/OCULTA LOS MENSAJES DE ERROR CORRESPONDIENTES.
	 * @param e OBJETO KEYEVENT QUE CONTIENE INFORMACIÓN SOBRE EL EVENTO DE SOLTAR UNA TECLA.
	 */
	public void keyReleased(KeyEvent e) {
		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL CAMPO DE TEXTO 'NOMBRE'.
		if(e.getSource().equals(PA.txtNombre)) {
			// REALIZAR VALIDACIONES SOBRE EL NOMBRE INGRESADO.
			if (Validaciones.vacio(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("CAMPO VACIO");
			} else if (Validaciones.SoloLetras(PA.txtNombre.getText())) {
				PA.lblErrorNombre.setVisible(true);
				PA.lblErrorNombre.setText("NUMEROS NO PERMITIDOS");
			} else {
				PA.lblErrorNombre.setVisible(false);
			}
		}

		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL CAMPO DE TEXTO 'TELEFONO'.
		if(e.getSource().equals(PA.txtTelefono)) {
			// REALIZAR VALIDACIONES SOBRE EL TELEFONO INGRESADO.
			if(Validaciones.SoloNum(PA.txtTelefono.getText())) {
				PA.lblErrorTelefono.setVisible(true);
				PA.lblErrorTelefono.setText("LETRAS NO PERMITIDAS");
			} else if(Validaciones.CantidadTelefono(PA.txtTelefono.getText())) {
				PA.lblErrorTelefono.setVisible(true);
				PA.lblErrorTelefono.setText("TAMAÑO DE TELEFONO INCORRECTO");
			} else {
				PA.lblErrorTelefono.setVisible(false);
			}
		}

		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL CAMPO DE TEXTO 'DOCUMENTO'.
		if(e.getSource().equals(PA.txtDocumento)) {
			// REALIZAR VALIDACIONES SOBRE EL DOCUMENTO INGRESADO.
			if(Validaciones.vacio(PA.txtDocumento.getText())) {
				PA.lblErrorDocumento.setVisible(true);
				PA.lblErrorDocumento.setText("CAMPO VACIO");
			} else if(Validaciones.SoloNum(PA.txtDocumento.getText())) {
				PA.lblErrorDocumento.setVisible(true);
				PA.lblErrorDocumento.setText("NO SE PERMITEN LETRAS");
			} else if(Validaciones.CantidadCedula(PA.txtDocumento.getText())) {
				PA.lblErrorDocumento.setVisible(true);
				PA.lblErrorDocumento.setText("TAMAÑO DE DOCUMENTO NO PERMITIDO");
			} else {
				PA.lblErrorDocumento.setVisible(false);
			}
		}

		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL CAMPO DE TEXTO 'CONTRASENANUEVA'.
		if(e.getSource().equals(PA.txtContrasenaN)) {
			// REALIZAR VALIDACIONES SOBRE LA CONTRASEÑA NUEVA INGRESADA.
			if(Validaciones.vacio(String.valueOf(PA.txtContrasenaN.getPassword()))) {
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCNueva.setText("CAMPO VACIO");
			} else if(Validaciones.ValidarContraseña(String.valueOf(PA.txtContrasenaN.getPassword()))) {
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCNueva.setText("CONTRASEÑA NO VALIDA");
			} else if (Validaciones.Cantidadcontraseña(String.valueOf(PA.txtContrasenaN.getPassword()))){
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCNueva.setText("LA CONTRASEÑA DEBE SER ENTRE 8 Y 11 CARACTERES");
			} else{
				PA.lblErrorCNueva.setVisible(false);
			}

			// COMPROBAR SI LAS CONTRASEÑAS NUEVA Y CONFIRMADA COINCIDEN.
			if(!String.valueOf(PA.txtContrasenaN.getPassword()).equals(String.valueOf(PA.txtContrasenaC.getPassword()))){
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCConfirmar.setVisible(true);
				PA.lblErrorCConfirmar.setText("NO COINCIDEN");
				PA.lblErrorCNueva.setText("NO COINCIDEN");
			} else {
				PA.lblErrorCNueva.setVisible(false);
				PA.lblErrorCConfirmar.setVisible(false);
			}
		}

		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL CAMPO DE TEXTO 'CONTRASENACONFIRMAR'.
		if(e.getSource().equals(PA.txtContrasenaC)) {
			// REALIZAR VALIDACIONES SOBRE LA CONTRASEÑA DE CONFIRMACIÓN INGRESADA.
			if(Validaciones.vacio(String.valueOf(PA.txtContrasenaC.getPassword()))) {
				PA.lblErrorCConfirmar.setVisible(true);
				PA.lblErrorCConfirmar.setText("CAMPO VACIO");
			} else if(Validaciones.ValidarContraseña(String.valueOf(PA.txtContrasenaC.getPassword()))) {
				PA.lblErrorCConfirmar.setVisible(true);
				PA.lblErrorCConfirmar.setText("CONTRASEÑA NO VALIDA");
			} else if (Validaciones.Cantidadcontraseña(String.valueOf(PA.txtContrasenaC.getPassword()))){
				PA.lblErrorCConfirmar.setVisible(true);
				PA.lblErrorCConfirmar.setText("LA CONTRASEÑA DEBE SER ENTRE 8 Y 11 CARACTERES");
			} else {
				PA.lblErrorCConfirmar.setVisible(false);
			}

			// COMPROBAR SI LAS CONTRASEÑAS NUEVA Y CONFIRMADA COINCIDEN.
			if(!String.valueOf(PA.txtContrasenaN.getPassword()).equals(String.valueOf(PA.txtContrasenaC.getPassword()))){
				PA.lblErrorCNueva.setVisible(true);
				PA.lblErrorCConfirmar.setVisible(true);
				PA.lblErrorCConfirmar.setText("NO COINCIDEN");
				PA.lblErrorCNueva.setText("NO COINCIDEN");
			} else {
				PA.lblErrorCNueva.setVisible(false);
				PA.lblErrorCConfirmar.setVisible(false);
			}
		}
	}

}
