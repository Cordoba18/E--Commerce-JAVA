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
	public JTextField textId;
	public JLabel lblError;
	
	
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 214, 885, 272);
		add(scrollPane);
		
		tblPdnuevos = new JTable();
		tblPdnuevos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblPdnuevos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id","Nombre", "Precio", "Descuento","Descripcion", "Categoria", "Id_user", "Estado"
				}
			));
		scrollPane.setViewportView(tblPdnuevos);
		
		btnEditar = new JButton("Editar");
		btnEditar.setVisible(false);
		btnEditar.setBounds(1023, 234, 104, 30);
		add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		btnEliminar.setBounds(1023, 272, 104, 30);
		add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setVisible(false);
		btnCancelar.setBounds(1137, 246, 96, 42);
		add(btnCancelar);
		
		textId = new JTextField();
		textId.setVisible(false);
		textId.setDoubleBuffered(true);
		textId.setBounds(340, 75, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(128, 127, 136, 42);
		add(lblNewLabel);
		
		lblError = new JLabel("");
		lblError.setVisible(false);
		lblError.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblError.setBounds(290, 172, 366, 31);
		add(lblError);
		
		
		
	}
}