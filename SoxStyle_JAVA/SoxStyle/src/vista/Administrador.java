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

public class Administrador extends JFrame {

	public JPanel contentPane, panelPrincipal, leftBar, topBar;
	public JLabel lbl_Logo, lbl_NameStore, lbl_Administrador;
	public JButton btnProductos, btnProductosN, btnProductosA,
				   btnSliders, btnEstadisticas, btnUsuariosR;

	public Administrador() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrincipal.setBounds(318, 60, 1240, 757);
		contentPane.add(panelPrincipal);
		
		leftBar = new JPanel();
		leftBar.setLocation(0, 0);
		leftBar.setSize(319, 817);
		contentPane.add(leftBar);
		leftBar.setLayout(null);
		
		topBar = new JPanel();
		topBar.setLocation(318, 0);
		topBar.setSize(1240, 173);
		contentPane.add(topBar);
		topBar.setLayout(null);
		
		lbl_Administrador = new JLabel("Administrador");
		lbl_Administrador.setBounds(900, 10, 208, 41);
		topBar.add(lbl_Administrador);
		lbl_Administrador.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		lbl_NameStore = new JLabel("SoxStore");
		lbl_NameStore.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbl_NameStore.setBounds(83, 136, 128, 41);
		leftBar.add(lbl_NameStore);
		
		btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnProductos.setBounds(0, 198, 319, 65);
		leftBar.add(btnProductos);
		
		btnProductosN = new JButton("Productos Nuevos");
		btnProductosN.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnProductosN.setBounds(0, 262, 319, 65);
		leftBar.add(btnProductosN);
		
		btnProductosA = new JButton("Productos Antiguos");
		btnProductosA.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnProductosA.setBounds(0, 326, 319, 65);
		leftBar.add(btnProductosA);
		
		btnSliders = new JButton("Sliders");
		btnSliders.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSliders.setBounds(0, 390, 319, 65);
		leftBar.add(btnSliders);
		
		btnEstadisticas = new JButton("Estadísticas");
		btnEstadisticas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnEstadisticas.setBounds(0, 454, 319, 65);
		leftBar.add(btnEstadisticas);
		
		btnUsuariosR = new JButton("Usuarios registrados");
		btnUsuariosR.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnUsuariosR.setBounds(0, 518, 319, 65);
		leftBar.add(btnUsuariosR);
		
		lbl_Logo = new JLabel();
		lbl_Logo.setBounds(53, 10, 208, 122);
		leftBar.add(lbl_Logo);
		
		ImageIcon image = new ImageIcon("images//Logo.jpg");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lbl_Logo.getWidth(), lbl_Logo.getHeight(), Image.SCALE_DEFAULT));
		lbl_Logo.setIcon(icon);
		this.lbl_Logo.repaint();
	}
}
