package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTree;

public class Perfil_usuario extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtDocumento;
	private JTextField txtTelefono;
	private JTextField txtDireccion;

	/**
	 * Create the panel.
	 */
	public Perfil_usuario() {

		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		JLabel lblTitulo = new JLabel("Perfil Usuario");
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
		lblNewLabel_1_1.setBounds(150, 300, 119, 28);
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
		txtDocumento.setBounds(279, 305, 182, 19);
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
		
		JComboBox cbxCiudad = new JComboBox();
		cbxCiudad.setBounds(279, 498, 182, 21);
		add(cbxCiudad);
		
		JButton btnGuardar = new JButton("Guardar ");
		btnGuardar.setBounds(307, 575, 136, 28);
		add(btnGuardar);
		
		JLabel lblCambiarContrasea = new JLabel("                                    ");
		lblCambiarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCambiarContrasea.setBounds(648, 58, 260, 41);
		add(lblCambiarContrasea);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Departamento");
		lblNewLabel_1_1_1_1_1_1.setBounds(150, 445, 119, 28);
		add(lblNewLabel_1_1_1_1_1_1);
		
		JComboBox cbxDepartamento = new JComboBox();
		cbxDepartamento.setBounds(279, 449, 182, 21);
		add(cbxDepartamento);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tipo de Documento");
		lblNewLabel_1_1_2.setBounds(150, 246, 119, 28);
		add(lblNewLabel_1_1_2);
		
		JComboBox cbxTipoDocumento = new JComboBox();
		cbxTipoDocumento.setBounds(279, 250, 182, 21);
		add(cbxTipoDocumento);
		
		
	}
}
