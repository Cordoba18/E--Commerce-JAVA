

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
import vista.Login;
import vista.Registrarse;

public class RegistrarseController implements MouseListener, KeyListener, ActionListener {
	
	Registrarse R;
	
	// CONSTRUCTOR DE LA CLASE REGISTRARSECONTROLLER QUE RECIBE UN OBJETO REGISTRARSE COMO PARÁMETRO.
	public RegistrarseController(Registrarse R) {
		// ASIGNA EL OBJETO REGISTRARSE RECIBIDO COMO PARÁMETRO A LA VARIABLE MIEMBRO R.
		this.R = R;

		// AGREGA EL CONTROLADOR DE EVENTOS ACTIONLISTENER AL BOTÓN 'BTNCREAR' DEL OBJETO REGISTRARSE R.
		this.R.btnCrear.addActionListener(this);

		// AGREGA EL CONTROLADOR DE EVENTOS KEYLISTENER AL CAMPO DE TEXTO 'TXTCEDULA' DEL OBJETO REGISTRARSE R.
		this.R.txtCedula.addKeyListener(this);

		// AGREGA EL CONTROLADOR DE EVENTOS KEYLISTENER AL CAMPO DE TEXTO 'TXTCONTRASEÑA' DEL OBJETO REGISTRARSE R.
		this.R.txtContraseña.addKeyListener(this);

		// AGREGA EL CONTROLADOR DE EVENTOS KEYLISTENER AL CAMPO DE TEXTO 'TXTCORREO' DEL OBJETO REGISTRARSE R.
		this.R.txtCorreo.addKeyListener(this);

		// AGREGA EL CONTROLADOR DE EVENTOS KEYLISTENER AL CAMPO DE TEXTO 'TXTNOMBRE' DEL OBJETO REGISTRARSE R.
		this.R.txtNombre.addKeyListener(this);

		// AGREGA EL CONTROLADOR DE EVENTOS KEYLISTENER AL CAMPO DE TEXTO 'TXTTELEFONO' DEL OBJETO REGISTRARSE R.
		this.R.txtTelefono.addKeyListener(this);

		// AGREGA EL CONTROLADOR DE EVENTOS MOUSELISTENER AL LABEL 'LBLYATENGOCUENTA' DEL OBJETO REGISTRARSE R.
		this.R.lblYatengocuenta.addMouseListener(this);

		// LLAMA AL MÉTODO PRIVADO 'INICIAR' PARA MOSTRAR LA VENTANA REGISTRARSE.
		Iniciar();
	}

	// MÉTODO PRIVADO QUE SE LLAMA DESDE EL CONSTRUCTOR PARA MOSTRAR LA VENTANA REGISTRARSE.
	private void Iniciar() {
		R.setVisible(true);
		R.setTitle("CREA TÚ CUENTA");
	}







	@Override
	/**
	 * MANEJA LOS EVENTOS DE ACCIÓN QUE OCURREN EN LA INTERFAZ DE REGISTRO.
	 * COMPRUEBA SI EL EVENTO PROVIENE DEL BOTÓN 'BTNCREAR' Y LUEGO REALIZA LAS VALIDACIONES DE LOS CAMPOS.
	 * SI TODAS LAS VALIDACIONES SON EXITOSAS, CREA UN NUEVO OBJETO DE USUARIO, LO ALMACENA EN LA BASE DE DATOS
	 * Y MUESTRA UN MENSAJE DE ÉXITO. SI EL USUARIO YA EXISTE, MUESTRA UN MENSAJE DE ERROR.
	 * @param e OBJETO ACTIONEVENT QUE CONTIENE INFORMACIÓN SOBRE EL EVENTO DE ACCIÓN.
	 */

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(R.btnCrear)) {
			// OBTENER LOS VALORES INGRESADOS POR EL USUARIO EN LOS CAMPOS DE TEXTO.
			String cedula = R.txtCedula.getText();
			String nombre = R.txtNombre.getText();
			String telefono = R.txtTelefono.getText();
			String correo = R.txtCorreo.getText();
			String contrasena = R.txtContraseña.getText();
			Ayudas ayuda = new Ayudas(); // CREAR UN OBJETO DE LA CLASE AYUDAS PARA FUNCIONES DE APOYO.
			Usuario u = new Usuario(); // CREAR UN NUEVO OBJETO DE USUARIO PARA ALMACENAR LOS DATOS INGRESADOS.

			// REALIZAR VALIDACIONES EN LOS CAMPOS DE TEXTO Y MOSTRAR MENSAJES DE ERROR CORRESPONDIENTES.
			if(Validaciones.vacio(nombre)) {
				R.lblErrorNombre.setVisible(true);
				R.lblErrorNombre.setText("Campo vacio");
			} else if(Validaciones.SoloLetras(nombre)) {
				R.lblErrorNombre.setVisible(true);
				R.lblErrorNombre.setText("No se permiten números ni caracteres especiales");
			} else if(Validaciones.vacio(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("Campo vacio");
			} else if(Validaciones.SoloNum(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("No se permiten letras");
			} else if(Validaciones.CantidadCedula(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("Cantidad no válida");
			} else if(Validaciones.vacio(telefono)) {
				R.lblErrorTelefono.setVisible(true);
				R.lblErrorTelefono.setText("Campo vacio");
			} else if(Validaciones.SoloNum(telefono)) {
				R.lblErrorTelefono.setVisible(true);
				R.lblErrorTelefono.setText("No se permiten letras");
			} else if(Validaciones.CantidadTelefono(telefono)) {
				R.lblErrorTelefono.setVisible(true);
				R.lblErrorTelefono.setText("Cantidad no válida");
			} else if(Validaciones.vacio(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("Campo vacio");
			} else if(Validaciones.ValidarCorreo(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("Formato de correo no válido");
			} else if (Validaciones.CantidadCorreo(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("El correo es muy largo");
			} else if(Validaciones.vacio(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("Campo vacio");
			} else if(Validaciones.ValidarContraseña(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("Contraseña no válida");
			} else if (Validaciones.Cantidadcontraseña(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("La contraseña debe tener entre 8 y 10 caracteres");
			} else {
				// SI TODAS LAS VALIDACIONES SON EXITOSAS, CONFIGURAR LOS DATOS DEL OBJETO USUARIO.
				u.setCedula(cedula);
				u.setNombre(nombre);
				u.setTelefono(telefono);
				u.setCorreo(correo);
				try {
					u.setContrasena(ayuda.Cifra(contrasena)); // CIFRAR LA CONTRASEÑA ANTES DE ALMACENARLA.
				} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
						| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e1) {
					e1.printStackTrace();
				}
				
				// OCULTAR MENSAJES DE ERROR.
				R.lblErrorCedula.setVisible(false);
				R.lblErrorContraseña.setVisible(false);
				R.lblErrorCorreo.setVisible(false);
				R.lblErrorNombre.setVisible(false);
				R.lblErrorTelefono.setVisible(false);
				
				Consultas consulta = new Consultas(); // CREAR OBJETO DE LA CLASE CONSULTAS PARA INTERACTUAR CON LA BASE DE DATOS.

				// CONSULTAR SI EL USUARIO YA EXISTE EN LA BASE DE DATOS.
				if(!consulta.ConsultarUsuario(u)) {
					// SI EL USUARIO NO EXISTE, INSERTARLO EN LA BASE DE DATOS.
					if(consulta.InsertarUsuario(u)) {
						consulta.ConsultarUsuario(u); // CONSULTAR AL USUARIO RECIENTEMENTE INSERTADO PARA OBTENER SU ID.
						consulta.Monitorias(String.valueOf(u.getId()), "14", u.getCorreo()); // REALIZAR ALGUNA ACCIÓN ADICIONAL (EN ESTE CASO, PARECE ESTAR RELACIONADA CON MONITORIAS).
						JOptionPane.showMessageDialog(null, "USUARIO CREADO CON ÉXITO");
						R.dispose(); // CERRAR LA VENTANA DE REGISTRO.
						Login l = new Login(); // CREAR UNA NUEVA INSTANCIA DE LA CLASE LOGIN PARA MOSTRAR LA VENTANA DE INICIO DE SESIÓN.
						new LoginController(l); // INICIAR EL CONTROLADOR DE LA VENTANA DE INICIO DE SESIÓN.
					}
				} else {
					JOptionPane.showMessageDialog(null, "ESE USUARIO YA EXISTE");
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
	/**
	 * MANEJA LOS EVENTOS DE TECLA LIBERADA EN LOS CAMPOS DE TEXTO.
	 * COMPRUEBA EL CAMPO DE TEXTO FUENTE Y REALIZA LAS VALIDACIONES CORRESPONDIENTES.
	 * SI LAS VALIDACIONES SON EXITOSAS, OCULTA LOS MENSAJES DE ERROR RESPECTIVOS.
	 * @param e OBJETO KEYEVENT QUE CONTIENE INFORMACIÓN SOBRE EL EVENTO DE TECLA LIBERADA.
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(R.txtCedula)) {
			// OBTENER EL TEXTO INGRESADO EN EL CAMPO DE CÉDULA.
			String cedula = R.txtCedula.getText();
			if(Validaciones.vacio(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("Campo vacio");
			}else if(Validaciones.SoloNum(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("No se permiten letras");
			}else if(Validaciones.CantidadCedula(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("Cantidad no válida");
			}else {
				// SI LAS VALIDACIONES SON EXITOSAS, OCULTAR EL MENSAJE DE ERROR DE CÉDULA.
				R.lblErrorCedula.setVisible(false);
			}
		}
		
		if(e.getSource().equals(R.txtNombre)) {
			// OBTENER EL TEXTO INGRESADO EN EL CAMPO DE NOMBRE.
			String nombre = R.txtNombre.getText();
			if(Validaciones.vacio(nombre)) {
				R.lblErrorNombre.setVisible(true);
				R.lblErrorNombre.setText("Campo vacio");
			}else if(Validaciones.SoloLetras(nombre)) {
				R.lblErrorNombre.setVisible(true);
				R.lblErrorNombre.setText("No se permiten números ni caracteres especiales");
			}else {
				// SI LAS VALIDACIONES SON EXITOSAS, OCULTAR EL MENSAJE DE ERROR DE NOMBRE.
				R.lblErrorNombre.setVisible(false);
			}
		}
		
		if(e.getSource().equals(R.txtTelefono)) {
			// OBTENER EL TEXTO INGRESADO EN EL CAMPO DE TELÉFONO.
			String telefono = R.txtTelefono.getText();
			if(Validaciones.vacio(telefono)) {
				R.lblErrorTelefono.setVisible(true);
				R.lblErrorTelefono.setText("Campo vacio");
			}else if(Validaciones.SoloNum(telefono)) {
				R.lblErrorTelefono.setVisible(true);
				R.lblErrorTelefono.setText("No se permiten letras");
			}else if(Validaciones.CantidadTelefono(telefono)) {
				R.lblErrorTelefono.setVisible(true);
				R.lblErrorTelefono.setText("Cantidad no válida");
			}else {
				// SI LAS VALIDACIONES SON EXITOSAS, OCULTAR EL MENSAJE DE ERROR DE TELÉFONO.
				R.lblErrorTelefono.setVisible(false);
			}
		}
		
		if(e.getSource().equals(R.txtCorreo)) {
			// OBTENER EL TEXTO INGRESADO EN EL CAMPO DE CORREO.
			String correo = R.txtCorreo.getText();
			if(Validaciones.vacio(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("Campo vacio");
			}else if(Validaciones.ValidarCorreo(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("Formato de correo no válido");
			}else if (Validaciones.CantidadCorreo(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("El correo es muy largo");
			}else {
				// SI LAS VALIDACIONES SON EXITOSAS, OCULTAR EL MENSAJE DE ERROR DE CORREO.
				R.lblErrorCorreo.setVisible(false);
			}
		}
		
		if(e.getSource().equals(R.txtContraseña)) {
			// OBTENER EL TEXTO INGRESADO EN EL CAMPO DE CONTRASEÑA.
			String contrasena = R.txtContraseña.getText();
			if(Validaciones.vacio(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("Campo vacio");
			}else if(Validaciones.ValidarContraseña(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("Contraseña no válida");
			}else if (Validaciones.Cantidadcontraseña(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("La contraseña debe ser 8-10 Caracteres");
			}else {
				// SI LAS VALIDACIONES SON EXITOSAS, OCULTAR EL MENSAJE DE ERROR DE CONTRASEÑA.
				R.lblErrorContraseña.setVisible(false);
			}
		}
	}




	@Override


	/**
	 * MANEJA LOS EVENTOS DE CLIC DEL MOUSE.
	 * COMPRUEBA EL COMPONENTE FUENTE DEL EVENTO PARA DETERMINAR LA ACCIÓN A REALIZAR.
	 * SI EL COMPONENTE FUENTE ES EL LABEL 'LBLYATENGOCUENTA', CIERRA LA VENTANA ACTUAL DE REGISTRO
	 * Y ABRE LA VENTANA DE INICIO DE SESIÓN.
	 * @param e OBJETO MOUSEEVENT QUE CONTIENE INFORMACIÓN SOBRE EL EVENTO DE CLIC DEL MOUSE.
	 */
	public void mouseClicked(MouseEvent e) {
		// COMPROBAR SI EL COMPONENTE FUENTE DEL EVENTO ES EL LABEL 'LBLYATENGOCUENTA'.
		if(e.getSource().equals(R.lblYatengocuenta)) {
			R.dispose(); // CERRAR LA VENTANA ACTUAL DE REGISTRO.
			Login L = new Login(); // CREAR UNA NUEVA INSTANCIA DE LA CLASE LOGIN PARA MOSTRAR LA VENTANA DE INICIO DE SESIÓN.
			new LoginController(L); // INICIAR EL CONTROLADOR DE LA VENTANA DE INICIO DE SESIÓN.
		}
	}






	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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



