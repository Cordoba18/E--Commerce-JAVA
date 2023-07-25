package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Administrador extends JFrame {

	public JPanel contentPane, panelPrincipal, leftBar, topBar;
	
	public JLabel lbl_Logo, lbl_NameStore, lbl_Administrador, lbl_IdUser, lblImagen, lblCerrarSesion;
	
	public JButton btnProductos, btnProductosN, btnProductosA,
				   btnSliders, btnEstadisticas, btnUsuariosR;
	
	public ImageIcon image;

	public Administrador() {
		setTitle("Administración");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1651, 855);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setSize(2000, 2000);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrincipal.setBounds(318, 60, 1318, 757);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		leftBar = new JPanel();
		leftBar.setBackground(new Color(255, 255, 255));
		leftBar.setLocation(0, 0);
		leftBar.setSize(319, 817);
		contentPane.add(leftBar);
		leftBar.setLayout(null);
		
		topBar = new JPanel();
		topBar.setBackground(new Color(255, 255, 255));
		topBar.setLocation(318, 0);
		topBar.setSize(1318, 58);
		contentPane.add(topBar);
		topBar.setLayout(null);
		
		lbl_Administrador = new JLabel("Administrador");
		lbl_Administrador.setBounds(986, 17, 208, 41);
		topBar.add(lbl_Administrador);
		lbl_Administrador.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		lbl_NameStore = new JLabel("STYLE SPORT");
		lbl_NameStore.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NameStore.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbl_NameStore.setBounds(56, 211, 220, 41);
		leftBar.add(lbl_NameStore);
		
		btnProductos = new JButton("PRODUCTOS");
		btnProductos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProductos.setIcon(new ImageIcon("icons\\Lg-producto.png"));
		btnProductos.setBackground(new Color(255, 255, 255));
		btnProductos.setForeground(new Color(0, 0, 0));
		btnProductos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnProductos.setBounds(10, 263, 296, 65);
		leftBar.add(btnProductos);
		
		btnProductosN = new JButton("PRODUCTOS NUEVOS");
		btnProductosN.setHorizontalAlignment(SwingConstants.LEFT);
		btnProductosN.setIcon(new ImageIcon("icons\\Lg-producto.png"));
		btnProductosN.setBackground(new Color(255, 255, 255));
		btnProductosN.setForeground(new Color(0, 0, 0));
		btnProductosN.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnProductosN.setBounds(10, 339, 299, 65);
		leftBar.add(btnProductosN);
		
		btnProductosA = new JButton("PRODUCTOS ANTIGUOS\r\n");
		btnProductosA.setHorizontalAlignment(SwingConstants.LEFT);
		btnProductosA.setIcon(new ImageIcon("icons\\Lg-producto.png"));
		btnProductosA.setBackground(new Color(255, 255, 255));
		btnProductosA.setForeground(new Color(0, 0, 0));
		btnProductosA.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnProductosA.setBounds(10, 415, 299, 65);
		leftBar.add(btnProductosA);
		
		btnSliders = new JButton("SLIDERS");
		btnSliders.setHorizontalAlignment(SwingConstants.LEFT);
		btnSliders.setIcon(new ImageIcon("icons\\Lg-sliders.png"));
		btnSliders.setBackground(new Color(255, 255, 255));
		btnSliders.setForeground(new Color(0, 0, 0));
		btnSliders.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnSliders.setBounds(10, 491, 299, 65);
		leftBar.add(btnSliders);
		
		btnEstadisticas = new JButton("ESTADISTICAS");
		btnEstadisticas.setHorizontalAlignment(SwingConstants.LEFT);
		btnEstadisticas.setIcon(new ImageIcon("icons\\Lg-estadisticas.png"));
		btnEstadisticas.setBackground(new Color(255, 255, 255));
		btnEstadisticas.setForeground(new Color(0, 0, 0));
		btnEstadisticas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnEstadisticas.setBounds(13, 567, 296, 65);
		leftBar.add(btnEstadisticas);
		
		btnUsuariosR = new JButton("USUARIOS REGISTRADOS");
		btnUsuariosR.setHorizontalAlignment(SwingConstants.LEFT);
		btnUsuariosR.setIcon(new ImageIcon("icons\\Lg-usuario-registrado.png"));
		btnUsuariosR.setBackground(new Color(255, 255, 255));
		btnUsuariosR.setForeground(new Color(0, 0, 0));
		btnUsuariosR.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnUsuariosR.setBounds(13, 643, 296, 65);
		leftBar.add(btnUsuariosR);
		
		lbl_Logo = new JLabel();
		lbl_Logo.setBounds(56, 30, 208, 179);
		leftBar.add(lbl_Logo);
		ImageIcon image = new ImageIcon("images//Logo.png");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lbl_Logo.getWidth(), lbl_Logo.getHeight(), Image.SCALE_DEFAULT));
		lbl_Logo.setIcon(icon);
		
		lblCerrarSesion = new JLabel("CERRAR SESION");
		lblCerrarSesion.setForeground(new Color(255, 0, 0));
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCerrarSesion.setBounds(56, 719, 220, 41);
		leftBar.add(lblCerrarSesion);
		this.lbl_Logo.repaint();
		
		lbl_IdUser = new JLabel("");
		lbl_IdUser.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbl_IdUser.setBounds(0, 11, 400, 41);
		topBar.add(lbl_IdUser);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(1214, 11, 54, 52);
		topBar.add(lblImagen);
		ImageIcon image2 = new ImageIcon("icons//Lg-usuario.png");
		Icon icon2 = new ImageIcon(image2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		lblImagen.setIcon(icon2);
		this.lblImagen.repaint();
		
	}
}
