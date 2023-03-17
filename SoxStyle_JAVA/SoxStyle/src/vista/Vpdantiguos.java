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

public class Vpdantiguos extends JPanel{
	
	public JTextField textBuscarPdAntiguos;
	public JButton btnBuscarA;
	public JTable tblPdantiguos;
	public JButton btnElimnar;
	public JButton btnEditar;
	
	
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
		
		btnBuscarA = new JButton("Buscar");
		btnBuscarA.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnBuscarA.setBackground(Color.WHITE);
		btnBuscarA.setBounds(128, 127, 115, 44);
		add(btnBuscarA);
		
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
		
		btnElimnar = new JButton("");
		btnElimnar.setBounds(1023, 272, 37, 30);
		add(btnElimnar);
		
		btnEditar = new JButton("");
		btnEditar.setBounds(1023, 234, 37, 30);
		add(btnEditar);
		
		

	}
}