package controlador;
/*
 * En_esta_parte_importamos_todas_las_clases_de_java_necesarias_para_el_desarrollo_del_login_,_importamos_las_clases_para_escuchar_las
 * _acciones_de_la_vista_y_las_exepciones.
 */
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

/*
 * En_esta_parte_importamos_las_clases_de_otros_paquetes_,_tambien_necesarias_para_el_desarrollo_del_login.
 */
import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.Usuario;
import sql.Consultas;
import vista.Administrador;
import vista.Login;
import vista.Registrarse;
/*
 * Aqui_encontramos_la_clase_LoginController_con_las_implementaciones_para_escuchar_las_acciones_del_mous_,_las_teclas_y_los_botones_
 * en_la_vista
 */
public class LoginController implements MouseListener, KeyListener, ActionListener{
/*
 * Se_decalra_lavista_y_se_inicializan_la_misma_vista_,_los_botones__el_label_y_los_cuadros_de_texto_de_la_vista.
 * por_ultimo_se_llama_el_metodo_iniciar.
 */
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
/*
 * El_primer_bloque_del_actionPerformd_se_usa_para_que_cuando_el_administrador_desee_inciar_session_
 * se_le_asigna_a_las_variables_correo_y_contraseña_lo_que_haya_en_los_bloques_de_texto_de_la_vista
 * y_se_instancian_las_clases_Usuario_y_Ayudas_._por_ultimo_si_se_precenta_algun_error_en_esta_parte
 * se_guarda_y_se_imprime_en_printStackTrace.
 */
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
			
/*
 * En_estos_bloques_de_la_linea_76_a_la_104_entonctramos_las_validaciones_de_que_no_se_pueda_dejar_campos_vacios_,
 * que_el_formato_del_correo_sea_valido_,_que_el_correo_no_sea_muy_largo_,_la_contraaseña_debe_ser_valida_,_no_puede_pasar_la_cantidad
 * de_caracyteres_.		
 */
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
					
/*
 * De_la_linea_108_a_la_118_.primero_se_pone_el_label_de_error_en_falso_y_se_instancia_la_calse_Consultas.
 * priemro_se_valida_que_si_la_consulta_ConsultarUsuario_es_diferente_al_resultado_que_da_la_consulta_se_arroja_un_mensaje_inidcando_
 * que_el_ususario_no_existe
 */
				}else {
						L.lblErrorCorreo.setVisible(false);
						L.lblErrorContraseña.setVisible(false);
						Consultas consulta = new Consultas();
						if(!consulta.ConsultarUsuario(u)) {
							JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE");
/*
 * Luego_se_valida_si_el_usuario_esta_activo_o_inactivo_llamando_la_consulta_EstadoUsuario_y_entregandole_el_modelo_Usuario
 * ,_si_es_asi_se_arroja_un_mensaje_indicando_que_el_ususario_que_se_esta_ingresando_
 * esta_ianctivo						
 */
						}else if(consulta.EstadoUsuario(u)){
							JOptionPane.showMessageDialog(null, "EL USUARIO ESTA INACTIVO");}
/*
 * Luego_se_valida_que_el_rol_del_usuario_sea_administrador_llamando_la_consulta_ConsultarRolUsuario_y_entrgandole_el_modelo_Usuario
 * si_la_consulta_arroja_un_dato_distinto_al_esperado_,_se__arroja_un_mensaje_indicand_que_el_usuario_ingresado_no_es_un_administrador						
 */
						else if(!consulta.ConsultarRolUsuario(u)){
							JOptionPane.showMessageDialog(null, "USTED NO ES UN ADMINISTRADOR");}
/*
 * Por_ultimo_llamammos_la_consulta_ingreso_y_le_entregamos_el_modelo_Usuario_,_luego_creamos_un_try_catch_para_decifrar_la_contraseña_
 * y_compararla_con_la_que_hay_en_la_base_de_datos_._luego_se_cierra_la_vista_libera_los_recursos_de_la_vista_usando_el_L.dispose();
 * ,_se_se_instancia_el_vista_de_administrador_y_se_crea_el_controlador_del_administrador_entregandole_el_la_vista_de_administrador_y_
 * el_modelo_Usuario_._por_ultimo_se_llama_la_consulta_monitorias_para_dejar_registro_de_lo_que_se_hizo_y_se_manda_un_mensaje
 * indicando_que_se_registro_exotosamente.					
 */
						else if(consulta.ingreso(u)) {
							try {
								ayuda.descifrar(u.getContrasena(), contraseña);
								L.dispose();
								Administrador A = new Administrador();
								new AdministradorController(A, u);
								consulta.Monitorias(String.valueOf(u.getId()), "15", u.getCorreo());
								JOptionPane.showMessageDialog(null, "LOGUEADO CORRECTAMENTE");
/*
 * En_caso_que_lo_de_arriba_no_se_cumpla_se_guardan_en_e1_las_exepcones_y_se_manda_un_mensaje_indicando_que_la_contraseña_no_coincide
 * con_el_usuario.								
 */
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
	
/*
 * En_este_keyRealeased_se_escucha_las_teclas_a_la_hora_de_escribir_en_el_bloque_de_texto_Correo.
 * se_valida_que_el_no_pueda_estar_en_vacio_,_que_el_formato_del_correo_sea_valido_y_que_no_sea_muy_largo
 */
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
/*
* En_este_keyRealeased_se_escucha_las_teclas_a_la_hora_de_escribir_en_el_bloque_de_texto_Contraseña.
* se_valida_que_el_no_pueda_estar_en_vacio_,_que_ls_contraseña_sea_valida_y_que_cumpla_la_cantidad_de_caracteres_establecidos.
*/	
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
/*
 * Este_metodo_escucha_el_click_del_mouse_en_el_lblNotengocuenta_de_la_vista_login_,_se_libera_los_recursos_de_la_vista_L_y
 * instancia_la_vista_registrarse_,_y_se_crea_el_controlador_RegistrarseController_entregandole_la_vista_Registrarse.
 */
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
	
/*
 * Este_es_el_metodo_iniciar_que_pone_la_vista_L_en_visible_y_el_titulo_en_iniciar_session.
 */
	private void Iniciar() {
		L.setVisible(true);
		L.setTitle("INICIAR SESIÓN");
	}
}
