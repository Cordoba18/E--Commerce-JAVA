package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Perfil_usuario extends JPanel {
	
	public JTextField txtNombre,txtCorreo,txtDocumento,txtTelefono,txtDireccion;
	public JComboBox cbxCiudad, cbxDepartamento;
	public JButton btnGuardar;
	public JLabel lblDocumento,lblErrorNombre ,lblErrorDocumento,lblErrorTelefono,lblErrorDireccion;
	
	/**
	 * Create the panel.
	 */
	public Perfil_usuario() {
		setBackground(new Color(255, 255, 255));

		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		JLabel lblTitulo = new JLabel("PERFIL USUARIO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblTitulo.setBounds(399, 26, 467, 70);
		add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(188, 139, 119, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefono");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(188, 308, 119, 28);
		add(lblNewLabel_1_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtNombre.setBounds(735, 139, 371, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(735, 188, 371, 19);
		add(txtCorreo);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(735, 258, 371, 19);
		add(txtDocumento);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(735, 315, 371, 19);
		add(txtTelefono);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Direccion");
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(188, 372, 119, 28);
		add(lblNewLabel_1_1_1_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(735, 379, 371, 19);
		add(txtDireccion);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ciudad");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(188, 498, 119, 28);
		add(lblNewLabel_1_1_1_1_1);
		
		cbxCiudad = new JComboBox();
		cbxCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbxCiudad.setBounds(735, 505, 371, 21);
		add(cbxCiudad);
		
		btnGuardar = new JButton("MODIFICAR");
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setIcon(new ImageIcon("icons\\Lg-editar.png"));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnGuardar.setBounds(871, 548, 235, 59);
		add(btnGuardar);
		
		JLabel lblCambiarContrasea = new JLabel("                                    ");
		lblCambiarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCambiarContrasea.setBounds(648, 58, 260, 41);
		add(lblCambiarContrasea);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Departamento");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(188, 436, 119, 28);
		add(lblNewLabel_1_1_1_1_1_1);
		
		cbxDepartamento = new JComboBox();
		cbxDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbxDepartamento.setBounds(735, 443, 371, 21);
		add(cbxDepartamento);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCorreo.setBounds(188, 191, 119, 28);
		add(lblCorreo);
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDocumento.setBounds(188, 253, 119, 28);
		add(lblDocumento);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNombre.setBounds(734, 163, 372, 14);
		add(lblErrorNombre);
		
		lblErrorDocumento = new JLabel("ERROR");
		lblErrorDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDocumento.setForeground(Color.RED);
		lblErrorDocumento.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorDocumento.setBounds(734, 277, 372, 14);
		add(lblErrorDocumento);
		
		lblErrorTelefono = new JLabel("ERROR");
		lblErrorTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorTelefono.setForeground(Color.RED);
		lblErrorTelefono.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorTelefono.setBounds(735, 334, 372, 14);
		add(lblErrorTelefono);
		
		lblErrorDireccion = new JLabel("ERROR");
		lblErrorDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDireccion.setForeground(Color.RED);
		lblErrorDireccion.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorDireccion.setBounds(735, 398, 372, 14);
		add(lblErrorDireccion);
		
		lblErrorDireccion.setVisible(false);
		lblErrorDocumento.setVisible(false);
		lblErrorNombre.setVisible(false);
		lblErrorTelefono.setVisible(false);

		
	}
}
