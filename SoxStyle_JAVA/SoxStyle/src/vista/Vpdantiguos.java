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
	
	
	/**
	 * Create the panel.
	 */
	
	
	public Vpdantiguos() {
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null);
		
		JLabel lblListaPdAntiguos = new JLabel("Lista de Productos Antiguos");
		lblListaPdAntiguos.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblListaPdAntiguos.setBounds(64, 59, 333, 42);
		add(lblListaPdAntiguos);
		
		textBuscarPdAntiguos = new JTextField();
		textBuscarPdAntiguos.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textBuscarPdAntiguos.setColumns(10);
		textBuscarPdAntiguos.setBounds(290, 127, 482, 42);
		add(textBuscarPdAntiguos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 214, 885, 272);
		add(scrollPane);
		
		tblPdantiguos = new JTable();
		tblPdantiguos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		tblPdantiguos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Precio", "Descuento", "Categoria", "Descripcion", "Imagen del producto", "Estado"
				}
			));
		scrollPane.setViewportView(tblPdantiguos);
		
		btnEliminar = new JButton("");
		btnEliminar.setVisible(false);
		btnEliminar.setBounds(1023, 272, 37, 30);
		add(btnEliminar);
		
		btnEditar = new JButton("");
		btnEditar.setVisible(false);
		btnEditar.setBounds(1023, 234, 37, 30);
		add(btnEditar);
		
		textId = new JTextField();
		textId.setVisible(false);
		textId.setBounds(356, 75, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblBuscar.setBounds(128, 127, 136, 42);
		add(lblBuscar);
		
		btnCancelar = new JButton("");
		btnCancelar.setVisible(false);
		btnCancelar.setBounds(1070, 247, 56, 42);
		add(btnCancelar);
		
		

	}
}