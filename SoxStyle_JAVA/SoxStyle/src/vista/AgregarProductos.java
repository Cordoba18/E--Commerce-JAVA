package vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder; 

public class AgregarProductos extends JPanel {
	public JTextField txtNombre;
	public JTextField txtPrecio;
	public JTextField txtDescuento;
	public JButton btnAgregar;
	public JComboBox cbxCategoria;
	public JPanel panel;
	public JLabel lblErrorNomPro;
	public JLabel lblErrorPrecio;
	public JLabel lblErrorDescuento;
	public JButton btnBAImagen;
	public JLabel lblDescripcion;
	public JTextArea textAreaDescripcion;
	public JLabel lblErrorDescripcion;
	private JScrollPane scrollPane;
	public JLabel lblNombreImagen;

	/**
	 * Create the panel.
	 */
	public AgregarProductos() {
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		JLabel lblNewLabel = new JLabel("Agregar Producto");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel.setBounds(49, 25, 257, 62);
		add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(332, 84, 457, 565);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescuento.setBounds(42, 191, 113, 21);
		panel.add(lblDescuento);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setBounds(240, 71, 146, 28);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setBounds(240, 133, 146, 21);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtDescuento = new JTextField();
		txtDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDescuento.setBounds(240, 192, 146, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 250, 98, 21);
		panel.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setBounds(241, 253, 145, 21);
		panel.add(cbxCategoria);
		
		lblErrorNomPro = new JLabel("ERROR");
		lblErrorNomPro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNomPro.setVisible(false);
		lblErrorNomPro.setForeground(Color.RED);
		lblErrorNomPro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorNomPro.setBounds(240, 102, 146, 21);
		panel.add(lblErrorNomPro);
		
		lblErrorPrecio = new JLabel("ERROR");
		lblErrorPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorPrecio.setVisible(false);
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorPrecio.setBounds(240, 161, 146, 21);
		panel.add(lblErrorPrecio);
		
		lblErrorDescuento = new JLabel("ERROR");
		lblErrorDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDescuento.setVisible(false);
		lblErrorDescuento.setForeground(Color.RED);
		lblErrorDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescuento.setBounds(240, 222, 146, 21);
		panel.add(lblErrorDescuento);
		
		btnBAImagen = new JButton("Añadir Imagen");
		btnBAImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBAImagen.setBounds(199, 509, 162, 27);
		panel.add(btnBAImagen);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescripcion.setBounds(42, 311, 98, 21);
		panel.add(lblDescripcion);
		
		lblErrorDescripcion = new JLabel("ERROR");
		lblErrorDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDescripcion.setVisible(false);
		lblErrorDescripcion.setForeground(Color.RED);
		lblErrorDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescripcion.setBounds(81, 478, 280, 21);
		panel.add(lblErrorDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 369, 280, 99);
		panel.add(scrollPane);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		scrollPane.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescripcion.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del Producto:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(42, 73, 190, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(42, 136, 132, 14);
		panel.add(lblNewLabel_1_1);
		
		lblNombreImagen = new JLabel("imagen");
		lblNombreImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreImagen.setBounds(81, 510, 280, 14);
		panel.add(lblNombreImagen);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(486, 680, 124, 29);
		add(btnAgregar);
		btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregar.setBackground(new Color(0, 150, 255));

	}
}

