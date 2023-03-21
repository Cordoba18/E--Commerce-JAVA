package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Vpdnuevos extends JPanel{

	public JTextField textBuscarPdNuevos;	
	public JButton btnBuscarN;
	public JTable tblPdnuevos;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JTextField textId;
	
	
	/**
	 * Create the panel.
	 */
	
	
	public Vpdnuevos() {
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblListaDeProductos = new JLabel("Lista de Productos Nuevos");
		lblListaDeProductos.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblListaDeProductos.setBounds(64, 59, 333, 42);
		add(lblListaDeProductos);
		
		textBuscarPdNuevos = new JTextField();
		textBuscarPdNuevos.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textBuscarPdNuevos.setColumns(10);
		textBuscarPdNuevos.setBounds(290, 127, 482, 42);
		add(textBuscarPdNuevos);
		
		btnBuscarN = new JButton("Buscar");
		btnBuscarN.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnBuscarN.setBackground(Color.WHITE);
		btnBuscarN.setBounds(128, 127, 115, 44);
		add(btnBuscarN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 214, 885, 272);
		add(scrollPane);
		
		tblPdnuevos = new JTable();
		tblPdnuevos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblPdnuevos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Precio", "Descuento", "Categoria", "Descripcion", "Imagen del producto", "Estado"
				}
			));
		scrollPane.setViewportView(tblPdnuevos);
		
		btnEditar = new JButton("");
		btnEditar.setBounds(1023, 234, 37, 30);
		add(btnEditar);
		
		btnEliminar = new JButton("");
		btnEliminar.setBounds(1023, 272, 37, 30);
		add(btnEliminar);
		
		textId = new JTextField();
		textId.setDoubleBuffered(true);
		textId.setBounds(340, 75, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		
		
	}
}