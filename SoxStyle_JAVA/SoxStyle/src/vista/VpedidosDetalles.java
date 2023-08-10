package vista;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class VpedidosDetalles extends JPanel {
	
	public JTable tblProductosPedidos;
	public JButton btnBontonProducto;
	/**
	 * Create the panel.
	 */
	public VpedidosDetalles() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblProductos.setBounds(48, 93, 262, 87);
		add(lblProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 209, 931, 332);
		add(scrollPane);
		
		tblProductosPedidos = new JTable();
		tblProductosPedidos.setDefaultEditor(Object.class, null );
		scrollPane.setViewportView(tblProductosPedidos);
		
		btnBontonProducto = new JButton("Ver detalle pd");
		btnBontonProducto.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnBontonProducto.setBounds(1111, 325, 169, 104);
		btnBontonProducto.setBackground(new Color(255, 255, 255));
		btnBontonProducto.setForeground(new Color(0, 0, 0));
		add(btnBontonProducto);
	}
}
