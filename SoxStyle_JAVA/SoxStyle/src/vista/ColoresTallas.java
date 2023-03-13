package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class ColoresTallas extends JPanel {

	private JPanel contentPane1;
	public JPanel pnlPrincipal;
	public JTable TBLproductos;
	public JTable Tblcores;
	public JScrollPane tablaTalla = new JScrollPane();
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Create the panel.
	 */
	public ColoresTallas() {
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBounds(0, 0, 1230, 757);
		pnlPrincipal.setBackground(SystemColor.textHighlightText);
		pnlPrincipal.setBorder(UIManager.getBorder("PopupMenu.border"));
		contentPane1.add(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		tablaTalla.setBounds(44, 189, 558, 360);
		tablaTalla.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pnlPrincipal.add(tablaTalla);
		tablaTalla.setViewportView(TBLproductos);
	
		TBLproductos = new JTable();
		TBLproductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id_talla", "Talla", "Cantida"
			}
		));
		tablaTalla.setViewportView(TBLproductos);
		
		JLabel lblListadeproductos = new JLabel("Editar Producto");
		lblListadeproductos.setBounds(74, 75, 210, 32);
		lblListadeproductos.setFont(new Font("Segoe UI", Font.BOLD, 23));
		pnlPrincipal.add(lblListadeproductos);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(992, 10, 71, 36);
		pnlPrincipal.add(lblNewLabel_1);
		
		JScrollPane tablaCOLORES = new JScrollPane();
		tablaCOLORES.setBounds(629, 189, 558, 360);
		pnlPrincipal.add(tablaCOLORES);
		
		Tblcores = new JTable();
		Tblcores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id_color", "color"
			}
		));
		tablaCOLORES.setViewportView(Tblcores);
		
		JLabel lblNewLabel = new JLabel("Talla");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblNewLabel.setBounds(58, 586, 80, 23);
		pnlPrincipal.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(214, 586, 220, 36);
		pnlPrincipal.add(textField);
		textField.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblCantidad.setBounds(58, 639, 122, 23);
		pnlPrincipal.add(lblCantidad);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 643, 220, 32);
		pnlPrincipal.add(textField_1);
		
		JButton Btn_buscar_1 = new JButton("Agregar");
		Btn_buscar_1.setForeground(Color.BLACK);
		Btn_buscar_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Btn_buscar_1.setBackground(new Color(0, 150, 255));
		Btn_buscar_1.setBounds(200, 695, 105, 32);
		pnlPrincipal.add(Btn_buscar_1);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblColor.setBounds(675, 586, 152, 23);
		pnlPrincipal.add(lblColor);
		
		JButton Btn_buscar_1_1 = new JButton("Agregar");
		Btn_buscar_1_1.setForeground(Color.BLACK);
		Btn_buscar_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Btn_buscar_1_1.setBackground(new Color(0, 150, 255));
		Btn_buscar_1_1.setBounds(810, 639, 105, 32);
		pnlPrincipal.add(Btn_buscar_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(785, 586, 220, 36);
		pnlPrincipal.add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Talla");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 39));
		lblNewLabel_2.setBounds(231, 130, 152, 45);
		pnlPrincipal.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Colores");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 39));
		lblNewLabel_2_1.setBounds(821, 134, 152, 45);
		pnlPrincipal.add(lblNewLabel_2_1);

	
		

	}
}
