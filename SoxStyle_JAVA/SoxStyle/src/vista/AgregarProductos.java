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
	public JLabel lblNombreImagen;
	private JLabel lblDescuento_1;
	private JLabel lblDescuento_2;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public AgregarProductos() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		JLabel lblNewLabel = new JLabel("Agregar producto");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(49, 25, 393, 68);
		add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(277, 77, 699, 565);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDescuento.setBounds(42, 191, 190, 21);
		panel.add(lblDescuento);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setBounds(412, 71, 257, 28);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setBounds(450, 129, 219, 21);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtDescuento = new JTextField();
		txtDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDescuento.setBounds(573, 192, 53, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCategoria.setBounds(42, 250, 190, 21);
		panel.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cbxCategoria.setBounds(411, 253, 257, 34);
		panel.add(cbxCategoria);
		
		lblErrorNomPro = new JLabel("ERROR");
		lblErrorNomPro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNomPro.setVisible(false);
		lblErrorNomPro.setForeground(Color.RED);
		lblErrorNomPro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorNomPro.setBounds(412, 97, 257, 21);
		panel.add(lblErrorNomPro);
		
		lblErrorPrecio = new JLabel("ERROR");
		lblErrorPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorPrecio.setVisible(false);
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorPrecio.setBounds(523, 150, 146, 21);
		panel.add(lblErrorPrecio);
		
		lblErrorDescuento = new JLabel("ERROR");
		lblErrorDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDescuento.setVisible(false);
		lblErrorDescuento.setForeground(Color.RED);
		lblErrorDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescuento.setBounds(523, 219, 146, 21);
		panel.add(lblErrorDescuento);
		
		btnBAImagen = new JButton("Añadir Imagen");
		btnBAImagen.setForeground(new Color(0, 0, 0));
		btnBAImagen.setBackground(new Color(255, 255, 255));
		btnBAImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBAImagen.setBounds(507, 450, 162, 27);
		panel.add(btnBAImagen);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDescripcion.setBounds(42, 311, 190, 21);
		panel.add(lblDescripcion);
		
		lblErrorDescripcion = new JLabel("ERROR");
		lblErrorDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDescripcion.setVisible(false);
		lblErrorDescripcion.setForeground(Color.RED);
		lblErrorDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescripcion.setBounds(389, 418, 280, 21);
		panel.add(lblErrorDescripcion);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del Producto:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(42, 73, 190, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(42, 129, 190, 21);
		panel.add(lblNewLabel_1_1);
		
		lblNombreImagen = new JLabel("imagen");
		lblNombreImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreImagen.setBounds(389, 459, 280, 14);
		panel.add(lblNombreImagen);
		
		lblDescuento_1 = new JLabel("%");
		lblDescuento_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescuento_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescuento_1.setBounds(636, 191, 33, 21);
		panel.add(lblDescuento_1);
		
		lblDescuento_2 = new JLabel("$");
		lblDescuento_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescuento_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescuento_2.setBounds(412, 129, 33, 21);
		panel.add(lblDescuento_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(389, 322, 280, 97);
		panel.add(scrollPane);
		
		textAreaDescripcion = new JTextArea();
		scrollPane.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescripcion.setBackground(Color.WHITE);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setIcon(new ImageIcon("icons\\Lg-boton-agregar.png"));
		btnAgregar.setBounds(485, 653, 310, 53);
		add(btnAgregar);
		btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregar.setBackground(new Color(255, 255, 255));

	}
}

