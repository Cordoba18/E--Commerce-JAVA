package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UsuariosRegistrados extends JPanel {
	private JTextField textField;
	
	public JTable TBLproductos;
	public JScrollPane tabla = new JScrollPane();
	public JPanel pnlPrincipal;

	/**
	 * Create the panel.
	 */
	public UsuariosRegistrados() {
		setLayout(null);
		
		tabla.setBounds(35, 201, 996, 407);
		tabla.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pnlPrincipal.add(tabla);
		tabla.setViewportView(TBLproductos);
		

		
		TBLproductos = new JTable();
		TBLproductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Precio", "Descuento", "Categorial", "Descripción", "Imagen del producto", "Estado"
			}
		));
		tabla.setViewportView(TBLproductos);
		
		JLabel lblNewLabel = new JLabel("Lista de Usuarios Registrados");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 239, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(40, 54, 53, 22);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(86, 56, 299, 20);
		add(textField);
		textField.setColumns(10);

	}
}
