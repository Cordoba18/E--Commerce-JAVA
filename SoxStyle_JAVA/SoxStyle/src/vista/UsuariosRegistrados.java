package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;

public class UsuariosRegistrados extends JPanel {
	private JTextField textField;
	
	public JTable TBLproductos;
	public JPanel pnlPrincipal;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public UsuariosRegistrados() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		

		
		JLabel lblNewLabel = new JLabel("Lista de Usuarios Registrados");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 263, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 77, 53, 22);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(86, 79, 299, 20);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 7));
		scrollPane.setBounds(86, 148, 870, 364);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 7));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Fecha de Nacimiento", "Numero de contacto", "direccion", "Correo Electronico", "Estado"
			}
		));
		scrollPane.setViewportView(table);

	}
}
