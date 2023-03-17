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
import java.awt.Rectangle;

import javax.swing.JMenuBar;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Component;
import javax.swing.Box;



public class PaginaProductos extends JPanel {

	public JTextField txtProductos;
	public JButton btnBuscarr;
	public JTable tblProductos;
	


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PaginaProductos() {

	
		
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblListaProductos = new JLabel("Lista de Productos");
		lblListaProductos.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblListaProductos.setBounds(76, 56, 251, 42);
		add(lblListaProductos);
		
		txtProductos = new JTextField();
		txtProductos.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtProductos.setColumns(10);
		txtProductos.setBounds(290, 127, 708, 42);
		add(txtProductos);
		
		btnBuscarr = new JButton("Buscar");
		btnBuscarr.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnBuscarr.setBackground(Color.WHITE);
		btnBuscarr.setBounds(86, 127, 157, 44);
		add(btnBuscarr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 214, 1064, 442);
		add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblProductos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Precio", "Descuento", "Categoria", "Descripcion", "Imagen del producto", "Estado"
				}
			));
		scrollPane.setViewportView(tblProductos);
		
		JButton btnNewButton = new JButton("Agregar nuevo Producto");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnNewButton.setBounds(403, 56, 371, 38);
		add(btnNewButton);
	}
}