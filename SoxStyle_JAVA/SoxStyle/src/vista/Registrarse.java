package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Registrarse extends JFrame {

	private JPanel    contentPane;
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
	public JLabel lblErrorCedula;
	public JLabel lblErrorTelefono;

	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 607);
		 contentPane = new JPanel();
		 contentPane.setBackground(new Color(240, 240, 240));
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setTitle("REGISTRARSE");
		setContentPane( contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 422, 568);
		 contentPane.add(panel);
		panel.setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(10, 103, 402, 349);
		panel.add(lblImagen);
		ImageIcon image = new ImageIcon("images//Logo.png");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		lblImagen.setIcon(icon);
		this.lblImagen.repaint();
		JLabel lblNewLabel = new JLabel("REGISTRARSE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel.setBounds(485, 23, 336, 87);
		 contentPane.add(lblNewLabel);
		
		lblCorreo = new JLabel("CORREO");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblCorreo.setBounds(446, 324, 130, 21);
		 contentPane.add(lblCorreo);
		
		JLabel lblNewLabel_1_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(446, 402, 130, 21);
		 contentPane.add(lblNewLabel_1_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCorreo.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtCorreo.setBounds(446, 346, 416, 30);
		 contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCorreo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblErrorCorreo.setBounds(545, 376, 317, 21);
		 contentPane.add(lblErrorCorreo);
		
		lblErrorContraseña = new JLabel("ERROR");
		lblErrorContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContraseña.setForeground(Color.RED);
		lblErrorContraseña.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblErrorContraseña.setBounds(545, 461, 317, 21);
		 contentPane.add(lblErrorContraseña);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		txtContraseña.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtContraseña.setBounds(446, 427, 416, 30);
		 contentPane.add(txtContraseña);
		
		btnCrear = new JButton("CREAR");
		btnCrear.setBackground(new Color(255, 255, 255));
		btnCrear.setForeground(new Color(0, 0, 0));
		btnCrear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCrear.setBounds(732, 500, 130, 37);
		 contentPane.add(btnCrear);
		
		lblYatengocuenta = new JLabel("YA TENGO CUENTA");
		lblYatengocuenta.setForeground(new Color(255, 0, 0));
		lblYatengocuenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblYatengocuenta.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblYatengocuenta.setBounds(446, 493, 176, 44);
		 contentPane.add(lblYatengocuenta);
		
		lblN = new JLabel("NOMBRE COMPLETO:");
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblN.setBounds(446, 120, 130, 21);
		 contentPane.add(lblN);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNombre.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(446, 141, 416, 30);
		 contentPane.add(txtNombre);
		
		lblCedulaDeCiudadania = new JLabel("CEDULA DE CIUDADANÍA:");
		lblCedulaDeCiudadania.setHorizontalAlignment(SwingConstants.LEFT);
		lblCedulaDeCiudadania.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblCedulaDeCiudadania.setBounds(446, 185, 130, 21);
		 contentPane.add(lblCedulaDeCiudadania);
		
		txtCedula = new JTextField();
		txtCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCedula.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtCedula.setColumns(10);
		txtCedula.setBounds(446, 207, 416, 30);
		 contentPane.add(txtCedula);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTelefono.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(446, 283, 416, 30);
		 contentPane.add(txtTelefono);
		
		lblN_2 = new JLabel("TELEFONO DE CONTACTO:");
		lblN_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblN_2.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblN_2.setBounds(446, 259, 130, 21);
		 contentPane.add(lblN_2);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNombre.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblErrorNombre.setBounds(545, 168, 316, 21);
		 contentPane.add(lblErrorNombre);
		
		lblErrorCedula = new JLabel("ERROR");
		lblErrorCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCedula.setForeground(Color.RED);
		lblErrorCedula.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblErrorCedula.setBounds(546, 237, 316, 21);
		 contentPane.add(lblErrorCedula);
		
		lblErrorTelefono = new JLabel("ERROR");
		lblErrorTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorTelefono.setForeground(Color.RED);
		lblErrorTelefono.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblErrorTelefono.setBounds(546, 314, 316, 21);
		 contentPane.add(lblErrorTelefono);
		
		lblErrorCorreo.setVisible(false);
		lblErrorContraseña.setVisible(false);
		lblErrorCedula.setVisible(false);
		lblErrorNombre.setVisible(false);
		lblErrorTelefono.setVisible(false);
		
	}

}
