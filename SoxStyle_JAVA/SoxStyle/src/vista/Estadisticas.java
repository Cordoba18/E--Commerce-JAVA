package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Estadisticas extends JPanel {
	public JTable tblUsuariosIngresadosDia;
	public JTable tblProductosMasVendidos;
	public JTable tblPruductosMenosVendidos;
	public JLabel lblNewLabel;
	

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
		
		JScrollPane scllUsuariosIngresadosDia = new JScrollPane();
		scllUsuariosIngresadosDia.setBounds(352, 162, 169, 152);
		add(scllUsuariosIngresadosDia);
		
		tblUsuariosIngresadosDia = new JTable();
		scllUsuariosIngresadosDia.setViewportView(tblUsuariosIngresadosDia);
		tblUsuariosIngresadosDia.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		tblUsuariosIngresadosDia.setModel(new DefaultTableModel(
			new Object[][] {
				{"13/03/2023", "120"},
			},
			new String[] {
				"Dia", "C_Usuarios"
			}
		));
		
		JScrollPane scllProductosMasVendidos = new JScrollPane();
		scllProductosMasVendidos.setBounds(352, 359, 169, 152);
		add(scllProductosMasVendidos);
		
		tblProductosMasVendidos = new JTable();
		scllProductosMasVendidos.setViewportView(tblProductosMasVendidos);
		tblProductosMasVendidos.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		tblProductosMasVendidos.setModel(new DefaultTableModel(
			new Object[][] {
				{"palo", "20"},
			},
			new String[] {
				"Producto", "Cantidad"
			}
		));
		
		JScrollPane scllProductosMenosVendidos = new JScrollPane();
		scllProductosMenosVendidos.setBounds(352, 559, 169, 152);
		add(scllProductosMenosVendidos);
		
		tblPruductosMenosVendidos = new JTable();
		scllProductosMenosVendidos.setViewportView(tblPruductosMenosVendidos);
		tblPruductosMenosVendidos.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		tblPruductosMenosVendidos.setModel(new DefaultTableModel(
			new Object[][] {
				{"piedra", "1"},
			},
			new String[] {
				"Producto", "Cantidad"
			}
		));

	}
}
