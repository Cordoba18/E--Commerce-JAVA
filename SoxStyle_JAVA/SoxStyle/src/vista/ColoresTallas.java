package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ColoresTallas extends JPanel {
	
	public JTable TablaTalla;
	public JTable tablacolores;
	public JTable table;
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_1;
	public JTextField txtTalla;
	public JTextField txtCantidad;
	public JTextField txtColor;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_2_1;
	public JLabel lblTalla;
	public JLabel lblTalla_1;
	public JLabel lblCantidad;
	public JButton BtnAgregar;
	public JLabel lblErrorTalla;
	public JLabel lblErrorCantidad;
	public JLabel lblColor;
	public JButton BtnAgregar2;
	public JLabel lblErrorColor;
	/**
	 * Create the panel.
	 */
	public ColoresTallas() {
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		
		lblNewLabel = new JLabel("Editar Producto\r\n");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel.setBounds(74, 75, 210, 32);
		add(lblNewLabel);
		
		lblTalla = new JLabel("Talla");
		lblTalla.setFont(new Font("Segoe UI", Font.BOLD, 39));
		lblTalla.setBounds(231, 130, 152, 45);
		add(lblTalla);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 189, 558, 360);
		add(scrollPane);
		
		TablaTalla = new JTable();
		TablaTalla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id_talla", "Talla", "Cantidad"
			}
		));
		scrollPane.setViewportView(TablaTalla);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(629, 189, 558, 360);
		add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id_color", "Color"
			}
		));
		scrollPane_1.setViewportView(table);
		
		lblNewLabel_2_1 = new JLabel("Colores");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 39));
		lblNewLabel_2_1.setBounds(821, 134, 152, 45);
		add(lblNewLabel_2_1);
		
		lblTalla_1 = new JLabel("Talla");
		lblTalla_1.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblTalla_1.setBounds(58, 586, 80, 23);
		add(lblTalla_1);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(214, 586, 220, 36);
		add(txtTalla);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblCantidad.setBounds(58, 639, 122, 23);
		add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(214, 643, 220, 32);
		add(txtCantidad);
		
		BtnAgregar = new JButton("Agregar");
		BtnAgregar.setForeground(Color.BLACK);
		BtnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnAgregar.setBackground(new Color(0, 150, 255));
		BtnAgregar.setBounds(221, 706, 105, 32);
		add(BtnAgregar);
		
		lblErrorTalla = new JLabel("ERROR");
		lblErrorTalla.setVisible(false);
		lblErrorTalla.setForeground(new Color(255, 0, 0));
		lblErrorTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorTalla.setBounds(466, 598, 105, 14);
		add(lblErrorTalla);
		
		lblErrorCantidad = new JLabel("ERROR");
		lblErrorCantidad.setVisible(false);
		lblErrorCantidad.setForeground(Color.RED);
		lblErrorCantidad.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorCantidad.setBounds(466, 651, 105, 14);
		add(lblErrorCantidad);
		
		lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblColor.setBounds(675, 586, 100, 23);
		add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(785, 586, 220, 36);
		add(txtColor);
		
		BtnAgregar2 = new JButton("Agregar");
		BtnAgregar2.setForeground(Color.BLACK);
		BtnAgregar2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnAgregar2.setBackground(new Color(0, 150, 255));
		BtnAgregar2.setBounds(849, 643, 105, 32);
		add(BtnAgregar2);
		
		lblErrorColor = new JLabel("ERROR");
		lblErrorColor.setVisible(false);
		lblErrorColor.setForeground(Color.RED);
		lblErrorColor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorColor.setBounds(1015, 598, 105, 14);
		add(lblErrorColor);
		
		
		
		
		
	}

	}

