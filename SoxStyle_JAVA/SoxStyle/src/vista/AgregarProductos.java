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
		
		JLabel lblDescuento = new JLabel("DESCUENTO:");
		lblDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescuento.setBounds(42, 172, 113, 21);
		panel.add(lblDescuento);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setText("NombreProducto");
		txtNombre.setBounds(182, 53, 204, 27);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setBounds(240, 123, 146, 21);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtDescuento = new JTextField();
		txtDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDescuento.setBounds(290, 173, 96, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 239, 98, 21);
		panel.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setBounds(240, 242, 145, 21);
		panel.add(cbxCategoria);
		
		lblErrorNomPro = new JLabel("ERROR");
		lblErrorNomPro.setVisible(false);
		lblErrorNomPro.setForeground(Color.RED);
		lblErrorNomPro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorNomPro.setBounds(318, 91, 68, 21);
		panel.add(lblErrorNomPro);
		
		lblErrorPrecio = new JLabel("ERROR");
		lblErrorPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorPrecio.setVisible(false);
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorPrecio.setBounds(247, 147, 139, 21);
		panel.add(lblErrorPrecio);
		
		lblErrorDescuento = new JLabel("ERROR");
		lblErrorDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDescuento.setVisible(false);
		lblErrorDescuento.setForeground(Color.RED);
		lblErrorDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescuento.setBounds(240, 203, 146, 21);
		panel.add(lblErrorDescuento);
		
		btnBAImagen = new JButton("Añadir Imagen");
		btnBAImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBAImagen.setBounds(200, 501, 162, 27);
		panel.add(btnBAImagen);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescripcion.setBounds(42, 291, 98, 21);
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
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE DEL PRODUCTO:");
		lblNewLabel_1.setBounds(40, 62, 132, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRECIO:");
		lblNewLabel_1_1.setBounds(40, 131, 132, 14);
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

