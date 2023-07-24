package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Perfil_administrador extends JPanel {
	public JTextField txtNombre;
	public JTextField txtCorreo;
	public JTextField txtDocumento;
	public JTextField txtTelefono;
	public JTextField txtDireccion;
	public JPasswordField txtContrasenaA;
	public JPasswordField txtContrasenaN;
	public JPasswordField txtContrasenaC;
	public JComboBox cbxDepartamento;
	public JComboBox cbxCiudad;
	public JButton btnGuardar, btnCambiarContrasena;
	/**
	 * Create the panel.
	 */
	public Perfil_administrador() {
		setBackground(new Color(255, 255, 255));

		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		JLabel lblTitulo = new JLabel("PERFIL ADMINISTRATIVO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitulo.setBounds(118, 45, 404, 80);
		add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(150, 178, 119, 28);
		add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtNombre.setBounds(360, 183, 182, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(360, 245, 182, 19);
		add(txtCorreo);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(360, 306, 182, 19);
		add(txtDocumento);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(360, 360, 182, 19);
		add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(360, 419, 182, 19);
		add(txtDireccion);
		
		cbxCiudad = new JComboBox();
		cbxCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbxCiudad.setBounds(298, 546, 244, 21);
		add(cbxCiudad);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setIcon(new ImageIcon("icons\\Lg-editar.png"));
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setBounds(298, 614, 244, 54);
		add(btnGuardar);
		
		JLabel lblCambiarContrasea = new JLabel("CAMBIAR CONTRASEÑA");
		lblCambiarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiarContrasea.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblCambiarContrasea.setBounds(707, 45, 481, 80);
		add(lblCambiarContrasea);
		
		JLabel lblContraseaActual = new JLabel("Contraseña Actual");
		lblContraseaActual.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblContraseaActual.setBounds(735, 175, 182, 28);
		add(lblContraseaActual);
		
		txtContrasenaA = new JPasswordField();
		txtContrasenaA.setBounds(976, 182, 197, 19);
		add(txtContrasenaA);
		
		txtContrasenaN = new JPasswordField();
		txtContrasenaN.setBounds(976, 255, 197, 19);
		add(txtContrasenaN);
		
		txtContrasenaC = new JPasswordField();
		txtContrasenaC.setBounds(976, 327, 197, 19);
		add(txtContrasenaC);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nueva Contraseña");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(735, 248, 182, 28);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Confirmar Contraseña");
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(735, 320, 182, 28);
		add(lblNewLabel_1_2_1);
		
		btnCambiarContrasena = new JButton("CAMBIAR CONTRASEÑA");
		btnCambiarContrasena.setIcon(new ImageIcon("icons\\Lg-editar.png"));
		btnCambiarContrasena.setForeground(new Color(0, 0, 0));
		btnCambiarContrasena.setBackground(new Color(255, 255, 255));
		btnCambiarContrasena.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnCambiarContrasena.setBounds(816, 397, 357, 54);
		add(btnCambiarContrasena);
		
		cbxDepartamento = new JComboBox();
		cbxDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbxDepartamento.setBounds(298, 482, 244, 21);
		add(cbxDepartamento);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCorreo.setBounds(150, 238, 119, 28);
		add(lblCorreo);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDocumento.setBounds(150, 299, 119, 28);
		add(lblDocumento);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTelefono.setBounds(150, 353, 119, 28);
		add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDireccion.setBounds(150, 412, 119, 28);
		add(lblDireccion);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDepartamento.setBounds(150, 476, 119, 28);
		add(lblDepartamento);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCiudad.setBounds(150, 540, 119, 28);
		add(lblCiudad);
		
	}
}
