package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Estadisticas extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public Estadisticas() {
		setBounds(new Rectangle(0, 0, 1230, 757));
		setLayout(null);
		
		JLabel lblTotalUsuRegis = new JLabel("Total de usuarios registrados:");
		lblTotalUsuRegis.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTotalUsuRegis.setBounds(352, 61, 169, 33);
		add(lblTotalUsuRegis);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setBounds(531, 61, 46, 33);
		add(lblNewLabel);
		
		JLabel lblUsuariosIngresadosPor = new JLabel("Usuarios ingresados por dia");
		lblUsuariosIngresadosPor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblUsuariosIngresadosPor.setBounds(352, 131, 169, 33);
		add(lblUsuariosIngresadosPor);
		
		JLabel lblTotalUsuRegis_1_1 = new JLabel("Productos mas vendidos");
		lblTotalUsuRegis_1_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTotalUsuRegis_1_1.setBounds(352, 315, 169, 33);
		add(lblTotalUsuRegis_1_1);
		
		JLabel lblTotalUsuRegis_1_2 = new JLabel("Productos menos vendidos");
		lblTotalUsuRegis_1_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTotalUsuRegis_1_2.setBounds(352, 515, 169, 33);
		add(lblTotalUsuRegis_1_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"13/03/2023", "120"},
			},
			new String[] {
				"Dia", "C_Usuarios"
			}
		));
		table.setBounds(362, 176, 153, 128);
		add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"palo", "20"},
			},
			new String[] {
				"Producto", "Cantidad"
			}
		));
		table_1.setBounds(362, 359, 153, 128);
		add(table_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"piedra", "1"},
			},
			new String[] {
				"Producto", "Cantidad"
			}
		));
		table_2.setBounds(362, 555, 153, 128);
		add(table_2);

	}

}
