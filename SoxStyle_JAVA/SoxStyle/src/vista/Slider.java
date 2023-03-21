package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Slider extends JPanel {
	private JTable table;
	public JTextField txtNombre;
	public JLabel lblModificar;
	public JScrollPane scrollPane;
	public JLabel lblNombre;
	public JLabel lblDescripcion;
	public JTextArea txtArea;
	public JButton btnActivar;
	public JButton btnCambiar;
	public JButton btnEstado;
	/**
	 * Create the panel.
	 */
	public Slider() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		lblModificar = new JLabel("Modificar Slider");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblModificar.setBounds(33, 29, 207, 58);
		add(lblModificar);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		scrollPane.setBounds(33, 123, 876, 450);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Informacion", "Imagen", "Estados"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(1029, 125, 134, 50);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		txtNombre.setBounds(964, 186, 271, 34);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblDescripcion.setBounds(1029, 285, 134, 50);
		add(lblDescripcion);
		
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		txtArea.setBounds(964, 345, 271, 166);
		add(txtArea);
		
		btnActivar = new JButton("Activar");
		btnActivar.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnActivar.setBounds(936, 595, 99, 34);
		add(btnActivar);
		
		btnCambiar = new JButton("Cambiar imagen");
		btnCambiar.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnCambiar.setBounds(1045, 595, 129, 34);
		add(btnCambiar);
		
		btnEstado = new JButton("Estado");
		btnEstado.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnEstado.setBounds(1184, 595, 89, 34);
		add(btnEstado);
	}
}
