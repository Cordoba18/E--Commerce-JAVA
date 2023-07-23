package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import javax.swing.JButton;

public class UsuariosRegistrados extends JPanel {
	public JTextField txtBuscar;
	
	public JTable TBLproductos;
	public JPanel pnlPrincipal;
	public JTable table;
	public JButton btnEditar, btnEliminar, btnCancelar;
	/**
	 * Create the panel.
	 */
	public UsuariosRegistrados() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		

		
		JLabel lblNewLabel = new JLabel("Lista de Usuarios Registrados");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(86, 11, 263, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(86, 77, 53, 22);
		add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(149, 79, 299, 20);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI Black", Font.PLAIN, 7));
		scrollPane.setBounds(86, 148, 870, 364);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI Black", Font.PLAIN, 7));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Fecha de Nacimiento", "Numero de contacto", "direccion", "Correo Electronico", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(978, 175, 89, 23);
		add(btnEditar);
		btnEditar.setVisible(false);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(978, 220, 89, 23);
		add(btnEliminar);
		btnEliminar.setVisible(false);
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(1095, 200, 85, 21);
		add(btnCancelar);
		btnCancelar.setVisible(false);

	}
}
