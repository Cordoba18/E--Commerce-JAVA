package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Vpdantiguos extends JPanel{
	
	public JTextField textBuscarPdAntiguos;
	public JTable tblPdantiguos;
	public JButton btnEliminar;
	public JButton btnEditar;
	public JButton btnCancelar;
	public JTextField textId;
	private JLabel lblBuscar;
	public JLabel lblErrorA;
	
	
	/**
	 * Create the panel.
	 */
	
	
	public Vpdantiguos() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblListaPdAntiguos = new JLabel("Lista de Productos Antiguos");
		lblListaPdAntiguos.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblListaPdAntiguos.setBounds(20, 53, 395, 42);
		add(lblListaPdAntiguos);
		
		textBuscarPdAntiguos = new JTextField();
		textBuscarPdAntiguos.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textBuscarPdAntiguos.setColumns(10);
		textBuscarPdAntiguos.setBounds(116, 127, 951, 42);
		add(textBuscarPdAntiguos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 217, 1064, 442);
		add(scrollPane);
		
		tblPdantiguos = new JTable();
		tblPdantiguos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblPdantiguos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Id","Nombre", "Precio", "Descuento","Descripcion", "Categoria", "Id_user", "Estado"
				}
			));
		scrollPane.setViewportView(tblPdantiguos);
		
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
		
		textId = new JTextField();
		textId.setVisible(false);
		textId.setBounds(589, 31, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblBuscar.setBounds(20, 123, 86, 42);
		add(lblBuscar);
		

		
		lblErrorA = new JLabel("");
		lblErrorA.setVisible(false);
		lblErrorA.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorA.setBounds(290, 175, 326, 28);
		add(lblErrorA);
		
		

	}
}