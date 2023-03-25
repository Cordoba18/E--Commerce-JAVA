package vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder; 

public class AgregarProductos extends JPanel {
	public JTextField txtNombre;
	public JTextField txtPrecio;
	public JTextField txtEstado;
	public JButton btnAgregar;
	public JComboBox cbxCategoria;
	public JPanel panel;
	public JLabel lblErrorNomPro;
	public JLabel lblErrorPrecio;
	public JLabel lblErrorEstado;
	public JButton btnBAImagen;
	public JButton btnBATallaColor;
	public JLabel lblDescripcion;
	public JTextArea textAreaDescripcion;
	public JLabel lblErrorDescripcion;
	private JScrollPane scrollPane;

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
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEstado.setBounds(40, 203, 85, 21);
		panel.add(lblEstado);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setText("NombreProducto");
		txtNombre.setBounds(135, 63, 204, 27);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setText("$XXXXXXXX");
		txtPrecio.setBounds(40, 142, 146, 21);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtEstado.setText("Nuevo");
		txtEstado.setBounds(135, 204, 96, 19);
		panel.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 270, 98, 21);
		panel.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setBounds(141, 273, 145, 21);
		panel.add(cbxCategoria);
		
		lblErrorNomPro = new JLabel("ERROR");
		lblErrorNomPro.setVisible(false);
		lblErrorNomPro.setForeground(Color.RED);
		lblErrorNomPro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorNomPro.setBounds(135, 100, 204, 21);
		panel.add(lblErrorNomPro);
		
		lblErrorPrecio = new JLabel("ERROR");
		lblErrorPrecio.setVisible(false);
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorPrecio.setBounds(207, 142, 179, 21);
		panel.add(lblErrorPrecio);
		
		lblErrorEstado = new JLabel("ERROR");
		lblErrorEstado.setVisible(false);
		lblErrorEstado.setForeground(Color.RED);
		lblErrorEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorEstado.setBounds(241, 203, 179, 21);
		panel.add(lblErrorEstado);
		
		btnBAImagen = new JButton("Añadir Imagen");
		btnBAImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBAImagen.setBounds(40, 509, 162, 27);
		panel.add(btnBAImagen);
		
		btnBATallaColor = new JButton("Añadir Talla/Color");
		btnBATallaColor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBATallaColor.setBounds(224, 509, 179, 27);
		panel.add(btnBATallaColor);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescripcion.setBounds(40, 326, 98, 21);
		panel.add(lblDescripcion);
		
		lblErrorDescripcion = new JLabel("ERROR");
		lblErrorDescripcion.setVisible(false);
		lblErrorDescripcion.setForeground(Color.RED);
		lblErrorDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescripcion.setBounds(81, 478, 280, 21);
		panel.add(lblErrorDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 369, 280, 99);
		panel.add(scrollPane);
		
		textAreaDescripcion = new JTextArea();
		scrollPane.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescripcion.setBackground(Color.WHITE);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(486, 680, 124, 29);
		add(btnAgregar);
		btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregar.setBackground(new Color(0, 150, 255));

	}
}

