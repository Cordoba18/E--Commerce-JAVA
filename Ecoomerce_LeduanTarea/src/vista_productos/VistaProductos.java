package vista_productos;

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

		this.setTitle("Prodcutos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 752);
		contentPane1 = new JPanel();
		contentPane1.setBackground(SystemColor.window);
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBackground(SystemColor.inactiveCaptionBorder);
		pnlPrincipal.setBorder(UIManager.getBorder("PopupMenu.border"));
		pnlPrincipal.setBounds(0, 0, 1079, 718);
		contentPane1.add(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		tabla.setBounds(24, 211, 908, 511);
		tabla.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1139, 48);
		panel.setBackground(new Color(0, 153, 255));
		pnlPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido Administrador:");
		lblBienvenido.setBounds(568, 10, 507, 36);
		panel.add(lblBienvenido);
		lblBienvenido.setForeground(Color.BLACK);
		lblBienvenido.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(470, 10, 71, 36);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(VistaProductos.class.getResource("/img/ajustes2.png")));
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(187, 133, 490, 32);
		pnlPrincipal.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		JButton Btn_buscar = new JButton("Buscar\r\n");
		Btn_buscar.setBounds(50, 130, 105, 32);
		Btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPrincipal.add(Btn_buscar);
		
		JLabel lblListadeproductos = new JLabel("Lista de productos\r\n");
		lblListadeproductos.setBounds(24, 68, 190, 17);
		lblListadeproductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlPrincipal.add(lblListadeproductos);
		
		btnAgregar = new JButton("Agregar nuevo producto");
		btnAgregar.setBounds(236, 70, 199, 23);
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPrincipal.add(btnAgregar);
	}
}
