package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Estadisticas extends JPanel {
	public JTable tblUsuariosIngresadosDia;
	public JTable tblProductosMasVendidos;
	public JTable tblPruductosMenosVendidos;
	public JLabel lblNewLabel;
	private JTable tabla_monitorias;
	

	/**
	 * Create the panel.
	 */
	public Estadisticas() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1230, 757));
		setLayout(null);
		
		JLabel lblTotalUsuRegis = new JLabel("Total de usuarios registrados:");
		lblTotalUsuRegis.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTotalUsuRegis.setBounds(66, 37, 305, 57);
		add(lblTotalUsuRegis);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setBounds(531, 61, 46, 33);
		add(lblNewLabel);
		
		JLabel lblUsuariosIngresadosPor = new JLabel("Usuarios ingresados por dia");
		lblUsuariosIngresadosPor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblUsuariosIngresadosPor.setBounds(66, 118, 169, 33);
		add(lblUsuariosIngresadosPor);
		
		JLabel lblTotalUsuRegis_1_1 = new JLabel("Productos mas vendidos");
		lblTotalUsuRegis_1_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTotalUsuRegis_1_1.setBounds(66, 335, 169, 33);
		add(lblTotalUsuRegis_1_1);
		
		JLabel lblTotalUsuRegis_1_2 = new JLabel("Productos menos vendidos");
		lblTotalUsuRegis_1_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTotalUsuRegis_1_2.setBounds(66, 536, 169, 33);
		add(lblTotalUsuRegis_1_2);
		
		JScrollPane scllUsuariosIngresadosDia = new JScrollPane();
		scllUsuariosIngresadosDia.setBounds(66, 172, 444, 152);
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
		scllProductosMasVendidos.setBounds(66, 373, 444, 152);
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
		scllProductosMenosVendidos.setBounds(66, 577, 444, 152);
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
		
		JLabel lblTotalProductosCreados = new JLabel("Total Productos Creados:");
		lblTotalProductosCreados.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTotalProductosCreados.setBounds(645, 37, 267, 57);
		add(lblTotalProductosCreados);
		
		JLabel lblTotalUsuarioRegistrados = new JLabel("0");
		lblTotalUsuarioRegistrados.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalUsuarioRegistrados.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTotalUsuarioRegistrados.setBounds(377, 37, 258, 57);
		add(lblTotalUsuarioRegistrados);
		
		JLabel lblTotalProductos = new JLabel("0");
		lblTotalProductos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalProductos.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTotalProductos.setBounds(930, 37, 258, 57);
		add(lblTotalProductos);
		
		JLabel lblMonitoriasDeUsuario = new JLabel("Monitorias de usuario:");
		lblMonitoriasDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMonitoriasDeUsuario.setBounds(757, 118, 169, 33);
		add(lblMonitoriasDeUsuario);
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(757, 172, 444, 557);
		add(scrollpane);
		
		tabla_monitorias = new JTable();
		tabla_monitorias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollpane.setViewportView(tabla_monitorias);

	}
}
