package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class ColoresTallas extends JPanel {
	
	public JTable TablaTalla;
	public JTable TablaColores;
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
	public JButton BtnAgregarTalla;
	public JLabel lblErrorTalla;
	public JLabel lblErrorCantidad;
	public JLabel lblColor;
	public JButton BtnAgregarC;
	public JLabel lblErrorColor;
	public JButton BtnBorrarC;
	public JButton BtnEditarTalla;
	public JButton BtnCancelarC;
	public	JButton BtnBorrarTalla;
	public JButton BtncancelarTalla;

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
				"id", "cantidad", "talla", "id_producto","estados_id","created_at","updated_at"
			}
		));
		scrollPane.setViewportView(TablaTalla);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(629, 189, 558, 360);
		add(scrollPane_1);
		
		TablaColores = new JTable();
		TablaColores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"id", "color","id_producto","estados_id","created_at","updated_at"
			}
		));
		scrollPane_1.setViewportView(TablaColores);
		
		lblNewLabel_2_1 = new JLabel("Colores");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 39));
		lblNewLabel_2_1.setBounds(821, 134, 152, 45);
		add(lblNewLabel_2_1);
		
		lblTalla_1 = new JLabel("Talla");
		lblTalla_1.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblTalla_1.setBounds(61, 652, 80, 23);
		add(lblTalla_1);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(205, 639, 220, 36);
		add(txtTalla);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblCantidad.setBounds(58, 598, 122, 23);
		add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(205, 589, 220, 32);
		add(txtCantidad);
		
		BtnAgregarTalla = new JButton("Agregar");
		BtnAgregarTalla.setForeground(Color.BLACK);
		BtnAgregarTalla.setBackground(new Color(255, 255, 255));
		BtnAgregarTalla.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnAgregarTalla.setBackground(new Color(0, 150, 255));
		BtnAgregarTalla.setBounds(522, 621, 105, 32);
		add(BtnAgregarTalla);
		
		lblErrorTalla = new JLabel("ERROR");
		lblErrorTalla.setVisible(false);
		lblErrorTalla.setForeground(new Color(255, 0, 0));
		lblErrorTalla.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblErrorTalla.setBounds(455, 663, 136, 14);
		add(lblErrorTalla);
		
		lblErrorCantidad = new JLabel("ERROR");
		lblErrorCantidad.setVisible(false);
		lblErrorCantidad.setForeground(Color.RED);
		lblErrorCantidad.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblErrorCantidad.setBounds(455, 607, 136, 14);
		add(lblErrorCantidad);
		
		lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblColor.setBounds(675, 586, 100, 23);
		add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(785, 586, 220, 36);
		add(txtColor);
		
		BtnAgregarC = new JButton("Agregar");
		BtnAgregarC.setForeground(Color.BLACK);
		BtnAgregarC.setBackground(new Color(255, 255, 255));
		BtnAgregarC.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnAgregarC.setBackground(new Color(0, 150, 255));
		BtnAgregarC.setBounds(1035, 643, 105, 32);
		add(BtnAgregarC);
		
		lblErrorColor = new JLabel("ERROR");
		lblErrorColor.setVisible(false);
		lblErrorColor.setForeground(Color.RED);
		lblErrorColor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblErrorColor.setBounds(1015, 598, 146, 14);
		add(lblErrorColor);
		
		BtnBorrarC = new JButton("Borrar");
		BtnBorrarC.setForeground(Color.BLACK);
		BtnBorrarC.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnBorrarC.setBackground(Color.RED);
		BtnBorrarC.setBounds(805, 643, 105, 32);
		BtnBorrarC.setVisible(false);
		add(BtnBorrarC);
		
		BtnEditarTalla = new JButton("Editar");
		BtnEditarTalla.setForeground(Color.BLACK);
		BtnEditarTalla.setBackground(new Color(255, 255, 255));
		BtnEditarTalla.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnEditarTalla.setBackground(new Color(0, 150, 255));
		BtnEditarTalla.setBounds(522, 566, 105, 32);
		BtnEditarTalla.setVisible(false);
		add(BtnEditarTalla);
		
		BtnCancelarC = new JButton("Cancelar");
		BtnCancelarC.setForeground(Color.BLACK);
		BtnCancelarC.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnCancelarC.setBackground(new Color(0, 150, 255));
		BtnCancelarC.setBounds(690, 643, 105, 32);
		BtnCancelarC.setVisible(false);
		add(BtnCancelarC);
		
		BtnBorrarTalla = new JButton("Borrar");
		BtnBorrarTalla.setForeground(Color.BLACK);
		BtnBorrarTalla.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnBorrarTalla.setBackground(Color.RED);
		BtnBorrarTalla.setBounds(366, 706, 105, 32);
		BtnBorrarTalla.setVisible(false);
		add(BtnBorrarTalla);
		
		BtncancelarTalla = new JButton("Cancelar");
		BtncancelarTalla.setForeground(Color.BLACK);
		BtncancelarTalla.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtncancelarTalla.setBackground(new Color(0, 150, 255));
		BtncancelarTalla.setBounds(58, 706, 105, 32);
		BtncancelarTalla.setVisible(false);
		add(BtncancelarTalla);
		
		
		
			}

	}