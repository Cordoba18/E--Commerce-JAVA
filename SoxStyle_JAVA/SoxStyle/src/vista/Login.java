package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField txtCorreo;
	public JTextField txtContraseña;
	public JLabel lblImagen ;
	public JLabel lblNewLabel;
	
	public JLabel lblCorreo ;
	
	
	
	public JLabel lblErrorCorreo;
	
	public JLabel lblErrorContraseña;
	
	
	
	public JButton btnIniciar;
	
	public JLabel lblNotengocuenta ;
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		 this.setTitle("LOGIN");
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 416, 491);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(10, 67, 396, 351);
		panel.add(lblImagen);
		ImageIcon image = new ImageIcon("images//Logo.png");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		lblImagen.setIcon(icon);
		this.lblImagen.repaint();
		
		JLabel lblNewLabel = new JLabel("INICIAR SESIÓN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 29));
		lblNewLabel.setBounds(446, 60, 336, 87);
		contentPane.add(lblNewLabel);
		
		lblCorreo = new JLabel("CORREO");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCorreo.setBounds(446, 171, 130, 44);
		contentPane.add(lblCorreo);
		
		JLabel lblNewLabel_1_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(446, 274, 130, 44);
		contentPane.add(lblNewLabel_1_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCorreo.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtCorreo.setBounds(446, 213, 316, 37);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCorreo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		lblErrorCorreo.setBounds(446, 250, 317, 37);
		contentPane.add(lblErrorCorreo);
		
		lblErrorContraseña = new JLabel("ERROR");
		lblErrorContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContraseña.setForeground(Color.RED);
		lblErrorContraseña.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		lblErrorContraseña.setBounds(445, 352, 317, 37);
		contentPane.add(lblErrorContraseña);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		txtContraseña.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtContraseña.setBounds(446, 312, 316, 37);
		contentPane.add(txtContraseña);
		
		btnIniciar = new JButton("INICIAR");
		btnIniciar.setForeground(new Color(0, 0, 0));
		btnIniciar.setBackground(new Color(255, 255, 255));
		btnIniciar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnIniciar.setBounds(632, 400, 130, 37);
		contentPane.add(btnIniciar);
		
		lblNotengocuenta = new JLabel("NO TENGO CUENTA");
		lblNotengocuenta.setForeground(new Color(255, 0, 0));
		lblNotengocuenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotengocuenta.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNotengocuenta.setBounds(446, 393, 176, 44);
		contentPane.add(lblNotengocuenta);
		
		lblErrorCorreo.setVisible(false);
		lblErrorContraseña.setVisible(false);
	}
}
