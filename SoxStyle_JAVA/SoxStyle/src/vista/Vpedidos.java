package vista;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Vpedidos extends JPanel {
	
	public JTable tblPedidosComprados, tblpedidosDespachados;
	public JButton btnVerDetalles;

	/**
	 * Create the panel.
	 */
	public Vpedidos() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblCompras = new JLabel("Compras");
		lblCompras.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCompras.setBounds(43, 24, 262, 87);
		add(lblCompras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 109, 979, 221);
		add(scrollPane);
		
		tblPedidosComprados = new JTable();
		tblPedidosComprados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tblPedidosComprados.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tblPedidosComprados);
		
		JLabel lblDespachados = new JLabel("Despachados");
		lblDespachados.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblDespachados.setBounds(43, 374, 262, 87);
		add(lblDespachados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(111, 459, 979, 221);
		add(scrollPane_1);
		
		tblpedidosDespachados = new JTable();
		scrollPane_1.setViewportView(tblpedidosDespachados);
		
		btnVerDetalles = new JButton("Ver detalles");
		btnVerDetalles.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnVerDetalles.setBounds(1125, 342, 169, 104);
		btnVerDetalles.setBackground(new Color(255, 255, 255));
		btnVerDetalles.setForeground(new Color(0, 0, 0));
		add(btnVerDetalles);
	}
}
