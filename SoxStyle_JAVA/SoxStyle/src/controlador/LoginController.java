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
import vista.Login;
import vista.Registrarse;

public class LoginController implements MouseListener, KeyListener, ActionListener{

	Login L;
	public LoginController(Login L) {
		this.L = L;
		this.L.btnIniciar.addActionListener(this);
		this.L.txtCorreo.addKeyListener(this);
		this.L.txtContraseña.addKeyListener(this);
		this.L.lblNotengocuenta.addMouseListener(this);
		Iniciar();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(L.btnIniciar)) {
			
			String correo = L.txtCorreo.getText();
			String contraseña = L.txtContraseña.getText();
			
			Usuario u = new Usuario();
			Ayudas ayuda = new Ayudas();
			u.setCorreo(correo);
			try {
				u.setContrasena(ayuda.Cifra(contraseña));
			} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
					| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if(Validaciones.vacio(correo)) {
				L.lblErrorCorreo.setVisible(true);
				L.lblErrorCorreo.setText("Campo vacio");
			}else 
			if(Validaciones.ValidarCorreo(correo)) {
				L.lblErrorCorreo.setVisible(true);
				L.lblErrorCorreo.setText("Formato de correo no valido");
				
			}else 
				if (Validaciones.CantidadCorreo(correo)) {
					L.lblErrorCorreo.setVisible(true);
					L.lblErrorCorreo.setText("El correo es muy largo");
					
					}else 
						if(Validaciones.vacio(contraseña)) {
						L.lblErrorContraseña.setVisible(true);
						L.lblErrorContraseña.setText("Campo vacio");
					}
					else
						if(Validaciones.ValidarContraseña(contraseña)) {
				L.lblErrorContraseña.setVisible(true);
				L.lblErrorContraseña.setText("Contraseña no valida");
			
			}else 
				if (Validaciones.Cantidadcontraseña(contraseña)) {
					L.lblErrorContraseña.setVisible(true);
					L.lblErrorContraseña.setText("La contraseña debe ser 8-10 Caracteres");
					
					
				}else {
						L.lblErrorCorreo.setVisible(false);
						L.lblErrorContraseña.setVisible(false);
						Consultas consulta = new Consultas();
						if(!consulta.ConsultarUsuario(u)) {
							JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE");
						}else if(consulta.EstadoUsuario(u)){
							JOptionPane.showMessageDialog(null, "EL USUARIO ESTA INACTIVO");}
						else if(!consulta.ConsultarRolUsuario(u)){
							JOptionPane.showMessageDialog(null, "USTED NO ES UN ADMINISTRADOR");}
						else if(consulta.ingreso(u)) {
							try {
								consulta.Monitorias(String.valueOf(u.getId()), "15", u.getCorreo());
								ayuda.descifrar(u.getContrasena(), contraseña);
								L.dispose();
								Administrador A = new Administrador();
								new AdministradorController(A, u);
								JOptionPane.showMessageDialog(null, "LOGUEADO CORRECTAMENTE");
								
							} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
									| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "LA CONTRASEÑA NO COINCIDE CON EL USUARIO");
							}
							
							
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
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(L.txtCorreo)) {
			
			String correo = L.txtCorreo.getText();
			if(Validaciones.vacio(correo)) {
				L.lblErrorCorreo.setVisible(true);
				L.lblErrorCorreo.setText("Campo vacio");
			}else 
			if(Validaciones.ValidarCorreo(correo)) {
				L.lblErrorCorreo.setVisible(true);
				L.lblErrorCorreo.setText("Formato de correo no valido");
			}else 
				if (Validaciones.CantidadCorreo(correo)) {
					L.lblErrorCorreo.setVisible(true);
					L.lblErrorCorreo.setText("El correo es muy largo");
					
				}else {
					
					L.lblErrorCorreo.setVisible(false);
				}
			
		}
		
		if(e.getSource().equals(L.txtContraseña)) {
			
			String contraseña = L.txtContraseña.getText();
			if(Validaciones.vacio(contraseña)) {
				L.lblErrorContraseña.setVisible(true);
				L.lblErrorContraseña.setText("Campo vacio");
			}else
			if(Validaciones.ValidarContraseña(contraseña)) {
				L.lblErrorContraseña.setVisible(true);
				L.lblErrorContraseña.setText("Contraseña no valida");
			}else 
				if (Validaciones.Cantidadcontraseña(contraseña)) {
					L.lblErrorContraseña.setVisible(true);
					L.lblErrorContraseña.setText("La contraseña debe ser 8-10 Caracteres");
					
				}else {
					
					L.lblErrorContraseña.setVisible(false);
				}
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	
		if(e.getSource().equals(L.lblNotengocuenta)) {
			
			L.dispose();
			Registrarse R = new Registrarse();
			new RegistrarseController(R);
			
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
	
	private void Iniciar() {
		L.setVisible(true);
		L.setTitle("INICIAR SESIÓN");
	}
}
