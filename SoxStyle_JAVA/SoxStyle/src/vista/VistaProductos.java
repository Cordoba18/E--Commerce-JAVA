package vista;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Label;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Component;
import javax.swing.Box;



public class VistaProductos extends JFrame {
	private JPanel contentPane1;
	public JPanel pnlPrincipal;
	public JTable TBLproductos;
	public JScrollPane tabla = new JScrollPane();
	private JTextField txtBuscador;
	private JButton btnAgregar;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaProductos frame = new VistaProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaProductos() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1230, 757);
		contentPane1 = new JPanel();
		contentPane1.setBackground(SystemColor.control);
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBounds(0, 0, 1230, 757);
		pnlPrincipal.setBackground(SystemColor.menu);
		pnlPrincipal.setBorder(UIManager.getBorder("PopupMenu.border"));
		contentPane1.add(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		tabla.setBounds(35, 201, 996, 407);
		tabla.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pnlPrincipal.add(tabla);
		tabla.setViewportView(TBLproductos);
		
		getContentPane().setLayout(null);
		
		TBLproductos = new JTable();
		TBLproductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Precio", "Descuento", "Categorial", "Descripción", "Imagen del producto", "Estado"
			}
		));
		tabla.setViewportView(TBLproductos);
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(284, 132, 490, 32);
		txtBuscador.setFont(new Font("Segoe UI", Font.BOLD, 10));
		pnlPrincipal.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		JButton Btn_buscar = new JButton("Buscar\r\n");
		Btn_buscar.setBounds(118, 130, 105, 32);
		Btn_buscar.setForeground(SystemColor.activeCaptionText);
		Btn_buscar.setBackground(new Color(0, 150, 255));
		Btn_buscar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		pnlPrincipal.add(Btn_buscar);
		
		JLabel lblListadeproductos = new JLabel("Lista de productos\r\n");
		lblListadeproductos.setBounds(74, 75, 210, 32);
		lblListadeproductos.setFont(new Font("Segoe UI", Font.BOLD, 23));
		pnlPrincipal.add(lblListadeproductos);
		
		btnAgregar = new JButton("Agregar nuevo producto");
		btnAgregar.setBounds(306, 79, 253, 32);
		btnAgregar.setBackground(new Color(0, 150, 255));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		pnlPrincipal.add(btnAgregar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(992, 10, 71, 36);
		pnlPrincipal.add(lblNewLabel_1);
	
		
		JLabel lblBienvenido = new JLabel("Administrador");
		lblBienvenido.setBounds(810, 10, 152, 36);
		pnlPrincipal.add(lblBienvenido);
		lblBienvenido.setForeground(Color.BLACK);
		lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 22));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 1220, 55);
		pnlPrincipal.add(panel);
		panel.setLayout(null);
	}
}