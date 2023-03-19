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
	public RegistrarseController(Registrarse R) {
		this.R = R;
		this.R.btnCrear.addActionListener(this);
		this.R.txtCedula.addKeyListener(this);
		this.R.txtContraseña.addKeyListener(this);
		this.R.txtCorreo.addKeyListener(this);
		this.R.txtNombre.addKeyListener(this);
		this.R.txtTelefono.addKeyListener(this);
		this.R.lblYatengocuenta.addMouseListener(this);
		Iniciar();
	}
	
	
	
	
	
	private void Iniciar() {
		R.setVisible(true);
		R.setTitle("CREA TÚ CUENTA");
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(R.btnCrear)) {
			
			String cedula = R.txtCedula.getText();
			String nombre = R.txtNombre.getText();
			String telefono = R.txtTelefono.getText();
			String correo = R.txtCorreo.getText();
			String contrasena = R.txtContraseña.getText();
			Ayudas ayuda = new Ayudas();
			Usuario u = new Usuario();
			
			
		
			
			if(Validaciones.vacio(nombre)) {
				R.lblErrorNombre.setVisible(true);
				R.lblErrorNombre.setText("Campo vacio");
			}else 
			if(Validaciones.SoloLetras(nombre)) {
				R.lblErrorNombre.setVisible(true);
				R.lblErrorNombre.setText("No se permiten numeros ni caracteres especiales");
			}else
				if(Validaciones.vacio(cedula)) {
					R.lblErrorCedula.setVisible(true);
					R.lblErrorCedula.setText("Campo vacio");
				}else  
				if(Validaciones.SoloNum(cedula)) {
					R.lblErrorCedula.setVisible(true);
					R.lblErrorCedula.setText("No se permiten letras");
				}else
				if(Validaciones.CantidadCedula(cedula)) {
					R.lblErrorCedula.setVisible(true);
					R.lblErrorCedula.setText("Cantidad no valida");
				}else
					if(Validaciones.vacio(telefono)) {
						R.lblErrorTelefono.setVisible(true);
						R.lblErrorTelefono.setText("Campo vacio");
					}else 
					if(Validaciones.SoloNum(telefono)) {
						R.lblErrorTelefono.setVisible(true);
						R.lblErrorTelefono.setText("No se permiten letras");}
						else
						if(Validaciones.CantidadTelefono(telefono)) {
							R.lblErrorTelefono.setVisible(true);
							R.lblErrorTelefono.setText("Cantidad no valida");}
						else if(Validaciones.vacio(correo)) {
							R.lblErrorCorreo.setVisible(true);
							R.lblErrorCorreo.setText("Campo vacio");
						}else 
						if(Validaciones.ValidarCorreo(correo)) {
							R.lblErrorCorreo.setVisible(true);
							R.lblErrorCorreo.setText("Formato de correo no valido");
						}else 
							if (Validaciones.CantidadCorreo(correo)) {
								R.lblErrorCorreo.setVisible(true);
								R.lblErrorCorreo.setText("El correo es muy largo");
								
							}else 
								if(Validaciones.vacio(contrasena)) {
								R.lblErrorContraseña.setVisible(true);
								R.lblErrorContraseña.setText("Campo vacio");
							}else
							if(Validaciones.ValidarContraseña(contrasena)) {
								R.lblErrorContraseña.setVisible(true);
								R.lblErrorContraseña.setText("Contraseña no valida");
							}else 
								if (Validaciones.Cantidadcontraseña(contrasena)) {
									R.lblErrorContraseña.setVisible(true);
									R.lblErrorContraseña.setText("La contraseña debe ser 8-10 Caracteres");
									
								}else {
									u.setCedula(cedula);
									u.setNombre(nombre);
									u.setTelefono(telefono);
									u.setCorreo(correo);
									try {
										u.setContrasena(ayuda.Cifra(contrasena));
									
//										JOptionPane.showMessageDialog(null, descifrado);
									} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
											| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									R.lblErrorCedula.setVisible(false);
									R.lblErrorContraseña.setVisible(false);
									R.lblErrorCorreo.setVisible(false);
									R.lblErrorNombre.setVisible(false);
									R.lblErrorTelefono.setVisible(false);
//									Consultas consulta = new Consultas();
//									if(!consulta.ConsultarUsuario(u)) {
//										if(consulta.InsertarUsuario(u)) {
//											JOptionPane.showMessageDialog(null, "USUARIO CREADO CON EXITO");
//										}
//										}else {
//											JOptionPane.showMessageDialog(null, "ESE USUARIO YA EXISTE");
//										}
//									}
									
									
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
		if(e.getSource().equals(R.txtCedula)) {
			String cedula = R.txtCedula.getText();
			if(Validaciones.vacio(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("Campo vacio");
			}else  
			if(Validaciones.SoloNum(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("No se permiten letras");
			}else
			if(Validaciones.CantidadCedula(cedula)) {
				R.lblErrorCedula.setVisible(true);
				R.lblErrorCedula.setText("Cantidad no valida");
			}else {
					
					R.lblErrorCedula.setVisible(false);
				}
		}
if(e.getSource().equals(R.txtNombre)) {
	String nombre = R.txtNombre.getText();
	if(Validaciones.vacio(nombre)) {
		R.lblErrorNombre.setVisible(true);
		R.lblErrorNombre.setText("Campo vacio");
	}else 
	if(Validaciones.SoloLetras(nombre)) {
		R.lblErrorNombre.setVisible(true);
		R.lblErrorNombre.setText("No se permiten numeros ni caracteres especiales");
	}else {
			
			R.lblErrorNombre.setVisible(false);
		}
		}
if(e.getSource().equals(R.txtTelefono)) {
	String telefono = R.txtTelefono.getText();
	if(Validaciones.vacio(telefono)) {
		R.lblErrorTelefono.setVisible(true);
		R.lblErrorTelefono.setText("Campo vacio");
	}else 
	if(Validaciones.SoloNum(telefono)) {
		R.lblErrorTelefono.setVisible(true);
		R.lblErrorTelefono.setText("No se permiten letras");}
		else
		if(Validaciones.CantidadTelefono(telefono)) {
			R.lblErrorTelefono.setVisible(true);
			R.lblErrorTelefono.setText("Cantidad no valida");}
		else {
			
			R.lblErrorTelefono.setVisible(false);
		}
}
if(e.getSource().equals(R.txtCorreo)) {
			
			String correo = R.txtCorreo.getText();
			if(Validaciones.vacio(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("Campo vacio");
			}else 
			if(Validaciones.ValidarCorreo(correo)) {
				R.lblErrorCorreo.setVisible(true);
				R.lblErrorCorreo.setText("Formato de correo no valido");
			}else 
				if (Validaciones.CantidadCorreo(correo)) {
					R.lblErrorCorreo.setVisible(true);
					R.lblErrorCorreo.setText("El correo es muy largo");
					
				}else {
					
					R.lblErrorCorreo.setVisible(false);
				}
			
		}
		
		if(e.getSource().equals(R.txtContraseña)) {
			
			String contrasena =R.txtContraseña.getText();
			if(Validaciones.vacio(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("Campo vacio");
			}else
			if(Validaciones.ValidarContraseña(contrasena)) {
				R.lblErrorContraseña.setVisible(true);
				R.lblErrorContraseña.setText("Contraseña no valida");
			}else 
				if (Validaciones.Cantidadcontraseña(contrasena)) {
					R.lblErrorContraseña.setVisible(true);
					R.lblErrorContraseña.setText("La contraseña debe ser 8-10 Caracteres");
					
				}else {
					
					R.lblErrorContraseña.setVisible(false);
				}
			
		}
		
	}



	@Override


	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource().equals(R.lblYatengocuenta)) {
			R.dispose();
			Login L = new Login();
			new LoginController(L);
			
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