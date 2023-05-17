package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

public class PaginaProductos extends JPanel {

	public JTextField txtProductos;
	public JTable tblProductos;
	public JButton btnAgregarProductos;
	public 	JButton btnEliminar;
	public JButton btnEditar;
	public 	JButton btnCancelar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PaginaProductos() {	
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblListaProductos = new JLabel("Lista de Productos");
		lblListaProductos.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblListaProductos.setBounds(76, 56, 251, 42);
		add(lblListaProductos);
		
		txtProductos = new JTextField();
		txtProductos.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		txtProductos.setColumns(10);
		txtProductos.setBounds(290, 127, 708, 42);
		add(txtProductos);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 214, 1064, 442);
		add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblProductos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Precio", "Descuento", "Categoria", "Descripcion", "Imagen del producto", "Estado"
				}
			));
		scrollPane.setViewportView(tblProductos);
		
		
		btnAgregarProductos = new JButton("Agregar nuevo producto");
		btnAgregarProductos.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnAgregarProductos.setBounds(403, 56, 371, 38);
		add(btnAgregarProductos);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setVisible(false);
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(1129, 328, 124, 44);
		add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(1129, 273, 111, 44);
		add(btnEliminar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setVisible(false);
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(1129, 218, 111, 44);
		add(btnEditar);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblBuscar.setBounds(128, 123, 86, 42);
		add(lblBuscar);
	}
}