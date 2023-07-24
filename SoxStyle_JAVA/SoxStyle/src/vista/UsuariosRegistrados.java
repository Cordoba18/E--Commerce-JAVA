package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
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
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		

		
		JLabel lblNewLabel = new JLabel("Lista de Usuarios Registrados");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(20, 53, 450, 42);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1.setBounds(20, 123, 86, 42);
		add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(116, 129, 968, 42);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		scrollPane.setBounds(20, 217, 1064, 442);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Fecha de Nacimiento", "Numero de contacto", "direccion", "Correo Electronico", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setVisible(false);
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(1129, 335, 163, 59);
		add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("icons\\Lg-eliminar.png"));
		btnEliminar.setVisible(false);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(1129, 277, 163, 59);
		add(btnEliminar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("icons\\Lg-editar.png"));
		btnEditar.setVisible(false);
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(1129, 218, 163, 59);
		add(btnEditar);
		

	}
}
