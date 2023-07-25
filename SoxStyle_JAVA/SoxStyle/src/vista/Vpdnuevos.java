package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Vpdnuevos extends JPanel{

	public JTextField textBuscarPdNuevos;	
	public JTable tblPdnuevos;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JButton btnCancelar;
	public JLabel lblError;
	
	
	
	/**
	 * Create the panel.
	 */
	
	
	public Vpdnuevos() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblListaDeProductos = new JLabel("Lista de Productos Nuevos");
		lblListaDeProductos.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblListaDeProductos.setBounds(20, 53, 378, 42);
		add(lblListaDeProductos);
		
		textBuscarPdNuevos = new JTextField();
		textBuscarPdNuevos.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textBuscarPdNuevos.setColumns(10);
		textBuscarPdNuevos.setBounds(116, 127, 968, 42);
		add(textBuscarPdNuevos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 217, 1064, 442);
		add(scrollPane);
		
		tblPdnuevos = new JTable();
		tblPdnuevos.setBackground(new Color(255, 255, 255));
		tblPdnuevos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblPdnuevos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id","Nombre", "Precio", "Descuento","Descripcion", "Categoria", "Id_user", "Estado"
				}
			));
		scrollPane.setViewportView(tblPdnuevos);
		
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
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(20, 123, 86, 42);
		add(lblNewLabel);
		
		lblError = new JLabel("");
		lblError.setVisible(false);
		lblError.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblError.setBounds(290, 172, 366, 31);
		add(lblError);
		
		
		
	}
}