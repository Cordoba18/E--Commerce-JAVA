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

	public JPanel contentPane1;
	public JPanel pnlPrincipal;
	public JTable TBLproductos;
	public JTable Tblcores;
	public JScrollPane tablaTalla = new JScrollPane();
	public JLabel lblNewLabel_1;
	public JTextField txtTalla;
	public JTextField txtCantidad;
	public JTextField txtColor;
	public JButton BtnAgregar;
	public JButton BtnAgregar2;
	public JLabel lblTalla;
	public JLabel lblCantidad;
	public JLabel lblColor;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_2_1;
	public JLabel lblErrorTalla;
	public JLabel lblErrorCantidad;
	public JLabel lblErrorColor;
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
				"Id_talla", "Talla", "Cantidad"
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
		
		lblTalla = new JLabel("Talla");
		lblTalla.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblTalla.setBounds(58, 586, 80, 23);
		pnlPrincipal.add(lblTalla);
		
		txtTalla = new JTextField();
		txtTalla.setBounds(214, 586, 220, 36);
		pnlPrincipal.add(txtTalla);
		txtTalla.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblCantidad.setBounds(58, 639, 122, 23);
		pnlPrincipal.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(214, 643, 220, 32);
		pnlPrincipal.add(txtCantidad);
		
		BtnAgregar = new JButton("Agregar");
		BtnAgregar.setForeground(Color.BLACK);
		BtnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnAgregar.setBackground(new Color(0, 150, 255));
		BtnAgregar.setBounds(200, 695, 105, 32);
		pnlPrincipal.add(BtnAgregar);
		
		lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblColor.setBounds(675, 586, 100, 23);
		pnlPrincipal.add(lblColor);
		
		BtnAgregar2 = new JButton("Agregar");
		BtnAgregar2.setForeground(Color.BLACK);
		BtnAgregar2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BtnAgregar2.setBackground(new Color(0, 150, 255));
		BtnAgregar2.setBounds(810, 639, 105, 32);
		pnlPrincipal.add(BtnAgregar2);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(785, 586, 220, 36);
		pnlPrincipal.add(txtColor);
		
		lblNewLabel_2 = new JLabel("Talla");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 39));
		lblNewLabel_2.setBounds(231, 130, 152, 45);
		pnlPrincipal.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("Colores");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 39));
		lblNewLabel_2_1.setBounds(821, 134, 152, 45);
		pnlPrincipal.add(lblNewLabel_2_1);
		
		lblErrorTalla = new JLabel("ERROR");
		lblErrorTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorTalla.setForeground(new Color(255, 0, 0));
		lblErrorTalla.setVisible(false);
		lblErrorTalla.setBounds(466, 598, 105, 14);
		pnlPrincipal.add(lblErrorTalla);
		
		lblErrorCantidad = new JLabel("ERROR");
		lblErrorCantidad.setVisible(false);
		lblErrorCantidad.setForeground(Color.RED);
		lblErrorCantidad.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorCantidad.setBounds(466, 651, 105, 14);
		pnlPrincipal.add(lblErrorCantidad);
		
		lblErrorColor = new JLabel("ERROR");
		lblErrorColor.setVisible(false);
		lblErrorColor.setForeground(Color.RED);
		lblErrorColor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorColor.setBounds(1015, 598, 105, 14);
		pnlPrincipal.add(lblErrorColor);

	
		

	}
}
