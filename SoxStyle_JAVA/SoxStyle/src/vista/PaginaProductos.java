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
	public JTextField txtid;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PaginaProductos() {
		setBackground(new Color(255, 255, 255));	
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblListaProductos = new JLabel("Lista de Productos");
		lblListaProductos.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblListaProductos.setBounds(20, 53, 251, 42);
		add(lblListaProductos);
		
		txtProductos = new JTextField();
		txtProductos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtProductos.setColumns(10);
		txtProductos.setBounds(116, 127, 968, 42);
		add(txtProductos);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 217, 1064, 442);
		add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblProductos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {

						"id","nombre", "precio"	, "descuento" ,"descripcion" , "calificacion" ,"n_p_calificaron" ,"categoria", "id_user", "estados_id",	"created_at" ,"updated_at"
				}
			));
		scrollPane.setViewportView(tblProductos);
		
		
		btnAgregarProductos = new JButton("AGREGAR NUEVO PRODUCTO");
		btnAgregarProductos.setBackground(new Color(255, 255, 255));
		btnAgregarProductos.setIcon(new ImageIcon("icons\\Lg-boton-agregar.png"));
		btnAgregarProductos.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnAgregarProductos.setBounds(402, 45, 682, 60);
		add(btnAgregarProductos);
		
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
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblBuscar.setBounds(20, 123, 86, 42);
		add(lblBuscar);
		
		txtid = new JTextField();
	
		txtid.setVisible(false);
		txtid.setBounds(20, 182, 96, 19);
		add(txtid);
		txtid.setColumns(10);
	}
}