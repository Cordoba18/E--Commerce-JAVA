package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	public JTextField txtCorreo;
	public JTextField txtContraseña;
	public JLabel lblImagen ;
	public JLabel lblNewLabel;
	
	public JLabel lblCorreo ;
	
	
	
	public JLabel lblErrorCorreo;
	
	public JLabel lblErrorContraseña;
	
	
	
	public JButton btnCrear;
	
	public JLabel lblYatengocuenta ;
	public JLabel lblN;
	public JTextField txtNombre;
	public JLabel lblCedulaDeCiudadania;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JLabel lblN_2;
	public JLabel lblErrorNombre;
	public JLabel lblErrorCC;
	public JLabel lblErrorTelefono;

	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 530);
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(255, 255, 255));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 416, 491);
		contentPane_1.add(panel);
		panel.setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(10, 11, 396, 469);
		panel.add(lblImagen);
		
		JLabel lblNewLabel = new JLabel("REGISTRARSE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel.setBounds(446, 23, 336, 87);
		contentPane_1.add(lblNewLabel);
		
		lblCorreo = new JLabel("CORREO");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblCorreo.setBounds(446, 277, 130, 21);
		contentPane_1.add(lblCorreo);
		
		JLabel lblNewLabel_1_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(446, 336, 130, 21);
		contentPane_1.add(lblNewLabel_1_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCorreo.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		txtCorreo.setBounds(446, 311, 316, 14);
		contentPane_1.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCorreo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorCorreo.setBounds(446, 322, 317, 21);
		contentPane_1.add(lblErrorCorreo);
		
		lblErrorContraseña = new JLabel("ERROR");
		lblErrorContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContraseña.setForeground(Color.RED);
		lblErrorContraseña.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorContraseña.setBounds(446, 375, 317, 14);
		contentPane_1.add(lblErrorContraseña);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		txtContraseña.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		txtContraseña.setBounds(446, 360, 316, 14);
		contentPane_1.add(txtContraseña);
		
		btnCrear = new JButton("CREAR");
		btnCrear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCrear.setBounds(632, 400, 130, 37);
		contentPane_1.add(btnCrear);
		
		lblYatengocuenta = new JLabel("YA TENGO CUENTA");
		lblYatengocuenta.setForeground(new Color(255, 0, 0));
		lblYatengocuenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblYatengocuenta.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblYatengocuenta.setBounds(446, 393, 176, 44);
		contentPane_1.add(lblYatengocuenta);
		
		lblN = new JLabel("NOMBRE COMPLETO:");
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblN.setBounds(446, 109, 130, 21);
		contentPane_1.add(lblN);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNombre.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		txtNombre.setColumns(10);
		txtNombre.setBounds(446, 129, 316, 14);
		contentPane_1.add(txtNombre);
		
		lblCedulaDeCiudadania = new JLabel("CEDULA DE CIUDADANÍA:");
		lblCedulaDeCiudadania.setHorizontalAlignment(SwingConstants.LEFT);
		lblCedulaDeCiudadania.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblCedulaDeCiudadania.setBounds(446, 164, 130, 21);
		contentPane_1.add(lblCedulaDeCiudadania);
		
		txtCedula = new JTextField();
		txtCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCedula.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		txtCedula.setColumns(10);
		txtCedula.setBounds(446, 184, 316, 14);
		contentPane_1.add(txtCedula);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTelefono.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(446, 252, 316, 14);
		contentPane_1.add(txtTelefono);
		
		lblN_2 = new JLabel("TELEFONO DE CONTACTO:");
		lblN_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblN_2.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblN_2.setBounds(446, 220, 130, 21);
		contentPane_1.add(lblN_2);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNombre.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorNombre.setBounds(446, 143, 316, 21);
		contentPane_1.add(lblErrorNombre);
		
		lblErrorCC = new JLabel("ERROR");
		lblErrorCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCC.setForeground(Color.RED);
		lblErrorCC.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorCC.setBounds(446, 202, 316, 21);
		contentPane_1.add(lblErrorCC);
		
		lblErrorTelefono = new JLabel("ERROR");
		lblErrorTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorTelefono.setForeground(Color.RED);
		lblErrorTelefono.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
		lblErrorTelefono.setBounds(446, 266, 316, 21);
		contentPane_1.add(lblErrorTelefono);
		
		lblErrorCorreo.setVisible(false);
		lblErrorContraseña.setVisible(false);
		
	}

}
