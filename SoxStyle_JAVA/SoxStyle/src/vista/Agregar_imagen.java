package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Agregar_imagen extends JPanel {
	
	public JTextField txtBuscar;
	public JScrollPane tbl_Agregar = new JScrollPane();
	public JButton btn_Agregar;
	private JTable table;
	

	/**
	 * Create the panel.
	 */
	public Agregar_imagen() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		btn_Agregar = new JButton("Agregar");
		btn_Agregar.setBounds(441, 640, 151, 47);
		btn_Agregar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		add(btn_Agregar);
		
		JLabel lblNewLabel = new JLabel("Agregar más imágenes al producto");
		lblNewLabel.setBounds(37, 20, 504, 47);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar:");
		lblNewLabel_1.setBounds(118, 119, 90, 31);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(219, 119, 400, 31);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 224, 727, 351);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.BOLD, 18));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Imagen", "Estado"
			}
		));
		
		JButton btn_Editar = new JButton("Editar");
		btn_Editar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btn_Editar.setBounds(867, 246, 85, 21);
		add(btn_Editar);
		
		JButton btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btn_Eliminar.setBounds(962, 247, 85, 21);
		add(btn_Eliminar);
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(0).setMinWidth(17);
		table.getColumnModel().getColumn(0).setMaxWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(1).setMinWidth(9);
		table.getColumnModel().getColumn(1).setMaxWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(233);

	}
}
