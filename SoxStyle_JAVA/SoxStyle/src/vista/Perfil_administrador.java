package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

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

		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		JLabel lblTitulo = new JLabel("Perfil administrador");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setBounds(289, 58, 260, 41);
		add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(150, 159, 119, 28);
		add(lblNewLabel);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(150, 208, 119, 28);
		add(lblCorreo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Documento");
		lblNewLabel_1_1.setBounds(150, 274, 119, 28);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefono");
		lblNewLabel_1_1_1.setBounds(150, 338, 119, 28);
		add(lblNewLabel_1_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(279, 164, 182, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(279, 213, 182, 19);
		add(txtCorreo);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(279, 279, 182, 19);
		add(txtDocumento);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(279, 343, 182, 19);
		add(txtTelefono);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Direccion");
		lblNewLabel_1_1_1_1.setBounds(150, 397, 119, 28);
		add(lblNewLabel_1_1_1_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(279, 402, 182, 19);
		add(txtDireccion);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ciudad");
		lblNewLabel_1_1_1_1_1.setBounds(150, 494, 119, 28);
		add(lblNewLabel_1_1_1_1_1);
		
		cbxCiudad = new JComboBox();
		cbxCiudad.setBounds(279, 498, 182, 21);
		add(cbxCiudad);
		
		btnGuardar = new JButton("Guardar ");
		btnGuardar.setBounds(323, 552, 136, 28);
		add(btnGuardar);
		
		JLabel lblCambiarContrasea = new JLabel("Cambiar Contraseña");
		lblCambiarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCambiarContrasea.setBounds(648, 58, 260, 41);
		add(lblCambiarContrasea);
		
		JLabel lblContraseaActual = new JLabel("Contraseña Actual");
		lblContraseaActual.setBounds(550, 159, 182, 28);
		add(lblContraseaActual);
		
		txtContrasenaA = new JPasswordField();
		txtContrasenaA.setBounds(765, 164, 182, 19);
		add(txtContrasenaA);
		
		txtContrasenaN = new JPasswordField();
		txtContrasenaN.setBounds(765, 213, 182, 19);
		add(txtContrasenaN);
		
		txtContrasenaC = new JPasswordField();
		txtContrasenaC.setBounds(765, 279, 182, 19);
		add(txtContrasenaC);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nueva Contraseña");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(550, 216, 182, 28);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Confirmar Contraseña");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(550, 274, 182, 28);
		add(lblNewLabel_1_2_1);
		
		btnCambiarContrasena = new JButton("Cambiar Contraseña");
		btnCambiarContrasena.setBounds(694, 338, 136, 28);
		add(btnCambiarContrasena);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Departamento");
		lblNewLabel_1_1_1_1_1_1.setBounds(150, 445, 119, 28);
		add(lblNewLabel_1_1_1_1_1_1);
		
		cbxDepartamento = new JComboBox();
		cbxDepartamento.setBounds(279, 449, 182, 21);
		add(cbxDepartamento);
		
	}
}
